package in.vaidicjoshi.geektrust.backend.watermanagement.model;

import in.vaidicjoshi.geektrust.backend.watermanagement.enums.ApartmentType;
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
  @Setter private ApartmentType apartmentType;
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

  public abstract Integer getTotalPeople();

  public void initializeBillableCommunity(
      @NonNull ApartmentType apartmentType, @NonNull Double ratio) {
    this.ratio = ratio;
    this.apartmentType = apartmentType;
  }

  public boolean isInitializedBillableCommunity() {
    return Objects.nonNull(apartmentType) && Objects.nonNull(ratio);
  }
}
