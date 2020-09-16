package com.dev.abhishekove;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JsonPlaceHolgerApi {

    @GET("search")
    Call<ArtistList> getArtists(@Query("term") String term);
}
