package in.vaidicjoshi.geektrust.backend.watermanagement.service.billgeneration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Vaidic Joshi
 * @date 20/11/21
 */
class BoreWellBillGenerationServiceTest {
  @Mock BoreWellBillGenerationService service;

  @BeforeEach
  void setUp() {
    service = new BoreWellBillGenerationService(10, 10, 30, 1);
  }

  @Test
  public void testGenerateBill() {
    assertEquals(4500.0, service.generateBill());
  }
}
