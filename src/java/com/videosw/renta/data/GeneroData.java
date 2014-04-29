/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videosw.renta.data;

import com.videosw.renta.domain.Genero;
import com.videosw.renta.exceptions.GeneroNoExisteException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author Equipo
 */
public class GeneroData extends BaseData {

    public GeneroData() {

    }

    public void eliminar(int codGenero) throws SQLException {
        String sqlDelete = "{CALL EliminarGenero(?)}";
        Connection con = this.getConnection();
        CallableStatement stmtDelete = con.prepareCall(sqlDelete);
        stmtDelete.setInt(1, codGenero);
        stmtDelete.executeUpdate();
        con.close();
    }

    public void editar(Genero genero) throws SQLException {
        String sqlUpdate = "{CALL EditarGenero(?,?)}";
        Connection con = this.getConnection();
        CallableStatement stmtUpdate = con.prepareCall(sqlUpdate);
        stmtUpdate.setInt(1, genero.getCodGenero());
        stmtUpdate.setString(2, genero.getNombreGenero());
        stmtUpdate.executeUpdate();
        con.close();
    }

    public LinkedList<Genero> getGeneros() throws SQLException {
        String sqlSelect = "SELECT cod_genero, nombre_genero"
                + " FROM Genero"
                + " ORDER BY nombre_genero";
        Connection conexion = this.getConnection();
        PreparedStatement statement = conexion.prepareStatement(sqlSelect);
        ResultSet resultSet = statement.executeQuery();
        LinkedList<Genero> generos = new LinkedList<Genero>();
        while (resultSet.next()) {
            Genero genero = new Genero();
            genero.setCodGenero(resultSet.getInt("cod_genero"));
            genero.setNombreGenero(resultSet.getString("nombre_genero"));

            generos.add(genero);
        }

        conexion.close();

        return generos;
    }

    public Genero getGenero(int codGenero) throws SQLException, GeneroNoExisteException {
        String sqlSelect = "{CALL GetGenero(?)}";
        Connection con = this.getConnection();
        CallableStatement stmt = con.prepareCall(sqlSelect);
        stmt.setInt(1, codGenero);
        ResultSet result = stmt.executeQuery();

        Genero genero = new Genero();
        if (result.next()) {            
            genero.setCodGenero(result.getInt("cod_genero"));
            genero.setNombreGenero(result.getString("nombre_genero"));
        } else {
                throw new GeneroNoExisteException();
        }

        con.close();

        return genero;
    }

}
