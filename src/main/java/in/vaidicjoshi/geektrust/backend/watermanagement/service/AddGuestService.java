package in.vaidicjoshi.geektrust.backend.watermanagement.service;

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
  public String processOperation(List<String> arguments, BillableCommunity community) {
    return null;
  }
}
