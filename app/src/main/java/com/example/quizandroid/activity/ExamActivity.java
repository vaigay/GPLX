package com.example.quizandroid.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizandroid.Adapter.ExamAdapter;
import com.example.quizandroid.Adapter.IExamClicked;
import com.example.quizandroid.DAO.ExamDAO;
import com.example.quizandroid.Model.Exam;
import com.example.quizandroid.R;

import java.util.List;


public class ExamActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    private List<Exam> examList;
    private ExamDAO examDAO;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_exam);
        examDAO = new ExamDAO(this);
        examList = examDAO.getAllExam();

        recyclerView = findViewById(R.id.exam_recycler);
        myAdapter = new ExamAdapter(this,examList, new IExamClicked() {
            @Override
            public void clickedExam(int position) {
                Intent intent = new Intent(ExamActivity.this,ExamDetailActivity.class);
                Exam e = examList.get(position);
                intent.putExtra("id",e.getId());
                intent.putExtra("result",e.getResult());
                intent.putExtra("status",e.getStatus());
                startActivity(intent);
            }
        });

        layoutManager = new GridLayoutManager(this,3);


        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myAdapter);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Thi lý thuyết");
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}
