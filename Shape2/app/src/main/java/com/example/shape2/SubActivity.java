package com.example.shape2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shape2.databinding.ActivitySubBinding;

public class SubActivity extends AppCompatActivity {
    ActivitySubBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivitySubBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        int shapeNum = intent.getIntExtra("shape", 0);
        if(shapeNum==0) {
            binding.imageView.setImageResource(R.drawable.circle);
        }
        else if(shapeNum==1) {
            binding.imageView.setImageResource(R.drawable.square);
        }

        binding.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = getIntent();
                intent1.putExtra("result", "성공");
                setResult(RESULT_OK, intent1);
                finish();
            }
        });
    }
}
