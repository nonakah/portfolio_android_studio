package com.example.quizsample2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import android.widget.Toast;

public class Quiz extends AppCompatActivity {

    //どのメソッドからでも使えるように準備。
    private TextView tvCount;
    private TextView tvQuestion;
    private Button ansBtn1;
    private Button ansBtn2;
    private Button ansBtn3;
    private Button ansBtn4;
    private Button nextBtn;

    private int i = 0;





    //クイズデータ準備。
    String quizData[][] = {
            //{"問題","正解","選択肢１","選択肢２","選択肢３"}
            {"1+1=", "2", "3", "4", "1"},
            {"1-1=", "0", "2", "-1", "1"},
            {"1+1-1×1÷1=", "1", "2", "0", "3"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);

        //IDを取得。
        getId();

        //クイズを表示。
        showQuiz();


    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();

        return super.onSupportNavigateUp();
    }

    //まずidを取得して準備。
    public void getId() {
        tvCount = findViewById(R.id.tvCount);
        tvQuestion = findViewById(R.id.tvQuestion);
        ansBtn1 = findViewById(R.id.ansBtn1);
        ansBtn2 = findViewById(R.id.ansBtn2);
        ansBtn3 = findViewById(R.id.ansBtn3);
        ansBtn4 = findViewById(R.id.ansBtn4);
        nextBtn = findViewById(R.id.nextBtn);
    }
    //クイズを表示。
    public void showQuiz(){
        //問題の順番をシャッフルして表示。
        List<Integer> num = Arrays.asList(1,2,3,4);
        Collections.shuffle(num);

        tvCount.setText("残り"+(3-i)+"問");
        tvQuestion.setText(quizData[i][0]);
        ansBtn1.setText(quizData[i][num.get(0)]);
        ansBtn2.setText(quizData[i][num.get(1)]);
        ansBtn3.setText(quizData[i][num.get(2)]);
        ansBtn4.setText(quizData[i][num.get(3)]);
    }
    //ボタンが押された時の正誤判定。
    public void onButton(View view){
        //押されたボタン。
        Button clickedBtn = (Button)view;
        String clickedAns = clickedBtn.getText().toString();

        //選択肢１がクリックされた時の処理。
        if(clickedAns.equals(quizData[i][1])){
            String bingo = getString(R.string.bingo);
            clickedBtn.setText(bingo);

            //ボタンを無効化、ネクストボタンを有効化。
            ansBtn1.setEnabled(false);
            ansBtn2.setEnabled(false);
            ansBtn3.setEnabled(false);
            ansBtn4.setEnabled(false);
            nextBtn.setEnabled(true);


            //３問め以降の場合はアクティビティ画面を作成して画面遷移する。
            if(i == 2 ){
                Intent intent = new Intent(this,Result.class);
                startActivity(intent);
                //３問めに行くまで次の問題へすすむ。
            }else{
                //次の問題へ誘導するトーストの表示。
                String goMsg = getString(R.string.toast_go_next);
                Toast.makeText(this, goMsg, Toast.LENGTH_SHORT).show();

                i++;

            }
            //選択肢１以外が選択された時の処理。
        }else{
            String wrong = getString(R.string.wrong);
            String gameOver = getString(R.string.game_over);
            clickedBtn.setText(wrong);
            tvQuestion.setText(gameOver);

            //ボタンを無効化。
            ansBtn1.setEnabled(false);
            ansBtn2.setEnabled(false);
            ansBtn3.setEnabled(false);
            ansBtn4.setEnabled(false);
            nextBtn.setEnabled(false);
            //初期画面へ戻るよう誘導するトーストの表示。
            String endMsg = getString(R.string.toast_end);
            Toast.makeText(this, endMsg, Toast.LENGTH_SHORT).show();
        }
    }
    //6)Nextボタンがおされた時の処理。
    public  void onNext(View view){
        showQuiz();

        ansBtn1.setEnabled(true);
        ansBtn2.setEnabled(true);
        ansBtn3.setEnabled(true);
        ansBtn4.setEnabled(true);
    }



}