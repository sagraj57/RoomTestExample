package com.sagar.android.roomtestexample;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ArrayList<String> users;

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;

    private static final String TAG = "MainActivity";
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = findViewById(R.id.fab);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //Demo Arraylist for adapter
        users = new ArrayList<>();
        for (int i = 0; i<100; i++) {
            users.add("Sagar # " + i);
        }
        adapter = new UserAdapter(users);
        recyclerView.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: pressed");
                startActivity(new Intent(MainActivity.this, CreateUser.class));
            }
        });
    }
}
