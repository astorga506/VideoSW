/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videosw.renta.data;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Equipo
 */
public class BaseDataTest {

    BaseData bd;

    @Before
    public void setUp() {

        bd = new BaseData();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void hello() {
        try {
            bd.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(BaseDataTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
