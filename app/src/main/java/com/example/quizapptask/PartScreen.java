package com.example.quizapptask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PartScreen extends AppCompatActivity {

    Button testCardbtn1,testCardbtn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part_screen);
        initVal();

        testCardbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PartScreen.this,TestActivity.class);
                startActivity(intent);
            }
        });

    }

    public void initVal(){
        testCardbtn1 = findViewById(R.id.testCard1);
        testCardbtn2 = findViewById(R.id.testCard2);


    }
}