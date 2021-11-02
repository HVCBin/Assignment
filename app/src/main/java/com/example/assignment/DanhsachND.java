package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.assignment.Adapter.AdapterNguoiDung;
import com.example.assignment.DAO.DAO_TT;
import com.example.assignment.Model.ThuThu;

import java.util.ArrayList;

public class DanhsachND extends AppCompatActivity {
    RecyclerView recyclerView;
    AdapterNguoiDung adapterNguoiDung;
    ArrayList<ThuThu> list;
    DAO_TT dao_tt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsach_nd);
        recyclerView = findViewById(R.id.recy_ds_nd);
        dao_tt = new DAO_TT(this);
        list = (ArrayList<ThuThu>) dao_tt.getNgDung();
        adapterNguoiDung = new AdapterNguoiDung(this,list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterNguoiDung);
    }

    @Override
    protected void onResume() {
        super.onResume();
        list.clear();
        list.addAll(dao_tt.getNgDung());
        if (list != null){
            adapterNguoiDung.notifyDataSetChanged();
        }
    }
}