package in.vaidicjoshi.geektrust.backend.watermanagement.service.billgeneration;

/**
 * @author Vaidic Joshi
 * @date 20/11/21
 */
public class BoreWellBillGenerationService extends BillGenerationService {

  public BoreWellBillGenerationService(int people, int lts, int days, double ratio) {
    super(people, lts, days, ratio);
  }

  @Override
  protected void updateMaxUptoBillRate() {
    getMaxUptoBillRate().put(Integer.MAX_VALUE, 1.5);
  }
}
