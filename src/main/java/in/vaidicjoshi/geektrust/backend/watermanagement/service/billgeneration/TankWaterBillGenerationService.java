package in.vaidicjoshi.geektrust.backend.watermanagement.service.billgeneration;

/**
 * @author Vaidic Joshi
 * @date 20/11/21
 */
public class TankWaterBillGenerationService extends BillGenerationService {

  public TankWaterBillGenerationService(int people, int lts, int days) {
    super(people, lts, days, 1);
  }

  @Override
  protected void updateMaxUptoBillRate() {
    getMaxUptoBillRate().put(500, 2.0);
    getMaxUptoBillRate().put(1500, 3.0);
    getMaxUptoBillRate().put(3000, 5.0);
    getMaxUptoBillRate().put(Integer.MAX_VALUE, 8.0);
  }
}
