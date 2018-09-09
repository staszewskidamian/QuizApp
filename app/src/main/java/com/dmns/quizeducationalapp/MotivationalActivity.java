package com.dmns.quizeducationalapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by developer on 11/05/2017.
 */

public class MotivationalActivity extends AppCompatActivity {

    int yes_answer = 0;
    int no_answer = 0;
    int maybe_answer = 0;
    String usr_name;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.motivatonalquiz);

        String name = this.getIntent().getStringExtra("text");
        usr_name = name;

        Button buttonClick = (Button)findViewById(R.id.show_answers);
        buttonClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int res = yes_answer + no_answer + maybe_answer;
                if (res >= 6){
                    String text = getResources().getString(R.string.option1);
                    result = usr_name + text;
                } else if (res <= 4 ){
                    String text = getResources().getString(R.string.option2);
                    result = usr_name + text;
                } else if (yes_answer == 5 && res == 5){
                    String text = getResources().getString(R.string.option3);
                    result = usr_name + text;
                }else if(no_answer == 5 && res == 5){
                    String text = getResources().getString(R.string.option4);
                    result = usr_name + text;                 }
                else
                {  String text = getResources().getString(R.string.option5);
                    result = usr_name + text; }
                Intent intent = new Intent(MotivationalActivity.this, ResultActivity.class);
                intent.putExtra("result", result);
                startActivity(intent);
                finish();
            }

        });

    }


    public void onCheckboxClickedYes (View v){
        yes_answer += 1;
        String text = getResources().getString(R.string.chosenYes);
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    public void onCheckboxClickedNo (View v){
        no_answer += 1;
        String text = getResources().getString(R.string.chosenNo);
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    public void onCheckboxClickedMaybe (View v){
        maybe_answer += 1;
        String text = getResources().getString(R.string.chosenMaybe);
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }




}