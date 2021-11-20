package in.vaidicjoshi.geektrust.backend.watermanagement.model;

import in.vaidicjoshi.geektrust.backend.watermanagement.enums.Operator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Vaidic Joshi
 * @date 20/11/21
 */
class CommandTest {
  @Mock Command command;

  @BeforeEach
  void setUp() {
    command = Mockito.mock(Command.class);
  }

  @Test
  void testFromWithValidInput() {
    String input = "ALLOT_WATER 3 1:5";
    Command command = Command.from(input);
    assertEquals(Operator.ALLOT_WATER, command.getOperator());
    assertEquals(Arrays.asList("3", "1:5"), command.getOperands());
    input = "ADD_GUESTS 10";
    command = Command.from(input);
    assertEquals(Operator.ADD_GUESTS, command.getOperator());
    assertEquals(Collections.singletonList("10"), command.getOperands());
    input = "BILL";
    command = Command.from(input);
    assertEquals(Operator.BILL, command.getOperator());
    assertEquals(Collections.emptyList(), command.getOperands());
  }

  @Test
  void testFromWithValidArgumentCardinality() {
    final String input = "ALLOT_WATER 3 1:5";
    assertDoesNotThrow(() -> Command.from(input));
    final String anotherInput = "ADD_GUESTS 5";
    assertDoesNotThrow(() -> Command.from(anotherInput));
  }

  @Test
  void testFromWithInValidOperation() {
    final String input = "ADD_GUESTS 10 2";
    assertThrows(UnsupportedOperationException.class, () -> Command.from(input));
    final String anotherInput = "ALLOT_WATER 3";
    assertThrows(UnsupportedOperationException.class, () -> Command.from(anotherInput));
  }

  @Test
  void testConstructorWithNullValues() {
    assertThrows(NullPointerException.class, () -> new Command(Operator.ALLOT_WATER, null));
    assertThrows(NullPointerException.class, () -> new Command(null, new ArrayList<>()));
    assertThrows(NullPointerException.class, () -> new Command(null, null));
  }
}
