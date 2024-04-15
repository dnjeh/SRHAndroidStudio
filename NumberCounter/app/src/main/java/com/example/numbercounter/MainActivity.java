package com.example.numbercounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView numberTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numberTextView = findViewById(R.id.numberTextView);

        Button resetButton = findViewById(R.id.resetButton);
        Button plusButton = findViewById(R.id.plusButton);

        //1번째: this로 달기
        resetButton.setOnClickListener(this);
        plusButton.setOnClickListener(this);
        /*
        //2번째: 직접 달아주기
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

         */
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.resetButton:
                numberTextView.setText("0");
                break;
            case R.id.plusButton:
                numberTextView.setText(Integer.toString(Integer.parseInt(numberTextView.getText().toString())+1));
                break;
        }
    }
}