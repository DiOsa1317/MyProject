package com.example.russianidioms.presentation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.russianidioms.domain.WordFromIdiomDIc;

import java.util.List;

public class DicOfIdViewModel extends ViewModel {
    private MutableLiveData<List<WordFromIdiomDIc>> words = new MutableLiveData<List<WordFromIdiomDIc>>();
    public LiveData<List<WordFromIdiomDIc>> wordsL = words;
    public void load() {

    }
}
