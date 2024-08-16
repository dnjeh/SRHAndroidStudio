package com.example.project_v2;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewbinding.ViewBinding;

import com.example.project_v2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.SwitchAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(binding.SwitchAgree.isChecked()) {
                    binding.Text2.setVisibility(View.VISIBLE);
                    binding.Rgroup1.setVisibility(View.VISIBLE);
                    binding.BtnFinish.setVisibility(View.VISIBLE);
                    binding.BtnBack.setVisibility(View.VISIBLE);
                    binding.imgPokemon.setVisibility(View.VISIBLE);
                }
                else {
                    binding.Text2.setVisibility(View.INVISIBLE);
                    binding.Rgroup1.setVisibility(View.INVISIBLE);
                    binding.BtnFinish.setVisibility(View.INVISIBLE);
                    binding.BtnBack.setVisibility(View.INVISIBLE);
                    binding.imgPokemon.setVisibility(View.INVISIBLE);
                }
            }
        });

        binding.Rgroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==binding.RdoFairy.getId()) {
                    binding.imgPokemon.setImageResource(R.drawable.fairy);
                }
                else if(checkedId==binding.RdoJammanbo.getId()) {
                    binding.imgPokemon.setImageResource(R.drawable.jammanbo);
                }
                else if(checkedId==binding.RdoPikachu.getId()) {
                    binding.imgPokemon.setImageResource(R.drawable.pikachu);
                }
            }
        });
        binding.BtnBack.setOnClickListener(this);
        binding.BtnFinish.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.BtnBack) {
            binding.Rgroup1.clearCheck();
            binding.imgPokemon.setImageResource(0);
            binding.SwitchAgree.setChecked(false);
        }
        else if(v.getId() == R.id.BtnFinish) {
            finish();
        }
    }
}