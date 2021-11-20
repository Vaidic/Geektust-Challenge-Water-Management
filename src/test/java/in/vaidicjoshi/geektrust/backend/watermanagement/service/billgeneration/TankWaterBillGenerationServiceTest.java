package in.vaidicjoshi.geektrust.backend.watermanagement.service.billgeneration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Vaidic Joshi
 * @date 20/11/21
 */
class TankWaterBillGenerationServiceTest {
  @Mock TankWaterBillGenerationService service;

  @BeforeEach
  void setUp() {
    service = new TankWaterBillGenerationService(100, 10, 30);
  }

  @Test
  public void testGenerateBill() {
    assertEquals(227500.0, service.generateBill());
  }
}
