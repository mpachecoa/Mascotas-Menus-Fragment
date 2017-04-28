package com.example.sistema.mascotas.pojo;

/**
 * Created by Sistema on 26/04/2017.
 */

public class FotoLike {
    private int foto;
    private int like;

    public FotoLike(int foto, int like) {
        this.foto = foto;
        this.like = like;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }
}
