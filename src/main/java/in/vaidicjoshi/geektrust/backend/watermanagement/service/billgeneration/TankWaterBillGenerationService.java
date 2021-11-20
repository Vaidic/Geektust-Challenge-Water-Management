package in.vaidicjoshi.geektrust.backend.watermanagement.service.billgeneration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vaidic Joshi
 * @date 20/11/21
 */
public class TankWaterBillGenerationService extends BillGenerationService {
  private static final Map<Integer, Double> maxUptoBillRate = new HashMap<>();

  static {
    maxUptoBillRate.put(500, 2.0);
    maxUptoBillRate.put(1500, 3.0);
    maxUptoBillRate.put(3000, 5.0);
    maxUptoBillRate.put(Integer.MAX_VALUE, 8.0);
  }

  public TankWaterBillGenerationService() {
    super(maxUptoBillRate);
  }
}
