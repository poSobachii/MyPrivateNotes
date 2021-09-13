package server_side.service.game;

import org.springframework.stereotype.Service;
import server_side.enums.CardSuit;
import server_side.enums.CardValue;
import server_side.util.pojo.Card;

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
