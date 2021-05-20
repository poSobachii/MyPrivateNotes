package gamma.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import java.math.BigDecimal;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "bet_strategy")
@Getter
@Setter
@NoArgsConstructor
public class BettingStrategy {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String strategyName;
    private BigDecimal startingSum;
    private BigDecimal maxRatio;
    private BigDecimal betSum;
    private BigDecimal currentSum;
    private Integer affectedBetQty;

    public BettingStrategy(BettingStrategyDTO bettingStrategyDTO) {
        this.strategyName = bettingStrategyDTO.getStrategyName();
        this.startingSum = bettingStrategyDTO.getStartingSum();
        this.currentSum = bettingStrategyDTO.getStartingSum();
        this.maxRatio = bettingStrategyDTO.getMaxRatio();
        this.betSum = bettingStrategyDTO.getBetSum();
        this.affectedBetQty = 0;
    }

    public void addAffectedBet() {
        this.affectedBetQty =+ 1;
    }
}
