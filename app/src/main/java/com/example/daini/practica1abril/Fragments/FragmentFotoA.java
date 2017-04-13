package com.example.daini.practica1abril.Fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.daini.practica1abril.R;
import com.example.daini.practica1abril.Models.Resultados;
import com.example.daini.practica1abril.Actividades.ResultadosActivity;

import java.util.ArrayList;

/**
 * Created by Daini on 30/03/2017.
 */

public class FragmentFotoA extends Fragment{
    private ImageView iv,like, dislike;
    private Bitmap bit;
    private ViewPager viewPager;
    private Resultados resultados;
    private static ArrayList<Resultados> arrayListResultados;
    private static int pos = 0;
    private String[] titulos = new String[]{"Vida de Perro", "El Chico", "Tiempos Modernos", "El Gran Dictador", "Candilejas"};
    private String nombreDirector = "Charles Chaplin";
    public FragmentFotoA() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fotos_a, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewPager = (ViewPager)getActivity().findViewById(R.id.pager_view);


        arrayListResultados= Resultados.mArraylist;

        final Bitmap[] bitmaps = FragmentA.images;
        if (bitmaps!=null) {
            final ArrayList<Bitmap> arrayList = new ArrayList<>();
            for (int i = 0; i < bitmaps.length; i++) {
                arrayList.add(bitmaps[i]);

            }
            bit = arrayList.get(pos);
            iv = (ImageView) getView().findViewById(R.id.image_viewA);
            iv.setImageBitmap(bit);
            like = (ImageView) getView().findViewById(R.id.likeA);
            dislike = (ImageView) getView().findViewById(R.id.dislikeA);
            like.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewPager = (ViewPager) getActivity().findViewById(R.id.pager_view);
                    resultados = new Resultados(nombreDirector, titulos[pos], bit);
                    if (pos < 4) {
                        resultados.setArrayList(arrayListResultados);
                        pos++;
                        bit = arrayList.get(pos);
                        iv.setImageBitmap(bit);

                    } else {
                        resultados.setArrayList(arrayListResultados);
                        int item = viewPager.getCurrentItem();
                        item++;
                        viewPager.setCurrentItem(item);
                        like.setEnabled(false);
                        dislike.setEnabled(false);
                    }
                }
            });
            dislike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewPager = (ViewPager) getActivity().findViewById(R.id.pager_view);
                    if (pos < 4) {
                        pos++;
                        bit = arrayList.get(pos);
                        iv.setImageBitmap(bit);
                    } else {
                        int item = viewPager.getCurrentItem();
                        item++;
                        viewPager.setCurrentItem(item);
                        like.setEnabled(false);
                        dislike.setEnabled(false);
                    }
                }
            });
        }
    }
}
