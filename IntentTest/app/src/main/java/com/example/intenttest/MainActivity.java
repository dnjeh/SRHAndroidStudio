package com.example.intenttest;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.net.URI;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityResultLauncher<Intent> launcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Activity Life cycle", "onCreate 에서 호출됨");
        TextView mainResultTextView = findViewById(R.id.mainResultTextView);
        Button nextButton = findViewById(R.id.nextButton);
        EditText inputEditText = findViewById(R.id.inputEditText);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SubActivity.class);

                intent.putExtra("message", inputEditText.getText().toString());
                intent.putExtra("number", 510);

                //startActivity(intent);
                launcher.launch(intent);
            }
        });

        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult o) {
                        //sub 엑티비티에서 돌아왔을때 실행되는 부분
                        String msg = o.getData().getStringExtra("result");
                        mainResultTextView.setText(msg);
                    }
                }
        );

        findViewById(R.id.dialButton).setOnClickListener(this);
        findViewById(R.id.mapButton).setOnClickListener(this);
        findViewById(R.id.smsButton).setOnClickListener(this);
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dialButton:
                Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"));
                startActivity(dialIntent);
                break;
            case R.id.mapButton:
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:"));
                startActivity(mapIntent);
                break;
                case R.id.smsButton:
                    Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("smsto:"));
                    smsIntent.putExtra("sms_body", "제국아일해라");
                    startActivity(smsIntent);
                    break;
        }
    }
}