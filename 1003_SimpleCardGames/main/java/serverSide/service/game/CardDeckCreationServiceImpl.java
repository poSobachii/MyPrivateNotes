package serverSide.service.game;

import org.springframework.stereotype.Service;
import serverSide.enums.CardSuit;
import serverSide.enums.CardValue;
import serverSide.util.pojo.Card;

import java.util.Collections;
import java.util.Stack;

@Service
public class CardDeckCreationServiceImpl implements CardDeckCreationService {

    @Override
    public Stack<Card> createSimpleDeckOfCards() {
        Stack<Card> deckOfCards = new Stack<>();
        for (CardValue cardValue : CardValue.values()) {
            for (CardSuit cardSuit : CardSuit.values()) {
                deckOfCards.add(new Card(cardValue, cardSuit));
            }
        }
        Collections.shuffle(deckOfCards);
        return deckOfCards;
    }


}
