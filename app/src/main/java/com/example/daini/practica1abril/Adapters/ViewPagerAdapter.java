package com.example.daini.practica1abril.Adapters;

import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.daini.practica1abril.Fragments.FragmentA;
import com.example.daini.practica1abril.Fragments.FragmentB;
import com.example.daini.practica1abril.Fragments.FragmentC;
import com.example.daini.practica1abril.Fragments.FragmentD;

import java.util.ArrayList;

/**
 * Created by Daini on 28/03/2017.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private final Resources resources;
    private ArrayList<Fragment> registredFragments = new ArrayList<Fragment>();
    private static final int num = 4;

    public ViewPagerAdapter(FragmentManager fm, Resources resources) {
        super(fm);
        this.resources = resources;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        switch (position){
            case 0:
                fragment = new FragmentA();
                break;
            case 1:
                fragment = new FragmentB();
                break;
            case 2:
                fragment = new FragmentC();
                break;
            case 3:
                fragment = new FragmentD();
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return num;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title = "Charles Chaplin";
                break;
            case 1:
                title = "Emir Kusturica";
                break;
            case 2:
                title = "Lars Von Trier";
                break;
            case 3:
                title = "Billy Wilder";
                break;
        }
        return title;
    }

//    @Override
//    public Object instantiateItem(ViewGroup container, int position) {
//        Fragment fragment = (Fragment)super.instantiateItem(container, position);
//        registredFragments.add(position, fragment);
//
//        return fragment;//super.instantiateItem(container, position);
//    }
//
//    public Fragment getRegistredFragment(int position){
//        return registredFragments.get(position);
//    }
//
//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//        registredFragments.remove(position);
//        super.destroyItem(container, position, object);
//    }
}
