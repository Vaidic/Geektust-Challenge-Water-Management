package in.vaidicjoshi.geektrust.backend.watermanagement.service.billgeneration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vaidic Joshi
 * @date 20/11/21
 */
public class CorporationBillGenerationService extends BillGenerationService {
  private static final Map<Integer, Double> maxUptoBillRate = new HashMap<>();

  static {
    maxUptoBillRate.put(Integer.MAX_VALUE, 1.0);
  }

  public CorporationBillGenerationService() {
    super(maxUptoBillRate);
  }
}
