package com.example.cricket.temperature;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText etChirps;
    Button btn;
    TextView tvResult;
    DecimalFormat formatter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etChirps = findViewById(R.id.etChirps);
        btn = findViewById(R.id.btn);
        tvResult = findViewById(R.id.tvResult);

        tvResult.setVisibility(View.GONE);

        formatter = new DecimalFormat("#0.00");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (etChirps.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please enter all the fields!", Toast.LENGTH_SHORT ).show();
                }
                else
                {
                    int chirps = Integer.parseInt(etChirps.getText().toString().trim());
                    double temp = (chirps / 3.0) + 4;

                    String results = "The approximate temperature outside is " + formatter.format(temp) + " degree Celsius.";

                    tvResult.setText(results);

                    tvResult.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
