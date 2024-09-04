package com.example.sharetest;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edit;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit = findViewById(R.id.edit);
        resultText = findViewById(R.id.resultTxt);
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences sp = getSharedPreferences("SFile", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        String str = edit.getText().toString();
        editor.putString("Key", str);
        editor.commit();
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        SharedPreferences sp = getSharedPreferences("SFile", MODE_PRIVATE);
        String str = sp.getString("Key", "");
        resultText.setText(str);

        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
    }
}