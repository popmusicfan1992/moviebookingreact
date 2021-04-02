package com.example.khoahoc.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.khoahoc.Database.Database;
import com.example.khoahoc.model.SinhVien;

public class SinhVienController {
    SQLiteDatabase database;
    public  SinhVienController(Context context){
        Database createDatabase = new Database(context);
       database = createDatabase.open();


    }
    public long ThemSinhVien(SinhVien sinhVien){

        ContentValues contentValues = new ContentValues();
        contentValues.put(Database.SinhVien_MaSV,sinhVien.getMaSV());
        contentValues.put(Database.SinhVien_UserName,sinhVien.getUserName());
        contentValues.put(Database.SinhVien_PassWord,sinhVien.getPassWord());
        long KiemTra = database.insert(Database.TB_SinhVien,null,contentValues);
        return  KiemTra;

    }
    public boolean KiemTraSinhVien(){
        String truyvan = "SELECT * FROM " + Database.TB_SinhVien;
        Cursor cursor = database.rawQuery(truyvan,null);
        if(cursor.getCount() != 0){
            return true;
        }else{
            return false;
        }

    }
    public boolean KiemTraDangNhap(String username , String password){
        String truyvan = "SELECT * FROM " + Database.TB_SinhVien + " WHERE " +  Database.SinhVien_UserName + " = '" + username
                + "' AND " + Database.SinhVien_PassWord + " = '" + password + "'";
        Cursor cursor = database.rawQuery(truyvan,null);
        if(cursor.getCount() != 0){
            return true;
        }else{
            return false;
        }
    }
}
