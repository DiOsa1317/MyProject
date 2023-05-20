package com.example.russianidioms.domain;
public class WordFromIdiomDIc {
    private final long id;
    private  final  String name;
    private final String meaning;

    public WordFromIdiomDIc(long id, String name, String meaning) {
        this.id=id;
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
}
