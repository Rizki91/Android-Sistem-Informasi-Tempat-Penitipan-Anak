package com.example.tempatpenitipan;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by Kuncoro on 22/03/2016.
 */
public class tools extends Fragment {

    public tools(){}
    RelativeLayout view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = (RelativeLayout) inflater.inflate(R.layout.kegiatan, container, false);

        getActivity().setTitle("Kegiatan");

        return view;
    }
}