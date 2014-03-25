/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videosw.renta.data;

import com.videosw.renta.domain.Actor;
import com.videosw.renta.domain.Pelicula;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Equipo
 */
public class PeliculaDataTest {

    PeliculaData pd;

    @Before
    public void setUp() {
        pd = new PeliculaData();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void hello() {
//        try {
//            LinkedList<Actor> actores = pd.getActores(9);
//            for (Actor actor : actores) {
//                System.out.println(" -" + actor.getNombreActor() + " " + actor.getApellidosActor());
//            }//actores
//
//        } catch (SQLException ex) {
//            Logger.getLogger(PeliculaDataTest.class.getName()).log(Level.SEVERE, null, ex);
//        }

        try {
            LinkedList<Pelicula> peliculas = pd.getPeliculas();
            for (Pelicula p : peliculas) {
                System.out.println("Codigo Pelicula: " + String.valueOf((p.getCodPelicula())));
                System.out.println("Titulo: " + p.getTitulo());
                System.out.println("Genero: " + p.getGenero().getNombreGenero());
                System.out.println("Actores:");
                for (Actor actor : p.getActores()) {
                    System.out.println(" -" + actor.getNombreActor() + " " + actor.getApellidosActor());
                }//actores
                System.out.println("\n");
            }//peliculas

        } catch (SQLException ex) {
            Logger.getLogger(PeliculaDataTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
