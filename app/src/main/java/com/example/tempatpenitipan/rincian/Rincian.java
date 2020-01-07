package com.example.tempatpenitipan.rincian;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.tempatpenitipan.R;

public class Rincian extends AppCompatActivity {
    ListView simpleList;
    String Item[] = {"", "", "", ""};
    String SubItem[] = {"Ac", "Tempat Tidur", "Makan Sehat", "Tempat Bermain"};
    int flags[] = {R.drawable.ac,R.drawable.tempattidur, R.drawable.makan, R.drawable.tempat };
    Button button;
    Button button1;
    private ProgressDialog progress;
    Dialog dia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rincian1);
        ActionBar menu = getSupportActionBar();
        menu.setDisplayShowHomeEnabled(true);
        menu.setDisplayHomeAsUpEnabled(true);

        button = (Button) findViewById(R.id.button);
        button1 = (Button) findViewById(R.id.lokasi) ;
        simpleList = (ListView) findViewById(R.id.ListView1);
        CustomAdapte customAdapter = new CustomAdapte(getApplicationContext(), Item, SubItem, flags);
        simpleList.setAdapter(customAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                showCustomDialog();

            }

        });
        findViewById(R.id.lokasi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                klik("https://goo.gl/maps/qa28ULuccjXtgYkv7");
            }
        });
    }
    public void klik(String url){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    private void showCustomDialog() {

        dia = new Dialog(Rincian.this);
        dia.setContentView(R.layout.harga);
        dia.setCancelable(false);
        dia.show();

        Button but = (Button) dia.findViewById(R.id.buttonOk2);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dia.dismiss();
            }
        });


    }
}