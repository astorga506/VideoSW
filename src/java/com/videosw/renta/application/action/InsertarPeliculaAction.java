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
import com.videosw.renta.business.PeliculaBusiness;
import com.videosw.renta.domain.Genero;
import com.videosw.renta.domain.Pelicula;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author Equipo
 */
public class InsertarPeliculaAction extends ActionSupport implements Preparable, ModelDriven<Pelicula>{
    
    private LinkedList<Genero> generos;
    private Pelicula peliculaInsertar;//recolector de los datos que vienen del navegador
    private String mensaje;

    @Override
    public String execute() throws Exception {        
        return INPUT;
    }
    
    public String insertar(){
        PeliculaBusiness peliculaBusiness = new PeliculaBusiness();  
        boolean insertado = true;
        try{
            peliculaBusiness.insertar(peliculaInsertar);
        }catch(SQLException e){
            e.getErrorCode();
            insertado = false;
            mensaje = "Ocurrió un erro conla base de datos. Inténtelo nuevamente. Si el error persiste contacte al adimistrador del sistema";
        }
        if(insertado){
            this.mensaje = "La película se insertó correctamente";
            return SUCCESS;
        }else {
            return ERROR;
        }
    }

    @Override
    public void validate() {
        if(peliculaInsertar.getTitulo().length() == 0 || peliculaInsertar.getTitulo().equals(null)){
            addFieldError("titulo", "Debe de ingresar un titulo");
        }
        
        if(peliculaInsertar.getTotalPeliculas() < 0){
            addFieldError("totalPeliculas", "La cantidad de películas debe ser superior a 0");
        }
    }
    
    @Override
    public void prepare() throws Exception {
        GeneroBusiness generoBusiness = new GeneroBusiness();
        generos = generoBusiness.getGeneros();
        peliculaInsertar = new Pelicula();
        mensaje = "";
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

    public String getMensaje() {
        return mensaje;
    }
}
