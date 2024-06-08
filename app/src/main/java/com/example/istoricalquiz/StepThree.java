package com.example.istoricalquiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class StepThree extends AppCompatActivity {

    private RadioGroup radioGroupThreeRG;
    private Button toNextThreeBTN;
    private int thirdScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_step_three);

        radioGroupThreeRG = findViewById(R.id.radioGroupThreeRG);
        toNextThreeBTN = findViewById(R.id.toNextThreeBTN);

        thirdScore = getIntent().getIntExtra("key_two", thirdScore);

        radioGroupThreeRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case -1:
                        Toast.makeText(StepThree.this, "Выберите один из вариантов",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.threeTwoRB:
                        thirdScore = thirdScore + 100;
                        break;
                    default:
                        break;
                }
            }
        });

        toNextThreeBTN.setOnClickListener(v -> {
            Intent intent = new Intent(this, StepFour.class);
            intent.putExtra("key_three", thirdScore);
            startActivity(intent);
        });
    }
}