/*
CLASE Etiqueta

Declaraciónes y prestaciones dirigidas a la gestión de etiquetas de imágenes.
 */

/*
    realización: Juan Montes de Oca
 */


package practica_laberinto;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Etiqueta extends JLabel{
    //DECLARACIÓN DE ATRIBUTOS
    private static final int dimX=56;
    private static final int dimY=56;
    private ImageIcon imagen;
    
    //MÉTODO CONSTRUCTOR
    public Etiqueta(ImageIcon imagen) {
        this.imagen=imagen;
        inicializacionEtiqueta();
    }
    
    //MÉTODOS FUNCIONALES
    //lleva a cabo la incialización de una etiqueta asignándole la imagen que
    //va a representar y parametrizando sus características
    public void inicializacionEtiqueta() {
        setIcon(redimensionarImagenEtiqueta(imagen));
        setSize(dimX, dimY);       
        setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        setVerticalAlignment(javax.swing.SwingConstants.CENTER); 
        setBackground(Color.WHITE);
        setOpaque(true); 
    }

    //lleva a cabo la actualización de una etiqueta seleccionada asignándole la imagen que
    //le corresponde y el color rojo como color de fondo para identificar
    //su selección.
    public void seleccionarEtiqueta() {
        setBackground(Color.RED);
        setOpaque(true);        
    }    

    //lleva a cabo la actualización de una etiqueta deseleccionada el color blanco 
    //como color de fondo para identificar su deselección.
    public void deseleccionarEtiqueta() {
        setBackground(Color.WHITE);
        setOpaque(true);        
    }

    
    //redimensionamiento de una imagen en base a las dimensiones de una
    //etiqueta
    public ImageIcon redimensionarImagenEtiqueta(ImageIcon imagen) {
        Image imgEscalada = imagen.getImage().getScaledInstance(dimX-4,
            dimY-4, java.awt.Image.SCALE_DEFAULT);
        return new ImageIcon(imgEscalada); 
    }    

}
