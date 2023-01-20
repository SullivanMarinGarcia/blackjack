package test;

import blackjack.BlackJack;
import java.util.ArrayList;
import java.util.List;
import model.Card;
import model.Player;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BlackJackTest {
    
    @Test
    public void given_one_card_should_calculate_value() {
        assertEquals(3, Card._3.value());
        assertEquals(10, Card.Jack.value());
        assertEquals(10, Card.Queen.value());
        assertEquals(10, Card.King.value());
        assertEquals(11, Card.Ace.value());
    }
    
    @Test
    public void given_two_card_should_calculate_value() {
        List<Card> bet = new ArrayList<>();
        bet.add(Card._4); bet.add(Card.King);
        assertEquals(14, BlackJack.getBetSum(bet));
    }
    
    @Test
    public void given_two_cards_should_determine_if_is_blackjack() {
        List<Card> bet = new ArrayList<>();
        bet.add(Card.Jack); bet.add(Card.Queen);
        assertEquals(false, BlackJack.isBlackJack(bet));
        bet.clear();
        bet.add(Card.Jack); bet.add(Card.Ace);
        assertEquals(true, BlackJack.isBlackJack(bet));
    }
    
    @Test
    public void given_three_cards_should_determine_that_is_not_blackjack() {
        List<Card> bet = new ArrayList<>();
        bet.add(Card.Jack); bet.add(Card._5); bet.add(Card._6);
        assertEquals(false, BlackJack.isBlackJack(bet));
    }
    
    @Test
    public void given_two_cards_should_determine_that_is_not_bust() {
        List<Card> bet = new ArrayList<>();
        bet.add(Card._10); bet.add(Card._5);
        assertEquals(false, BlackJack.isBust(bet));
    }
    
    @Test
    public void given_three_cards_should_determine_that_is_bust_or_not() {
        List<Card> bet = new ArrayList<>();
        bet.add(Card._10); bet.add(Card._5); bet.add(Card.Jack);
        assertEquals(true, BlackJack.isBust(bet));
        bet.clear();
        bet.add(Card._10); bet.add(Card._5); bet.add(Card._6);
        assertEquals(false, BlackJack.isBust(bet));
    }
    
    @Test
    public void should_say_that_winner_is_player1() {
        List<Card> betPlayer1 = new ArrayList<>();
        betPlayer1.add(Card.Jack); betPlayer1.add(Card.Ace);
        
        List<Card> betPlayer2 = new ArrayList<>();
        betPlayer2.add(Card._10); betPlayer2.add(Card._5); betPlayer2.add(Card._6);
        
        List<Card> betPlayer3 = new ArrayList<>();
        betPlayer3.add(Card._3); betPlayer3.add(Card._6); betPlayer3.add(Card.Ace); betPlayer3.add(Card._3); betPlayer3.add(Card.Ace); betPlayer3.add(Card.King);
        
        List<Card> betCroupier = new ArrayList<>();
        betCroupier.add(Card._9); betCroupier.add(Card._7);
        
        Player player1 = new Player(betPlayer1);
        Player player2 = new Player(betPlayer2);
        Player player3 = new Player(betPlayer3);
        Player croupier = new Player(betCroupier);
        
        List<Card> deck = new ArrayList<>();
        deck.add(Card._5); deck.add(Card._4); deck.add(Card.King); deck.add(Card._2);
        
        List<Player> winners = new ArrayList<>();
        winners.add(player1);
        
        assertEquals(winners, BlackJack.getWinners(player1, player2, player3, croupier, deck));
    }
    
    public void should_say_that_winners_are_player1_and_player3() {
        List<Card> betPlayer1 = new ArrayList<>();
        betPlayer1.add(Card._10); betPlayer1.add(Card.King);
        
        List<Card> betPlayer2 = new ArrayList<>();
        betPlayer2.add(Card._10); betPlayer2.add(Card._2); betPlayer2.add(Card._6);
        
        List<Card> betPlayer3 = new ArrayList<>();
        betPlayer3.add(Card._8); betPlayer3.add(Card._8); betPlayer3.add(Card._5); 
        
        List<Card> betCroupier = new ArrayList<>();
        betCroupier.add(Card._5); betCroupier.add(Card._10);
        
        Player player1 = new Player(betPlayer1);
        Player player2 = new Player(betPlayer2);
        Player player3 = new Player(betPlayer3);
        Player croupier = new Player(betCroupier);
        
        List<Card> deck = new ArrayList<>();
        deck.add(Card.Ace); deck.add(Card._3); deck.add(Card.King); deck.add(Card._2);
        
        List<Player> winners = new ArrayList<>();
        winners.add(player1); winners.add(player3);
        
        assertEquals(winners, BlackJack.getWinners(player1, player2, player3, croupier, deck));
    }
}
