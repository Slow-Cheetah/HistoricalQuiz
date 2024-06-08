package com.example.istoricalquiz;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FinalActivity extends AppCompatActivity {

    private TextView resulTV;
    private TextView commentTV;

    String wellDone = "Молодец! Все ответы верные!";
    String good = "Хорошо! С одним вопросом не справился.";
    String notGood = "Не хорошо, 3 из 5 верно";
    String bad = "Ай ай, всего два верных ответа! Старайся лучше!";
    String veryBad = "Один или ни одного верного ответа. Стоит изучать историю.";

    private int resultScore = 0;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_final);

        resulTV = findViewById(R.id.resulTV);
        commentTV = findViewById(R.id.commentTV);

        resultScore = getIntent().getIntExtra("key_five", resultScore);
        String value = Integer.toString(resultScore);
        resulTV.setText(value);
        switch (resultScore) {
            case 500:
                commentTV.setText(wellDone);
                break;
            case 400:
                commentTV.setText(good);
                break;
            case 300:
                commentTV.setText(notGood);
                break;
            case 200:
                commentTV.setText(bad);
                break;
            case 100:
                commentTV.setText(veryBad);
                break;
            case 0:
                commentTV.setText(veryBad);
                break;
        }
    }
}