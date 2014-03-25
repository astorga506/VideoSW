/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.videosw.renta.domain;

import java.util.LinkedList;

/**
 *
 * @author Equipo
 */
public class Pelicula {
    
    private int codPelicula;
    private String titulo;
    private int totalPeliculas;
    private boolean subtitulada;
    private boolean estreno;
    private Genero genero;
    private LinkedList<Actor> actores;

    public Pelicula() {
        genero = new Genero();
        actores = new LinkedList<Actor>();
    }

    public Pelicula(int codPelicula, String titulo, int totalPeliculas, boolean subtitulada, 
                                                            boolean estreno, Genero genero, LinkedList<Actor> actores) {
        this.codPelicula = codPelicula;
        this.titulo = titulo;
        this.totalPeliculas = totalPeliculas;
        this.subtitulada = subtitulada;
        this.estreno = estreno;
        this.genero = genero;
        this.actores = actores;
    }

    public int getCodPelicula() {
        return codPelicula;
    }

    public void setCodPelicula(int codPelicula) {
        this.codPelicula = codPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getTotalPeliculas() {
        return totalPeliculas;
    }

    public void setTotalPeliculas(int totalPeliculas) {
        this.totalPeliculas = totalPeliculas;
    }

    public boolean isSubtitulada() {
        return subtitulada;
    }

    public void setSubtitulada(boolean subtitulada) {
        this.subtitulada = subtitulada;
    }

    public boolean isEstreno() {
        return estreno;
    }

    public void setEstreno(boolean estreno) {
        this.estreno = estreno;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public LinkedList<Actor> getActores() {
        return actores;
    }

    public void setActores(LinkedList<Actor> actores) {
        this.actores = actores;
    }
}
