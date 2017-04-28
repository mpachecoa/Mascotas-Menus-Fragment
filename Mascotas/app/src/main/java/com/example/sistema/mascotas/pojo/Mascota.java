package com.example.sistema.mascotas.pojo;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Sistema on 21/04/2017.
 */

public class Mascota {
    private String nombre;
    private int fotoPerfil;
    private int like;
    private ArrayList<FotoLike> fotos;

    public Mascota(String nombre, int fotoPerfil, int like, ArrayList<FotoLike> fotos) {
        this.nombre = nombre;
        this.fotoPerfil = fotoPerfil;
        this.like = like;
        this.fotos = fotos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(int fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public ArrayList<FotoLike> getFotos() {
        return fotos;
    }

    public void setFotos(ArrayList<FotoLike> fotos) {
        this.fotos = fotos;
    }
}
