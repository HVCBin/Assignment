package com.example.assignment.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.assignment.DanhsachND;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

import com.example.assignment.DAO.DAO_TT;
import com.example.assignment.Model.ThuThu;
import com.example.assignment.R;


public class ThemNgDungFragment extends Fragment {

    TextInputEditText ed_ma_tt , ed_ho_ten_tt , ed_mk_tt , ed_nhap_lai_mk;
    Button btn_them,btnTT;
    ArrayList<ThuThu> arrayList;
    DAO_TT cn;
    public ThemNgDungFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate (R.layout.fragment_them_ng_dung, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated (view, savedInstanceState);
        ed_ma_tt = view.findViewById (R.id.ed_ma_tt);
        ed_ho_ten_tt = view.findViewById (R.id.ed_ten_tk_tt);
        ed_mk_tt = view.findViewById (R.id.ed_mat_khau_tt);
        ed_nhap_lai_mk = view.findViewById (R.id.ed_nhap_lai_mk);
        btn_them = view.findViewById (R.id.btn_them_thu_thu);
        btnTT = view.findViewById(R.id.btn_tt_thu_thu);
        arrayList = new ArrayList<> ();
        cn = new DAO_TT (getContext ());

        btn_them.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                if(ed_ma_tt.getText ().toString ().isEmpty ()){
                    Toast.makeText (getContext (), "Vui l??ng nh???p m?? th??? th??", Toast.LENGTH_SHORT).show ();
                }else if(ed_ho_ten_tt.getText ().toString ().isEmpty ()){
                    Toast.makeText (getContext (), "Vui l??ng nh???p h??? t??n", Toast.LENGTH_SHORT).show ();
                }else if(ed_mk_tt.getText ().toString ().isEmpty ()){
                    Toast.makeText (getContext (), "Vui l??ng nh???p m???t kh???u", Toast.LENGTH_SHORT).show ();
                }else if(ed_nhap_lai_mk.getText ().toString ().isEmpty ()){
                    Toast.makeText (getContext (), "vui l??ng nh???p l???i m???t kh???u", Toast.LENGTH_SHORT).show ();
                }else{
                    String matt = ed_ma_tt.getText ().toString ();
                    String hotentt = ed_ho_ten_tt.getText ().toString ();
                    String mktt = ed_mk_tt.getText ().toString ();
                    String nhap_lai_mk = ed_nhap_lai_mk.getText ().toString ();
                    if(nhap_lai_mk.equals (mktt)){
                        ThuThu tt = new ThuThu (matt,hotentt,mktt);
                        arrayList.add (tt);
                        cn.ThemTT (tt);
                        Toast.makeText (getContext (), "Th??m th??nh c??ng", Toast.LENGTH_SHORT).show ();
                    }else{
                        Toast.makeText (getContext (), "M???t kh???u x??c nh???n kh??ng ????ng !", Toast.LENGTH_SHORT).show ();
                        return;
                    }
                }
            }
        });
        btnTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DanhsachND.class);
                startActivity(intent);
            }
        });
    }
}