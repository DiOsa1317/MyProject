package com.example.russianidioms.domain;

public class WordFromDrDic extends WordFromDic{

    public WordFromDrDic(long id, String name, String meaning, String history) {
        super(id, name, meaning, history);
    }

    public WordFromDrDic(String name, String meaning, String history) {
        super(name, meaning, history);
    }
}
