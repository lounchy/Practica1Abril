package com.example.daini.practica1abril.AsyncTask;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.daini.practica1abril.Adapters.ViewPagerAdapter;
import com.example.daini.practica1abril.Fragments.FragmentA;
import com.example.daini.practica1abril.Fragments.FragmentB;
import com.example.daini.practica1abril.Fragments.FragmentC;
import com.example.daini.practica1abril.Fragments.FragmentD;
import com.example.daini.practica1abril.R;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Daini on 30/03/2017.
 */

public class AsyncTaskB extends AsyncTask<String[], Void, Bitmap[]> {
    private FragmentB fragmentB;

    public AsyncTaskB(FragmentB fragmentB) {
        this.fragmentB = fragmentB;
    }

    @Override
    protected Bitmap [] doInBackground(String []... params) {
        Bitmap[] bitmapArray = null;
        Bitmap bitmapDownloaded = null;
        String urls_foto = null;
        URL url = null;
        String [] urlList = params[0];
        HttpURLConnection httpc = null;
        InputStream inputStream = null;
        bitmapArray = new Bitmap[urlList.length];
        int respuesta;

        for (int i = 0; i <urlList.length ; i++) {
            try {
                urls_foto = urlList[i];
                url = new URL(urls_foto);
                httpc = (HttpURLConnection)url.openConnection();
                respuesta = httpc.getResponseCode();
                if (respuesta == HttpURLConnection.HTTP_OK){
                    inputStream = httpc.getInputStream();
                    bitmapDownloaded = BitmapFactory.decodeStream(inputStream);
                    bitmapArray[i] = bitmapDownloaded;
                }else {

                }

            }catch (Throwable t){

            }finally {
                httpc.disconnect();
            }
        }
        return bitmapArray;
    }
    @Override
    protected void onPostExecute(Bitmap[] bitmaps) {

          fragmentB.getImages(bitmaps);

    }
}
