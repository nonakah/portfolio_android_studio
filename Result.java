package com.example.quizsample2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        //アクションバーに戻るボタンを実装するための準備。
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        //お礼と初期画面へ戻るよう誘導するトーストの表示。
        String thankMsg = getString(R.string.toast_thanks);
        Toast.makeText(this, thankMsg, Toast.LENGTH_LONG).show();

    }
    //アクションバーに戻るボタンを実装する。
    @Override
    public boolean onSupportNavigateUp(){
        finish();

        return super.onSupportNavigateUp();
    }

}




