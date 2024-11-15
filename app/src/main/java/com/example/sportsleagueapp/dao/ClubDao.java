package com.example.sportsleagueapp.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.sportsleagueapp.model.Club;

import java.util.List;

@Dao
public interface ClubDao {
    @Insert
    void insertClubs(List<Club> clubs);

    @Query("SELECT * FROM clubs WHERE strTeam LIKE :query OR strLeague LIKE :query")
    List<Club> searchClubs(String query);
}
