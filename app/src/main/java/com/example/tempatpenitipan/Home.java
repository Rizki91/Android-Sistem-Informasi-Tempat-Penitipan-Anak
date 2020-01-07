package com.example.tempatpenitipan;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Home extends Fragment {



    public Home(){}
    RelativeLayout view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        view = (RelativeLayout) inflater.inflate(R.layout.home, container, false);

        getActivity().setTitle("Home");

        return view;
    }

}