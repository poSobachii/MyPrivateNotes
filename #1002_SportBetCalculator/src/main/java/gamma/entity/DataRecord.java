package gamma.entity;

import gamma.enums.BetResult;
import gamma.enums.BetStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "bet_record_nhl")
@Getter
@Setter
@NoArgsConstructor
public class DataRecord {

    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String dateOfMatch;
    @Enumerated(EnumType.STRING)
    private BetStatus betStatus;
    @Enumerated(EnumType.STRING)
    private BetResult betResult;

    private String nameTeamOne;
    private BigDecimal betRateTeamOne;
    private BigDecimal betSizeTeamOne;

    private String nameTeamTwo;
    private BigDecimal betRateTeamTwo;
    private BigDecimal betSizeTeamTwo;

    private BigDecimal betSum;
    private BigDecimal cleanWinSum;
    private BigDecimal winRatio;

    public DataRecord(DataRecordDTO dataRecordDTO) {
        this.dateOfMatch = dataRecordDTO.getDateOfMatch();
        this.nameTeamOne = dataRecordDTO.getNameTeamOne();
        this.nameTeamTwo = dataRecordDTO.getNameTeamTwo();
        this.betRateTeamOne = dataRecordDTO.getBetRateTeamOne();
        this.betRateTeamTwo = dataRecordDTO.getBetRateTeamTwo();
    }
}
