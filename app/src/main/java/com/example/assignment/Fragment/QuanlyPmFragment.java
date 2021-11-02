package com.example.assignment.Fragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Calendar;

import com.example.assignment.Adapter.AdapterPhieuMuon;
import com.example.assignment.DAO.DAO_PM;
import com.example.assignment.Model.PhieuMuon;
import com.example.assignment.R;


public class QuanlyPmFragment extends Fragment {

    RecyclerView recyclerView;
    FloatingActionButton floatingActionButton;
    AdapterPhieuMuon adapterPhieuMuon;
    DAO_PM cn;
    ArrayList<PhieuMuon> arrayList;
    public QuanlyPmFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate (R.layout.fragment_quan_ly_phieu_muon, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated (view, savedInstanceState);
        recyclerView = view.findViewById (R.id.recy_phieuMuon);
        floatingActionButton = view.findViewById (R.id.fl_them_phieuMuon);
        arrayList = new ArrayList<> ();
        cn = new DAO_PM (getContext ());
        adapterPhieuMuon = new AdapterPhieuMuon (getContext (),arrayList,this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager (getContext (),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager (layoutManager);
        recyclerView.setAdapter (adapterPhieuMuon);

        floatingActionButton.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                DiaLogThem ();
            }
        });
    }
    public void DiaLogThem(){
        AlertDialog.Builder builder = new AlertDialog.Builder (getContext ());
        View view = LayoutInflater.from (getContext ()).inflate (R.layout.dia_log_them_phieu_muon,null);
        builder.setView (view);

        TextInputEditText ed_ma_pm = view.findViewById (R.id.ed_ma_phieu_muon);
        TextInputEditText ed_ngay = view.findViewById (R.id.ed_ngay_tra);
        Button btn_chon_ngay = view.findViewById (R.id.btn_chon_ngay_pm);
        TextInputEditText ed_trangthai = view.findViewById(R.id.edTrangThai);
        TextInputEditText ed_tien_thue = view.findViewById (R.id.ed_tien_thue);
        TextInputEditText ed_ma_Sach = view.findViewById (R.id.ed_ma_sach_pm);
        Button btn_them_pm = view.findViewById (R.id.btn_them_pm);
        Button btn_thoat = view.findViewById (R.id.btn_thoat_pm);

        Dialog dg = builder.create ();
        Calendar calendar = Calendar.getInstance ();
        btn_chon_ngay.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog (getActivity (), new DatePickerDialog.OnDateSetListener () {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month+1;
                        ed_ngay.setText (dayOfMonth + "/" + month + "/" + year);
                    }
                },calendar.DATE, calendar.MONTH,calendar.YEAR);
                dialog.show ();
            }
        });

        btn_them_pm.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                if (ed_ma_pm.getText ().toString ().isEmpty () && ed_ma_Sach.getText ().toString ().isEmpty ()){
                    Toast.makeText (getActivity (), "Vui lòng nhập mã phiếu mượn", Toast.LENGTH_SHORT).show ();
                }else if(ed_ngay.getText ().toString ().isEmpty ()){
                    Toast.makeText (getActivity (), "Vui lòng nhập ngày", Toast.LENGTH_SHORT).show ();
                }else if(ed_trangthai.getText().toString().isEmpty() ){
                    Toast.makeText (getActivity (), "Vui lòng nhap trang thai", Toast.LENGTH_SHORT).show ();
                }else if(ed_tien_thue.getText ().toString ().isEmpty ()){
                    Toast.makeText (getActivity (), "Vui lòng nhập tiền thuê", Toast.LENGTH_SHORT).show ();
                    return;
                }
                PhieuMuon pm = new PhieuMuon ();
                pm.setMaPM (Integer.parseInt (ed_ma_pm.getText ().toString ()));
                pm.setNgay (ed_ngay.getText ().toString ());
                pm.setMaSach (Integer.parseInt (ed_ma_Sach.getText ().toString ()));
                pm.setTraSach (ed_trangthai.getText().toString());
                pm.setTienThue (Integer.parseInt (ed_tien_thue.getText ().toString ()));
                arrayList.add (pm);
                adapterPhieuMuon.notifyDataSetChanged ();
                cn.ThemPM (pm);
                Toast.makeText (getActivity (),"Thêm thành công",Toast.LENGTH_LONG).show ();

            }
        });
        btn_thoat.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                dg.dismiss ();
            }
        });

        dg.show ();
    }

    public void Delete(int id){
        cn.Delete (id);
    }
    public void Update(PhieuMuon pm){
        cn.UpdatePM (pm);
    }
    @Override
    public void onResume() {
        super.onResume ();
        arrayList.clear ();
        arrayList.addAll (cn.GetPM());
        if(arrayList != null){
            adapterPhieuMuon.notifyDataSetChanged ();
        }
    }
}