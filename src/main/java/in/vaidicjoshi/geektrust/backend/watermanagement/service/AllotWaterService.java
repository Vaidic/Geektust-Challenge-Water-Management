package in.vaidicjoshi.geektrust.backend.watermanagement.service;

import in.vaidicjoshi.geektrust.backend.watermanagement.enums.ApartmentType;
import in.vaidicjoshi.geektrust.backend.watermanagement.exception.WaterBillException;
import in.vaidicjoshi.geektrust.backend.watermanagement.model.BillableCommunity;
import lombok.Getter;

import java.util.List;

/**
 * @author Vaidic Joshi
 * @date 20/11/21
 */
public class AllotWaterService implements CommunityOperationService {
  @Getter private static final AllotWaterService instance = new AllotWaterService();

  private AllotWaterService() {}

  @Override
  public String processOperation(List<String> arguments, BillableCommunity community)
      throws WaterBillException {
    int numberOfRooms = Integer.parseInt(arguments.get(0));
    String[] split = arguments.get(1).split(":");
    Double ratio = 1.0 * Integer.parseInt(split[0]) / Integer.parseInt(split[1]);
    community.initializeBillableCommunity(ApartmentType.fromNumberOfRooms(numberOfRooms), ratio);
    return null;
  }
}
