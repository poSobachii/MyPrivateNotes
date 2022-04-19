package gamma.service;

import gamma.entity.BettingStrategy;
import gamma.entity.BettingStrategyDTO;
import gamma.entity.DataRecord;

import java.util.List;

public interface StrategyService {
    void addNewStrategy(BettingStrategyDTO bettingStrategyDTO);

    List<BettingStrategy> getAllStrategies();

    void deleteStrategy(Long path);

    void calculateStrategies(DataRecord dataRecord);
}
