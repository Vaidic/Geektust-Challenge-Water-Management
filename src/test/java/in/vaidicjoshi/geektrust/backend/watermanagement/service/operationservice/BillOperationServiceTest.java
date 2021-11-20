package in.vaidicjoshi.geektrust.backend.watermanagement.service.operationservice;

import in.vaidicjoshi.geektrust.backend.watermanagement.enums.ApartmentType;
import in.vaidicjoshi.geektrust.backend.watermanagement.model.GeekHeightsCommunity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Vaidic Joshi
 * @date 20/11/21
 */
class BillOperationServiceTest {
  @Mock BillOperationService service;
  @Mock GeekHeightsCommunity community;

  @BeforeEach
  void setUp() {
    service = BillOperationService.getInstance();
    community = new GeekHeightsCommunity(10, 30);
    community.initializeBillableCommunity(ApartmentType.TW0_BEDROOM_APARTMENT, 3, 10);
  }

  @Test
  public void testWithNoGuest() {
    assertEquals("900 1215", service.processOperation(null, community));
  }

  @Test
  public void testWithGuest() {
    community.addGuests(10);
    assertEquals("3900 12715", service.processOperation(null, community));
  }

  @Test
  public void testWithNoGuestAndRounding() {
    community.initializeBillableCommunity(ApartmentType.TW0_BEDROOM_APARTMENT, 1, 3);
    assertEquals("900 1200", service.processOperation(null, community));
  }

  @Test
  public void testWithGuestAndRounding() {
    community.addGuests(15);
    community.initializeBillableCommunity(ApartmentType.TW0_BEDROOM_APARTMENT, 1, 3);
    assertEquals("5400 24700", service.processOperation(null, community));
  }
}
