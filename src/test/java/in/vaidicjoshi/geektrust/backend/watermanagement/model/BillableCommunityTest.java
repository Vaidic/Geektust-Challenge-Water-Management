package in.vaidicjoshi.geektrust.backend.watermanagement.model;

import in.vaidicjoshi.geektrust.backend.watermanagement.enums.ApartmentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Vaidic Joshi
 * @date 20/11/21
 */
class BillableCommunityTest {
  @Mock BillableCommunity community;

  @BeforeEach
  void setUp() {
    community = new GeekHeightsCommunity(10, 30);
  }

  @Test
  void testGetTotalWaterConsumedInAMonth() {
    community.setApartmentType(ApartmentType.TW0_BEDROOM_APARTMENT);
    community.addGuests(10);
    community.addGuests(20);
    community.getTotalWaterConsumedInAMonth();
    assertEquals(33 * 300, community.getTotalWaterConsumedInAMonth());
  }

  @Test
  void testInitializeBillableCommunityWithValidValues() {
    community.initializeBillableCommunity(ApartmentType.TW0_BEDROOM_APARTMENT, 1, 5);
    assertTrue(community.isInitializedBillableCommunity());
  }

  @Test
  void testIsInitializedBillableCommunityReturnsFalse() {
    assertFalse(community.isInitializedBillableCommunity());
  }
}
