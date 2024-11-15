package com.example.sportsleagueapp;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface LeagueDao {

    // Insert a single league
    @Insert
    void insert(League league);

    // Insert multiple leagues in a batch
    @Insert
    void insertAll(List<League> leagues);

    // Query all leagues
    @Query("SELECT * FROM leagues")
    List<League> getAllLeagues();
}
