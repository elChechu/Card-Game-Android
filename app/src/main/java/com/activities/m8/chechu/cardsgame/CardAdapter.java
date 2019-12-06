package com.activities.m8.chechu.cardsgame;

import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.view.ViewGroup;
import android.view.View;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    /**
     * Cards store
     */
    private List<Card> items;

    /**
     * Game instance
     */
    private Game game;

    public CardAdapter(List<Card> items, Game game) {
        this.items = items;
        this.game = game;
    }

    /**
     *
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        /**
         * Actual image view
         */
        public ImageView image;


        public ViewHolder(View v) {
            super(v);
            image = v.findViewById(R.id.image);
            image.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            if (game.isTurnCardAvailable() && game.running()) {

                final Card card = items.get(getAdapterPosition());
                game.showCard(card);
                notifyDataSetChanged();

                // Setup timer
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        game.hideCard(card);
                        notifyDataSetChanged();
                    }
                }, 2000);
            }
        }
    }

    /**
     * @param vg
     * @param i
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup vg, int i) {
        return new ViewHolder(
                LayoutInflater
                        .from(vg.getContext())
                        .inflate(R.layout.card_layout, vg, false)
        );
    }

    /**
     * @param vh
     * @param i
     */
    @Override
    public void onBindViewHolder(ViewHolder vh, int i) {
        vh.image.setImageResource(items.get(i).getImage());
    }

    /**
     * Get items size
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return items.size();
    }
}
