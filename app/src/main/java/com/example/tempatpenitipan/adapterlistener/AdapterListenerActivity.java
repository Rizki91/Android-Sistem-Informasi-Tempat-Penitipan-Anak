package com.example.tempatpenitipan.adapterlistener;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.tempatpenitipan.kegiatan.Kegiatan1;
import com.example.tempatpenitipan.kegiatan.Kegiatan2;
import com.example.tempatpenitipan.R;
import com.example.tempatpenitipan.kegiatan.Kegiatan3;
import com.example.tempatpenitipan.kegiatan.Kegiatan4;
import com.example.tempatpenitipan.kegiatan.Kegiatan5;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class AdapterListenerActivity extends AppCompatActivity
        implements HariAdapter.HariAdapterCallback {

    @BindView(R.id.rvMakanan)
    RecyclerView rvMakanan;

    Unbinder unbinder;
    HariAdapter hariAdapter;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_listener);

        ButterKnife.bind(this);
        unbinder = ButterKnife.bind(this);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.title_adapter_click_listener));

        hariAdapter = new HariAdapter(this, getHariList(), this);
        rvMakanan.setLayoutManager(new LinearLayoutManager(this));
        rvMakanan.setItemAnimator(new DefaultItemAnimator());
        rvMakanan.setHasFixedSize(true);
        rvMakanan.setAdapter(hariAdapter);
        hariAdapter.notifyDataSetChanged();
    }

    private List<Hari> getHariList(){
        List<Hari> HariList = new ArrayList<>();

        HariList.add(new Hari("Senin"));
        HariList.add(new Hari("Selasa"));
        HariList.add(new Hari("Rabu"));
        HariList.add(new Hari("Kamis"));
        HariList.add(new Hari("Jumat"));

        return HariList;
    }

    @Override
    public void onRowHariAdapterClicked(int position) {
        String nama = getHariList().get(position).getNama();

        switch (position){
            case 0 :
                Intent i = new Intent(getApplicationContext(), Kegiatan1.class);
                startActivity(i);
                break;
            case 1 :
                Intent ii = new Intent(getApplicationContext(), Kegiatan3.class);
                startActivity(ii);
                break;
            case 2 :
                Intent iii = new Intent(getApplicationContext(), Kegiatan4.class);
                startActivity(iii);
                break;
            case 3 :
                Intent iiii = new Intent(getApplicationContext(), Kegiatan5.class);
                startActivity(iiii);
                break;
            case 4 :
                Intent iiiii = new Intent(getApplicationContext(), Kegiatan2.class);
                startActivity(iiiii);
                break;
        }

        Toast.makeText(this, "Kamu memilih hari " + nama, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
