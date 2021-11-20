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
  @Setter private Integer corporationShare;
  @Setter private Integer totalShare;
  @Setter private int guests;

  public BillableCommunity(
      @NonNull Integer allocatedWaterPerPersonLts, @NonNull Integer numberOfBillableDaysInMonth) {
    this.allocatedWaterPerPersonLts = allocatedWaterPerPersonLts;
    this.numberOfBillableDaysInMonth = numberOfBillableDaysInMonth;
  }

  public void addGuests(int guests) {
    this.guests += guests;
  }

  public abstract Integer getTotalPeople();

  public abstract int getTotalWaterConsumedInAMonth();

  public void initializeBillableCommunity(
      @NonNull ApartmentType apartmentType,
      @NonNull Integer corporationShare,
      @NonNull Integer totalShare) {
    this.totalShare = totalShare;
    this.corporationShare = corporationShare;
    this.apartmentType = apartmentType;
  }

  public boolean isInitializedBillableCommunity() {
    return Objects.nonNull(apartmentType)
        && Objects.nonNull(totalShare)
        && Objects.nonNull(corporationShare);
  }
}
