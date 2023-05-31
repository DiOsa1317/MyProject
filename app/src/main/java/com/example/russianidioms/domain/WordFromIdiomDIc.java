package com.example.russianidioms.domain;
public class WordFromIdiomDIc extends WordFromDic {

    public WordFromIdiomDIc(long id, String name, String meaning) {
        super(id, name, meaning);
    }

    public WordFromIdiomDIc(String name, String meaning) {
        super(name, meaning);
    }
}
