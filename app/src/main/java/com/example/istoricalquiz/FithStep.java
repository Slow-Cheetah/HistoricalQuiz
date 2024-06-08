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

public class FithStep extends AppCompatActivity {
    private RadioGroup radioGroupFithRG;
    private Button toEndBTN;
    private int fiveScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fith_step);

        radioGroupFithRG = findViewById(R.id.radioGroupFithRG);
        toEndBTN = findViewById(R.id.toEndBTN);

        fiveScore = getIntent().getIntExtra("key_four", fiveScore);

        radioGroupFithRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case -1:
                        Toast.makeText(FithStep.this, "Выберите один из вариантов",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.fithFourRB:
                        fiveScore = fiveScore + 100;
                        break;
                    default:
                        break;
                }
            }
        });

        toEndBTN.setOnClickListener(v -> {
            Intent intent = new Intent(this, FinalActivity.class);
            intent.putExtra("key_five", fiveScore);
            startActivity(intent);
        });
    }
}