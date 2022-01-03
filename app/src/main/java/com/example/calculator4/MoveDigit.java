package com.example.calculator4;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class
MoveDigit extends AppCompatActivity {

    public static final String DISPLAY_KEY = "Data";
    private TextView displayInfoTextView, otherInfoTextView2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_digit);

        displayInfoTextView = findViewById(R.id.move_digit_text_view);
        otherInfoTextView2 = findViewById(R.id.move_digit_text_view2);

        // receive the parcelable data from SourceMoveDigit
        Bundle data = getIntent().getExtras();
        HomeWorkDisplayInfo homeWorkDisplayInfo = (HomeWorkDisplayInfo) data.getParcelable(DISPLAY_KEY);

        String displayInfo = homeWorkDisplayInfo.getDisplayInfo();
        String otherInfo = homeWorkDisplayInfo.getOtherInfo();

        Log.i("SourceMoveDigit", "display info: " + displayInfo + " otherInfo: " + otherInfo);

        displayInfoTextView.setText(displayInfo);
        otherInfoTextView2.setText(otherInfo);
    }
}
