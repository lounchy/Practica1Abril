package com.example.daini.practica1abril.Actividades;


import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.daini.practica1abril.Fragments.CaruselFragment;
import com.example.daini.practica1abril.R;

public class MainActivity extends AppCompatActivity {
    private CaruselFragment cf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        cf = new CaruselFragment();

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.container, cf).commit();
    }
}
