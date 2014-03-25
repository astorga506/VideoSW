/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videosw.renta.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Equipo
 */
public class BaseData {

    public BaseData() {
    }

    public Connection getConnection() throws SQLException {

        String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://10.155.7.170;"
                    + "databaseName=VideoSW_a80703;"
                    + "user=lenguajes;password=lenguajes;";

        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        Connection connection = DriverManager.getConnection(url);

        return connection;

    }//getConnection

}
