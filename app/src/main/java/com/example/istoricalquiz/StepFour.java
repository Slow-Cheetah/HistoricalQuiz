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

public class StepFour extends AppCompatActivity {
    private RadioGroup radioGroupFourRG;
    private Button fourBTN;
    private int fourScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_step_four);

        radioGroupFourRG = findViewById(R.id.radioGroupFourRG);
        fourBTN = findViewById(R.id.fourBTN);

        fourScore = getIntent().getIntExtra("key_three", fourScore);

        radioGroupFourRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case -1:
                        Toast.makeText(StepFour.this, "Выберите один из вариантов",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.fourFourRB:
                        fourScore = fourScore + 100;
                        break;
                    default:
                        break;
                }
            }
        });

        fourBTN.setOnClickListener(v -> {
            Intent intent = new Intent(this, FithStep.class);
            intent.putExtra("key_four", fourScore);
            startActivity(intent);
        });
    }
}