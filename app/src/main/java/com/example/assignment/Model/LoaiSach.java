package com.example.assignment.Model;

public class LoaiSach {
    private int maLoai;
    private String TieuDe;
    private String tenLoai;

    public LoaiSach() {
    }

    public LoaiSach(int maLoai, String tieuDe, String tenLoai) {
        this.maLoai = maLoai;
        TieuDe = tieuDe;
        this.tenLoai = tenLoai;
    }

    public int getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(int maLoai) {
        this.maLoai = maLoai;
    }

    public String getTieuDe() {
        return TieuDe;
    }

    public void setTieuDe(String tieuDe) {
        TieuDe = tieuDe;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }
}
