package com.example.shape;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.shape.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ActivityResultLauncher<Intent> launcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.startImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!binding.radioButton.isChecked()&&!binding.radioButton2.isChecked()) {
                    Toast.makeText(MainActivity.this, "찾고 싶은 모양을 클릭하세요", Toast.LENGTH_SHORT).show();
                } //안댐
                else {
                    Intent intent = new Intent(MainActivity.this, SubActivity.class);

                    intent.putExtra("shape", binding.radioButton.isChecked()?0:1);
                    launcher.launch(intent);
                }
            }
        });

        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult o) {
                        //다시 돌아왔을 때 실행되는 코드
                    }
                }
        );
    }
}