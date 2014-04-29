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
import com.videosw.renta.exceptions.GeneroNoExisteException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;

/**
 *
 * @author Equipo
 */
public class EditarGeneroAction extends ActionSupport implements Preparable, ModelDriven<Genero>, ServletRequestAware {

    private Genero generoEditar;
    private HttpServletRequest request;
    private String mensaje;
    private boolean existe;

    public EditarGeneroAction() {
    }
    
    public String editar(){
        GeneroBusiness generoBus = new GeneroBusiness();
        boolean editado = true;
        try{
            generoBus.editar(generoEditar);
        }catch(SQLException ex){
            editado = !editado;
        }
        if(editado){
            mensaje = "El género fue modificado exitosamente";
            return SUCCESS;
        }else{
            return INPUT;
        }        
    }

    @Override
    public String execute() throws Exception {
        if (existe) {
            return INPUT;
        } else {
            return ERROR;
        }
    }//execute

    @Override
    public void prepare() throws Exception {
        existe = true;
        int codGenero = Integer.parseInt(request.getParameter("codGenero"));
        try {
            generoEditar = new GeneroBusiness().getGenero(codGenero);
        } catch (GeneroNoExisteException gnee) {
            existe = false;
        }
    }

    @Override
    public Genero getModel() {
        return generoEditar;
    }

    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        this.request = hsr;
    }

    public Genero getGeneroEditar() {
        return generoEditar;
    }

    public void setGeneroEditar(Genero generoEditar) {
        this.generoEditar = generoEditar;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public void validate() {
        if(this.getModel().getNombreGenero().trim().equals("")){
            addFieldError("nombreGenero", "Debe de ingresar un nombre de género");
        }
    }
    
    
}
