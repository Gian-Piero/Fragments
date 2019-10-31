package com.example.fragments;

import java.io.Serializable;

public class Juego implements Serializable {

    private String nombreJuego;
    private String precio;
    private int imagen;
    private String plataformas;
    private String descripcion;

    public Juego(String nombreJuego, String precio, String plataformas ,int imagen, String descripcion)
    {
        this.nombreJuego = nombreJuego;
        this.precio = precio;
        this.plataformas = plataformas;
        this.imagen = imagen;
        this.descripcion = descripcion;
    }

    public String getNombreJuego()
    {
        return nombreJuego;
    }

    public String getPrecio()
    {
        return precio;
    }

    public int getImagen()
    {
        return imagen;
    }

    public String getPlataformas()
    {
        return plataformas;
    }

    public String getDescripcion()
    {
        return  descripcion;
    }

}
