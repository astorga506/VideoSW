/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.videosw.renta.application.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.videosw.renta.business.GeneroBusiness;
import com.videosw.renta.domain.Genero;
import com.videosw.renta.domain.Pelicula;
import java.util.LinkedList;

/**
 *
 * @author Equipo
 */
public class InsertarPeliculaAction extends ActionSupport implements Preparable, ModelDriven<Pelicula>{
    
    private LinkedList<Genero> generos;
    private Pelicula peliculaInsertar;//recolector de los datos que vienen del navegador

    @Override
    public String execute() throws Exception {
        return INPUT;
    }

    @Override
    public void prepare() throws Exception {
        GeneroBusiness generoBusiness = new GeneroBusiness();
        generos = generoBusiness.getGeneros();
        peliculaInsertar = new Pelicula();
    }

    @Override
    public Pelicula getModel() {
        return this.peliculaInsertar;
    }
    
    public LinkedList<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(LinkedList<Genero> generos) {
        this.generos = generos;
    }

    public void setPeliculaInsertar(Pelicula peliculaInsertar) {
        this.peliculaInsertar = peliculaInsertar;
    }
    
}
