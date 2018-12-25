package edu.northeastern.ccs.cs5500;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sushmita Chaudhari
 */
public class BlackJack extends GameClass {

    /**
     * Number of Players including Dealer in a BJ game
     */
    private int numberOfPlayers;
    /**
     * Number of cards in each hand
     */
    private int numberOfCardsInHand;
    /**
     * List of hands in a game
     */
    private List<Player> players;
    /**
     * Deck in use in the game
     */
    private Deck deck;

    /**
     * Dealer of the BJ-game
     */
    private Dealer dealer;

    /**
     * Game class constructor
     *
     * @param numCards number of cards each player should receive
     */
    BlackJack(int numCards) {

        this.numberOfCardsInHand = numCards;
    }

    /**
     * Deals two cards to each player and tot he dealer.
     *
     * Adds all the hands to a list -- a List of Hand and sends to the Player class
     */
    @Override
    public void deal()
    {
        if(numberOfPlayers < 1)
        {
            System.err.println("Number of hands/player can't be zero.");
            System.exit(1);
        }
        /* shuffle the deck */
        deck.shuffle();

        /* dealer deals cards to themself */
        List<Card> dealerCards = new ArrayList<>();

        for(int j = 0; j < numberOfCardsInHand; j++)
        {
            dealerCards.add(deck.pullCard());
        }
        /* Dealer hand is created */
        NewHand dealerHand =  new NewHandClass(dealerCards);
        dealer = new Dealer("Dealer", dealerHand);

        /* Create hands for players */
        players = new ArrayList<>();

        for(int i = 0; i < numberOfPlayers - 1; i++)
        {
            List<Card> eachHand = new ArrayList<>();
            //* adding cards to a hand *//*
            for(int j = 0; j < numberOfCardsInHand; j++)
            {
                eachHand.add(deck.pullCard());
            }

            NewHand hand = new NewHandClass(eachHand);
            /*List of hands*/
            List<NewHand> hands = new ArrayList<>();
            hands.add(hand);
            /* Add the players to the list of players
               Create a new player and add the hands to it and one dealer face up card*/
            players.add(new Player("Players", hands, dealerHand.showCards().get(1)));
        }
    }

    /**
     * Create a deck for BlackJack game
     * @param deckType deck type
     * @param numberOfDecks number of decks to create a whole Vegas deck
     */
    @Override
    public void createDeck(String deckType, int numberOfDecks)
    {
        /* Creating a Vegas deck as it is same as Standard and allows to add more number of decks */
        if(deckType.equals("Vegas"))
        {
            VegasDeckBuilder vegasDeckBuilder = new VegasDeckBuilder();
            vegasDeckBuilder.setNumberOfDecks(numberOfDecks);
            deck = vegasDeckBuilder.makeDeck();
        }
    }

    /**
     * Set the number of hands for the game
     * @param numberOfhands number of players
     */
    @Override
    public void setNumberOfhands(int numberOfhands)
    {
        this.numberOfPlayers = numberOfhands;
    }


    /**
     * Each player plays their turn in Blackjack.
     * The play goes on until all the players take the STAND action
     * When a player takes HIT action:  a new card is added to the hand
     * When a player takes SPLIT action: current hand is split into two;
     * and the player plays with two hands
     *
     * @param player A player in the game
     */
    private void playForCurrentPlayer(Player player) {

        int handCount = 0;
        //player's hand has more than one card
        while (player.getPlayerNewHands().size() > handCount) {
            /* The game lets the player decide what decision to take based on the hand the player has and the total. */

            /* Extract the first hand */
            NewHand hand = player.getPlayerNewHands().get(handCount);

            /* Count the total of that hand */
            int handTotalPlayer = handTotal(hand);

            /* if the total is 21, then go to next player */
            if(handTotalPlayer == 21) {
                handCount++;
                continue;
            }

            /* Let the player take the decision based on their hand and the total */
            PlayerActionEnum actionEnum = player.decision(hand, handTotalPlayer);

            /* Until all players take the action STAND, the play goes on */
            while (actionEnum != PlayerActionEnum.STAND)
                if (actionEnum == PlayerActionEnum.HIT) {
                    /* Add a card to the hand if the action is HIT*/
                    Card pulledCard = deck.pullCard();
                    hand.accept(pulledCard);

                    int handTotal = handTotal(hand);
                    if (handTotal >= 21) {
                        actionEnum =  PlayerActionEnum.STAND;
                    } else {
                        actionEnum =  player.decision(hand, handTotal);
                    }

                } else if (actionEnum == PlayerActionEnum.SPLIT) {
                    if (player.getCredits() > 1) {

                        /* Create a list of cards for new hand */
                        List<Card> newHandCards = new ArrayList<>();

                        //* Remove a card from the last hand and add to new hand-- split the hand */
                        Card removedCard = hand.pullCard();
                        newHandCards.add(removedCard);

                        //* add a new card  to the original hand */
                        hand.accept(deck.pullCard());

                        newHandCards.add(deck.pullCard());
                        NewHand hand2 = new NewHandClass(newHandCards);
                        player.addHand(hand2);

                        int handTotal = handTotal(hand);
                        actionEnum =  player.decision(hand, handTotal);
                    }
                    else
                        throw new IllegalStateException("You have no money to play.");

            }
            handCount++;
        }

    }

