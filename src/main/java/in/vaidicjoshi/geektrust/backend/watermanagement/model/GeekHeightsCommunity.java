package in.vaidicjoshi.geektrust.backend.watermanagement.model;

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
    return getApartmentType().getNumberOfPeople() + getGuests();
  }

  @Override
  public int getTotalWaterConsumedInAMonth() {
    return getNumberOfBillableDaysInMonth() * getTotalPeople() * getAllocatedWaterPerPersonLts();
  }
}
