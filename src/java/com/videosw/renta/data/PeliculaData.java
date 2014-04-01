/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videosw.renta.data;

import com.videosw.renta.domain.Actor;
import com.videosw.renta.domain.Pelicula;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.sql.Types;

/**
 *
 * @author Equipo
 */
public class PeliculaData extends BaseData {

    public PeliculaData() {
    }

    //1. Crear la sentencia SQL
    public LinkedList<Pelicula> getPeliculas() throws SQLException {
        String sqlSelect = "SELECT p.cod_pelicula,p.titulo,p.cod_genero,p.total_peliculas,"
                + "p.subtitulada,p.estreno,g.nombre_genero"
                + "  FROM Pelicula p,Genero g"
                + "  WHERE p.cod_genero = g.cod_genero";
        //2. Abrir una conexion con la b.d.        
        Connection conexion = this.getConnection();
        //3. Crear el statement
        PreparedStatement statement = conexion.prepareStatement(sqlSelect);
        //4. Ejectuar el statement
        ResultSet resultSet = statement.executeQuery();
        //5. Recorrer el ResultSet
        LinkedList<Pelicula> peliculas = new LinkedList<Pelicula>();
        while (resultSet.next()) {
            Pelicula pelicula = new Pelicula();

            pelicula.setCodPelicula(resultSet.getInt("cod_pelicula"));
            pelicula.setTitulo(resultSet.getString("titulo"));
            pelicula.getGenero().setCodGenero(resultSet.getInt("cod_genero"));
            pelicula.setTotalPeliculas(resultSet.getInt("total_peliculas"));
            pelicula.setSubtitulada(resultSet.getBoolean("subtitulada"));
            pelicula.setEstreno(resultSet.getBoolean("estreno"));
            pelicula.getGenero().setNombreGenero(resultSet.getString("nombre_genero"));
            pelicula.setActores(getActores(pelicula.getCodPelicula()));

            peliculas.add(pelicula);
        }
        conexion.close();

        return peliculas;
    }

    public LinkedList<Actor> getActores(int codPelicula) throws SQLException {
        String sqlSelect = "SELECT a.cod_actor,a.nombre_actor,a.apellidos_actor"
                            + " FROM Actor a, Pelicula_Actor p"
                            + " WHERE a.cod_actor = p.cod_actor AND p.cod_pelicula =?"
                            + " ORDER BY a.nombre_actor";
        Connection conexion = this.getConnection();
        PreparedStatement statement = conexion.prepareStatement(sqlSelect);
        statement.setInt(1, codPelicula);
        ResultSet resultSet = statement.executeQuery();
        
        LinkedList<Actor> actores = new LinkedList<Actor>();
        while(resultSet.next()){
            Actor actor = new Actor();
            
            actor.setCodActor(resultSet.getInt("cod_actor"));
            actor.setNombreActor(resultSet.getString("nombre_actor"));
            actor.setApellidosActor(resultSet.getString("apellidos_actor"));
            
            actores.add(actor);
        }
        
        conexion.close();
        
        return actores;
    }//getActores
    
    public Pelicula insertar(Pelicula pelicula) throws SQLException{
    
        String sqlInsert = "{CALL InsertarPelicula(?,?,?,?,?,?)}";
        Connection conexion = this.getConnection();
        CallableStatement statement = conexion.prepareCall(sqlInsert);
        
        statement.registerOutParameter(1, Types.INTEGER);
        statement.setString(2, pelicula.getTitulo());
        statement.setInt(3, pelicula.getGenero().getCodGenero());
        statement.setInt(4, pelicula.getTotalPeliculas());
        statement.setBoolean(5, pelicula.isSubtitulada());
        statement.setBoolean(6, pelicula.isEstreno());
        
        statement.executeUpdate();
        
        pelicula.setCodPelicula(statement.getInt(1));
        
        conexion.close();
    
        return pelicula;
    }
}

