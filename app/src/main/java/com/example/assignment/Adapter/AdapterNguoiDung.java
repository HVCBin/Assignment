package com.example.assignment.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment.Model.ThuThu;
import com.example.assignment.R;

import java.util.List;

public class AdapterNguoiDung extends RecyclerView.Adapter<AdapterNguoiDung.DSNDViewHolder>{
    Context context;
    List<ThuThu> list;

    public AdapterNguoiDung(Context context, List<ThuThu> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public DSNDViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_ds_nd,null);
        return new DSNDViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DSNDViewHolder holder, int position) {
        ThuThu thuThu = list.get(position);
        holder.txtHoten.setText(thuThu.getHoTen());
        holder.txtMatKhau.setText(thuThu.getMatKhau());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class DSNDViewHolder extends RecyclerView.ViewHolder {
        TextView txtHoten;
        TextView txtMatKhau;
        public DSNDViewHolder(@NonNull View itemView) {
            super(itemView);
            txtHoten = itemView.findViewById(R.id.txtHoten);
            txtMatKhau = itemView.findViewById(R.id.txtMk);
        }
    }
}
