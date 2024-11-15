package com.example.sportsleagueapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.sportsleagueapp.dao.LeagueDao;
import com.example.sportsleagueapp.model.League;

@Database(entities = {League.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;

    public abstract LeagueDao leagueDao();

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "football-db")
                    .build();
        }
        return INSTANCE;
    }
}