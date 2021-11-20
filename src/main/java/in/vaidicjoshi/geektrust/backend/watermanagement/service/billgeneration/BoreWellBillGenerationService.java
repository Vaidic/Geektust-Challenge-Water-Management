package in.vaidicjoshi.geektrust.backend.watermanagement.service.billgeneration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vaidic Joshi
 * @date 20/11/21
 */
public class BoreWellBillGenerationService extends BillGenerationService {
  private static final Map<Integer, Double> maxUptoBillRate = new HashMap<>();

  static {
    maxUptoBillRate.put(Integer.MAX_VALUE, 1.5);
  }

  public BoreWellBillGenerationService() {
    super(maxUptoBillRate);
  }
}
