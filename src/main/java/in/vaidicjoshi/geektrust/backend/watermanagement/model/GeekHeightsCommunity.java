package in.vaidicjoshi.geektrust.backend.watermanagement.model;

import in.vaidicjoshi.geektrust.backend.watermanagement.exception.WaterBillException;
import lombok.NonNull;

/**
 * @author Vaidic Joshi
 * @date 20/11/21
 */
public class GeekHeightsCommunity extends BillableCommunity {

  public GeekHeightsCommunity(
      @NonNull Integer allocatedWaterPerPersonLts, @NonNull Integer numberOfBillableDaysInMonth) {
    super(allocatedWaterPerPersonLts, numberOfBillableDaysInMonth);
  }

  @Override
  public Integer getTotalPeople() {
    if (!isInitializedBillableCommunity()) {
      throw new WaterBillException("The apartment type is not yet defined");
    }
    return getApartmentType().getNumberOfPeople() + getGuests();
  }

  @Override
  public int getTotalWaterConsumedInAMonth() {
    if (!isInitializedBillableCommunity()) {
      throw new WaterBillException("The apartment type is not yet defined");
    }
    return getNumberOfBillableDaysInMonth() * getTotalPeople() * getAllocatedWaterPerPersonLts();
  }
}
