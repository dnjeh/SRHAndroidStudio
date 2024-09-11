package com.example.fragexam;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1, btn2, btn3;
    FragmentManager fm;
    FragmentTransaction ft;
    Fragment1 f1;
    Fragment2 f2;
    Fragment3 f3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        f1 = new Fragment1();
        f2 = new Fragment2();
        f3 = new Fragment3();

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        ft.add(R.id.main_fragment, f1);
        ft.commit();

    }

    @Override
    public void onClick(View v) {
        ft = fm.beginTransaction();

        if(v.getId()==R.id.btn1) {
            ft.replace(R.id.main_fragment, f1);
            ft.commit();
        }
        else if(v.getId()==R.id.btn2) {
            ft.replace(R.id.main_fragment, f2);
            ft.commit();
        }
        else if(v.getId()==R.id.btn3) {
            ft.replace(R.id.main_fragment, f3);
            ft.commit();
        }
    }
}