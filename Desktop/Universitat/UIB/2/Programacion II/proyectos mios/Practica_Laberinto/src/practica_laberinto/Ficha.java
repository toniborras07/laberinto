/*
CLASE BOLA
 */
package practica_laberinto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class Ficha extends JComponent {
    //DECLARACIÓN DE ATRIBUTOS
    private int x,y;
    private int diametro,direccionX=1,direccionY=1;
    private Color colorRelleno, colorTrazado;
    
    public Ficha(int datoDiametro, int datoX, int datoY, Color datoColorTrazado, Color datoColorRelleno) {
        diametro=datoDiametro;
        x=datoX;
        y=datoY;
        colorTrazado=datoColorTrazado;
        colorRelleno=datoColorRelleno;
    }

    public void dibujar(Graphics2D g2, String jugador) {
        switch(jugador){
            case "meliodas":
                 try {
                        BufferedImage imagenFichero = ImageIO.read(new File("meliodas.png"));
                        g2.drawImage(imagenFichero.getScaledInstance(60, 60, 0), x,
                                y, this);
                    } catch (IOException ex) {
                        Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
                    }
                break;
            case "dianne":
                try {
                        BufferedImage imagenFichero = ImageIO.read(new File("dianne.png"));
                        g2.drawImage(imagenFichero.getScaledInstance(30, 30, 0), x,
                                y, this);
                    } catch (IOException ex) {
                        Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
                    }
                break;
            case "ban":
                try {
                        BufferedImage imagenFichero = ImageIO.read(new File("ban.png"));
                        g2.drawImage(imagenFichero.getScaledInstance(30, 30, 0), x,
                                y, this);
                    } catch (IOException ex) {
                        Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
                    }
                break;
            case "merlin":
                try {
                        BufferedImage imagenFichero = ImageIO.read(new File("merlin.png"));
                        g2.drawImage(imagenFichero.getScaledInstance(30, 30, 0), x,
                                y, this);
                    } catch (IOException ex) {
                        Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
                    }
                break;
            case "escannor":
                try {
                        BufferedImage imagenFichero = ImageIO.read(new File("escannor.png"));
                        g2.drawImage(imagenFichero.getScaledInstance(30, 30, 0), x,
                                y, this);
                    } catch (IOException ex) {
                        Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
                    }
                break;
            case "king":
                try {
                        BufferedImage imagenFichero = ImageIO.read(new File("king.png"));
                        g2.drawImage(imagenFichero.getScaledInstance(30, 30, 0), x,
                                y, this);
                    } catch (IOException ex) {
                        Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
                    }
                break;
            case "gowter":
                try {
                        BufferedImage imagenFichero = ImageIO.read(new File("gowter.png"));
                        g2.drawImage(imagenFichero.getScaledInstance(30, 30, 0), x,
                                y, this);
                    } catch (IOException ex) {
                        Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
                    }
                break;
            case "hawk":
                try {
                        BufferedImage imagenFichero = ImageIO.read(new File("hawk.png"));
                        g2.drawImage(imagenFichero.getScaledInstance(30, 30, 0), x,
                                y, this);
                    } catch (IOException ex) {
                        Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
                    }
                break;
        }
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        g2.setColor(colorRelleno);
//        g2.fill(new Ellipse2D.Float(x,y,diametro,diametro));
//        g2.setColor(colorTrazado);
//        g2.draw(new Ellipse2D.Float(x,y,diametro,diametro));
    }    
    
//    public void actualizacionCoordenada(int dimX, int dimY) {
//        x += (1*direccionX);
//        y += (1*direccionY);
//        //verificación coordenada X
//        if ( x > (dimX-50) ){
//            direccionX=-1;
//        }
//        if (x < 0) {
//            direccionX=1;
//        }
//        //verificación coordenada Y
//        if ( y > (dimY-50) ){
//            direccionY=-1;
//        }
//        if (y < 0) {
//            direccionY=1;
//        } 
//    }
}
