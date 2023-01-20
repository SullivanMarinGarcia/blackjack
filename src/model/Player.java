package model;

import blackjack.BlackJack;
import java.util.List;

public class Player {
    private final List<Card> bet;
    
    public Player(List<Card> bet) {
        this.bet = bet;
    }
    
    public List<Card> getBet() {
        return bet;
    }
    
    public void addCard(Card card) {
        bet.add(card);
    }
    
    public boolean isWinner(Player croupier) {
        int sumBetCroupier = BlackJack.getBetSum(croupier.getBet());
        int sumBetPlayer = BlackJack.getBetSum(this.bet);
        
        return (sumBetPlayer > sumBetCroupier) && (sumBetPlayer <= 21) || BlackJack.isBlackJack(this.bet);
    }
}   
