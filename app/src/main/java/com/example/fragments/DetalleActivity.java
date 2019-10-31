package com.example.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class DetalleActivity extends AppCompatActivity {

    public static final String EXTRA_TEXTO = "com.example.ejfragments.EXTRA_TEXTO";

    protected  void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        FragmentoDetalleJuego detalleJuego = (FragmentoDetalleJuego)getSupportFragmentManager().findFragmentById(R.id.frgDetalle);

        Juego juego = (Juego) getIntent().getSerializableExtra("EXTRA_TEXTO");

        detalleJuego.mostrarDetalle(juego.getImagen(), juego.getDescripcion(),juego.getPrecio() ,juego.getPlataformas() );
    }
}
