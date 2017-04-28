package com.example.sistema.mascotas.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sistema.mascotas.R;
import com.example.sistema.mascotas.adapter.FotoLikeAdaptador;
import com.example.sistema.mascotas.adapter.MascotaAdaptador;
import com.example.sistema.mascotas.pojo.FotoLike;
import com.example.sistema.mascotas.pojo.Mascota;

import java.util.ArrayList;

import static com.example.sistema.mascotas.R.id.rvMascotas;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {
    private Mascota mascota;

    private ImageView imgFotoPerfil;
    private TextView tvNombre;

    private RecyclerView rvFotosLike;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_perfil, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        imgFotoPerfil = (ImageView) getActivity().findViewById(R.id.imgFotoPerfil);
        tvNombre      = (TextView)  getActivity().findViewById(R.id.tvNombre);

        rvFotosLike = (RecyclerView) getActivity().findViewById(R.id.rvFotosLike);

        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);

        rvFotosLike.setLayoutManager(glm);

        inicializarMascota();
        imgFotoPerfil.setImageResource(mascota.getFotoPerfil());
        tvNombre.setText(String.valueOf(mascota.getNombre()));

        inicializarAdaptador();
    }

    public void inicializarMascota() {
        ArrayList<FotoLike> fotosLike = new ArrayList<>();
        // Mascota 1
        fotosLike.add(new FotoLike(R.drawable.ic_perro1, 0));
        fotosLike.add(new FotoLike(R.drawable.ic_perro1, 1));
        fotosLike.add(new FotoLike(R.drawable.ic_perro1, 5));
        fotosLike.add(new FotoLike(R.drawable.ic_perro1, 2));
        fotosLike.add(new FotoLike(R.drawable.ic_perro1, 1));
        fotosLike.add(new FotoLike(R.drawable.ic_perro1, 1));
        mascota  = new Mascota("Tavo", R.drawable.ic_perro1, 80, fotosLike);
    }

    public void inicializarAdaptador() {
        Log.d("mascota","inicializarAdaptador " + mascota.getFotos().get(0).getFoto());
        FotoLikeAdaptador adaptador = new FotoLikeAdaptador(mascota.getFotos(), getActivity());
        rvFotosLike.setAdapter(adaptador);
    }

    public void onChangeData(Mascota mascota1) {
        Log.d("mascota","Perfil " + mascota1.getNombre());
        this.mascota = mascota1;
        imgFotoPerfil.setImageResource(mascota.getFotoPerfil());
        tvNombre.setText(String.valueOf(mascota.getNombre()));
        inicializarAdaptador();


    }

}
