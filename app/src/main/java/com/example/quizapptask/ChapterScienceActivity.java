package com.example.quizapptask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChapterScienceActivity extends AppCompatActivity {

    Button chapter1,chapter2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_science);
        chapter1 = findViewById(R.id.sciencechapter1);
        chapter2 = findViewById(R.id.sciencechapter2);

        chapter1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChapterScienceActivity.this,PartScreen.class);
                startActivity(intent);
            }
        });

    }
}