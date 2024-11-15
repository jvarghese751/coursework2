package com.example.sportsleagueapp.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SportsDBApi {
    @GET("search_all_teams.php")
    Call<ClubsResponse> getClubsByLeague(@Query("l") String leagueName);

    @GET("lookup_all_teams.php")
    Call<JerseyResponse> getJerseys(@Query("id") String clubId);
}