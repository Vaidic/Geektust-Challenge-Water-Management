package in.vaidicjoshi.geektrust.backend.watermanagement.model;

import in.vaidicjoshi.geektrust.backend.watermanagement.enums.Room;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Objects;

/**
 * @author Vaidic Joshi
 * @date 20/11/21
 */
@Getter
public abstract class BillableCommunity {

  @NonNull private final Integer allocatedWaterPerPersonLts;
  @NonNull private final Integer numberOfBillableDaysInMonth;
  @Setter private Room room;
  @Setter private Double ratio;

  public BillableCommunity(
      @NonNull Integer allocatedWaterPerPersonLts, @NonNull Integer numberOfBillableDaysInMonth) {
    this.allocatedWaterPerPersonLts = allocatedWaterPerPersonLts;
    this.numberOfBillableDaysInMonth = numberOfBillableDaysInMonth;
  }

  @Setter private int guests;

  public void addGuests(int guests) {
    this.guests += guests;
  }

  public abstract int getTotalPeople();

  public void initializeBillableCommunity(@NonNull Room room, @NonNull Double ratio) {
    this.ratio = ratio;
    this.room = room;
  }

  public boolean isInitializedBillableCommunity() {
    return Objects.nonNull(room) && Objects.nonNull(ratio);
  }
}
