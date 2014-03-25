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
public class Actor {
    
    private int codActor;
    private String nombreActor;
    private String apellidosActor;

    public Actor() {
    }

    public Actor(int codActor, String nombreActor, String apellidosActor) {
        this.codActor = codActor;
        this.nombreActor = nombreActor;
        this.apellidosActor = apellidosActor;
    }

    public int getCodActor() {
        return codActor;
    }

    public void setCodActor(int codActor) {
        this.codActor = codActor;
    }

    public String getNombreActor() {
        return nombreActor;
    }

    public void setNombreActor(String nombreActor) {
        this.nombreActor = nombreActor;
    }

    public String getApellidosActor() {
        return apellidosActor;
    }

    public void setApellidosActor(String apellidosActor) {
        this.apellidosActor = apellidosActor;
    }    
}
