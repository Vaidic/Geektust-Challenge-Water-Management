package in.vaidicjoshi.geektrust.backend.watermanagement.service.operationservice;

import in.vaidicjoshi.geektrust.backend.watermanagement.exception.WaterBillException;
import in.vaidicjoshi.geektrust.backend.watermanagement.model.BillableCommunity;
import lombok.Getter;

import java.util.List;

/**
 * @author Vaidic Joshi
 * @date 20/11/21
 */
public class AddGuestService implements CommunityOperationService {
  @Getter private static final AddGuestService instance = new AddGuestService();

  private AddGuestService() {}

  @Override
  public String processOperation(List<String> arguments, BillableCommunity community)
      throws WaterBillException {
    int guests = Integer.parseInt(arguments.get(0));
    if (!community.isInitializedBillableCommunity()) {
      throw new WaterBillException("Guests cannot be added before adding Appartment");
    }
    community.addGuests(guests);
    return null;
  }
}
