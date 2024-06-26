package com.example.animalshop;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.animalshop.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityMainBinding binding;
    int val_price; //제품 가격(배송비 미포함)
    int val_delivery; //배송비
    int val_pay; //총 결제 비용
    int selected_product = 1500; //선택한 제품의 한 개 가격
    int selected_count = 1; //선택한 수량

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.radio1.setOnClickListener(this);
        binding.radio2.setOnClickListener(this);
        binding.radio3.setOnClickListener(this);

        binding.btnPlus.setOnClickListener(this);
        binding.btnMinus.setOnClickListener(this);
        binding.btnPay.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.radio1) {
            binding.imgProductMain.setImageResource(R.drawable.product1);
            selected_product = 1500;
            sumTotal();
        }
        else if(view.getId()==R.id.radio2) {
            binding.imgProductMain.setImageResource(R.drawable.product2);
            selected_product = 2000;
            sumTotal();
        }
        else if(view.getId()==R.id.radio3) {
            binding.imgProductMain.setImageResource(R.drawable.product3);
            selected_product = 3000;
            sumTotal();
        }
        else if(view.getId()==R.id.btn_plus) {
            selected_count++;
            binding.editCount.setText(selected_count+"");
            sumTotal();
        }
        else if(view.getId()==R.id.btn_minus) {
            if(selected_count == 1) {
                Toast.makeText(this, "선택할 수 있는 최소 수량은 1입니다.", Toast.LENGTH_SHORT).show();
                return;
            }
            selected_count--;
            binding.editCount.setText(selected_count+"");
            sumTotal();
        }
        else if(view.getId() == R.id.btn_pay) {
            if(binding.chkAgree.isChecked()) {
                Toast.makeText(this, val_pay + "결제 성공", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "결제 동의 버튼을 체크해주세요", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void sumTotal() {
        selected_count = Integer.parseInt(binding.editCount.getText().toString());
        val_price = selected_count * selected_product;
        val_delivery = val_price>=10000?0:2500;
        val_pay = val_price + val_delivery;
        binding.txtPrice.setText(val_price+"원");
        binding.txtDelivery.setText(val_delivery+"원");
        binding.txtPay.setText(val_pay+"원");
    }
}