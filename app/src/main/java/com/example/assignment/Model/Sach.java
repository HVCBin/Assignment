package com.example.assignment.Model;

public class Sach {
    private int maSach;
    private int maLoai;
    private String tenSach;
    private int giaThue;
    private int cotSach;

    public Sach() {
    }

    public Sach(int maSach, int maLoai, String tenSach, int giaThue, int cotSach) {
        this.maSach = maSach;
        this.maLoai = maLoai;
        this.tenSach = tenSach;
        this.giaThue = giaThue;
        this.cotSach = cotSach;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public int getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(int maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public int getGiaThue() {
        return giaThue;
    }

    public void setGiaThue(int giaThue) {
        this.giaThue = giaThue;
    }

    public int getCotSach() {
        return cotSach;
    }

    public void setCotSach(int cotSach) {
        this.cotSach = cotSach;
    }
}
