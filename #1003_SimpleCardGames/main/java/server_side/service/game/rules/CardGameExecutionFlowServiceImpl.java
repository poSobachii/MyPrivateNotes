package server_side.service.game.rules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server_side.enums.Game;
import server_side.service.player.PlayerNotificationService;
import server_side.util.pojo.Card;
import server_side.util.pojo.PlayingPlayer;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import static server_side.enums.PlayerInGameDecision.FOLD;
import static server_side.enums.PlayerInGameDecision.UNDECISIONED;

@Service
public class CardGameExecutionFlowServiceImpl implements CardGameExecutionFlowService {

    private final String LOST_TOKENS_NOTIFICATION = "You lost %s tokens";
    private final String WON_TOKENS_NOTIFICATION = "You won %s tokens";
    private final String TIE_NOTIFICATION = "It was a tie. No tokens deducted or gained";
    private final String FORCE_FOLD_NOTIFICATION = "Time is up. You Fold automatically";

    @Autowired
    PlayerNotificationService notificationService;

    @Override
    public Set<Card> dealCards(Stack<Card> deckOfCards, Game game) {
        Set<Card> cards = new HashSet<>();
        for (int i = 0; i < game.getCardsPerPlayer(); i++) {
            cards.add(deckOfCards.pop());
        }
        return cards;
    }

    @Override
    public void resolveRoundResult(Set<PlayingPlayer> playersInGame, Game game) {
        if (playersInGame.size() < game.getMinPlayerCount() || playersInGame.size() > game.getMaxPlayerCount()) {
            throw new RuntimeException("Wrong number of players. Game was aborted.");
            //abort game due wrong player count.
        }
        playersInGame.forEach(p ->
                {
                    if (p.getPlayerInGameAction().equals(UNDECISIONED)) {
                        p.setPlayerInGameAction(FOLD);
                        notificationService.runningGamePlayerNotification(p.getNickName(), String.format(FORCE_FOLD_NOTIFICATION, game.getBothFoldCoeff()), p.getBalance(), null);
                    }
                }
        );

        Set<PlayingPlayer> resolvingPlayers = new HashSet<>(playersInGame);
        PlayingPlayer foldedPlayer =
                resolvingPlayers.stream().filter(p -> p.getPlayerInGameAction().equals(FOLD)).findFirst().orElse(null);
        if (foldedPlayer != null) {
            resolvingPlayers.remove(foldedPlayer);
            if (resolvingPlayers.iterator().next().getPlayerInGameAction().equals(FOLD)) {
                playersInGame.forEach(p -> {
                    p.updateBalance(-game.getBothFoldCoeff());
                    notificationService.runningGamePlayerNotification(p.getNickName(), String.format(LOST_TOKENS_NOTIFICATION, game.getBothFoldCoeff()), p.getBalance(), false);
                });
            } else {
                for (PlayingPlayer p : playersInGame) {
                    if (p.getId().equals(foldedPlayer.getId())) {
                        p.updateBalance(-game.getFoldPlayCoeff());
                        notificationService.runningGamePlayerNotification(p.getNickName(), String.format(LOST_TOKENS_NOTIFICATION, game.getFoldPlayCoeff()), p.getBalance(), false);
                    } else {
                        p.updateBalance(+game.getFoldPlayCoeff());
                        notificationService.runningGamePlayerNotification(p.getNickName(), String.format(WON_TOKENS_NOTIFICATION, game.getFoldPlayCoeff()), p.getBalance(), true);
                    }
                }
            }

        } else {
            Long winningPlayerId = resolveCards(playersInGame);
            if (winningPlayerId != 0L) {
                for (PlayingPlayer p : playersInGame) {
                    if (p.getId().equals(winningPlayerId)) {
                        p.updateBalance(+game.getBothPlayCoeff());
                        notificationService.runningGamePlayerNotification(p.getNickName(), String.format(WON_TOKENS_NOTIFICATION, game.getBothPlayCoeff()), p.getBalance(), true);
                    } else {
                        p.updateBalance(-game.getBothPlayCoeff());
                        notificationService.runningGamePlayerNotification(p.getNickName(), String.format(LOST_TOKENS_NOTIFICATION, game.getBothPlayCoeff()), p.getBalance(), false);
                    }
                }
            } else {
                playersInGame.forEach(
                        p -> notificationService.runningGamePlayerNotification(p.getNickName(), TIE_NOTIFICATION, p.getBalance(), null));
            }
        }

    }

    private Long resolveCards(Set<PlayingPlayer> playersInGame) {
        Set<PlayingPlayer> resolvingPlayers = new HashSet<>(playersInGame);
        PlayingPlayer firstPlayer = resolvingPlayers.iterator().next();
        resolvingPlayers.remove(firstPlayer);
        PlayingPlayer secondPlayer = resolvingPlayers.iterator().next();
        return resolveStacks(firstPlayer, secondPlayer);
    }

    private Long resolveStacks(PlayingPlayer firstPlayer, PlayingPlayer secondPlayer) {
        Card c1 = getHighestCard(firstPlayer.getCardsOnHands());
        Card c2 = getHighestCard(secondPlayer.getCardsOnHands());
        int result = c1.getCardValue().ordinal() - c2.getCardValue().ordinal();
        if (result == 0) {
            firstPlayer.getCardsOnHands().remove(c1);
            secondPlayer.getCardsOnHands().remove(c2);
            if (firstPlayer.getCardsOnHands().size() > 0) {
                return resolveStacks(firstPlayer, secondPlayer);
            } else {
                return (long) result;
            }
        }
        return result < 0 ? firstPlayer.getId() : secondPlayer.getId();
    }

    private Card getHighestCard(Set<Card> cards) {
        return cards.stream().min(Comparator.comparing(c -> c.getCardValue().ordinal())).get();
    }

}
