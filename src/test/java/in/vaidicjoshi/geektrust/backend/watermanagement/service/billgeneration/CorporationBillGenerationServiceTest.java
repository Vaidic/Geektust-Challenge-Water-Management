package in.vaidicjoshi.geektrust.backend.watermanagement.service.billgeneration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Vaidic Joshi
 * @date 20/11/21
 */
class CorporationBillGenerationServiceTest {
  @Mock CorporationBillGenerationService service;

  @BeforeEach
  void setUp() {
    service = new CorporationBillGenerationService(10, 10, 30, 0.10);
  }

  @Test
  public void testGenerateBill() {
    assertEquals(300.0, service.generateBill());
  }
}
