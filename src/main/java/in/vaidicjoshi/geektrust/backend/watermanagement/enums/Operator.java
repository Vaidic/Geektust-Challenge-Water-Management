package in.vaidicjoshi.geektrust.backend.watermanagement.enums;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author Vaidic Joshi
 * @date 20/11/21
 */
@RequiredArgsConstructor
@Getter
public enum Operator {
  ALLOT_WATER(2),
  ADD_GUESTS(1),
  BILL(0);

  @NonNull private Integer numberOfArguments;
  //    @NonNull private Supplier<? extends WaterOperationService> operationService;
}
