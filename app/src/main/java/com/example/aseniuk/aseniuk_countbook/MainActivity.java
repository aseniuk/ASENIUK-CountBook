package com.example.aseniuk.aseniuk_countbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
//
//
//    private TextView counterTextView;
//    private Button AddCounterButton;
//    private Button ResetButton;
//
//    private int counter = 0;

//    private View.OnClickListener clickListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            switch (view.getId()) {
//                case R.id.AddCounterButton:
//                    addCounterButtonClicked();
//                    break;
//                case R.id.ResetButton :
//                    resetButtonClicked();
//                    break;
//
//            }
//        }
//    };

    public void addCounterButtonClicked(View v) {
        if(v.getId() == R.id.AddCounterButton)
        {
            Intent i = new Intent(MainActivity.this, Display.class);
            startActivity(i);
        }
    }

    @Override //like the run method
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //counterTextView = (TextView) findViewById(R.id.counterTextView);
//        AddCounterButton = (Button) findViewById(R.id.AddCounterButton);
//        AddCounterButton.setOnClickListener(clickListener);
//        ResetButton = (Button) findViewById(R.id.ResetButton);
//        ResetButton.setOnClickListener(clickListener);

        //initCounter();
    }


//    public void addCounterButtonClicked(View view) {
//        counter++;
//        counterTextView.setText(String.valueOf(counter)); //integer to string
//    }
//
//    public void resetButtonClicked(View view) {
//        counter = 0;
//        counterTextView.setText(String.valueOf(counter)); //integer to string
//    }
}
