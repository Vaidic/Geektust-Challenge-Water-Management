package in.vaidicjoshi.geektrust.backend.watermanagement.enums;

import in.vaidicjoshi.geektrust.backend.watermanagement.service.operationservice.AddGuestService;
import in.vaidicjoshi.geektrust.backend.watermanagement.service.operationservice.AllotWaterService;
import in.vaidicjoshi.geektrust.backend.watermanagement.service.operationservice.BillOperationService;
import in.vaidicjoshi.geektrust.backend.watermanagement.service.operationservice.OperationService;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.function.Supplier;

/**
 * @author Vaidic Joshi
 * @date 20/11/21
 */
@RequiredArgsConstructor
@Getter
public enum Operator {
  ALLOT_WATER(2, AllotWaterService::getInstance),
  ADD_GUESTS(1, AddGuestService::getInstance),
  BILL(0, BillOperationService::getInstance);

  @NonNull private Integer numberOfArguments;
  @NonNull private Supplier<? extends OperationService> operationService;
}
