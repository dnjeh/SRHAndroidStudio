package com.example.bmi_calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText heightText = findViewById(R.id.height);
        EditText weightText = findViewById(R.id.weight);
        Button enterButton = findViewById(R.id.enter);
        TextView outputView = findViewById(R.id.output);
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(heightText.getText().toString().length()==0||weightText.getText().toString().length()==0) {
                    Toast.makeText(MainActivity.this, "빈 값이 있습니다", Toast.LENGTH_SHORT).show();
                    return;
                }
                double height = Integer.parseInt(heightText.getText().toString())/(double)100;
                int weight = Integer.parseInt(weightText.getText().toString());
                double t=weight/Math.pow(height, 2);
                String temp;
                if(t>=35) temp="고도비만";
                else if(t>=30) temp="중정도비만";
                else if(t>=25) temp="경도비만";
                else if(t>=23) temp="과체중";
                else if(t>=18.5) temp="정상 체중";
                else temp="저체중";
                outputView.setVisibility(View.VISIBLE);
                outputView.setText(temp);
            }
        });
    }

}