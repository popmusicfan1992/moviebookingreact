package com.example.khoahoc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.khoahoc.Controller.SinhVienController;
import com.example.khoahoc.model.SinhVien;

public class DangKyActivity extends AppCompatActivity implements View.OnClickListener{
    EditText edMaSV,edUserName,edPassWord,edXacNhanMatKhau;
    TextView tv_DangNhap;
    Button btn_DangKi;
    SinhVienController sinhVienController;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
       edMaSV = (EditText) findViewById(R.id.edMaSV);
       edUserName = (EditText) findViewById(R.id.edUserName);
       edPassWord = (EditText) findViewById(R.id.edPassWord);
       edXacNhanMatKhau = (EditText) findViewById(R.id.edXacNhanMatKhau);
       btn_DangKi = (Button) findViewById(R.id.btn_DangKi);
       tv_DangNhap = (TextView) findViewById(R.id.tv_DangNhap);
       sinhVienController = new SinhVienController(this);
       btn_DangKi.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btn_DangKi:
                int sMaSV = Integer.parseInt(edMaSV.getText().toString());
                String sUserName = edUserName.getText().toString();
                String sPassWord = edPassWord.getText().toString();
                String sXacNhanPassWord = edXacNhanMatKhau.getText().toString();


                if(sUserName == null || sUserName.equals("")){
                    Toast.makeText(DangKyActivity.this,getResources().getString(R.string.nhapusername)+ "" , Toast.LENGTH_SHORT).show();

                }else if(sPassWord == null || sPassWord.equals("")){
                    Toast.makeText(DangKyActivity.this,getResources().getString(R.string.nhappassword)+ "" , Toast.LENGTH_SHORT).show();

                }


                else{
                    SinhVien sinhVien = new SinhVien();
                    sinhVien.setMaSV(sMaSV);
                    sinhVien.setUserName(sUserName);
                    sinhVien.setPassWord(sPassWord);

                   long KiemTra =  sinhVienController.ThemSinhVien(sinhVien);
                   if(KiemTra != 0){
                       Toast.makeText(DangKyActivity.this,getResources().getString(R.string.dangkithanhcong)+ "" , Toast.LENGTH_SHORT).show();

                   }else{
                       Toast.makeText(DangKyActivity.this,getResources().getString(R.string.dangkithatbai)+ "" , Toast.LENGTH_SHORT).show();
                   }


                }

                break;
            case R.id.tv_DangNhap :
                Intent intent = new Intent(DangKyActivity.this,DangNhapActivity.class);
                startActivity(intent);


                break;
        }
    }
}