    /**
     * Helper function for playForCurrentPlayer()
     *
     * When the player decides to take HIT action, a new card form deck is added to the hand.
     * After adding the card, the total of the hand is checked: if higher than 21 take action STAND else let the
     * player decide
     *
     * @param hand current hand of the player
     * @param player player in BJ-game - has hand, dealer card, credits(money)
     * @return action of PlayerActionEnum
     */
    PlayerActionEnum hitAction(NewHand hand, Player player)
    {
        Card pulledCard = deck.pullCard();
        hand.accept(pulledCard);

        int handTotal = handTotal(hand);
        if (handTotal >= 21) {
            return PlayerActionEnum.STAND;
        } else {
           return player.decision(hand, handTotal);
        }
    }

    /**
     * Helper function for playForCurrentPlayer()
     *
     * When the player decides to take SPLIT action, current hand is split into two
     * Cards are added to current and new hands. The new hand is added to the list of hands for the game.
     *
     * Now, the player plays with two hands, and the game has one added hand each time SPLIT happens
     *
     * @param hand current hand of the player
     * @param player player in BJ-game - has hand, dealer card, credits(money)
     * @return action of PlayerActionEnum
     */
     PlayerActionEnum splitAction(NewHand hand, Player player)
    {

        if (player.getCredits() > 1) {

            /* Create a list of cards for new hand */
            List<Card> newHandCards = new ArrayList<>();

            //* Remove a card from the last hand and add to new hand-- split the hand */
            Card removedCard = hand.pullCard();
            newHandCards.add(removedCard);

            //* add a new card  to the original hand */
            hand.accept(deck.pullCard());

            newHandCards.add(deck.pullCard());
            NewHand hand2 = new NewHandClass(newHandCards);
            player.addHand(hand2);

            int handTotal = handTotal(hand);
            return player.decision(hand, handTotal);
        }
        else
            return PlayerActionEnum.STAND;

    }


    /**
     * Increase the total value of the Player's NewHand
     *
     * @param newHand hand of the player
     */
    private int handTotal(NewHand newHand) {

        int totalValue = 0;
        for(Card card : newHand.showCards()) {

            totalValue = getTotalValue(totalValue, card);
        }
        return totalValue;
    }

    /**
     * Total value of the Dealer's hand
     *
     * @return total value of Dealer's hand
     */
    private int getDealerTotalValue() {

        int totalValueOfDealer = handTotal(dealer.dealerHand);
        while (totalValueOfDealer < 17) {
            Card newCard = deck.pullCard();

            totalValueOfDealer = getTotalValue(totalValueOfDealer, newCard);

            dealer.dealerHand.showCards().add(newCard);
        }

        return totalValueOfDealer;
    }


    /**
     * Add the card value to the existing total value of the hand
     *
     * @param totalValue total value of the hand
     * @param newCard a new card -- added to hand after HIT
     * @return updated total value of the hand
     */
    int getTotalValue(int totalValue, Card newCard) {

        int cardPip = newCard.getRank().getPips();
        cardPip = cardPip == 0? 10 : cardPip;
        if (cardPip == 1) {
            totalValue += 11;

            if (totalValue > 21) {
                totalValue -= 10;
            }
        } else {
            totalValue += cardPip;
        }
        return totalValue;
    }



    /**
     * Sets credits for players after the play is over for all players
     *
     * @param dealerTotal total of the hand of the dealer
     */
    private void setCreditsForPlayers(int dealerTotal)
    {
        for(Player player : players) {

            for(NewHand newHand : player.getPlayerNewHands()) {

                if(dealerTotal > 21 || (handTotal(newHand) > dealerTotal && handTotal(newHand) <=21)) {
                    player.setCredits(player.getCredits() + 1);
                    dealer.setCreditsForDealer(dealer.getCredits() -1);
                } else {
                    player.setCredits(player.getCredits() - 1);
                    dealer.setCreditsForDealer(dealer.getCredits() + 1);
                }
            }
        }

    }

    public static void main(String[] args)
    {

        /* BlackJack game is created using 2 cards in each hand.*/
        BlackJack game  = new BlackJack(2);

        /* Blackjack game uses Vegas aka Standard deck*/
        game.createDeck("Vegas", 6);

        /* Set the number of players, in this case 5*/
        game.setNumberOfhands(5);

        /* Deal - distribute two cards to each player*/
        game.deal();

        String dealer = game.dealer.name;
        int dealerCred = game.dealer.getCredits();


        /* Create Players */
        List<Player> players = game.players;

        for(Player player : players) {
            game.playForCurrentPlayer(player);
        }

        int dealerTotal = game.getDealerTotalValue();
        game.setCreditsForPlayers(dealerTotal);


        for (Player p : players) {
            System.out.println(p.getName() + "   " +  p.getCredits());
        }
    }
}
