package microservice.service.card;

import microservice.dto.card.CardAmountChangeRequestDTO;
import microservice.dto.card.CardRequestDTO;
import microservice.entity.DebtCard;
import microservice.repository.CardRepository;
import microservice.service.customer.CustomerService;
import microservice.service.validation.ValidationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class DebtCardServiceImplTest {

    @InjectMocks
    CardServiceImpl cardService;
    @Mock
    CustomerService customerService;
    @Mock
    ValidationService validationService;
    @Mock
    CardRepository cardRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void updateAmountById() throws Exception {
        when(cardRepository.findById(1L)).thenReturn(Optional.of(new DebtCard()));
        cardService.updateAmountById(1L, getChangeAmountRequest());
        verify(cardRepository, times(1)).save(any(DebtCard.class));
    }

    @Test
    void create() throws Exception {
        cardService.create(1L, getCustomerRequest());
        verify(customerService, times(1)).attachCard(any(Long.class), any(DebtCard.class));
    }

    private CardRequestDTO getCustomerRequest() {
        return new CardRequestDTO(
                100, "USD", "08/25");
    }

    private CardAmountChangeRequestDTO getChangeAmountRequest() {
        return new CardAmountChangeRequestDTO(200);
    }
}