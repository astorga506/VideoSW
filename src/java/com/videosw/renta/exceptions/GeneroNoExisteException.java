/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.videosw.renta.exceptions;

/**
 *
 * @author Equipo
 */
public class GeneroNoExisteException extends Exception{

    public GeneroNoExisteException() {
        super("No se encontró el género");
    }

    public GeneroNoExisteException(String message) {
        super(message);
    }
    
    
    
}
