package in.vaidicjoshi.geektrust.backend.watermanagement.model;

import in.vaidicjoshi.geektrust.backend.watermanagement.enums.GeekHeightsRoom;
import in.vaidicjoshi.geektrust.backend.watermanagement.enums.Room;
import lombok.NonNull;

/**
 * @author Vaidic Joshi
 * @date 20/11/21
 */
public class GeekHeightsCommunity extends BillableCommunity {

  public GeekHeightsCommunity(@NonNull Room room, @NonNull Double ratio) {
    super(room, ratio);
  }

  @Override
  public int getTotalPeople() {
    GeekHeightsRoom room = (GeekHeightsRoom) getRoom();
    return room.getNumberOfPeople() + getGuests();
  }

  @Override
  public void initializeBillableCommunity() {
    this.setAllocatedWaterPerPersonLts(10);
    this.setNumberOfBillableDaysInMonth(30);
  }
}
