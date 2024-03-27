package com.example.linearlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText idEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.school_info);

        Button prevButton = findViewById(R.id.prevButton);
        Button nextButton = findViewById(R.id.nextButton);
        Button endButton = findViewById(R.id.endButton);

        idEditText = findViewById(R.id.idEditText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);

        //1번째 방법
        prevButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);

        //2번째 방법
        endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("MainActivity", "endButton이 클릭되었습니다.");
                Toast.makeText(MainActivity.this, "endButton이 클릭되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.prevButton:
                Log.d("MainActivity", "prevButton이 클릭되었습니다");
                Toast.makeText(this, "prevButton이 클릭되었습니다", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nextButton:
                String idText = idEditText.getText().toString();
                if(idText.length() < 5) {
                    Toast.makeText(this, "아이디를 다시 입력하세요", Toast.LENGTH_SHORT).show();
                }
                else    {
                   Toast.makeText(this, idText+"님 반갑습니다.", Toast.LENGTH_SHORT).show();
        }
                break;
        }
    }
}