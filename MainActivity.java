package com.example.quizsample2;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button  startBtn= findViewById(R.id.startBtn);
        // lambda式でスタートボタンを押したときにクイズ画面へ進む処理の記述。
        startBtn.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(), Quiz.class);
            startActivity(intent);
        });
    }




}