package com.example.sistema.mascotas.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sistema.mascotas.Communicator;
import com.example.sistema.mascotas.R;
import com.example.sistema.mascotas.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Sistema on 21/04/2017.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;
    Communicator comm;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
        comm = (Communicator) activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder holder, final int position) {
        final Mascota mascota = mascotas.get(position);

        holder.imgFotoCV.setImageResource(mascota.getFotoPerfil());
        holder.tvNombreCV.setText(mascota.getNombre());
        holder.tvFavoritoCV.setText(String.valueOf(mascota.getLike()));

        holder.btnLikeCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste Like a " + mascota.getNombre(),
                        Toast.LENGTH_LONG).show();
                mascota.setLike(mascota.getLike() + 1);
                mascotas.set(position, mascota);
            }
        });
        holder.imgFotoCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("mascota","MascotaAdaptador " + mascota.getNombre());
                comm.repons(mascota);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView   imgFotoCV;
        private ImageButton btnLikeCV;
        private TextView    tvNombreCV;
        private TextView    tvFavoritoCV;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFotoCV    = (ImageView) itemView.findViewById(R.id.imgFotoCV);
            btnLikeCV    = (ImageButton) itemView.findViewById(R.id.btnLikeCV);
            tvNombreCV   = (TextView)  itemView.findViewById(R.id.tvNombreCV);
            tvFavoritoCV = (TextView)  itemView.findViewById(R.id.tvFavoritoCV);
        }
    }
}
