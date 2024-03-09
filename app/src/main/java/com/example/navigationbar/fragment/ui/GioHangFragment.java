package com.example.navigationbar.fragment.ui;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.navigationbar.R;
import com.example.navigationbar.adapter.CustomeAdapter_SP;
import com.example.navigationbar.model.SanPham;

import java.util.ArrayList;
import java.util.List;

public class GioHangFragment extends Fragment {

    ListView lvGioHang;
    public  static  List<SanPham> gioHangData = new ArrayList<>();
    CustomeAdapter_SP adapterSp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_gio_hang, container, false);
        
        setControl(view);
        setEvent();

        return view;
    }

    private void setEvent() {
        SanPham sanPham = new SanPham();
        sanPham.setMaSP("001");
        sanPham.setTenSp("Sam sung s30");
        sanPham.setGiaSp("30.000.000");
        sanPham.setLoaiSp("Samsung");
        gioHangData.add(sanPham);
        gioHangData.add(sanPham);
        gioHangData.add(sanPham);
        gioHangData.add(sanPham);

        adapterSp = new CustomeAdapter_SP(getContext(), R.layout.layout_item_sp_gio_hang, gioHangData);
        lvGioHang.setAdapter(adapterSp);
    }

    private void setControl(View view) {
        lvGioHang = view.findViewById(R.id.lvGioHang);
    }
}