package com.example.sportsleagueapp.network;

import com.example.sportsleagueapp.model.Jersey;
import com.google.gson.annotations.SerializedName;

import java.util.List;

// This class represents the response of the API call for fetching club jerseys
public class JerseyResponse {

    @SerializedName("equipment") // This maps to the "equipment" field in the JSON response
    public List<Jersey> jerseys; // List of jerseys
}