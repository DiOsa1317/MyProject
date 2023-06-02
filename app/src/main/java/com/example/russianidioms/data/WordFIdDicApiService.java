package com.example.russianidioms.data;

public class WordFIdDicApiService {
    private static WordFromIdiomDicApi wordFromIdiomDicApi;

    public static WordFromIdiomDicApi create() {
       return RetrofitService.getInstance().create(WordFromIdiomDicApi.class);
    }

    public static WordFromIdiomDicApi getInstance() {
        if(wordFromIdiomDicApi == null)  wordFromIdiomDicApi = create();
        return wordFromIdiomDicApi;
    }
}
