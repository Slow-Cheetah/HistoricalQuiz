package com.example.istoricalquiz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class StepOne extends AppCompatActivity {

    private RadioGroup radioGroupOneRG;
    private Button toNextOneBTN;

    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_step_one);

        radioGroupOneRG = findViewById(R.id.radioGroupOneRG);
        toNextOneBTN = findViewById(R.id.toNextOneBTN);

        radioGroupOneRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case -1:
                        Toast.makeText(StepOne.this, "Выберите один из вариантов",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.oneOneRB:
                        score = 100;
                        break;
                    default:
                        break;
                }
            }
        });

        toNextOneBTN.setOnClickListener(v -> {
            Intent intent = new Intent(this, StepTwo.class);
            intent.putExtra("key", score);
            startActivity(intent);
        });
    }
}