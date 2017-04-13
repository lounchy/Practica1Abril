package com.example.daini.practica1abril.Fragments;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.example.daini.practica1abril.AsyncTask.AsyncTaskA;
import com.example.daini.practica1abril.AsyncTask.AsyncTaskB;
import com.example.daini.practica1abril.R;


/**
 * Created by Daini on 28/03/2017.
 */

public class FragmentA extends Fragment {

    private ImageView d;
    public static Bitmap[] images;
    private Bitmap [] imageDownloaded;
    private AsyncTaskA asyncTaskA;
    private static boolean created;
    private static final String URL_IMAGEN_1 = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Chaplin_A_Dogs_Life.jpg/300px-Chaplin_A_Dogs_Life.jpg";
    private static final String URL_IMAGEN_2 = "https://s-media-cache-ak0.pinimg.com/736x/77/1e/b1/771eb19ae793ab6ba5cc67ff263d4a30.jpg";
    private static final String URL_IMAGEN_3 = "http://es.web.img2.acsta.net/r_640_600/b_1_d6d6d6/medias/nmedia/18/65/31/15/18880961.jpg";
    private static final String URL_IMAGEN_4 = "http://1.bp.blogspot.com/_tMBqqiYK7ak/SfHaWEjhrbI/AAAAAAAAOK8/tbCCmDMbDK0/s400/escenas+1.jpg";
    private static final String URL_IMAGEN_5 = "http://es.web.img1.acsta.net/r_640_600/b_1_d6d6d6/medias/nmedia/18/65/35/17/18855322.jpg";
    String [] urlArray = new String[]{URL_IMAGEN_1, URL_IMAGEN_2,URL_IMAGEN_3,URL_IMAGEN_4, URL_IMAGEN_5};

    public FragmentA() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final ProgressBar progressBar = (ProgressBar)getView().findViewById(R.id.progresbarA);
        if (!created){
            asyncTaskA = new AsyncTaskA(this);
            d = (ImageView) getView().findViewById(R.id.descargarA);
            d.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), "Descarga en curso",Toast.LENGTH_LONG).show();
                    asyncTaskA.execute(urlArray);
                    d.setEnabled(false);
                   progressBar.setVisibility(View.VISIBLE);


                }
            });
        }else {
            super.onActivityCreated(savedInstanceState);
        }


    }
    public void getImages(Bitmap [] bitmaps){
        imageDownloaded = bitmaps;
        images = imageDownloaded;
        FrameLayout frameLayout = (FrameLayout)getView().findViewById(R.id.fragmentA);
        frameLayout.removeAllViewsInLayout();
        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        FragmentFotoA fotoA = new FragmentFotoA();
        ft.replace(R.id.fragmentA,fotoA);
        ft.addToBackStack(null);
        ft.remove(new FragmentA());
        ft.commit();
        created = true;


    }
}
