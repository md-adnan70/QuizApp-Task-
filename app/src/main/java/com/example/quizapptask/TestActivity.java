package com.example.quizapptask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.example.quizapptask.MainActivity.list;


public class TestActivity extends AppCompatActivity {


    CountDownTimer countDownTimer;
    int timeValue = 100;
    ProgressBar progressBar;
    ImageView backBtn;
    CardView btnCard1, btnCard2, btnCard3, btnCard4;
    Button btnNext;
    TextView question, option1, option2, option3, option4,exitTV;
    List<ModelClass> allQuestionsList;
    ModelClass modelClass;
    int index = 0;
    int correctCount = 0;
    int wrongCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        initialiseViews();

        allQuestionsList = list;
        Collections.shuffle(allQuestionsList);
        modelClass = list.get(index);

        btnCard1.setBackgroundColor(getResources().getColor(R.color.white));
        btnCard2.setBackgroundColor(getResources().getColor(R.color.white));
        btnCard3.setBackgroundColor(getResources().getColor(R.color.white));
        btnCard4.setBackgroundColor(getResources().getColor(R.color.white));




        setAllDataFromListToOurView();



        countDownTimer = new CountDownTimer(10000,1000) {
            @Override
            public void onTick(long l) {
            timeValue = timeValue-10;
            progressBar.setProgress(timeValue);
            }

            @Override
            public void onFinish() {
                Dialog dialog = new Dialog(TestActivity.this);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setContentView(R.layout.timer_dialog);
                dialog.findViewById(R.id.tryAgain).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent  = new Intent(TestActivity.this,ClassScreen.class);
                        startActivity(intent);
                    }
                });
                dialog.show();

            }
        }.start();






    }

    private void setAllDataFromListToOurView() {
        enableButton();
        btnNext.setClickable(false);
        if(countDownTimer!=null){
            countDownTimer.cancel();
            countDownTimer.start();
        }
        question.setText(modelClass.getQuestion());
        option1.setText(modelClass.getoA());
        option2.setText(modelClass.getoB());
        option3.setText(modelClass.getoC());
        option4.setText(modelClass.getoD());

    }

    private void initialiseViews() {

        progressBar = findViewById(R.id.pregressBar);
        backBtn = findViewById(R.id.backBtn);
        exitTV = findViewById(R.id.exitTV);

        btnNext = findViewById(R.id.btnNext);
        question = findViewById(R.id.questionTV);
        option1 = findViewById(R.id.option1TV);
        option2 = findViewById(R.id.option2TV);
        option3 = findViewById(R.id.option3TV);
        option4 = findViewById(R.id.option4TV);

        btnCard1 = findViewById(R.id.cardbtn1);
        btnCard2 = findViewById(R.id.cardbtn2);
        btnCard3 = findViewById(R.id.cardbtn3);
        btnCard4 = findViewById(R.id.cardbtn4);
    }


    public void correct(CardView card) {

        card.setBackgroundColor(getResources().getColor(R.color.green));
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                correctCount++;
                index++;
                modelClass = list.get(index);
                resetColor();
                setAllDataFromListToOurView();
            }
        });


    }

    public void wrong(CardView card) {

        card.setBackgroundColor(getResources().getColor(R.color.red));
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wrongCount++;
                if (index < list.size()-1) {
                    index++;
                    modelClass = list.get(index);
                    setAllDataFromListToOurView();
                    resetColor();
                } else {
                    QuizOver();
                }

            }
        });


    }

    private void QuizOver() {
        Intent intent = new Intent(TestActivity.this, QuizFinish.class);
        intent.putExtra("correct", correctCount);
        intent.putExtra("wrong", wrongCount);
        startActivity(intent);
    }

    public void enableButton() {
        btnCard1.setEnabled(true);
        btnCard2.setEnabled(true);
        btnCard3.setEnabled(true);
        btnCard4.setEnabled(true);
    }

    public void disableButton() {
        btnCard1.setEnabled(false);
        btnCard2.setEnabled(false);
        btnCard3.setEnabled(false);
        btnCard4.setEnabled(false);
    }

    public void resetColor() {
        btnCard1.setBackgroundColor(getResources().getColor(R.color.white));
        btnCard2.setBackgroundColor(getResources().getColor(R.color.white));
        btnCard3.setBackgroundColor(getResources().getColor(R.color.white));
        btnCard4.setBackgroundColor(getResources().getColor(R.color.white));
    }

    public void optionAClicked(View view) {
        disableButton();
        btnNext.setClickable(true);
        if (modelClass.getoA().equals(modelClass.getAns())) {
            btnCard1.setCardBackgroundColor(getResources().getColor(R.color.green));
            if (index < list.size()-1) {
                correct(btnCard1);
            } else {
                QuizOver();
            }
        } else {
            wrong(btnCard1);
        }
    }

    public void optionBClicked(View view) {
        disableButton();
        btnNext.setClickable(true);
        if (modelClass.getoB().equals(modelClass.getAns())) {
            btnCard2.setCardBackgroundColor(getResources().getColor(R.color.green));
            if (index < list.size()-1) {
                correct(btnCard2);
            } else {
                QuizOver();
            }
        } else {
            wrong(btnCard2);
        }
    }

    public void optionCClicked(View view) {
        disableButton();
        btnNext.setClickable(true);
        if (modelClass.getoC().equals(modelClass.getAns())) {
            btnCard3.setCardBackgroundColor(getResources().getColor(R.color.green));
            if (index < list.size()-1) {
                correct(btnCard3);
            } else {
                QuizOver();
            }
        } else {
            wrong(btnCard3);
        }
    }

    public void optionDClicked(View view) {
        disableButton();
        btnNext.setClickable(true);
        if (modelClass.getoD().equals(modelClass.getAns())) {
            btnCard4.setCardBackgroundColor(getResources().getColor(R.color.green));
            if (index < list.size()-1) {
                correct(btnCard4);
            } else {
                QuizOver();
            }
        } else {
            wrong(btnCard4);
        }
    }

    public void back(View view) {
        Dialog dialog = new Dialog(TestActivity.this);
        dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        dialog.setContentView(R.layout.quit_layout);

        dialog.findViewById(R.id.cancelTV).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
        dialog.findViewById(R.id.okTV).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TestActivity.this,PartScreen.class);
                startActivity(intent);
            }
        });

        dialog.show();


    }

    public void exit(View view) {

    }
}