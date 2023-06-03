package com.example.russianidioms.domain;
public class WordFromIdiomDIc extends WordFromDic {

    public WordFromIdiomDIc(long id, String name, String meaning, String history) {
        super(id, name, meaning, history);
    }

    public WordFromIdiomDIc(String name, String meaning,  String history) {
        super(name, meaning, history);
    }

   }
