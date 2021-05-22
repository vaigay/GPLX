package com.example.quizandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizandroid.R;

public class MainActivity extends AppCompatActivity {
    Button practice, exam, quizWrong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        practice = findViewById(R.id.go_practice);
        exam = findViewById(R.id.go_exam);
        quizWrong = findViewById(R.id.go_exam_quiz_wrong);

        practice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, CategoryActivity.class);
                startActivity(i);
            }
        });

        exam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ExamActivity.class);
                startActivity(i);
            }
        });

        quizWrong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, QuizWrongActivity.class);
                startActivity(i);
            }
        });

    }
}