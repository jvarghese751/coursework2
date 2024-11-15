package com.example.sportsleagueapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.sportsleagueapp.AppDatabase;
import com.example.sportsleagueapp.R;
import com.example.sportsleagueapp.SearchByLeagueActivity;
import com.example.sportsleagueapp.SearchClubsActivity;
import com.example.sportsleagueapp.model.League;
import com.example.sportsleagueapp.network.SportsDBApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private Button btnAddLeagues, btnSearchClubsByLeague, btnSearchClubs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        btnAddLeagues = findViewById(R.id.btnAddLeagues);
        btnSearchClubsByLeague = findViewById(R.id.btnSearchClubsByLeague);
        btnSearchClubs = findViewById(R.id.btnSearchClubs);

        // Set up button listeners
        btnAddLeagues.setOnClickListener(v -> addLeaguesToDatabase());
        btnSearchClubsByLeague.setOnClickListener(v -> showSearchByLeagueScreen());
        btnSearchClubs.setOnClickListener(v -> showSearchClubsScreen());
    }

    // Method to add leagues to the database
    private void addLeaguesToDatabase() {
        // Create a list of leagues to insert into the database
        List<League> leagues = new ArrayList<>(Arrays.asList(
                new League(4330, "Scottish Premier League", "Soccer", "Scottish Premiership, SPFL"),
                new League(4331, "German Bundesliga", "Soccer", "Bundesliga, Fußball-Bundesliga"),
                new League(4332, "Italian Serie A", "Soccer", "Serie A"),
                new League(4334, "French Ligue 1", "Soccer", "Ligue 1 Conforama"),
                new League(4335, "Spanish La Liga", "Soccer", "LaLiga Santander, La Liga"),
                new League(4336, "Greek Superleague Greece", "Soccer", ""),
                new League(4337, "Dutch Eredivisie", "Soccer", "Eredivisie"),
                new League(4338, "Belgian Pro League", "Soccer", "Jupiler Pro League")
        ));

        // Insert the leagues into the database on a background thread
        new Thread(() -> {
            // Initialize the database
            AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "football-db").build();
            // Insert the leagues into the database
            db.leagueDao().insertLeagues(leagues);
            runOnUiThread(() -> {
                // Show a success message when the leagues are added
                Toast.makeText(MainActivity.this, "Leagues added to database!", Toast.LENGTH_SHORT).show();
            });
        }).start();
    }

    // Method to navigate to SearchByLeagueActivity
    private void showSearchByLeagueScreen() {
        // Start the activity where the user can search for clubs by league
        Intent intent = new Intent(MainActivity.this, SearchByLeagueActivity.class);
        startActivity(intent);
    }

    // Method to navigate to SearchClubsActivity
    private void showSearchClubsScreen() {
        // Start the activity where the user can search for clubs in the database
        Intent intent = new Intent(MainActivity.this, SearchClubsActivity.class);
        startActivity(intent);
    }
}