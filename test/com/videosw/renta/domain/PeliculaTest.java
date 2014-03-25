/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.videosw.renta.domain;

import java.util.LinkedList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Equipo
 */
public class PeliculaTest {
    
    private Pelicula pelicula;
    
    @Before
    public void setUp() {
        pelicula = new Pelicula();
    }
    
    @After
    public void tearDown() {
    }

     @Test
     public void hello() {
         
         pelicula.setTitulo("The Fight Club");
         pelicula.setCodPelicula(1000);
         pelicula.setEstreno(false);
         pelicula.setSubtitulada(true);
         pelicula.setTotalPeliculas(1);
         LinkedList<Actor> actores = new LinkedList<Actor>();
         actores.add(new Actor(1000, "Edward", "Norton"));
         actores.add(new Actor(1001, "Brad", "Pitt"));
         actores.add(new Actor(1002, "Jared", "Leto"));   
         actores.add(new Actor(1003, "Helena", "Bonham Carter"));
         pelicula.setActores(actores);
         pelicula.setGenero(new Genero(1000, "Drama"));
         
         System.out.println("Titulo: "+pelicula.getTitulo());
         System.out.println("Genero: "+pelicula.getGenero().getNombreGenero());
         System.out.println("Actores:");
         for (Actor actor : pelicula.getActores()) {
                      System.out.println(" -"+actor.getNombreActor()+" "+actor.getApellidosActor());
         }
     }
}
