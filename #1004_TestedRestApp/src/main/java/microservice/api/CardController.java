package microservice.api;

import microservice.dto.card.CardAmountChangeRequestDTO;
import microservice.dto.card.DebtCardDTO;
import microservice.dto.card.CardRequestDTO;
import microservice.service.card.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping
    public List<DebtCardDTO> getAll(){
        return cardService.getAll();
    }

    @GetMapping("/{id}")
    public DebtCardDTO getOneById(@PathVariable("id") Long id) throws Exception {
        return cardService.getOnById(id);
    }

    @PostMapping("/{id}")
    public void editById(@PathVariable("id") Long id, @RequestBody CardAmountChangeRequestDTO amountChangeRequest) throws Exception {
        cardService.updateAmountById(id, amountChangeRequest);
    }

    @PutMapping("/create/{customerId}")
    public void create(@PathVariable("customerId") Long customerId, @RequestBody CardRequestDTO cardRequest) throws Exception {
        cardService.create(customerId, cardRequest);
    }

    @DeleteMapping("/{id}/delete")
    public void delete(@PathVariable("id") Long id) {
        cardService.deleteById(id);
    }

}
