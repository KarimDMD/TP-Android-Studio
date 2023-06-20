package com.example.karimdamadtp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CharacterService {

    @GET("character")
    Call<CharacterRoot> getCharacterList(@Query("page") int page);
}
