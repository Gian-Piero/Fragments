package com.example.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;

public class FragmentoListado extends Fragment {

    private Juego[] datos = new Juego [] {
            new Juego ("Apex Legends", "20,60€", "PS4, XBOX, PC", R.drawable.apex, "Apex Legends es un videojuego gratuito perteneciente al género Battle Royale desarrollado por Respawn Entertainment y publicado por Electronic Arts. Fue lanzado para Microsoft Windows, PlayStation 4 y Xbox One el 4 de febrero de 2019."),
            new Juego ("Minecraft", "89,99€", "PS4, XBOX, PC, ANDROID E IOS", R.drawable.mainkra, "Minecraft es un videojuego de mundo abierto donde la exploración y las construcciones son fundamentales. Creado por Markus <<Notch>> Persson, nos permite desarrollar nuestros propios universos fantásticos y artísticos, mediante la colocación y destrucción de bloques."),
            new Juego ("Overwatch", "38,80€", "PC, PS4, XBOX", R.drawable.overwatch, "Overwatch es un videojuego de acción cooperativa y competitiva en primera persona desarrollado por Blizzard, creadores de juegos como Starcraft, Diablo o Warcraft, que por vez primera abordan un juego de perfil first person shooter."),
            new Juego ("LOL", "10,99€", "PC", R.drawable.lol, "League of Legends es un juego competitivo en línea de ritmo frenético, que fusiona la velocidad y la intensidad de la estrategia en tiempo real (ETR) con elementos de juegos de rol."),
            new Juego("Brawl Stars", "29,99€", "Android, Pc, Linux, PS4", R.drawable.brawstars , "Brawl Stars es un juego de mecánicas multijugador sencillas. Su modalidad principal consiste en que tres jugadores compiten con otros tres oponentes para conseguir y mantener unas gemas repartidas por unos mapas llenos de obstáculos.")
    };


   private ListView listaJuegos;
   private JuegoListener listenerJuegos;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragmento_listado, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        listaJuegos = (ListView)getView().findViewById(R.id.lstListado);
        listaJuegos.setAdapter(new AdaptadorJuegos(this));
        listaJuegos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                if (listenerJuegos != null)
                    listenerJuegos.onJuegoSeleccionado( (Juego)listaJuegos.getAdapter().getItem(position) );
            }
        });
    }


    class AdaptadorJuegos extends ArrayAdapter<Juego> {
        Activity context;
        AdaptadorJuegos(Fragment context) {
            super(context.getActivity(), R.layout.item_juego, datos);
            this.context = context.getActivity();
        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.item_juego, null);

            TextView lblNombreJuego = (TextView) item.findViewById(R.id.txtNombre);
            lblNombreJuego.setText(datos[position].getNombreJuego());

            ImageView imgJuego = (ImageView)item.findViewById(R.id.imagenJuego);
            imgJuego.setImageResource(datos[position].getImagen());

            return (item);
        }
    }

    public void setJuegoListener (JuegoListener listener){
        this.listenerJuegos =listener;
    }



}
