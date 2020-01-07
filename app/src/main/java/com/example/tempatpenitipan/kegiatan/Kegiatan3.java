package com.example.tempatpenitipan.kegiatan;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.tempatpenitipan.R;

public class Kegiatan3  extends AppCompatActivity {
    ListView simpleList;
    String Item[] = {"08:00-08:30", "08:30-09:00", "09:00-09:20", "09:20-10:20", "10:20-10:50", "10:50-13:30", "14:45-15:00",
            "15:00-15:30", "15:30-1600", "16:00"};
    String SubItem[] = {"Baris Berbaris", "Shalat Dhuha", "Materi Pagi", "Snack Time", "Minum Susu + Pipis", "Anak Dc Istirahat",
            "Bangun Tidur, Makan Siang, Dan Persiapan Mandi", "Mandi", "Berdoa Dan Persiapan Pulang", "Pulang"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kegiatan1);
        ActionBar menu = getSupportActionBar();
        menu.setDisplayShowHomeEnabled(true);
        menu.setDisplayHomeAsUpEnabled(true);

        simpleList = (ListView)findViewById(R.id.ListView1);
        CustomAdapte customAdapter = new CustomAdapte(getApplicationContext(), Item,SubItem);
        simpleList.setAdapter(customAdapter);
    }
}