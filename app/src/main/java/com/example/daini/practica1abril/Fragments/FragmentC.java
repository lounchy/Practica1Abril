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
import com.example.daini.practica1abril.AsyncTask.AsyncTaskC;
import com.example.daini.practica1abril.R;

/**
 * Created by Daini on 28/03/2017.
 */

public class FragmentC extends Fragment {
    private ImageView d;
    public static Bitmap[] imagesC;
    private Bitmap [] imageDownloaded;
    private AsyncTaskC asyncTaskC;
    private static boolean created;

    private static final String URL_IMAGEN_1 = "https://literariedad.files.wordpress.com/2015/03/foto-53.jpg";
    private static final String URL_IMAGEN_2 = "http://observandocine.com/wp-content/uploads/2013/12/Bailar-en-la-Oscuridad.jpg";
    private static final String URL_IMAGEN_3 = "http://jaimeburque.com/blog/wp-content/uploads/dogville.jpg";
    private static final String URL_IMAGEN_4 = "https://i.blogs.es/35db7f/antichrist/450_1000.jpg";
    private static final String URL_IMAGEN_5 = "http://estaticos03.telva.com/imagenes/2013/11/07/novias/1383834593_0.jpg";
    String [] urlArray = new String[]{URL_IMAGEN_1, URL_IMAGEN_2,URL_IMAGEN_3,URL_IMAGEN_4, URL_IMAGEN_5};

    public FragmentC() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_c, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final ProgressBar progressBar = (ProgressBar)getView().findViewById(R.id.progresbarC);
        if (!created){
            asyncTaskC = new AsyncTaskC(this);
            d = (ImageView) getView().findViewById(R.id.descargarC);
            d.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), "Descarga en curso",Toast.LENGTH_LONG).show();
                    asyncTaskC.execute(urlArray);
                    d.setEnabled(false);
                   progressBar.setVisibility(View.VISIBLE);

                }
            });
        }else {
            FrameLayout frameLayout = (FrameLayout)getView().findViewById(R.id.fragmentC);
            frameLayout.removeAllViewsInLayout();
        }
    }
    public void getImages(Bitmap [] bitmaps){

        imageDownloaded = bitmaps;
        imagesC = imageDownloaded;
        FrameLayout frameLayout = (FrameLayout)getView().findViewById(R.id.fragmentC);
        frameLayout.removeAllViewsInLayout();
        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        FragmentFotoC fotoC = new FragmentFotoC();
        ft.replace(R.id.fragmentC,fotoC);
        ft.addToBackStack(null);
        ft.remove(new FragmentC());
        ft.commit();
        created = true;
    }

}
