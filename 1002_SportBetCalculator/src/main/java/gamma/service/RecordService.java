package gamma.service;

import gamma.entity.DataRecord;
import gamma.entity.DataRecordDTO;

import java.util.List;

public interface RecordService {


    List<DataRecord> getAllOpenedRecords();

    void addNewRecord(DataRecordDTO recordDto);

    void deleteRecord(Long path);

    void proceedResult(Long path, Integer result);

    void calculateBet(Long path);

    void hideRecord(Long path);

    String getDate();
}

