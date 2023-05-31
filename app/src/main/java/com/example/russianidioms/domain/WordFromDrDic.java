package com.example.russianidioms.domain;

public class WordFromDrDic extends WordFromDic{

    public WordFromDrDic(long id, String name, String meaning) {
        super(id, name, meaning);
    }

    public WordFromDrDic(String name, String meaning) {
        super(name, meaning);
    }
}
