package com.example.navigationbar.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.navigationbar.R;
//import com.example.navigationbar.ViewChiTietSP;
import com.example.navigationbar.model.SanPham;

import java.util.List;

public class CustomeAdapter_SP extends ArrayAdapter {
    Context context;
    int resource;
    List<SanPham> data;
    Button btnChiTiet;
    public CustomeAdapter_SP(@NonNull Context context, int resource, List<SanPham> data) {
        super(context, resource, data);
        this.context = context;
        this.data = data;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(resource, null);
        ImageView ivHinh = convertView.findViewById(R.id.ivHinh);
        TextView tvTenSP = convertView.findViewById(R.id.tvTenSP);
        btnChiTiet = convertView.findViewById(R.id.btnChiTiet);

        SanPham sp = data.get(position);
        tvTenSP.setText(sp.getTenSp());
        if(sp.getLoaiSp().equals("Samsung")){
            ivHinh.setImageResource(R.drawable.samsung);
        }
        else if(sp.getLoaiSp().equals("Iphone")){
            ivHinh.setImageResource(R.drawable.iphone);
        }
        else if(sp.getLoaiSp().equals("Nokia")){
            ivHinh.setImageResource(R.drawable.nokia);
        }

//        btnChiTiet.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, ViewChiTietSP.class);
//                context.startActivity(intent);
//            }
//        });

        return convertView;
    }
}
