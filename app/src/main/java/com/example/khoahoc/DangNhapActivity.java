package com.example.khoahoc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.khoahoc.Controller.SinhVienController;

public class DangNhapActivity extends AppCompatActivity implements View.OnClickListener {
    EditText ed_DN_UserName,ed_DN_PassWord;
    Button btn_DangNhap;
    SinhVienController sinhVienController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.login);
        ed_DN_UserName = (EditText) findViewById(R.id.edUserName2);
        ed_DN_PassWord = (EditText) findViewById(R.id.edPassWord2);
        btn_DangNhap = (Button) findViewById(R.id.btn_DangNhap);
        sinhVienController = new SinhVienController(this);
    }
    public void btnDangNhap(){
        String sUserName = ed_DN_UserName.getText().toString();
        String sPassWord = ed_DN_PassWord.getText().toString();
      boolean kiemtra =  sinhVienController.KiemTraDangNhap(sUserName,sPassWord);
      if(kiemtra){
          Toast.makeText(DangNhapActivity.this,"Đăng nhập thành công !",Toast.LENGTH_SHORT).show();
      }else{
          Toast.makeText(DangNhapActivity.this,"Đăng nhập thất bại !",Toast.LENGTH_SHORT).show();
      }
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btn_DangNhap :
                btnDangNhap();

                break;
        }
    }
}
