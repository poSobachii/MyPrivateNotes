package microservice.dto.card;

import java.util.Objects;
import java.util.stream.Stream;

public class CardRequestDTO {

    private final int amount;
    private final String currency;
    private final String exp_date;

    public CardRequestDTO(int amount, String currency, String exp_date) {
        this.amount = amount;
        this.currency = currency;
        this.exp_date = exp_date;
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

    public boolean checkFieldsFilled() {
        return Stream.of(amount, currency, currency, exp_date)
                .anyMatch(Objects::isNull);
    }
}
