package com.example.daini.practica1abril.Fragments;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.daini.practica1abril.Adapters.ViewPagerAdapter;
import com.example.daini.practica1abril.R;
import com.example.daini.practica1abril.ZoomOut;


public class CaruselFragment extends Fragment {
    private TabLayout tl;
    private ViewPager vp;
    private ViewPagerAdapter vpa;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.carusel_fragment, container, false);
        tl = (TabLayout)root.findViewById(R.id.tab_layout);
        vp = (ViewPager)root.findViewById(R.id.pager_view);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        vpa = new ViewPagerAdapter(getChildFragmentManager(), getResources());


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            tl.setSelectedTabIndicatorColor(Color.TRANSPARENT);
            tl.setupWithViewPager(vp);
            vp.setAdapter(vpa);
            vp.setPageTransformer(true, new ZoomOut());
        }else {

            tl.setupWithViewPager(vp);
            vp.setAdapter(vpa);
        }

    }

}

