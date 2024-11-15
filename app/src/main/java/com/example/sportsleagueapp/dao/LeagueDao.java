package com.example.sportsleagueapp.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.sportsleagueapp.model.League;

import java.util.List;

@Dao
public interface LeagueDao {

    @Insert
    void insertLeagues(List<League> leagues);

    @Query("SELECT * FROM leagues")
    List<League> getAllLeagues();
}