package gamma.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SimpleRecordDTO {
    private String firstTeam;
    private Double firstTeamRate;
    private String secondTeam;
    private Double secondTeamRate;
    private Integer betMinimalAmount;


}
