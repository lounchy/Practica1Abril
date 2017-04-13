package com.example.daini.practica1abril.Actividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.daini.practica1abril.Adapters.ResultadosAdapter;
import com.example.daini.practica1abril.Fragments.FragmentFotoA;
import com.example.daini.practica1abril.Models.Resultados;
import com.example.daini.practica1abril.R;

import java.util.ArrayList;

public class ResultadosActivity extends AppCompatActivity {
    private ArrayList<Resultados> arrayListResultados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        Resultados resultados = new Resultados();
        arrayListResultados = Resultados.mArraylist;
        ResultadosAdapter resultadosAdapter = new ResultadosAdapter(this,arrayListResultados);
        ListView listView = (ListView)findViewById(R.id.list_view_resultados);
        listView.setAdapter(resultadosAdapter);
    }
}
