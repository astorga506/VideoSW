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
import static org.junit.Assert.*;

/**
 *
 * @author Equipo
 */
public class GeneroDataTest {
    
    public GeneroDataTest() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void hello() {
        try {
            System.out.println(new GeneroData().getGeneros().getFirst().getNombreGenero());
        } catch (SQLException ex) {
            Logger.getLogger(GeneroDataTest.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
}
