package com.example.russianidioms.data;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class RetrofitService {
    private static Retrofit retrofit;
    public static  final String BASE_URL = "https://192.168.0.17:8080";
    // https:google.com/path ? search

    public static Retrofit create() {
        return  new Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();
    }

    public static Retrofit getInstance() {
        if(retrofit == null) retrofit = create();
        return retrofit;
    }
}
