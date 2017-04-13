package com.example.daini.practica1abril.Models;

import android.graphics.Bitmap;

import java.util.ArrayList;

/**
 * Created by Daini on 10/04/2017.
 */

public class Resultados {
    public static ArrayList<Resultados> mArraylist = new ArrayList<>();
    private String nombre, titulo;
    private Bitmap bitmap;

    public Resultados() {
    }

    public Resultados(String nombre, String titulo, Bitmap bitmap) {
        this.nombre = nombre;
        this.titulo = titulo;
        this.bitmap = bitmap;
    }

    public ArrayList<Resultados> getArrayList() {
        return mArraylist;
    }

    public void setArrayList(ArrayList<Resultados> arrayList) {
        arrayList.add(new Resultados(nombre, titulo, bitmap));
        this.mArraylist = arrayList;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
