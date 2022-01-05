package com.example.calculator4;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SourceMoveDigit extends AppCompatActivity {

    private Button parcelableMoveDigitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_constraint_layout);

        parcelableMoveDigitButton = findViewById(R.id.parcelable_move_digit_button);

        // Parcelable transfer
        parcelableMoveDigitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // create HomeWorkDisplayInfo object
                HomeWorkDisplayInfo homeWorkDisplayInfo = new HomeWorkDisplayInfo("77777", "33333");
                // create intent to MainActivityCalculator class
                Intent intent = new Intent(SourceMoveDigit.this, MoveDigit.class);
                // Add HomeWorkDisplayInfo data as extras to the intent
                intent.putExtra("Data", homeWorkDisplayInfo);
                startActivity(intent);
            }
        });


    }
}