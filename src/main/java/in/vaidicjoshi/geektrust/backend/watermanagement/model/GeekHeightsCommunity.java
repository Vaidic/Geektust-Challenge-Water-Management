package in.vaidicjoshi.geektrust.backend.watermanagement.model;

import in.vaidicjoshi.geektrust.backend.watermanagement.enums.ApartmentType;
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
    ApartmentType room = getApartmentType();
    return room.getNumberOfPeople() + getGuests();
  }
}
