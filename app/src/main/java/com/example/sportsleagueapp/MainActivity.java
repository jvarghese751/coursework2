package com.example.sportsleagueapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the database
        db = AppDatabase.getDatabase(this);

        // Reference to the "Add Leagues to DB" button
        Button btnAddLeagues = findViewById(R.id.btnAddLeagues);

        // Set up the click listener for the "Add Leagues to DB" button
        btnAddLeagues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if the database is already filled
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        // Query to check if there are leagues already in the database
                        List<League> existingLeagues = db.leagueDao().getAllLeagues();

                        if (existingLeagues.isEmpty()) {
                            // Database is empty, insert the leagues
                            List<League> leagues = new ArrayList<>();
                            leagues.add(new League(4330, "Scottish Premier League", "Soccer", "Scottish Premiership, SPFL"));
                            leagues.add(new League(4331, "German Bundesliga", "Soccer", "Bundesliga, Fußball-Bundesliga"));
                            leagues.add(new League(4332, "Italian Serie A", "Soccer", "Serie A"));
                            leagues.add(new League(4334, "French Ligue 1", "Soccer", "Ligue 1 Conforama"));
                            leagues.add(new League(4335, "Spanish La Liga", "Soccer", "LaLiga Santander, La Liga"));
                            leagues.add(new League(4336, "Greek Superleague Greece", "Soccer", ""));
                            leagues.add(new League(4337, "Dutch Eredivisie", "Soccer", "Eredivisie"));
                            leagues.add(new League(4338, "Belgian Pro League", "Soccer", "Jupiler Pro League"));

                            try {
                                db.leagueDao().insertAll(leagues); // Insert data into DB

                                // Notify user on the UI thread
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(MainActivity.this, "Leagues Added to DB!", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            } catch (Exception e) {
                                // Log and show error message
                                android.util.Log.e("DatabaseError", "Error inserting data", e);
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(MainActivity.this, "Error inserting data", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        } else {
                            // Database already filled, notify user
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(MainActivity.this, "Database already filled", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }
                }).start();
            }
        });
    }
}