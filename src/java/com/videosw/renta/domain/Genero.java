/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.videosw.renta.domain;

/**
 *
 * @author Equipo
 */
public class Genero {
    
    private int codGenero;
    private String nombreGenero;

    public Genero() {
    }

    public Genero(int codGenero, String nombreGenero) {
        this.codGenero = codGenero;
        this.nombreGenero = nombreGenero;
    }

    public int getCodGenero() {
        return codGenero;
    }

    public void setCodGenero(int codGenero) {
        this.codGenero = codGenero;
    }

    public String getNombreGenero() {
        return nombreGenero;
    }

    public void setNombreGenero(String nombreGenero) {
        this.nombreGenero = nombreGenero;
    }
    
}
