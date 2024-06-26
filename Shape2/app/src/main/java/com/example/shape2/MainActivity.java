package com.example.shape2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.shape2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.startImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("Main", "onClick1");
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                if(binding.radioButton1.isChecked()) {
                    Log.d("Main", "onClick2");
                    intent.putExtra("shape", 0);
                    launcher.launch(intent);
                    Log.d("Main", "onClick3");
                }
                else if(binding.radioButton2.isChecked()) {
                    intent.putExtra("shape", 1);
                    launcher.launch(intent);
                }
                else {
                    Toast.makeText(MainActivity.this, "찾고 싶은 모양을 클릭하세요", Toast.LENGTH_SHORT).show();
                }
            }
        });
        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult o) {
                        //다시 Main으로 돌아왔을때 실행되는 코드
                        String result = o.getData().getStringExtra("result");

                        binding.textViewResult.setText(result);
                    }
                }
        );
    }
}