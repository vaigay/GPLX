package com.example.quizandroid.Model;

public class Category_Quiz {
    private int idCategory;
    private int idQuiz;

    public int getIdCategory() {
        return idCategory;
    }

    public int getIdQuiz() {
        return idQuiz;
    }

    public Category_Quiz(int idCategory, int idQuiz) {
        this.idCategory = idCategory;
        this.idQuiz = idQuiz;
    }
}
