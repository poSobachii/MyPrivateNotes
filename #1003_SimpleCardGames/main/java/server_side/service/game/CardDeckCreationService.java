package server_side.service.game;

import server_side.util.pojo.Card;

import java.util.Stack;

public interface CardDeckCreationService {

    Stack<Card> createSimpleDeckOfCards();

}
