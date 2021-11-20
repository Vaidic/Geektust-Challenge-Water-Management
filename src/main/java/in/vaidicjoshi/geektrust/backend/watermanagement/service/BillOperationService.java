package in.vaidicjoshi.geektrust.backend.watermanagement.service;

import in.vaidicjoshi.geektrust.backend.watermanagement.model.BillableCommunity;
import lombok.Getter;

import java.util.List;

/**
 * @author Vaidic Joshi
 * @date 20/11/21
 */
public class BillOperationService implements OperationService {
  @Getter private static final BillOperationService instance = new BillOperationService();

  private BillOperationService() {}

  @Override
  public String processOperation(List<String> arguments, BillableCommunity community) {
    return null;
  }
}
