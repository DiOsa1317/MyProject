package com.example.russianidioms.domain;

public class WordFromDic {
    private long id;
    private String name;
    private String meaning;

    public WordFromDic(long id, String name, String meaning) {
        this.id=id;
        this.name = name;
        this.meaning = meaning;
    }

    public WordFromDic(String name, String meaning) {
        this.name = name;
        this.meaning = meaning;
    }

    public String getName() {
        return name;
    }

    public String getMeaning() {
        return meaning;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "WordFromIdiomDIc{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", meaning='" + meaning + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}
