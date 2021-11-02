package com.example.assignment.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Dbhelper extends SQLiteOpenHelper {

    public Dbhelper(@Nullable Context context) {
        super (context, "PNLibA.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String table_ThuThu = "create table if not exists ThuThu(MATT text primary key , HOTEN text , MATKHAU text)";
        db.execSQL (table_ThuThu);
        String INSERT_THUTHU = "insert into ThuThu values" +
                "('01', 'Phạm Tiến A', '1234') ," +
                "('02', 'Phạm Tiến B', '1235'), " +
                "('03', 'Nguyễn Thị C', '1236'), " +
                "('04', 'Đinh Thị D', '1237'), " +
                "('05', 'Nguyễn Văn E', '1238')";
        db.execSQL(INSERT_THUTHU);
        String table_LoaiSach = "create table if not exists LoaiSach(MALOAI integer primary key ,TIEUDE TEXT, TENLOAI text)";
        db.execSQL (table_LoaiSach);
        String table_ThanhVien = "create table if not exists ThanhVien(MATV integer primary key , TENTV text , NAMSINH text)";
        db.execSQL (table_ThanhVien);
        String INSERT_THANHVIEN = "insert into ThanhVien values" +
                "(1, 'Phạm Văn A', '2002'), " +
                "(2, 'Nguyễn Đình B', '2001'), " +
                "(3, 'Trần Thị C', '2000'), " +
                "(4, 'Nguyễn Thị D', '2001'), " +
                "(5, 'Phạm Tiến E', '2002')";
        db.execSQL(INSERT_THANHVIEN);
        String table_Sach = "create table if not exists Sach (COTST integer,MASACH integer primary key , " +
                "TENSACH text ," +
                " GIATHUE integer ," +
                " MALOAI integer REFERENCES LoaiSach(MALOAI))";
        db.execSQL (table_Sach);
        String insert_sach = "insert into Sach values " +
                "(1,1,'Tấm Vải Đỏ',50000,500)," +
                "(2,2,'Một Mình Trên Đảo Hoang',40000,100)," +
                "(3,3,'Khoa Học',3000,3000)";
        db.execSQL (insert_sach);
        String table_phieuMuon = "create table if not exists PhieuMuon(MAPM integer primary key  ," +
                " MATT text REFERENCES ThuThu(MATT) ," +
                " MATV integer REFERENCES ThanhVien(MATV), " +
                "MASACH integer REFERENCES Sach (MASACH), " +
                "NGAY text , TRASACH text , TIENTHUE integer)";
        db.execSQL (table_phieuMuon);
        String INSERT_PHIEUMUON = "insert into PhieuMuon values" +
                "(4, '2',1, 1, '02/07/2002', 'đã trả', 10000)," +
                "(5, '3',2, 2 , '02/08/2002',  'chưa trả', 20000)," +
                "(6, '4',3, 3 , '02/09/2002', 'đã trả', 30000)," +
                "(7, '5',1, 1 , '02/10/2002', 'chưa trả', 40000)," +
                "(8, '6',1, 1 , '02/11/2002', 'chưa trả', 50000)";
        db.execSQL(INSERT_PHIEUMUON);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String xoa_tt = "drop table if exists ThuThu";
        db.execSQL (xoa_tt);
        String xoa_loaisach = "drop table if exists LoaiSach";
        db.execSQL (xoa_loaisach);
        String xoa_tv = "drop table if exists ThanhVien";
        db.execSQL (xoa_tv);
        String xoa_sach = "drop table if exists Sach";
        db.execSQL (xoa_sach);
        String xoa_pm = "drop table if exists PhieuMuon";
        db.execSQL (xoa_pm);
        onCreate (db);
    }
}
