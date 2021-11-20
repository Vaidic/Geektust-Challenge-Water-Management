package in.vaidicjoshi.geektrust.backend.watermanagement.model;

import in.vaidicjoshi.geektrust.backend.watermanagement.enums.GeekHeightsRoom;
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
  public int getTotalPeople() {
    GeekHeightsRoom room = (GeekHeightsRoom) getRoom();
    return room.getNumberOfPeople() + getGuests();
  }
}
