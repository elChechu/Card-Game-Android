package com.activities.m8.chechu.cardsgame;

import java.util.ArrayList;

public class Game {

    private enum State { RUNNING, WON, LOST };

    /**
     * Turned cards container
     */
    private ArrayList<Card> turned = new ArrayList<>();


    /**
     * Current game state
     */
    private State state = State.RUNNING;


    public boolean running() {
        return state == State.RUNNING;
    }

    public void finish() {
        state = State.LOST;
    }

    /**
     * Checks if new card can be turned
     *
     * @return
     */
    public boolean isTurnCardAvailable() {
        return turned.size() < 2;
    }

    /**
     * Show the front of the card
     *
     * @param card
     */
    public void showCard(Card card) {
        card.toggle(true);
        turned.add(card);
    }

    /**
     * Hides cards front face
     *
     * @param card
     */
    public void hideCard(Card card) {
        card.toggle(false);
        turned.remove(0);
    }
}
