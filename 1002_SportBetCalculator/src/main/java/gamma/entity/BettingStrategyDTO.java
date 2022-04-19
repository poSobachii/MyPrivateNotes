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
public class BettingStrategyDTO {

    private String strategyName;
    private BigDecimal startingSum;
    private BigDecimal maxRatio;
    private BigDecimal betSum;
}
