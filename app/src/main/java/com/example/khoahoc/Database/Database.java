package com.example.khoahoc.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    //Bang sinh vien
    public  static final String TB_SinhVien = "SINHVIEN";
    public  static final String SinhVien_MaSV = "MaSV";
    public  static final String SinhVien_HoTen = "HoTen";
    public  static final String SinhVien_UserName = "UserName";
    public  static final String SinhVien_PassWord = "PassWord";



    public Database(Context context) {
        super(context, "KhoaHoc", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tbSinhVien = "CREATE TABLE " + TB_SinhVien +" ("+
                SinhVien_MaSV + " TEXT PRIMARY KEY, "+
                SinhVien_HoTen+ "TEXT, " +
                SinhVien_UserName + "TEXT, " +
                SinhVien_PassWord + " TEXT )";
        db.execSQL(tbSinhVien);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public SQLiteDatabase open(){
        return this.getWritableDatabase();
    }
}
