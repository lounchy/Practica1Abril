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
import com.example.daini.practica1abril.AsyncTask.AsyncTaskD;
import com.example.daini.practica1abril.R;

/**
 * Created by Daini on 28/03/2017.
 */

public class FragmentD extends Fragment {
    private ImageView d;
    public static Bitmap[] imagesD;
    private Bitmap [] imageDownloaded;
    private AsyncTaskD asyncTaskD;
    private static boolean created;
    private static final String URL_IMAGEN_1 = "http://1.bp.blogspot.com/-0IX_pzbmGhk/UsFk2UsuhTI/AAAAAAAAPmg/Eh--cFFbHYA/s1600/weekend_without_a_sunrise_03.jpg";
    private static final String URL_IMAGEN_2 = "http://es.web.img3.acsta.net/r_1280_720/medias/nmedia/18/72/63/56/19172094.jpg";
    private static final String URL_IMAGEN_3 = "http://estaticos01.elmundo.es/elmundo/imagenes/2009/03/28/1238256254_0.jpg";
    private static final String URL_IMAGEN_4 = "https://cinemadreamer.files.wordpress.com/2009/02/apart2.jpg";
    private static final String URL_IMAGEN_5 = "http://photos1.blogger.com/blogger/8009/556/1600/aqui11.jpg";
    String [] urlArray = new String[]{URL_IMAGEN_1, URL_IMAGEN_2,URL_IMAGEN_3,URL_IMAGEN_4, URL_IMAGEN_5};

    public FragmentD() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_d, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final ProgressBar progressBar = (ProgressBar)getView().findViewById(R.id.progresbarD);
        if (!created){
            asyncTaskD = new AsyncTaskD(this);
            d = (ImageView) getView().findViewById(R.id.descargarD);

            d.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), "Descarga en curso",Toast.LENGTH_LONG).show();
                    asyncTaskD.execute(urlArray);
                    d.setEnabled(false);
                    progressBar.setVisibility(View.VISIBLE);

                }
            });
        }else {
            FrameLayout frameLayout = (FrameLayout)getView().findViewById(R.id.fragmentD);
            frameLayout.removeAllViewsInLayout();
        }
    }
    public void getImages(Bitmap [] bitmaps){

        imageDownloaded = bitmaps;
        imagesD = imageDownloaded;
        FrameLayout frameLayout = (FrameLayout)getView().findViewById(R.id.fragmentD);
        frameLayout.removeAllViewsInLayout();
        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        FragmentFotoD fotoD = new FragmentFotoD();
        ft.replace(R.id.fragmentD,fotoD);
        ft.addToBackStack(null);
        ft.remove(new FragmentD());
        ft.commit();
        created = true;
    }
}
