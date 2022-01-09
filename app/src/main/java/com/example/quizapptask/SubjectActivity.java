package com.example.quizapptask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SubjectActivity extends AppCompatActivity {

    Button btnEnglish,btnScience;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        btnEnglish = findViewById(R.id.englishBtn);
        btnScience = findViewById(R.id.scienceBtn);

        btnScience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SubjectActivity.this,ChapterScienceActivity.class);
                startActivity(intent);
            }
        });
    }
}