/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.videosw.renta.business;

import com.videosw.renta.data.GeneroData;
import com.videosw.renta.domain.Genero;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author Equipo
 */
public class GeneroBusiness {
    
    private GeneroData generoData;

    public GeneroBusiness() {
        generoData = new GeneroData();
    }
    
    public LinkedList<Genero> getGeneros() throws SQLException{
        return generoData.getGeneros();        
    }
    
    public void editar(Genero genero) throws SQLException {
        generoData.editar(genero);
    }
    
    public void eliminar(int codGenero) throws SQLException{
        generoData.eliminar(codGenero);
    }
    
}
