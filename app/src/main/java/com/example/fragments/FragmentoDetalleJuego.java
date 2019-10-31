package com.example.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentoDetalleJuego extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragmento_juego, container,false);
    }

    public void mostrarDetalle (int imagen, String descripcion, String precioJuego, String plataformas) {

        ImageView imgJuego = (ImageView)getView().findViewById(R.id.imagenJuego);
        imgJuego.setImageResource(imagen);

        TextView txtDescripcion = (TextView)getView().findViewById(R.id.txtDescripcion);
        txtDescripcion.setText(descripcion);

        TextView txtPrecio = (TextView)getView().findViewById(R.id.txtPrecioJuego);
        txtPrecio.setText("Diponible desde : " + precioJuego);

        TextView txtPlataformas = (TextView)getView().findViewById(R.id.txtPlataformaJuego);
        txtPlataformas.setText("Plataformas : " + plataformas);
    }
}


