package com.example.russianidioms.domain;

import java.util.List;

public class ThemeOfIdioms {
    private long id;
    private String name;
    private List<WordFromIdiomDIc> idioms;

    public ThemeOfIdioms(long id, String name, List<WordFromIdiomDIc> idioms) {
        this.id = id;
        this.name = name;
        this.idioms = idioms;
    }

    public ThemeOfIdioms(String name, List<WordFromIdiomDIc> idioms) {
        this.name = name;
        this.idioms = idioms;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<WordFromIdiomDIc> getIdioms() {
        return idioms;
    }

    @Override
    public String toString() {
        return "ThemeOfIdioms{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", idioms=" + idioms +
                '}';
    }
}
