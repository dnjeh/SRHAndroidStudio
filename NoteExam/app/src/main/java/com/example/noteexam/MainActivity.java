package com.example.noteexam;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.noteexam.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    ActivityMainBinding binding;
    ArrayList<String> titleData;
    ArrayAdapter<String> titleAdapter;

    ArrayList<String> noteData;
    ArrayAdapter<String> noteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        titleData = new ArrayList<>();
        titleData.add("선택");
        titleData.add("1학년");
        titleData.add("2학년");
        titleData.add("3학년");

        noteData = new ArrayList<>();

        titleAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titleData);
        binding.spinner.setAdapter(titleAdapter);
        noteAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, noteData);
        binding.listView.setAdapter(noteAdapter);

        binding.btnDele.setOnClickListener(this);
        binding.btnSave.setOnClickListener(this);
        binding.btnNew.setOnClickListener(this);
        binding.btnFinish.setOnClickListener(this);

        binding.listView.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_new) {
            binding.txtInput.setText("");
        }
        else if(v.getId()==R.id.btn_finish) {
            finish();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}