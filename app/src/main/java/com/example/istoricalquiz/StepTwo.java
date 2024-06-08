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

public class StepTwo extends AppCompatActivity {
    private RadioGroup radioGroupTwoRG;
    private Button toNextTwoBTN;
    private int secondScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_step_two);

        radioGroupTwoRG = findViewById(R.id.radioGroupTwoRG);
        toNextTwoBTN = findViewById(R.id.toNextTwoBTN);

        secondScore = getIntent().getIntExtra("key", secondScore);

        radioGroupTwoRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case -1:
                        Toast.makeText(StepTwo.this, "Выберите один из вариантов",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.twoThreeRB:
                        secondScore = secondScore + 100;
                        break;
                    default:
                        break;
                }
            }
        });

        toNextTwoBTN.setOnClickListener(v -> {
            Intent intent = new Intent(this, StepThree.class);
            intent.putExtra("key_two", secondScore);
            startActivity(intent);
        });
    }
}