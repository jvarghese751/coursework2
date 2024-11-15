package com.example.sportsleagueapp.network;

import com.example.sportsleagueapp.model.Club;
import com.google.gson.annotations.SerializedName;

import java.util.List;

// This class represents the response of the API call for fetching clubs
public class ClubsResponse {

    @SerializedName("teams") // This maps to the "teams" field in the JSON response
    public List<Club> teams;
}
