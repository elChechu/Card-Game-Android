package com.activities.m8.chechu.cardsgame;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.LayoutManager manager;
    private RecyclerView.Adapter adapter;
    private RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Card> items = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            items.add(
                    new Card(
                            getResources().getIdentifier("c" + i, "drawable", getPackageName()),
                            R.drawable.back
                    )
            );
        }

        final Game game = new Game();

        // Get recycler
        recycler = findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);

        // Creating manager
        manager = new GridLayoutManager(this, 3);
        recycler.setLayoutManager(manager);

        // Creating adapter
        adapter = new CardAdapter(items, game);
        recycler.setAdapter(adapter);


    }
}
