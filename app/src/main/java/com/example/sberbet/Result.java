package com.example.sberbet;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    private TextView tv;

    private static final double PERCENT = 3;

    private double get_income(double sum, double time, double rep) {
        return sum + (sum * rep * time) / 36500;
    }

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tv = findViewById(R.id.result);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            double sum = Double.parseDouble(bundle.getString("sum"));
            double time = Double.parseDouble(bundle.getString("time"));
            double rep = Double.parseDouble(bundle.getString("rep"));

            double income = get_income(sum, time,rep);

            tv.setText(String.format("%.2f", income - sum));
        }
    }
}