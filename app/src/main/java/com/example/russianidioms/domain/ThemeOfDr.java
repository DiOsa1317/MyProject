package com.example.russianidioms.domain;

import java.util.List;

public class ThemeOfDr {
    private long id;
    private String name;
    private List<WordFromDrDic> drWords;

    public ThemeOfDr(long id, String name, List<WordFromDrDic> drWords ) {
        this.id = id;
        this.name = name;
        this.drWords = drWords;
    }

    public ThemeOfDr(String name, List<WordFromDrDic> drWords ) {
        this.name = name;
        this.drWords = drWords;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<WordFromDrDic> getDrWords() {
        return drWords;
    }

    @Override
    public String toString() {
        return "ThemeOfIdioms{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", drWords" + drWords +
                '}';
    }
}
