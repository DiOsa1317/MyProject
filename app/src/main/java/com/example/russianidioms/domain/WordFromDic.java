package com.example.russianidioms.domain;

public class WordFromDic {
    private long id;
    private String name;
    private String meaning;
    private String history;

    public WordFromDic(long id, String name, String meaning, String history) {
        this.id=id;
        this.name = name;
        this.meaning = meaning;
        this.history = history;
    }

    public WordFromDic(String name, String meaning, String history) {
        this.name = name;
        this.meaning = meaning;
        this.history = history;
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

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }
}
