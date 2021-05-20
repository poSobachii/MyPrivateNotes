package gamma.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DataRecordDTO {
    private String dateOfMatch;

    private String nameTeamOne;
    private BigDecimal betRateTeamOne;

    private String nameTeamTwo;
    private BigDecimal betRateTeamTwo;

}
