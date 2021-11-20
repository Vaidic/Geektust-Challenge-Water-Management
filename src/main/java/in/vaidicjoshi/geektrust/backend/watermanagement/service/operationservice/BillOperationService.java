package in.vaidicjoshi.geektrust.backend.watermanagement.service.operationservice;

import in.vaidicjoshi.geektrust.backend.watermanagement.model.BillableCommunity;
import in.vaidicjoshi.geektrust.backend.watermanagement.service.billgeneration.BoreWellBillGenerationService;
import in.vaidicjoshi.geektrust.backend.watermanagement.service.billgeneration.CorporationBillGenerationService;
import in.vaidicjoshi.geektrust.backend.watermanagement.service.billgeneration.TankWaterBillGenerationService;
import lombok.Getter;

import java.util.List;
import java.util.StringJoiner;

/**
 * @author Vaidic Joshi
 * @date 20/11/21
 */
public class BillOperationService implements OperationService {
  @Getter private static final BillOperationService instance = new BillOperationService();

  private BillOperationService() {}

  @Override
  public String processOperation(List<String> arguments, BillableCommunity community) {
    StringJoiner bill = new StringJoiner(" ");
    bill.add(Integer.toString(community.getTotalWaterConsumedInAMonth()));
    double billValue = 0.0;

    billValue +=
        new CorporationBillGenerationService()
            .generateBill(
                community.getApartmentType().getNumberOfPeople(),
                community.getAllocatedWaterPerPersonLts(),
                community.getNumberOfBillableDaysInMonth(),
                community.getRatio());

    billValue +=
        new BoreWellBillGenerationService()
            .generateBill(
                community.getApartmentType().getNumberOfPeople(),
                community.getAllocatedWaterPerPersonLts(),
                community.getNumberOfBillableDaysInMonth(),
                1 - community.getRatio());

    billValue +=
        new TankWaterBillGenerationService()
            .generateBill(
                community.getGuests(),
                community.getAllocatedWaterPerPersonLts(),
                community.getNumberOfBillableDaysInMonth(),
                1);
    bill.add(Integer.toString((int) Math.round(billValue)));
    return bill.toString();
  }
}
