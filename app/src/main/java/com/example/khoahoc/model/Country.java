package com.example.khoahoc.model;

public class Country {
    public String TenNuoc,ThuDo;
    public int HinhAnh;

    public Country(String tenNuoc, String thuDo, int hinhAnh) {
        TenNuoc = tenNuoc;
        ThuDo = thuDo;
        HinhAnh = hinhAnh;
    }

    public String getTenNuoc() {
        return TenNuoc;
    }

    public void setTenNuoc(String tenNuoc) {
        TenNuoc = tenNuoc;
    }

    public String getThuDo() {
        return ThuDo;
    }

    public void setThuDo(String thuDo) {
        ThuDo = thuDo;
    }

    public int getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        HinhAnh = hinhAnh;
    }
}
