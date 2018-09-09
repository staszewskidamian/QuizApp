package com.dmns.quizeducationalapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


/**
 * Created by developer on 11/05/2017.
 */

public class ResultActivity extends AppCompatActivity {

    String toPrint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rasultlayout);

        String result = this.getIntent().getStringExtra("result");
        toPrint = result;
        display_answer(toPrint);
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
                Intent newGame = new Intent(ResultActivity.this, OneActivity.class);
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


    public void display_answer(String tell_text) {
        TextView scoreView = (TextView) findViewById(R.id.show_answer);
        scoreView.setText(String.valueOf(tell_text));
    }

}