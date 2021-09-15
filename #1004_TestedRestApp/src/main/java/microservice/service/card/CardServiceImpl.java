package microservice.service.card;

import microservice.dto.card.CardAmountChangeRequestDTO;
import microservice.dto.card.DebtCardDTO;
import microservice.dto.card.CardRequestDTO;
import microservice.entity.DebtCard;
import microservice.entity.enums.ValidationRule;
import microservice.repository.CardRepository;
import microservice.service.customer.CustomerService;
import microservice.service.validation.ValidationService;
import microservice.service.validation.pojo.EmptyFieldException;
import microservice.service.validation.pojo.NegativeAmountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private ValidationService validationService;

    @Override
    public void deleteById(Long cardId) {
        cardRepository.delete(getIfExists(cardId));
    }

    @Override
    public void updateAmountById(Long cardId, CardAmountChangeRequestDTO amountChange) throws Exception {
        checkAmountIsPositive(amountChange.getAmount());
        DebtCard debtCardToUpdate = getIfExists(cardId);
        debtCardToUpdate.setAmount(amountChange.getAmount());
        cardRepository.save(debtCardToUpdate);
    }

    @Override
    public void create(Long customerId, CardRequestDTO cardRequest) throws Exception {
        if (cardRequest.checkFieldsFilled()) {
            throw new EmptyFieldException();
        }
        validationService.validateFieldIsCorrect(cardRequest.getExp_date(), ValidationRule.CARD_EXPIRATION_DATE);
        checkAmountIsPositive(cardRequest.getAmount());

        DebtCard debtCard = transformToEntity(cardRequest);
        customerService.attachCard(customerId, debtCard);
    }

    @Override
    public List<DebtCardDTO> getAll() {
        return transformToCardDto(cardRepository.findAll());
    }

    @Override
    public DebtCardDTO getOnById(Long id) {
        return new DebtCardDTO(getIfExists(id));
    }

    @Override
    public List<DebtCardDTO> transformToCardDto(List<DebtCard> debtCardList) {
        if (!debtCardList.isEmpty()) {
            return debtCardList.stream().map(DebtCardDTO::new).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    private void checkAmountIsPositive(int amount) throws NegativeAmountException {
        if (amount < 0) {
            throw new NegativeAmountException();
        }
    }


    private DebtCard transformToEntity(CardRequestDTO cardRequest) {
        return new DebtCard(
                cardRequest.getAmount(),
                cardRequest.getCurrency(),
                cardRequest.getExp_date()
        );
    }

    private DebtCard getIfExists(Long id) {
        DebtCard debtCard = cardRepository.findById(id).orElse(null);
        if (debtCard == null) {
            String message = MessageFormat.format("No card with id [{0}] found", id);
            throw new EntityNotFoundException(message);
        }
        return debtCard;
    }
}
