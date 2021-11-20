package in.vaidicjoshi.geektrust.backend.watermanagement.model;

import in.vaidicjoshi.geektrust.backend.watermanagement.enums.Operator;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Vaidic Joshi
 * @date 20/11/21
 */
@RequiredArgsConstructor
@Getter
public class Command {
  @NonNull private Operator operator;
  @NonNull private List<String> operands;

  public static Command from(String str) {
    try {
      String[] commandWithArguments = str.split(" ");
      Operator operator = Operator.valueOf(commandWithArguments[0]);
      List<String> operands =
          Arrays.stream(commandWithArguments).skip(1).collect(Collectors.toList());
      Command command = new Command(operator, operands);
      command.validateOperandCardinality();
      return command;
    } catch (Exception e) {
      throw new UnsupportedOperationException("Invalid Command Supplied: " + str);
    }
  }

  public void validateOperandCardinality() {
    if (this.operator.getNumberOfArguments() != operands.size()) {
      throw new InputMismatchException("The number of arguments does not is not correct.");
    }
  }
}
