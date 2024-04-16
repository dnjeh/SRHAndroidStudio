package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText height;
    EditText weight;
    Button   enter ;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        height = findViewById(R.id.heightEditText);
        weight = findViewById(R.id.weightEditText);
        enter = findViewById(R.id.resultButton);
        result = findViewById(R.id.resultText);
        enter.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.resultButton:
                if(height.getText().toString().isEmpty()||weight.getText().toString().isEmpty()) {
                    Toast.makeText(this, "빈 값이 있습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                double doubleHeight = Double.parseDouble(height.getText().toString())/100;
                int intWeight = Integer.parseInt(weight.getText().toString());
                double bmi = intWeight/Math.pow(doubleHeight, 2);
                String temp;
                if(bmi>=35) temp="고도비만";
                else if(bmi>=30) temp="중정도비만";
                else if(bmi>=25) temp="경도비만";
                else if(bmi>=23) temp="과체중";
                else if(bmi>=18.5) temp="정상 체중";
                else temp="저체중";
                result.setText(temp);
                result.setVisibility(View.VISIBLE);
        }
    }
}