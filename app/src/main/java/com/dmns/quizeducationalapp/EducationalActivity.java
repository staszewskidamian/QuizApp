package com.dmns.quizeducationalapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by developer on 11/05/2017.
 */

public class EducationalActivity extends AppCompatActivity {

    int yes_answer = 0;
    int no_answer = 0;
    int maybe_answer = 0;
    String usr_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.educationalquiz);

        String name = this.getIntent().getStringExtra("text");
        usr_name = name;

        Button buttonClick = (Button) findViewById(R.id.test2);
        buttonClick.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                int corect = 0;
                EditText Field = (EditText) findViewById(R.id.edit_answer);
                Editable nameEditable = Field.getText();
                String tell_answer = nameEditable.toString();
                boolean brain = "brain".equalsIgnoreCase(tell_answer);
                boolean mozg = "mózg".equalsIgnoreCase(tell_answer);
                if (brain) {
                    corect++;
                }
                if (mozg) {
                    corect++;
                }
                RadioButton answer1 = (RadioButton) findViewById(R.id.question1Correct);
                if (answer1.isChecked()) {
                    corect++;
                }
                RadioButton answer2 = (RadioButton) findViewById(R.id.question2Correct);
                if (answer2.isChecked()) {
                    corect++;
                }
                RadioButton answer3 = (RadioButton) findViewById(R.id.question3Correct);
                if (answer3.isChecked()) {
                    corect++;
                }
                CheckBox checkBox1 = (CheckBox) findViewById(R.id.question4Correct1);
                CheckBox checkBox2 = (CheckBox) findViewById(R.id.question4Correct2);
                CheckBox checkBox3 = (CheckBox) findViewById(R.id.question4Wrong);
                if (checkBox1.isChecked() && checkBox2.isChecked() && !(checkBox3.isChecked())){corect++;}
                String text = getResources().getString(R.string.lastResults);
                String msg = String.format(text, usr_name, corect);
                Toast.makeText(EducationalActivity.this, msg, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(EducationalActivity.this, ResultActivity.class);
                intent.putExtra("result", msg);
                startActivity(intent);
                finish();
            }

        });
    }


    public void showAnswer(View v) {
        String text = getResources().getString(R.string.correctAnswer);
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }




}