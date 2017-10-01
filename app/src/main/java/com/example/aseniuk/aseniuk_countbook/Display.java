package com.example.aseniuk.aseniuk_countbook;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Display extends Activity {


    private TextView counterTextView;
    //private Button AddCounterButton;
    //private Button ResetButton;

    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);

        counterTextView = (TextView) findViewById(R.id.counterTextView);

    }

    public void addCounterButtonClicked(View view) {
        counter++;
        counterTextView.setText(String.valueOf(counter)); //integer to string
    }

    public void resetButtonClicked(View view) {
        counter = 0;
        counterTextView.setText(String.valueOf(counter)); //integer to string
    }

}
