package com.example.trope.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculatorActivity extends AppCompatActivity {
    protected double finalResult = 0;
    protected Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    protected TextView calculatorLed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initCalculator();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    protected void initCalculator() {
        calculatorLed = findViewById(R.id.calculatorLed);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        List<Button> NumberedButtons = Arrays.asList(button0, button1, button2, button3, button4, button5, button6, button7, button8, button9);
        for (Button tmpButton : NumberedButtons)
            tmpButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String newVal= ((Button) view).getText().toString();
                    String oldVal = calculatorLed.getText().toString();
                    if (oldVal.equals("0")) calculatorLed.setText(newVal);
                    else calculatorLed.setText( oldVal + newVal);
                }
            });

    }
}
