package gamma.service;

import gamma.entity.DataRecord;
import gamma.entity.DataRecordDTO;
import gamma.enums.BetResult;
import gamma.repository.DataRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;

import static gamma.enums.BetStatus.CALCULATED;
import static gamma.enums.BetStatus.CLOSED;
import static gamma.enums.BetStatus.COMPLETED;
import static gamma.enums.BetStatus.CREATED;

@Service
public class RecordServiceImpl implements RecordService {

    private BigDecimal minimalBetSize = BigDecimal.TEN;
    private String date;

    @Autowired
    DataRecordRepository dataRecordRepository;
    @Autowired
    StrategyService strategyService;

    @Override
    public List<DataRecord> getAllOpenedRecords() {
        List<DataRecord> dataRecordList =  dataRecordRepository.findNonHidden();
        dataRecordList.sort(Comparator.comparing(DataRecord::getDateOfMatch));
        return dataRecordList;
    }

    @Override
    public void addNewRecord(DataRecordDTO recordDto) {
        if(!recordDto.getDateOfMatch().equals("")) {
            this.date = recordDto.getDateOfMatch();
        }

        String[] teams = recordDto.getTeamNames().split("-");
        String teamOne = teams[0];
        String teamTwo = teams[1];
        DataRecord dataRecord = new DataRecord(date, teamOne , teamTwo ,recordDto.getBetRateTeamOne() ,recordDto.getBetRateTeamTwo());

        calculateBetSize(dataRecord, recordDto);
        dataRecord.setBetStatus(CREATED);
        dataRecordRepository.save(dataRecord);
    }

    @Override
    public void deleteRecord(Long path) {
        dataRecordRepository.deleteById(path);
    }

    @Override
    public void proceedResult(Long path, Integer result) {
        DataRecord dataRecord = dataRecordRepository.getOne(path);
        switch (result) {
            case 1:
                dataRecord.setBetResult(BetResult.TEAM_ONE);
                break;
            case 2:
                dataRecord.setBetResult(BetResult.TEAM_TWO);
                break;
            default:
                dataRecord.setBetResult(BetResult.LOST);
        }
        dataRecord.setBetStatus(COMPLETED);
        dataRecordRepository.save(dataRecord);
    }

    @Override
    public void calculateBet(Long path) {
        DataRecord dataRecord = dataRecordRepository.getOne(path);
        strategyService.calculateStrategies(dataRecord);
        dataRecord.setBetStatus(CALCULATED);
        dataRecordRepository.save(dataRecord);
    }

    @Override
    public void hideRecord(Long path) {
        DataRecord dataRecord = dataRecordRepository.getOne(path);
        dataRecord.setBetStatus(CLOSED);
        dataRecordRepository.save(dataRecord);
    }

    @Override
    public String getDate() {
        return date;
    }

    private void calculateBetSize(DataRecord record, DataRecordDTO recordDTO) {
        int compare = recordDTO.getBetRateTeamOne().compareTo(recordDTO.getBetRateTeamTwo());
        BigDecimal maxWinSize;
        BigDecimal otherTeamBetSize;

        if(compare > 0) {
            System.out.println("T_1 ratio is bigger: " + recordDTO.getBetRateTeamOne() + " T_2 ratio: " + recordDTO.getBetRateTeamTwo());
            maxWinSize = minimalBetSize.multiply(recordDTO.getBetRateTeamOne());
            otherTeamBetSize = maxWinSize.divide(recordDTO.getBetRateTeamTwo(), 2, RoundingMode.CEILING);
            record.setBetSizeTeamOne(minimalBetSize);
            record.setBetSizeTeamTwo(otherTeamBetSize);

        } else if (compare < 0) {
            System.out.println("T_2 ratio is bigger: " + recordDTO.getBetRateTeamTwo() + " T_1 ratio: " + recordDTO.getBetRateTeamOne());
            maxWinSize = minimalBetSize.multiply(recordDTO.getBetRateTeamTwo());
            otherTeamBetSize = maxWinSize.divide(recordDTO.getBetRateTeamOne(), 2, RoundingMode.CEILING);
            record.setBetSizeTeamOne(otherTeamBetSize);
            record.setBetSizeTeamTwo(minimalBetSize);
        } else {
            System.out.println("Ratio are equals");
            maxWinSize = minimalBetSize.multiply(recordDTO.getBetRateTeamTwo());
            otherTeamBetSize = minimalBetSize;
            record.setBetSizeTeamOne(minimalBetSize);
            record.setBetSizeTeamTwo(minimalBetSize);
        }

        BigDecimal amountSpent = minimalBetSize.add(otherTeamBetSize);
        BigDecimal profit = maxWinSize.subtract(minimalBetSize).subtract(otherTeamBetSize);
        BigDecimal profitRatio = amountSpent.divide(profit, 2, RoundingMode.CEILING);

        record.setBetSum(amountSpent);
        record.setCleanWinSum(profit);
        record.setWinRatio(profitRatio);

    }


}
