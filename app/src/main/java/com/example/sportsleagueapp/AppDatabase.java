package com.example.sportsleagueapp;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

@Database(entities = {League.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract LeagueDao leagueDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, "league_database")
                            .fallbackToDestructiveMigration()  // Automatically handle migrations
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
