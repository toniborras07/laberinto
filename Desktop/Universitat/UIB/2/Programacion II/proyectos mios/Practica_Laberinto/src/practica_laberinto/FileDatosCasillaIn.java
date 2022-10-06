/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_laberinto;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author toniborras
 */
public class FileDatosCasillaIn {

    private BufferedReader fichero;

    public FileDatosCasillaIn(String file) {
        try {
            fichero = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileDatosCasillaIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Casilla lecturaCasilla() {
        Casilla casilla = new Casilla();
        try {
            casilla.setNorte((char) fichero.read());
            if(casilla.getNorte()=='\n'){
                   casilla.setNorte((char) fichero.read());
                }
            //si el titulo de la cancion ha dado que es null, significa que no 
            //hay mas canciones por leer y que por tanto se ha llegado al final de fichero.
            if ((casilla.getNorte() == -1)) {
                return null;
            } else {
                
                casilla.setEste((char) fichero.read());
                casilla.setSur((char) fichero.read());

                casilla.setOeste((char) fichero.read());

            }

        } catch (IOException ex) {
            Logger.getLogger(FileDatosCasillaIn.class.getName()).log(Level.SEVERE, null, ex);
        }

        return casilla;
    }

    public int getFilas() {

        int fila = 0;
        try {
            fila = Integer.parseInt(fichero.readLine());
        } catch (IOException ex) {
            Logger.getLogger(FileDatosCasillaIn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fila;
    }

    public int getColumnas() {

        int columnas = 0;
        try {
            columnas = Integer.parseInt(fichero.readLine());
        } catch (IOException ex) {
            Logger.getLogger(FileDatosCasillaIn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return columnas;
    }
    
        
    public int[] getSalida() {

        int[] salida = new int[2];
        try {
            fichero.read();
            salida[0] = Integer.parseInt(fichero.readLine());
          //  System.out.println(salida[0]);
            salida[1] = Integer.parseInt(fichero.readLine())-1;
           // System.out.println(salida[1]);
        } catch (IOException ex) {
            Logger.getLogger(ex.toString());
        }
        return salida;
    }
}


