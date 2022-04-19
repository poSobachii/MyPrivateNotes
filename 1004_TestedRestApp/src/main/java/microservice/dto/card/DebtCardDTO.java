package microservice.dto.card;

import microservice.entity.DebtCard;

public class DebtCardDTO {

    private Long id;
    private int amount;
    private String currency;
    private String exp_date;

    public DebtCardDTO() {
    }

    public DebtCardDTO(DebtCard debtCard) {
        this.id = debtCard.getId();
        this.amount = debtCard.getAmount();
        this.currency = debtCard.getCurrency();
        this.exp_date = debtCard.getExp_date();
    }

    public Long getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getExp_date() {
        return exp_date;
    }
}
