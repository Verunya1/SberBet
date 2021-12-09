package com.example.sberbet;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    private Button bt;
    private EditText summ, percent, summMonth;
    private TextView textMonth;
    private SeekBar month;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        summ = findViewById(R.id.editTextTextPersonName);
        month = findViewById(R.id.seekBar);
        textMonth =findViewById(R.id.textView6);
        summMonth = findViewById(R.id.editTextTextPersonName3);
        percent = findViewById(R.id.editTextTextPersonName4);

        month.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textMonth.setText("Время: " + month.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        bt = findViewById(R.id.button);
        bt.setOnClickListener(view -> {
            String sum = summ.getText().toString();
            String time = Double.toString(month.getProgress());
            String rep = percent.getText().toString();
            Intent intent = new Intent(this, Result.class);
            intent.putExtra("summa", sum);
            intent.putExtra("time", time);
            intent.putExtra("rep", rep);
            startActivity(intent); // - вызов активности без возврата данных
        });
    }
}