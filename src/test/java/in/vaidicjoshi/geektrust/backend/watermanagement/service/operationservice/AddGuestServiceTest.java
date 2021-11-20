package in.vaidicjoshi.geektrust.backend.watermanagement.service.operationservice;

import in.vaidicjoshi.geektrust.backend.watermanagement.enums.ApartmentType;
import in.vaidicjoshi.geektrust.backend.watermanagement.exception.WaterBillException;
import in.vaidicjoshi.geektrust.backend.watermanagement.model.GeekHeightsCommunity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Vaidic Joshi
 * @date 20/11/21
 */
class AddGuestServiceTest {
  @Mock AddGuestService service;
  @Mock GeekHeightsCommunity community;

  @BeforeEach
  void setUp() {
    service = AddGuestService.getInstance();
    community = new GeekHeightsCommunity(10, 30);
  }

  @Test
  public void testAddGuestWhenNotInitialized() {
    assertFalse(community.isInitializedBillableCommunity());

    assertThrows(
        WaterBillException.class,
        () -> service.processOperation(Collections.singletonList("10"), community));
  }

  @Test
  public void testAddGuest() {
    community.initializeBillableCommunity(ApartmentType.TW0_BEDROOM_APARTMENT, 3, 10);
    service.processOperation(Collections.singletonList("10"), community);
    assertEquals(Integer.valueOf(13), community.getTotalPeople());
  }
}
