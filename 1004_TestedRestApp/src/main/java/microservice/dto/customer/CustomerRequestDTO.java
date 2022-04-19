package microservice.dto.customer;

import java.util.Objects;
import java.util.stream.Stream;

public class CustomerRequestDTO {

    private final String name;
    private final String surname;
    private final String country;
    private final String email;
    private final String password;

    public CustomerRequestDTO(String name, String surname, String country, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.country= country;
        this.email = email;
        this.password = password;
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

    public String getCountry() {
        return country;
    }

    public boolean checkFieldsFilled() {
        return Stream.of(name, surname, country, email, password)
                .anyMatch(Objects::isNull);
    }
}
