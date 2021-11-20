package in.vaidicjoshi.geektrust.backend.watermanagement.model;

import in.vaidicjoshi.geektrust.backend.watermanagement.enums.ApartmentType;
import in.vaidicjoshi.geektrust.backend.watermanagement.exception.WaterBillException;
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
    community.initializeBillableCommunity(ApartmentType.TW0_BEDROOM_APARTMENT, 1, 5);
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

  @Test
  void testGetTotalPeopleWhenNotInitialized() {
    assertThrows(WaterBillException.class, () -> community.getTotalPeople());
  }

  @Test
  void testTotalWaterConsumedInAMonthWhenNotInitialized() {
    assertThrows(WaterBillException.class, () -> community.getTotalWaterConsumedInAMonth());
  }

  @Test
  void testGetTotalPeople() {
    community.initializeBillableCommunity(ApartmentType.THREE_BEDROOM_APARTMENT, 1, 5);
    community.addGuests(10);
    community.addGuests(20);
    assertEquals(Integer.valueOf(35), community.getTotalPeople());
  }

  @Test
  void testAddGuestsWhenNotInitialized() {
    assertThrows(WaterBillException.class, () -> community.addGuests(10));
  }

  @Test
  void testAddGuests() {
    community.initializeBillableCommunity(ApartmentType.TW0_BEDROOM_APARTMENT, 1, 5);
    community.addGuests(10);
    assertEquals(Integer.valueOf(13), community.getTotalPeople());
  }
}
