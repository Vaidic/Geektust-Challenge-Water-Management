package in.vaidicjoshi.geektrust.backend.watermanagement.model;

import in.vaidicjoshi.geektrust.backend.watermanagement.enums.Room;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Vaidic Joshi
 * @date 20/11/21
 */
@Getter
public abstract class BillableCommunity {

  @NonNull private final Room room;
  @NonNull private final Double ratio;

  @Setter private int allocatedWaterPerPersonLts;
  @Setter private int numberOfBillableDaysInMonth;

  private Integer guests;

  public BillableCommunity(@NonNull Room room, @NonNull Double ratio) {
    this.room = room;
    this.ratio = ratio;
    this.guests = 0;
    initializeBillableCommunity();
  }

  public void addGuests(int guests) {
    this.guests += guests;
  }

  public abstract int getTotalPeople();

  public abstract void initializeBillableCommunity();
}
