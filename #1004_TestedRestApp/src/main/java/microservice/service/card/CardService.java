package microservice.service.card;

import microservice.dto.card.CardAmountChangeRequestDTO;
import microservice.dto.card.DebtCardDTO;
import microservice.dto.card.CardRequestDTO;
import microservice.entity.DebtCard;

import java.util.List;

public interface CardService {

    void deleteById(Long cardId);

    void updateAmountById(Long cardId, CardAmountChangeRequestDTO amountChangeRequest) throws Exception;

    void create(Long customerId, CardRequestDTO cardRequest) throws Exception;

    List<DebtCardDTO> getAll();

    DebtCardDTO getOnById(Long id);

    List<DebtCardDTO> transformToCardDto(List<DebtCard> debtCardList);
}
