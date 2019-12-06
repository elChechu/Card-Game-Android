package com.activities.m8.chechu.cardsgame;

public class Card {

    /**
     * Possible card_layout states
     */
    public enum State {
        BACK, FRONT, FIXED
    }

    /**
     * Image to show if card_layout state is FRONT
     */
    private int frontImage;

    /**
     * Image to show if card_layout state is BACK
     */
    private int backImage;

    /**
     * Current card_layout state
     */
    private State state;


    public Card(int frontImage, int backImage) {
        this.frontImage = frontImage;
        this.backImage = backImage;
        this.state = State.BACK;
    }

    /**
     * Show image depending on state
     *
     * @return
     */
    public int getImage() {
        return state == State.BACK ? backImage : frontImage;
    }

    /**
     * Toggles card_layout state
     */
    public void toggle(boolean front) {
        this.state = front ? State.FRONT : State.BACK;
    }

}
