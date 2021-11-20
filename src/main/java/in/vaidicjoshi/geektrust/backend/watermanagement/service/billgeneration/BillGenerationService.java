package in.vaidicjoshi.geektrust.backend.watermanagement.service.billgeneration;

import java.util.Map;

/**
 * @author Vaidic Joshi
 * @date 20/11/21
 */
public abstract class BillGenerationService {
  private final Map<Integer, Double> maxUptoBillRate;

  public BillGenerationService(Map<Integer, Double> maxUptoBillRate) {
    this.maxUptoBillRate = maxUptoBillRate;
  }

  public double generateBill(int ltsConsumed, double ratio) {
    final double[] totalConsumption = {ltsConsumed * ratio};
    final double[] bill = {0.0};
    maxUptoBillRate.keySet().stream()
        .sorted()
        .forEach(
            key -> {
              double currConsumption =
                  (totalConsumption[0] - key) > 0
                      ? key
                      : totalConsumption[0] > 0 ? totalConsumption[0] : 0;
              double rate = maxUptoBillRate.get(key);
              bill[0] += rate * currConsumption;
              totalConsumption[0] -= key;
            });
    if (totalConsumption[0] > 0) {
      bill[0] += totalConsumption[0] * maxUptoBillRate.get(Integer.MAX_VALUE);
    }
    return bill[0];
  }
}
