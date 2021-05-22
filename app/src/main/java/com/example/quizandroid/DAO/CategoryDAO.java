package com.example.quizandroid.DAO;

import android.content.Context;
import android.database.Cursor;

import com.example.quizandroid.Model.Answer;
import com.example.quizandroid.Model.Category;

import java.util.ArrayList;

public class CategoryDAO {
    private DBConnect dbConnect;
    public CategoryDAO(Context context){
        dbConnect = new DBConnect(context,DBInfo.dbName,null,DBInfo.version);
    }

    public ArrayList< Category > getAllCategory(){
        String sql = "SELECT * FROM category ORDER BY id";
        Cursor c = dbConnect.QueryData(sql);
        ArrayList< Category> categories = new ArrayList<>();
        while(c.moveToNext()){
            int id = c.getInt(c.getColumnIndex("id"));
            String content = c.getString(c.getColumnIndex("content"));
            String image = c.getString(c.getColumnIndex("image"));
            categories.add(new Category(id,content,image));
        }
        c.close();
        return categories;
    }


    public ArrayList<Answer> getAnswerByIdQuiz(int idQuiz){
        String sql = "SELECT * FROM answer WHERE idQuiz = " + idQuiz;
        ArrayList<Answer> answers = new ArrayList<>();
        Cursor c = dbConnect.QueryData(sql);
        while(c.moveToNext()){
            int id = c.getInt(c.getColumnIndex("id"));
            String content = c.getString(c.getColumnIndex("content"));
            boolean check = c.getInt(c.getColumnIndex("isTRue")) > 0;
            Answer answer = new Answer(id,check,content);
            answers.add(answer);
        }
        c.close();
        return answers;
    }





}
