/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.videosw.renta.application.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.videosw.renta.business.GeneroBusiness;
import com.videosw.renta.domain.Genero;
import java.util.LinkedList;

/**
 *
 * @author Equipo
 */
public class MentenerGenerosAction extends ActionSupport implements Preparable{
    
    private LinkedList<Genero> generos;
     
    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    @Override
    public void prepare() throws Exception {
        generos = new GeneroBusiness().getGeneros();
    }

    public LinkedList<Genero> getGeneros() {
        return generos;
    }
    
}
