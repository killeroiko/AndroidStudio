package com.example.aef_2020_2021;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


import java.util.Timer;
import java.util.TimerTask;

public class Calculate extends AppCompatActivity {
    EditText userWeightText;
    EditText userHeightText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(savedInstanceState != null){
            CharSequence userWeight = savedInstanceState.getCharSequence("savedUserWeight");
            CharSequence userHeight = savedInstanceState.getCharSequence("savedUserHeight");
            userHeightText.setText(userHeight);
            userWeightText.setText(userWeight);
        }
        else{
            super.onCreate(null);
            setContentView(R.layout.activity_calculate);
            userHeightText = findViewById(R.id.height);
            userWeightText = findViewById(R.id.weight);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        CharSequence userWeight = userWeightText.getText();
        CharSequence userHeight = userHeightText.getText();
        outState.putCharSequence("savedUserWeight",userWeight);
        outState.putCharSequence("savedUserHeight",userHeight);
    }

    public void CalculateBMI(View view) {

        TextView warning = findViewById(R.id.warning);



        String height = String.valueOf(userHeightText.getText());
        String weight = String.valueOf(userWeightText.getText());

        int h = Integer.parseInt(height);
        int w = Integer.parseInt(weight);

        if((h<= 30 || h>=250) && (w<1 || w>500)){
            warning.setText(R.string.warning1);
            warning.setVisibility(View.VISIBLE);
            hideWarning(warning);
        }
        else if(w<1 || w>500){
            warning.setText(R.string.warning2);
            warning.setVisibility(View.VISIBLE);
            hideWarning(warning);
        }
        else if(h<= 30 || h>=250){
            warning.setText(R.string.warning3);
            warning.setVisibility(View.VISIBLE);
            hideWarning(warning);
        }
    }

    private void hideWarning(TextView warning){
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                warning.setVisibility(View.INVISIBLE);
            }
        };

        timer.schedule(task,5000);
    }
}