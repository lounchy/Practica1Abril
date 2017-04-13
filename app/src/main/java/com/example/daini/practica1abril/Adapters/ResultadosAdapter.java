package com.example.daini.practica1abril.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.daini.practica1abril.Models.Resultados;
import com.example.daini.practica1abril.R;

import java.util.ArrayList;

/**
 * Created by Daini on 10/04/2017.
 */

public class ResultadosAdapter extends ArrayAdapter<Resultados> {
    private ArrayList<Resultados>arrayList;
    private Context context;
    public ResultadosAdapter(Context context, ArrayList<Resultados> arrayList) {
        super(context, 0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View elemento = convertView;
        if (elemento==null){
            elemento = LayoutInflater.from(getContext()).inflate(R.layout.pintar_resultado, parent, false);
        }else {
            elemento = convertView;
        }

        TextView tv1 = (TextView)elemento.findViewById(R.id.tv1);
        TextView tv2 = (TextView)elemento.findViewById(R.id.tv2);

        Resultados resultados = getItem(position);

        tv1.setText(resultados.getNombre());
        tv2.setText(resultados.getTitulo());
        return elemento;
    }
}
