package microservice.dto.card;

public class CardAmountChangeRequestDTO {

    private int amount;

    public CardAmountChangeRequestDTO() {
    }

    public CardAmountChangeRequestDTO(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
