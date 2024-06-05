package com.example.intenttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Button prevButton = findViewById(R.id.prevButton);
        TextView resultTextView = findViewById(R.id.resultTextView);

        Intent intent = getIntent();
        String message = intent.getStringExtra("message");
        int num = intent.getIntExtra("number", 0);

        resultTextView.setText("문자열" + message + ",숫자:" + num);

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = getIntent();
                intent1.putExtra("result", "성공!");
                setResult(RESULT_OK, intent1);

                finish();
            }
        });
    }
}