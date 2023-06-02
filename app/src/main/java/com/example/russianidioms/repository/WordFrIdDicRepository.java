package com.example.russianidioms.repository;

import com.example.russianidioms.data.WordFIdDicApiService;
import com.example.russianidioms.domain.WordFromIdiomDIc;

import java.util.List;

import retrofit2.Call;

public class WordFrIdDicRepository {
    public static Call<List<WordFromIdiomDIc>> getWords() {
      return WordFIdDicApiService.getInstance().getWords();
    }
}
