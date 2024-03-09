package com.example.navigationbar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.navigationbar.fragment.ui.DanhSachFragment;
import com.example.navigationbar.fragment.ui.GioHangFragment;
import com.google.android.material.navigation.NavigationView;

public class NavigationActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);

        setControl();
        setEvent();
    }

    private void setEvent() {
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.app_name, R.string.app_name);
        drawerToggle.syncState();
        drawerLayout.addDrawerListener(drawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;

                if(item.getItemId() == R.id.mnDanhSach){
                    Toast.makeText(NavigationActivity.this, "Danh sach", Toast.LENGTH_SHORT).show();
                    fragment = new DanhSachFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.flContent, fragment).commit();
                }
                else if(item.getItemId() == R.id.mnGioHang){
                    Toast.makeText(NavigationActivity.this, "Gio hang", Toast.LENGTH_SHORT).show();
                    fragment = new GioHangFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.flContent, fragment).commit();
                }
                else if(item.getItemId() == R.id.mnCaiDat){
                    Toast.makeText(NavigationActivity.this, "Cai dat", Toast.LENGTH_SHORT).show();
                }

                drawerLayout.closeDrawers();


                return false;
            }
        });
    }

    private void setControl() {
        drawerLayout = findViewById(R.id.dlTrangChu);
        navigationView = findViewById(R.id.navMenu);
    }

//    Hiện nút 3 chấm bên phải trên activation bar
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu, menu);
//        return super.onCreateOptionsMenu(menu);
//    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

//        Fragment fragment = null;
//
//        if(item.getItemId() == R.id.mnDanhSach){
//            Toast.makeText(NavigationActivity.this, "Danh sach", Toast.LENGTH_SHORT).show();
//            fragment = new DanhSachFragment();
//        }
//        else if(item.getItemId() == R.id.mnGioHang){
//            Toast.makeText(NavigationActivity.this, "Gio hang", Toast.LENGTH_SHORT).show();
//        }
//        else if(item.getItemId() == R.id.mnCaiDat){
//            Toast.makeText(NavigationActivity.this, "Cai dat", Toast.LENGTH_SHORT).show();
//        }
//
//        drawerLayout.closeDrawers();
//
//        if(fragment != null){
//            getSupportFragmentManager().beginTransaction().replace(R.id.flContent, fragment).commit();
//        }

        if(drawerToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }
}