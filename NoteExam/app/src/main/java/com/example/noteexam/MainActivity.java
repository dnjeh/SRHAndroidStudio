package com.example.noteexam;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.noteexam.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    ActivityMainBinding binding;
    ArrayList<String> titleData, noteData;   // 원본데이터
    ArrayAdapter<String> titleAdapter, noteAdapter;   // 어댑터

    int m_SelPos = -1;   // 리스트뷰에서 선택한 아이템의 인덱스 번호를 저장


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

        titleAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titleData);
        binding.spinner.setAdapter(titleAdapter);

        noteData = new ArrayList<>();

        noteAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, noteData);
        binding.listView.setAdapter(noteAdapter);

        binding.btnNew.setOnClickListener(this);
        binding.btnSave.setOnClickListener(this);
        binding.btnDele.setOnClickListener(this);
        binding.btnFinish.setOnClickListener(this);

        binding.listView.setOnItemClickListener(this);
        readNote();
    }

    private void readNote() {
        SharedPreferences sp = getSharedPreferences("MyNote", MODE_PRIVATE);
        int max = sp.getInt("MAX", 0);
        for(int i=0;i<max;i++) {
            noteData.add(sp.getString("note"+i, "")) ;
        }
        noteAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {

        // 인터넷 참조 - 버튼 클릭하면 키보드 내리기
        InputMethodManager manager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        if(getCurrentFocus()!=null)
            manager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

        if(view.getId()==R.id.btn_new){  // editText 지우기
            binding.txtInput.setText("");
        }
        else if(view.getId()==R.id.btn_finish){   // 앱 종료
            finish();
        }
        else if(view.getId()==R.id.btn_save){
            if(binding.spinner.getSelectedItemPosition()<1)
                Toast.makeText(this, "학년을 선택하세요.", Toast.LENGTH_SHORT).show();
            else {
                String note = binding.txtInput.getText().toString().trim();
                String title = binding.spinner.getSelectedItem().toString();

                if (note.length() == 0)
                    Toast.makeText(this, "저장할 내용이 없습니다.", Toast.LENGTH_SHORT).show();
                else {   // 학년 선택, 입력값도 있다
                    noteData.add("[" + title + "]" + note);
                    noteAdapter.notifyDataSetChanged();
                    saveNote();
                }
            }
        }
        else if(view.getId()==R.id.btn_dele){

            if(m_SelPos==-1 || binding.listView.getCount()==0)
                Toast.makeText(this, "삭제한 아이템을 선택하세요.", Toast.LENGTH_SHORT).show();
            else{
                noteData.remove(m_SelPos);
                noteAdapter.notifyDataSetChanged();
            }
        }
    }

    private void saveNote() {
        SharedPreferences sp = getSharedPreferences("MyNote", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.commit();
        editor.putInt("MAX", noteData.size());
        for(int i=0;i<noteData.size();i++) {
            editor.putString("note" + i, noteData.get(i));
        }
        editor.commit();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        m_SelPos = i;
        Toast.makeText(this, "리스트뷰" + i, Toast.LENGTH_SHORT).show();
        binding.txtInput.setText(noteData.get(i));
    }
}