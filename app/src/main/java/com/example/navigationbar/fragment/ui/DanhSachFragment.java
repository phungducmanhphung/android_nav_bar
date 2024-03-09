package com.example.navigationbar.fragment.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.navigationbar.R;
import com.example.navigationbar.adapter.CustomeAdapter_SP;
import com.example.navigationbar.csdl.DatabaseSP;
import com.example.navigationbar.model.SanPham;

import java.util.ArrayList;
import java.util.List;

public class DanhSachFragment extends Fragment {

    GridView gvDanhSach;
    List<SanPham> gvData;
    CustomeAdapter_SP gvAdapter;
    DatabaseSP databaseSP;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_danh_sach, container, false);

        setControl(view);
        setEvent();

        return view;
    }

    private void setEvent() {
        databaseSP = new DatabaseSP(getActivity());
        gvData = new ArrayList<>();
        SanPham sanPham = new SanPham();
        sanPham.setMaSP("001");
        sanPham.setTenSp("Sam sung s30");
        sanPham.setGiaSp("30.000.000");
        sanPham.setLoaiSp("Samsung");
        gvData.add(sanPham);
        gvData.add(sanPham);
        gvData.add(sanPham);
        gvData.add(sanPham);
        gvAdapter = new CustomeAdapter_SP(getContext(), R.layout.layout_item_sp, gvData);
        gvDanhSach.setAdapter(gvAdapter);
    }

    private void setControl(View view) {
        gvDanhSach = view.findViewById(R.id.gvDanhSach);
    }


}
