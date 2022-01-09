package com.example.quizapptask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class QuizFinish extends AppCompatActivity {

    Animation fade_in;
    CircularProgressBar circularProgressBar;
    TextView resultText;
    Button shareBtn,retryBtn;
    int correct,wrong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_finish);

        correct = getIntent().getIntExtra("correct",0);
        wrong = getIntent().getIntExtra("wrong",0);


        circularProgressBar = findViewById(R.id.circularProgressBar);
        resultText = findViewById(R.id.resultText);
        shareBtn = findViewById(R.id.shareBtn);
        retryBtn = findViewById(R.id.retyrBtn);
        fade_in = AnimationUtils.loadAnimation(QuizFinish.this,R.anim.fade);
        shareBtn.startAnimation(fade_in);
        retryBtn.startAnimation(fade_in);

        circularProgressBar.setProgress(correct);
        resultText.setText(correct+"/10");

        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                    String shareMessage= "\nI got "+correct+" marks out of 10. You can also try";
                    shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID +"\n\n";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "choose one"));
                } catch(Exception e) {
                    //e.toString();
                }
            }
        });

        retryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizFinish.this,TestActivity.class);
                startActivity(intent);
            }
        });


    }
}