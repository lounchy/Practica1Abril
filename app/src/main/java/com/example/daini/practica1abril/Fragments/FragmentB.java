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

import com.example.daini.practica1abril.AsyncTask.AsyncTaskB;
import com.example.daini.practica1abril.R;

/**
 * Created by Daini on 28/03/2017.
 */

public class FragmentB extends Fragment {
    private ImageView d;
    public static Bitmap[] imagesB;
    private Bitmap [] imageDownloaded;
    private AsyncTaskB asyncTaskB;

    private static boolean created;
    private static final String URL_IMAGEN_1 = "http://blogdemax.xcycom.net/image.axd?picture=2011%2F2%2Ftiempodegitanos.jpg";
    private static final String URL_IMAGEN_2 = "http://www.cyfraplus.pl/misc/base/galeria/underground_001.jpg";
    private static final String URL_IMAGEN_3 = "https://s-media-cache-ak0.pinimg.com/236x/f7/88/73/f78873d3904a0403b761e1d1031e60c8.jpg";
    private static final String URL_IMAGEN_4 = "http://es.web.img3.acsta.net/c_300_300/medias/nmedia/18/35/26/04/18377517.jpg";
    private static final String URL_IMAGEN_5 = "http://www.ecartelera.com/images/noticias/fotos/1800/1815/2.jpg";
    String [] urlArray = new String[]{URL_IMAGEN_1, URL_IMAGEN_2,URL_IMAGEN_3,URL_IMAGEN_4, URL_IMAGEN_5};

    public FragmentB() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_b, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final ProgressBar progressBar = (ProgressBar)getView().findViewById(R.id.progresbarB);
        if (!created){
            asyncTaskB = new AsyncTaskB(this);
            d = (ImageView) getView().findViewById(R.id.descargarB);
            d.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), "Descarga en curso",Toast.LENGTH_LONG).show();
                    asyncTaskB.execute(urlArray);
                    d.setEnabled(false);
                    progressBar.setVisibility(View.VISIBLE);

                }
            });
        }else {
            FrameLayout frameLayout = (FrameLayout)getView().findViewById(R.id.fragmentB);
            frameLayout.removeAllViewsInLayout();
        }
    }
    public void getImages(Bitmap [] bitmaps){

        imageDownloaded = bitmaps;
        imagesB = imageDownloaded;
        FrameLayout frameLayout = (FrameLayout)getView().findViewById(R.id.fragmentB);
        frameLayout.removeAllViewsInLayout();
        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        FragmentFotoB fotoB = new FragmentFotoB();
        ft.replace(R.id.fragmentB,fotoB);
        ft.addToBackStack(null);
        ft.remove(new FragmentB());
        ft.commit();
        created = true;
    }
}
