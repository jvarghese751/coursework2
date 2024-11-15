package com.example.sportsleagueapp.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "clubs")
public class Club {
    @PrimaryKey
    public int idTeam;
    public String strTeam;
    public String strTeamShort;
    public String strTeamAlternate;
    public int intFormedYear;
    public String strLeague;
    public String strStadium;
    public String strLocation;
    public int intStadiumCapacity;
    public String strWebsite;
    public String strLogo;

    public Club(int idTeam, String strTeam, String strTeamShort, String strTeamAlternate, int intFormedYear, String strLeague,
                String strStadium, String strLocation, int intStadiumCapacity, String strWebsite, String strLogo) {
        this.idTeam = idTeam;
        this.strTeam = strTeam;
        this.strTeamShort = strTeamShort;
        this.strTeamAlternate = strTeamAlternate;
        this.intFormedYear = intFormedYear;
        this.strLeague = strLeague;
        this.strStadium = strStadium;
        this.strLocation = strLocation;
        this.intStadiumCapacity = intStadiumCapacity;
        this.strWebsite = strWebsite;
        this.strLogo = strLogo;
    }
}