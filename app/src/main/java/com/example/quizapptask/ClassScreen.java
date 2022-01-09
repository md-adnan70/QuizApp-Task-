package com.example.quizapptask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class ClassScreen extends AppCompatActivity {

    Animation fade_in, scale_up, scale_down;
    Button btnClass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_screen);

        fade_in = AnimationUtils.loadAnimation(ClassScreen.this, R.anim.fade);
        btnClass = findViewById(R.id.btnClass);
        btnClass.startAnimation(fade_in);


        btnClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ClassScreen.this, SubjectActivity.class);
                startActivity(intent);

            }
        });


    }


}