/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.videosw.renta.business;

import com.videosw.renta.data.PeliculaData;
import com.videosw.renta.domain.Actor;
import com.videosw.renta.domain.Pelicula;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author Equipo
 */
public class PeliculaBusiness {
    private PeliculaData peliculaData;

    public PeliculaBusiness() {
        this.peliculaData = new PeliculaData();
    }
    
    public LinkedList<Pelicula> getPeliculas() throws SQLException {
        return this.peliculaData.getPeliculas();
    }
    
    public LinkedList<Actor> getActores(int codPelicula) throws SQLException {
        return this.peliculaData.getActores(codPelicula);
    }
        
    public Pelicula insertar(Pelicula pelicula) throws SQLException{
        return this.peliculaData.insertar(pelicula);
    }
    
}
