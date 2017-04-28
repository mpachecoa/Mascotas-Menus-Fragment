package com.example.sistema.mascotas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.sistema.mascotas.adapter.FavoritoAdaptador;
import com.example.sistema.mascotas.adapter.MascotaAdaptador;
import com.example.sistema.mascotas.pojo.FotoLike;
import com.example.sistema.mascotas.pojo.Mascota;

import java.util.ArrayList;

public class FavoritoMascotas extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView rvFavoritoMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorito_mascotas);

        Toolbar miActionBar= (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_dog_footprint_48_1);

        rvFavoritoMascotas = (RecyclerView) findViewById(R.id.rvFavoritoMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvFavoritoMascotas.setLayoutManager(llm);
        inicializarMascotas();
        inicializarAdaptador();

    }

    public void inicializarMascotas() {
        ArrayList<FotoLike> fotoslike;
        mascotas =  new ArrayList<>();
        // Mascota 1
        fotoslike = new ArrayList<>();
        fotoslike.add(new FotoLike(R.drawable.ic_perro1, 0));
        fotoslike.add(new FotoLike(R.drawable.ic_perro1, 1));
        fotoslike.add(new FotoLike(R.drawable.ic_perro1, 5));
        fotoslike.add(new FotoLike(R.drawable.ic_perro1, 2));
        mascotas.add(new Mascota("Tavo", R.drawable.ic_perro1, 80, fotoslike));

        // Mascota 2
        fotoslike = new ArrayList<>();
        fotoslike.add(new FotoLike(R.drawable.ic_perro2, 1));
        fotoslike.add(new FotoLike(R.drawable.ic_perro2, 2));
        fotoslike.add(new FotoLike(R.drawable.ic_perro2, 5));
        fotoslike.add(new FotoLike(R.drawable.ic_perro2, 4));
        fotoslike.add(new FotoLike(R.drawable.ic_perro2, 0));
        mascotas.add(new Mascota("Blacky", R.drawable.ic_perro2, 50, fotoslike));

        // Mascota 3
        fotoslike = new ArrayList<>();
        fotoslike.add(new FotoLike(R.drawable.ic_perro3, 10));
        fotoslike.add(new FotoLike(R.drawable.ic_perro3, 9));
        fotoslike.add(new FotoLike(R.drawable.ic_perro3, 5));
        mascotas.add(new Mascota("Mosha", R.drawable.ic_perro3, 34, fotoslike));

        // Mascota 4
        fotoslike = new ArrayList<>();
        fotoslike.add(new FotoLike(R.drawable.ic_gato1, 2));
        fotoslike.add(new FotoLike(R.drawable.ic_gato1, 4));
        fotoslike.add(new FotoLike(R.drawable.ic_gato1, 1));
        fotoslike.add(new FotoLike(R.drawable.ic_gato1, 4));
        fotoslike.add(new FotoLike(R.drawable.ic_gato1, 5));
        fotoslike.add(new FotoLike(R.drawable.ic_gato1, 4));
        mascotas.add(new Mascota("Rintintin", R.drawable.ic_gato1, 30, fotoslike));

        // Mascota 5
        fotoslike = new ArrayList<>();
        fotoslike.add(new FotoLike(R.drawable.ic_gato2, 4));
        fotoslike.add(new FotoLike(R.drawable.ic_gato2, 5));
        fotoslike.add(new FotoLike(R.drawable.ic_gato2, 2));
        fotoslike.add(new FotoLike(R.drawable.ic_gato2, 4));
        fotoslike.add(new FotoLike(R.drawable.ic_gato2, 1));
        fotoslike.add(new FotoLike(R.drawable.ic_gato2, 4));
        fotoslike.add(new FotoLike(R.drawable.ic_gato2, 5));
        mascotas.add(new Mascota("Tifón", R.drawable.ic_gato2, 25, fotoslike));


    }

    public void inicializarAdaptador() {
        FavoritoAdaptador adaptador = new FavoritoAdaptador(mascotas, this);
        rvFavoritoMascotas.setAdapter(adaptador);
    }

}
