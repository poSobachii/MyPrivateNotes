package serverSide.service.game;

import serverSide.util.pojo.Card;

import java.util.Stack;

public interface CardDeckCreationService {

    Stack<Card> createSimpleDeckOfCards();

}
