package in.vaidicjoshi.geektrust.backend.watermanagement.service;

import in.vaidicjoshi.geektrust.backend.watermanagement.model.BillableCommunity;
import lombok.Getter;

import java.util.List;

/**
 * @author Vaidic Joshi
 * @date 20/11/21
 */
public class AllotWaterService implements CommunityOperationService{
    @Getter
    private static final AllotWaterService instance = new AllotWaterService();

    private AllotWaterService() {}

    @Override
    public String processOperation(List<String> arguments, BillableCommunity community) {
    return null;
    }
}
