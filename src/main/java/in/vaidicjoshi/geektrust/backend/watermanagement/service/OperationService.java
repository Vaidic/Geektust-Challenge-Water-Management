package in.vaidicjoshi.geektrust.backend.watermanagement.service;

import in.vaidicjoshi.geektrust.backend.watermanagement.model.BillableCommunity;

import java.util.List;

/**
 * @author Vaidic Joshi
 * @date 20/11/21
 */
public interface OperationService {
  String processOperation(List<String> arguments, BillableCommunity community);
}
