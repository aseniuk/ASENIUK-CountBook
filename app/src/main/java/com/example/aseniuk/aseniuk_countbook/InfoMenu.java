package com.example.aseniuk.aseniuk_countbook;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InfoMenu extends Activity {

    private TextView counterTextView;
    private Button minus_button;
    private Button plus_button;
    private Button reset_button;

    private int counter;


    //code adapted from : https://www.youtube.com/watch?v=7d6iKupzkEg

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.minus_button :
                    minusCounter();
                    break;
                case R.id.plus_button :
                    plusCounter();
                    break;
                case R.id.reset_button :
                    initCounter();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_menu);

        counterTextView = (TextView) findViewById(R.id.counterTextView);
        minus_button = (Button) findViewById(R.id.minus_button);
        minus_button.setOnClickListener(clickListener);
        plus_button = (Button) findViewById(R.id.plus_button);
        plus_button.setOnClickListener(clickListener);
        reset_button = (Button) findViewById(R.id.reset_button);
        reset_button.setOnClickListener(clickListener);

        initCounter();

    }

    private void initCounter() {
        counter = 0;
        counterTextView.setText(String.valueOf(counter)); //integer to string
    }
    private void plusCounter() {
        counter++;
        counterTextView.setText(String.valueOf(counter)); //integer to string
    }

    private void minusCounter() {
        counter--;
        counterTextView.setText(String.valueOf(counter)); //integer to string
    }



}
