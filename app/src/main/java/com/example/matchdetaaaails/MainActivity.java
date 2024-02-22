package com.example.matchdetaaaails;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBarAce;
    private TextView textViewNumber1, textViewNumber2, resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewNumber1 = findViewById(R.id.ace1);
        textViewNumber2 = findViewById(R.id.ace2);
        progressBarAce = findViewById(R.id.progressBarAce);
    }

    public void compareNumbers(View view) {
        String strNum1 = textViewNumber1.getText().toString();
        String strNum2 = textViewNumber2.getText().toString();

        if (!strNum1.isEmpty() && !strNum2.isEmpty()) {
            int num1 = Integer.parseInt(strNum1);
            int num2 = Integer.parseInt(strNum2);

            int progress = (int) (((double) num1 / num2) * 100);

            // Définir la couleur de la première moitié de la barre de progression
            int color1 = Color.RED;

            // Définir la couleur de la deuxième moitié de la barre de progression
            int color2 = Color.GREEN;

            // Créer un tableau de dessins pour définir les couleurs
            LayerDrawable layerDrawable = (LayerDrawable) progressBarAce.getProgressDrawable();
            layerDrawable.getDrawable(2).setColorFilter(color1, android.graphics.PorterDuff.Mode.SRC_IN);
            layerDrawable.getDrawable(0).setColorFilter(color2, android.graphics.PorterDuff.Mode.SRC_IN);

            // Définir la progression
            progressBarAce.setProgress(progress);

            if (num1 == num2) {
                resultTextView.setText("Numbers are equal!");
            } else {
                resultTextView.setText("Numbers are not equal!");
            }

            progressBarAce.setVisibility(View.VISIBLE);
        } else {
            resultTextView.setText("Please enter both numbers.");
        }
    }
}