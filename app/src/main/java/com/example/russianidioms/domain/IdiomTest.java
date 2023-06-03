package com.example.russianidioms.domain;


public class IdiomTest {
    private long id;
   // private String name;
    private String theme;
    private String varient1;
    private String varient2;
    private String varient3;
    private String varient4;
    private int problem;




    public IdiomTest(long id, String theme, String varient1, String varient2, String varient3, String varient4, int problem) {
        this.id = id;
        this.theme = theme;
        this.varient1 = varient1;
        this.varient2 = varient2;
        this.varient3 = varient3;
        this.varient4 = varient4;
        this.problem = problem;
    }

    public IdiomTest(String theme, String varient1, String varient2, String varient3, String varient4, int problem) {
        this.theme = theme;
        this.varient1 = varient1;
        this.varient2 = varient2;
        this.varient3 = varient3;
        this.varient4 = varient4;
        this.problem = problem;
    }

    public int getProblem() {
        return problem;
    }

    //public String getName() {
      // return name;
    //}

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

    public void setProblem(int problem) {
        this.problem = problem;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void setVarient1(String varient1) {
        this.varient1 = varient1;
    }

    public void setVarient2(String varient2) {
        this.varient2 = varient2;
    }

    public void setVarient3(String varient3) {
        this.varient3 = varient3;
    }

    public void setVarient4(String varient4) {
        this.varient4 = varient4;
    }



}
