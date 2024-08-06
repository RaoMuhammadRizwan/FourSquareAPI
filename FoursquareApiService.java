package com.example.square;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface FoursquareApiService {
    @GET("places/search")
    Call<FoursquareResponse> searchPlaces(
            @Header("Authorization") String apiKey,
            @Query("query") String query,
            @Query("near") String near,
            @Query("limit") int limit
    );
}
