package com.dmns.quizeducationalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class OneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manylayouts);

        Button toMotiv = (Button) findViewById(R.id.motivationalButton);
        toMotiv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                EditText nameField = (EditText) findViewById(R.id.edit_name);
                Editable nameEditable = nameField.getText();
                String tell_name = nameEditable.toString();
                String usr_name;
                if (tell_name != null && !tell_name.isEmpty()) {
                    usr_name = tell_name;
                } else {
                    usr_name = "Anonymous User";
                }
                Intent intent = new Intent(OneActivity.this, MotivationalActivity.class);
                intent.putExtra("text", usr_name);
                startActivity(intent);
                finish();
            }

        });
        Button toEdu = (Button) findViewById(R.id.educationalButton);
        toEdu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                EditText nameField = (EditText) findViewById(R.id.edit_name);
                Editable nameEditable = nameField.getText();
                String tell_name = nameEditable.toString();
                String usr_name;
                if (tell_name != null && !tell_name.isEmpty()) {
                    usr_name = tell_name;
                } else {
                    usr_name = "Anonymous User";
                }
                Intent intent = new Intent(OneActivity.this, EducationalActivity.class);
                intent.putExtra("text", usr_name);
                startActivity(intent);
                finish();
            }

        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.chose_lang, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_newGame:
                // TODO
                this.finish();
                Intent newGame = new Intent(OneActivity.this, OneActivity.class);
                startActivity(newGame);
                return true;
            case R.id.action_endGame:
                this.finish();
                return true;
            case R.id.action_lang:
                // TODO
                Intent i = new Intent(android.provider.Settings.ACTION_LOCALE_SETTINGS);
                startActivity(i);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}


