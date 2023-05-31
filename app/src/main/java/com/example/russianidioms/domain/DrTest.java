package com.example.russianidioms.domain;

import android.graphics.drawable.Drawable;

import com.example.russianidioms.R;

import java.util.Objects;

public class DrTest {
    private  long id;
    private String name;
    private  String theme;
    private  String varient1;
    private  String varient2;
    private  String varient3;
    private  String varient4;
    private  Drawable problem;



    public DrTest(long id, String name, String theme, String varient1, String varient2, String varient3, String varient4, Drawable problem) {
        this.id = id;
        this.name=name;
        this.theme = theme;
        this.varient1 = varient1;
        this.varient2 = varient2;
        this.varient3 = varient3;
        this.varient4 = varient4;
        this.problem = problem;
    }

    public DrTest(String name, String theme, String varient1, String varient2, String varient3, String varient4, Drawable problem) {
        this.name=name;
        this.theme = theme;
        this.varient1 = varient1;
        this.varient2 = varient2;
        this.varient3 = varient3;
        this.varient4 = varient4;
        this.problem = problem;
    }



    public Drawable getProblem() {
        return problem;
    }


    public String getName() {
        return name;
    }

    public String getTheme() {return theme;}

    public String getVarient1() {
        return varient1;
    }

    public long getId() {
        return id;
    }

    public String getVarient2() {
        return varient2;
    }

    public String getVarient3() {
        return varient3;
    }

    public String getVarient4() {
        return varient4;
    }


    @Override
    public String toString() {
        return "IdiomTest{" +
                "id=" + id +
                ", theme='" + theme + '\'' +
                ", varient1='" + varient1 + '\'' +
                ", varient2='" + varient2 + '\'' +
                ", varient3='" + varient3 + '\'' +
                ", varient4='" + varient4 + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DrTest drTest = (DrTest) o;
        return id == drTest.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
