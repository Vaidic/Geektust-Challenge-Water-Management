package in.vaidicjoshi.geektrust.backend.watermanagement.service.operationservice;

import in.vaidicjoshi.geektrust.backend.watermanagement.model.GeekHeightsCommunity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Vaidic Joshi
 * @date 20/11/21
 */
class AllotWaterServiceTest {
  @Mock AllotWaterService service;
  @Mock GeekHeightsCommunity community;

  @BeforeEach
  void setUp() {
    service = AllotWaterService.getInstance();
    community = new GeekHeightsCommunity(10, 30);
  }

  @Test
  public void testAllotWater() {
    assertFalse(community.isInitializedBillableCommunity());
    service.processOperation(Arrays.asList("2", "1:3"), community);
    assertEquals(Integer.valueOf(3), community.getTotalPeople());
    assertTrue(community.isInitializedBillableCommunity());
  }
}
