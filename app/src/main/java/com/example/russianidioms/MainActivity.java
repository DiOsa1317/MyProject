package com.example.russianidioms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.russianidioms.data.WordFIdDicApiService;
import com.example.russianidioms.domain.WordFromIdiomDIc;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WordFIdDicApiService.getInstance().getWords().enqueue(new Callback<List<WordFromIdiomDIc>>() {
            @Override
            public void onResponse(Call<List<WordFromIdiomDIc>> call, Response<List<WordFromIdiomDIc>> response) {
                Log.d("DEBUG", response.body().toString());
            }

            @Override
            public void onFailure(Call<List<WordFromIdiomDIc>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
