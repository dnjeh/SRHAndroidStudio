package com.example.shape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.shape.databinding.ActivitySubBinding;

public class SubActivity extends AppCompatActivity implements View.OnClickListener {
    ActivitySubBinding binding;
    FrameLayout[] shapeFrameLayout = new FrameLayout[6];
    ImageView[] shapeImage = new ImageView[6];
    int[] selectShape = new int[6];
    int countShape = 0;
    ImageView checkImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySubBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        int shapeNum = intent.getIntExtra("shape", 0);
        if(shapeNum == 0) {
            binding.imageView.setImageResource(R.drawable.circle);
        }
        else {
            binding.imageView.setImageResource(R.drawable.square);
        }
        shapeFrameLayout[0] = binding.frameLayout01;
        shapeFrameLayout[1] = binding.frameLayout02;
        shapeFrameLayout[2] = binding.frameLayout03;
        shapeFrameLayout[3] = binding.frameLayout04;
        shapeFrameLayout[4] = binding.frameLayout05;
        shapeFrameLayout[5] = binding.frameLayout06;

        shapeImage[0] = binding.shape01;
        shapeImage[1] = binding.shape02;
        shapeImage[2] = binding.shape03;
        shapeImage[3] = binding.shape04;
        shapeImage[4] = binding.shape05;
        shapeImage[5] = binding.shape06;

        for(int i=0;i<shapeImage.length;i++) {
            shapeImage[i].setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.shape01) {
            selectUpdate(0);
        }
        else if(view.getId() == R.id.shape02) {
            selectUpdate(1);
        }
        else if(view.getId() == R.id.shape03) {
            selectUpdate(2);
        }
        else if(view.getId() == R.id.shape04) {
            selectUpdate(3);
        }
        else if(view.getId() == R.id.shape05) {
            selectUpdate(4);
        }
        else if(view.getId() == R.id.shape06) {
            selectUpdate(5);
        }
    }
    private void selectUpdate(int i) {
        if(selectShape[i]==0&&countShape>=2) Toast.makeText(SubActivity.this, "욕심쟁이", Toast.LENGTH_SHORT).show();
        else if(selectShape[i]==0) {
            selectShape[i]=1;
            countShape++;
            checkImage = new ImageView(this);
            checkImage.setImageResource(R.drawable.ok_check);
            shapeFrameLayout[i].addView(checkImage);
        }
        else {
            selectShape[i]=0;
            countShape--;
            shapeFrameLayout[i].removeViewAt(1);

        }
    }
}