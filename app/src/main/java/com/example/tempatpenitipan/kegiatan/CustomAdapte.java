package com.example.tempatpenitipan.kegiatan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tempatpenitipan.R;

public class CustomAdapte extends BaseAdapter {
    Context context;
    String Item[];
    String SubItem[];

    LayoutInflater inflter;

    public CustomAdapte(Context applicationContext, String[] Item, String[] SubItem) {
        this.context = context;
        this.Item = Item;
        this.SubItem = SubItem;

        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return Item.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.kegiatan22, null);
        TextView item = (TextView) view.findViewById(R.id.item);
        TextView subitem = (TextView) view.findViewById(R.id.subitem1);
        item.setText(Item[i]);
        subitem.setText(SubItem[i]);
        return view;
    }
}