package com.example.russianidioms.data;

import com.example.russianidioms.domain.WordFromIdiomDIc;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WordFromIdiomDicApi {
    @GET("word")
    Call<List<WordFromIdiomDIc>> getWords();

    @GET("word/{id}")
    Call<WordFromIdiomDIc> getWord(
            @Path("id")
                    long id
    );

    @DELETE("word/{id}")
    Call<Void> deleteWord(
            @Path("id")
                    long id
    );

}
