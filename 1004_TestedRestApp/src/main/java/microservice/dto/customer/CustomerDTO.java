package microservice.dto.customer;

import microservice.dto.card.DebtCardDTO;
import microservice.entity.Customer;

import java.util.List;

public class CustomerDTO {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private List<DebtCardDTO> cardList;

    public CustomerDTO() {
    }

    public CustomerDTO(Customer customer, List<DebtCardDTO> cardList) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.surname = customer.getSurname();
        this.email = customer.getEmail();
        this.password = customer.getPassword();
        this.cardList = cardList;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<DebtCardDTO> getCardList() {
        return cardList;
    }
}
