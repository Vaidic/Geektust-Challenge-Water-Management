package in.vaidicjoshi.geektrust.backend.watermanagement.enums;

import in.vaidicjoshi.geektrust.backend.watermanagement.exception.WaterBillException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Vaidic Joshi
 * @date 20/11/21
 */
class ApartmentTypeTest {

  @Test
  public void testValidConversion() {
    assertEquals(ApartmentType.TW0_BEDROOM_APARTMENT, ApartmentType.fromNumberOfRooms(2));
    assertEquals(ApartmentType.THREE_BEDROOM_APARTMENT, ApartmentType.fromNumberOfRooms(3));
  }

  @Test
  public void testInValidConversion() {
    assertThrows(WaterBillException.class, () -> ApartmentType.fromNumberOfRooms(20));
  }
}
