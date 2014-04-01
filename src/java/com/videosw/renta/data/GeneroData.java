/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.videosw.renta.data;

import com.videosw.renta.domain.Genero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author Equipo
 */
public class GeneroData extends BaseData{
    
    public GeneroData(){
        
    } 
    
    public LinkedList<Genero> getGeneros() throws SQLException{
        String sqlSelect = "SELECT cod_genero, nombre_genero"
                            + " FROM Genero"
                            + " ORDER BY nombre_genero";
        Connection conexion = this.getConnection();
        PreparedStatement statement = conexion.prepareStatement(sqlSelect);
        ResultSet resultSet = statement.executeQuery();
        LinkedList<Genero> generos = new LinkedList<Genero>();
        while(resultSet.next()){
            Genero genero = new Genero();
            genero.setCodGenero(resultSet.getInt("cod_genero"));
            genero.setNombreGenero(resultSet.getString("nombre_genero"));
            
            generos.add(genero);
        }
        
        conexion.close();
                
        return generos;
    }
    
}
