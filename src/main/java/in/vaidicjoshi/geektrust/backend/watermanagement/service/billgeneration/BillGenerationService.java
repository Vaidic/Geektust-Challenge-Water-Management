package in.vaidicjoshi.geektrust.backend.watermanagement.service.billgeneration;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Vaidic Joshi
 * @date 20/11/21
 */
public abstract class BillGenerationService {
  private final Map<Integer, Double> maxUptoBillRate;

  public BillGenerationService(Map<Integer, Double> maxUptoBillRate) {
    this.maxUptoBillRate = maxUptoBillRate;
  }

  public double generateBill(int people, int lts, int days, double ratio) {

    double totalConsumption = people * lts * days * ratio;
    double bill = 0;
    List<Integer> slabs = maxUptoBillRate.keySet().stream().sorted().collect(Collectors.toList());
    int prevSlabLimit = 0;
    for (int slab : slabs) {
      int slabDiff = slab - prevSlabLimit;
      double slabRate = maxUptoBillRate.get(slab);
      if (totalConsumption > slabDiff) {
        totalConsumption -= slabDiff;
        bill += slabDiff * slabRate;
      } else {
        bill += totalConsumption * slabRate;
        totalConsumption = 0;
      }
      prevSlabLimit = slab;
    }
    if (totalConsumption > 0) {
      bill += totalConsumption * maxUptoBillRate.get(Integer.MAX_VALUE);
      totalConsumption = 0;
    }

    return bill;
  }
}
