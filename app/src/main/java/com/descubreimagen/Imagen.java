package com.descubreimagen;

import android.media.Image;

public class Imagen {
    int id;
    String nombre;
    Image imagenCompleta;
    Image imagenDesarmada;

    public Imagen(int id,String nombre, Image imagenCompleta, Image imagenDesarmada) {
        this.id = id;
        this.nombre = nombre;
        this.imagenCompleta = imagenCompleta;
        this.imagenDesarmada = imagenDesarmada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Image getImagenCompleta() {
        return imagenCompleta;
    }

    public void setImagenCompleta(Image imagenCompleta) {
        this.imagenCompleta = imagenCompleta;
    }

    public Image getImagenDesarmada() {
        return imagenDesarmada;
    }

    public void setImagenDesarmada(Image imagenDesarmada) {
        this.imagenDesarmada = imagenDesarmada;
    }
}
