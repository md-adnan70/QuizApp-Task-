package com.example.quizapptask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView quizImg;
    ProgressBar progressBar;
    Animation fade_in;
    public static ArrayList<ModelClass> list;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quizImg = findViewById(R.id.quizImage);
        progressBar = findViewById(R.id.progress);
        fade_in = AnimationUtils.loadAnimation(MainActivity.this,R.anim.fade);

        quizImg.startAnimation(fade_in);

        list = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference("Subjects").child("Science").child("Part1").child("Questions");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                    ModelClass modelClass = dataSnapshot.getValue(ModelClass.class);
                    list.add(modelClass);
                }
                Intent intent = new Intent(MainActivity.this,ClassScreen.class);
                startActivity(intent);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                Intent intent = new Intent(MainActivity.this,TestActivity.class);
//                startActivity(intent);
            }
        },1500);

    }
}