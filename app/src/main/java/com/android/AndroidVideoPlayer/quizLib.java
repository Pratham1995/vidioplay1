package com.android.AndroidVideoPlayer;

public class quizLib {
    private String question[]={
            "what is square root of 9",
            "what is square root of 16","what is square root of 25","what is square root of 36","what is square root of 49"
    };

    private String choices[][]={
            {"3","4","5"},{"3","4","5"},{"3","6","5"},{"6","3","9"},{"2","7","6"}
    };
    private String answers[]={
    "3","4","5","6","7"
    };

    public String getQuestion(int a){
        String questions= question[a];
        return questions;
    }
    public String getchoice1(int a){
        String c1=choices[a][0];
        return c1;
    }
    public String getchoice2(int a){
        String c2=choices[a][1];
        return c2;
    }
    public String getchoice3(int a){
        String c3=choices[a][2];
        return c3;
    }
    public String getcorrectanswer(int a){
        String correct=answers[a];
        return correct;
    }


}
