package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements JuegoListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentoListado fragmentListado = (FragmentoListado) getSupportFragmentManager().findFragmentById(R.id.frgListado);
        fragmentListado.setJuegoListener(this);
    }

    @Override
    public void onJuegoSeleccionado(Juego j)
    {
        boolean hayDetalle = (getSupportFragmentManager().findFragmentById(R.id.frgDetalle)!= null);

        if (hayDetalle)
        {
            ((FragmentoDetalleJuego)getSupportFragmentManager().findFragmentById(R.id.frgDetalle)).mostrarDetalle(j.getImagen(), j.getNombreJuego(), j.getPlataformas(), j.getPrecio() );
        }
        else {
            Intent intent = new Intent(this, DetalleActivity.class);
            intent.putExtra("EXTRA_TEXTO", j);
            startActivity(intent);
        }
    }
}
