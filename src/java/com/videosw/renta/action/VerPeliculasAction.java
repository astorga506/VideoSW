/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.videosw.renta.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.sun.corba.se.spi.presentation.rmi.StubAdapter;
import com.videosw.renta.business.PeliculaBusiness;
import com.videosw.renta.domain.Genero;
import com.videosw.renta.domain.Pelicula;
import java.util.LinkedList;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;

/**
 *
 * @author Equipo
 */
public class VerPeliculasAction extends ActionSupport implements Preparable, ServletRequestAware{
    private LinkedList<Pelicula> peliculas;
    private Genero genero;
    private Pelicula PeliculaSeleccionada;
    private HttpServletRequest request;
    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
    
    public String mostrar() throws Exception{
        int codPelicula = Integer.parseInt(request.getParameter("codPelicula"));
        buscarPelicula(codPelicula);
        return SUCCESS;
    }
    
    private void buscarPelicula(int codPelicula){
        boolean encontrada = false;
        int i = 0;        
        while(i < peliculas.size() && !encontrada){
            if (peliculas.get(i).getCodPelicula() == codPelicula){
                encontrada = true;
                this.PeliculaSeleccionada = peliculas.get(i);
            }else {
                i++;
            }
        }//while
    }

    @Override
    public void prepare() throws Exception {
        PeliculaBusiness peliculaBus = new PeliculaBusiness();
        peliculas = peliculaBus.getPeliculas();
        genero = new Genero(100, "Biografía");
        //TODO falta capturar excepciones
    }

    public LinkedList<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(LinkedList<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        this.request = hsr;
    }

    public Pelicula getPeliculaSeleccionada() {
        return PeliculaSeleccionada;
    }

    public void setPeliculaSeleccionada(Pelicula PeliculaSeleccionada) {
        this.PeliculaSeleccionada = PeliculaSeleccionada;
    }  
        
}
