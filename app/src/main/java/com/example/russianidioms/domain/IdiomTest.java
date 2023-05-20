package com.example.russianidioms.domain;


import android.graphics.drawable.Drawable;

import com.example.russianidioms.R;

public class IdiomTest {
    private final long id;
    private final String name;
    private final String theme;
    private final String varient1;
    private final String varient2;
    private final String varient3;
    private final String varient4;
    private final Drawable problem;
    private final String btn_start = "Начать";
    private final int back= R.drawable.registration_rectangle;



    public IdiomTest(long id, String name, String theme, String varient1, String varient2, String varient3, String varient4, Drawable problem) {
        this.id = id;
        this.name=name;
        this.theme = theme;
        this.varient1 = varient1;
        this.varient2 = varient2;
        this.varient3 = varient3;
        this.varient4 = varient4;
        this.problem = problem;
        //this.back=back;
    }



    public Drawable getProblem() {
        return problem;
    }

    public String getBtn_start() {
     return btn_start;
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

    public int getBack() {
        return back ;
    }
}
