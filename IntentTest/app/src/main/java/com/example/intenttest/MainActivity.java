package com.example.intenttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Activity Life cycle", "onCreate 에서 호출됨");

        Button nextButton = findViewById(R.id.nextButton);
        EditText inputEditText = findViewById(R.id.inputEditText);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SubActivity.class);

                intent.putExtra("message", inputEditText.getText().toString());
                intent.putExtra("number", 510);

                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Activity Life cycle", "onStop 에서 호출됨");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Activity Life cycle", "onStart 에서 호출됨");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Activity Life cycle", "onResume 에서 호출됨");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Activity Life cycle", "onPause 에서 호출됨");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Activity Life cycle", "onDestroy 에서 호출됨");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Activity Life cycle", "onRestart 에서 호출됨");
    }
}