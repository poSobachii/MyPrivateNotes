package gamma.service;

import gamma.entity.BettingStrategy;
import gamma.entity.BettingStrategyDTO;
import gamma.entity.DataRecord;
import gamma.enums.BetResult;
import gamma.repository.BettingStrategyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StrategyServiceImpl implements StrategyService {

    @Autowired
    BettingStrategyRepository bettingStrategyRepository;

    @Override
    public void addNewStrategy(BettingStrategyDTO bettingStrategyDTO) {
        BettingStrategy entity = new BettingStrategy(bettingStrategyDTO);
        bettingStrategyRepository.save(entity);
    }

    @Override
    public List<BettingStrategy> getAllStrategies() {
        return bettingStrategyRepository.findAll();
    }

    @Override
    public void deleteStrategy(Long path) {
        bettingStrategyRepository.deleteById(path);
    }

    @Override
    public void calculateStrategies(DataRecord dataRecord) {
        List<BettingStrategy> strategies = bettingStrategyRepository.findAll();
        for (BettingStrategy str : strategies) {
            int compare = str.getMaxRatio().compareTo(dataRecord.getWinRatio());
            if(compare >= 0) {
                if(dataRecord.getBetResult().equals(BetResult.LOST)) {
                    str.setCurrentSum(str.getCurrentSum().subtract(dataRecord.getBetSum()));
                    str.addAffectedBet();
                } else {
                    str.setCurrentSum(str.getCurrentSum().add(dataRecord.getCleanWinSum()));
                    str.addAffectedBet();
                }
            }
        }
        bettingStrategyRepository.saveAll(strategies);
    }
}
