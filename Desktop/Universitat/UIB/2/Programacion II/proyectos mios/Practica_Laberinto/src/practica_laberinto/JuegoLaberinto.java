/*
GENERADOR DE IMÁGENES ICONO

realización: Juan Montes de Oca
 */
package practica_laberinto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class JuegoLaberinto extends JFrame implements MouseListener {

    //DECLARACIÓN DE ATRIBUTOS
    private Tablero tablero;
    private JMenuBar barraMenu;
    private JMenu menu;
    private JMenuItem reinicio;
    private JMenuItem nuevoMapa;
    private JMenuItem fin;
    private boolean finalPartida = false;
    private int posXBola;
    private int posYBola;

    private int cociente = 10; //cociente nos dará el factor por el que tenemos que subdividir
    //el dibujo para adaptarlo a una imagen cuya dimensión vendrá
    //dada por 1000/cociente. En el caso que el cociente tenga una
    //dimensión de 10 tendremos una imagen de 100x100 pixeles.
    private int dimensionImagen = 1000 / cociente;
    private String mapa;

    public JuegoLaberinto() {
        super("Laberinto");
        inicializacion();
        setVisible(true);

    }

    private void inicializacion() {
       
        //Panel de visualización del tablero de casillas
        tablero = new Tablero("maze1.txt");
        introducirBola(tablero);

        //Declaración de la barra de menu 
        barraMenu = new JMenuBar();
        //declaración opción MENU de la barra de menu
        menu = new JMenu("MENU");
        //declaración opciones de la opción MENU de la barra de menu
        reinicio = new JMenuItem("Reiniciar Posición");
        nuevoMapa = new JMenuItem("Nuevo Laberinto");
        fin = new JMenuItem("SALIR");

        //Gestor de eventos asociado a la opción GENERAR IMAGEN del menu
        nuevoMapa.addActionListener(new ActionListener() {
            JFrame ventana;

            @Override
            public void actionPerformed(ActionEvent evt) {
                JFileChooser ventanaSeleccionImagen = new JFileChooser();
                File ficheroImagen = null;
                if (ventanaSeleccionImagen.showOpenDialog(ventana) == JFileChooser.APPROVE_OPTION) {
                    ficheroImagen = ventanaSeleccionImagen.getSelectedFile();
                    tablero.Inicializar(ficheroImagen.toString());
                    introducirBola(tablero);
                    tablero.repaint();

                }
            }
        });

        //Gestor de eventos asociado a la opción BORRAR del menu
        reinicio.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                tablero.borrar();
                tablero.getCasilla(posXBola, posYBola).setOcupada();
                tablero.repaint();

            }
        });

        //Gestor de eventos asociado a la opción SALIR del menu
        fin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                System.exit(0);
            }
        });

        tablero.addKeyListener(new EventosTeclado());
        tablero.setFocusable(true);

        //adición en la opción menu de las opciones BORRAR, GENERAR IMAGEN y SALIR
        menu.add(reinicio);
        menu.add(nuevoMapa);
        menu.add(fin);
        //adición en la barra de menu de la opción MENU
        barraMenu.add(menu);
        //Adición en JFrame de la barra de menu
        setJMenuBar(barraMenu);
        //asociación del gestor de eventos del ratón MouseListener al JFrame
        addMouseListener(this);
        //adición en el JFrame del tablero de casillas
        getContentPane().add(tablero);
        setSize(500,752);
        pack();

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    //Gestor del evento del boton pulsado del ratón al JFrame
    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    public static void main(String[] args) {
        JuegoLaberinto taller = new JuegoLaberinto();
    }

    public void introducirBola(Tablero tablero) {
        Random r = new Random();
        posXBola = r.nextInt(tablero.getNumColumnas())%2+2;
//        System.out.println(posXBola);
        posYBola = r.nextInt(tablero.getNumFilas())%2+2;
//        System.out.println(posYBola);
        tablero.getCasilla(posXBola, posYBola).setOcupada();
//        tablero.repaint();

    }

    //clase gestión de eventos del teclado
    private class EventosTeclado implements KeyListener {

        @Override
        public void keyPressed(KeyEvent ke) {
            boolean cambio = false;

            for (int fila = 0; fila < tablero.getNumFilas(); fila++) {
                for (int columna = 0; columna < tablero.getNumColumnas(); columna++) {

                    if (tablero.getCasilla(fila, columna).isOcupada()) {
                        //En función de la casilla pulsada
//                        System.out.println(ke.getKeyText(ke.getKeyCode()));
                        switch (ke.getKeyText(ke.getKeyCode())) {
                            //Si la casilla pulsada es la casilla de dirección Arriba
                            case "←":
                                if (columna != 0) {
                                    if (!hayPared("←", tablero.getCasilla(fila, columna))) {
                                        tablero.getCasilla(fila, columna - 1).setOcupada();
                                        tablero.getCasilla(fila, columna).setLiberada();
                                        checkMeta(tablero.getCasilla(fila, columna - 1));
                                    }

                                }
                                cambio = true;
                                break;
                            //Si la casilla pulsada es la casilla de dirección Derecha    
                            case "↓":
                                if (fila != 14) {
                                    if (!hayPared("↓", tablero.getCasilla(fila, columna))) {
                                        tablero.getCasilla(fila + 1, columna).setOcupada();
                                        tablero.getCasilla(fila, columna).setLiberada();
                                        checkMeta(tablero.getCasilla(fila + 1, columna));
                                    }

                                }
                                cambio = true;
                                break;
                            //Si la casilla pulsada es la casilla de dirección Abajo
                            case "→":
                                if (columna != 9) {
                                    if (!hayPared("→", tablero.getCasilla(fila, columna))) {
                                        tablero.getCasilla(fila, columna + 1).setOcupada();
                                        tablero.getCasilla(fila, columna).setLiberada();
                                        checkMeta(tablero.getCasilla(fila, columna + 1));
                                    }

                                }
                                cambio = true;
                                break;
                            //Si la casilla pulsada es la casilla de dirección Izquierda    
                            case "↑":
                                if (fila != 0) {
                                    if (!hayPared("↑", tablero.getCasilla(fila, columna))) {
                                        tablero.getCasilla(fila - 1, columna).setOcupada();
                                        tablero.getCasilla(fila, columna).setLiberada();
                                        checkMeta(tablero.getCasilla(fila - 1, columna));
                                    }

                                }
                                cambio = true;
                                break;

                            //Si la casilla pulsada es la casilla de dirección Arriba
                            case "Arriba":
                                if (fila != 0) {
                                    if (!hayPared("Arriba", tablero.getCasilla(fila, columna))) {
                                        tablero.getCasilla(fila - 1, columna).setOcupada();
                                        tablero.getCasilla(fila, columna).setLiberada();
                                        checkMeta(tablero.getCasilla(fila - 1, columna));
                                    }

                                }
                                cambio = true;
                                break;
                            //Si la casilla pulsada es la casilla de dirección Derecha    
                            case "Derecha":
                                if (columna != 9) {
                                    if (!hayPared("Derecha", tablero.getCasilla(fila, columna))) {
                                        tablero.getCasilla(fila, columna + 1).setOcupada();
                                        tablero.getCasilla(fila, columna).setLiberada();
                                        checkMeta(tablero.getCasilla(fila, columna + 1));
                                    }

                                }
                                cambio = true;
                                break;
                            //Si la casilla pulsada es la casilla de dirección Abajo
                            case "Abajo":
                                if (fila != 14) {
                                    if (!hayPared("Abajo", tablero.getCasilla(fila, columna))) {
                                        tablero.getCasilla(fila + 1, columna).setOcupada();
                                        tablero.getCasilla(fila, columna).setLiberada();
                                        checkMeta(tablero.getCasilla(fila + 1, columna));
                                    }

                                }
                                cambio = true;
                                break;
                            //Si la casilla pulsada es la casilla de dirección Izquierda    
                            case "Izquierda":
                                if (columna != 0) {
                                    if (!hayPared("Izquierda", tablero.getCasilla(fila, columna))) {
                                        tablero.getCasilla(fila, columna - 1).setOcupada();
                                        tablero.getCasilla(fila, columna).setLiberada();
                                        checkMeta(tablero.getCasilla(fila, columna - 1));
                                    }

                                }
                                cambio = true;
                                break;

                        }

                        break;
                    }

                }
                //si ha habido ya un cambio se finaliza el tratamiento
                if (cambio) {
                    break;
                }
            }

            tablero.repaint();
            repaint();

        }

        @Override
        public void keyTyped(KeyEvent ke) {
        }

        @Override
        public void keyReleased(KeyEvent ke) {
        }
    }

    public Boolean hayPared(String g, Casilla casilla) {
        switch (g) {
            case "←":
                if (casilla.getOeste() != '1') {
                    return false;
                }
                break;
            //Si la casilla pulsada es la casilla de dirección Derecha    
            case "↓":
                if (casilla.getSur() != '1') {
                    return false;
                }
                break;
            //Si la casilla pulsada es la casilla de dirección Abajo
            case "→":
                if (casilla.getEste() != '1') {
                    return false;
                }
                break;
            //Si la casilla pulsada es la casilla de dirección Izquierda    
            case "↑":
                if (casilla.getNorte() != '1') {
                    return false;
                }
                break;

            //Si la casilla pulsada es la casilla de dirección Arriba
            case "Arriba":
                if (casilla.getNorte() != '1') {
                    return false;
                }
                break;
            //Si la casilla pulsada es la casilla de dirección Derecha    
            case "Derecha":
                if (casilla.getEste() != '1') {
                    return false;
                }
                break;
            //Si la casilla pulsada es la casilla de dirección Abajo
            case "Abajo":
                if (casilla.getSur() != '1') {
                    return false;
                }
                break;
            //Si la casilla pulsada es la casilla de dirección Izquierda    
            case "Izquierda":
                if (casilla.getOeste() != '1') {
                    return false;
                }
                break;

        }

        return true;

    }

    public void checkMeta(Casilla casilla) {
        if (tablero.isMeta(casilla)) {
            tablero.repaint();
            String options[] = {"ACEPTAR"};
            JOptionPane.showOptionDialog(null, "¡¡HAS GANADO!!", " ", -1, 1, null,
                    options, options[0]);
            Random r=new Random();
            switch(r.nextInt(3)+1){
                case 1:
                    mapa="maze1.txt";
                    tablero.Inicializar(mapa);
                    break;
                case 2:
                    mapa="maze2.txt";
                    tablero.Inicializar(mapa);
                    break;
                case 3:
                    mapa="maze3.txt";
                    tablero.Inicializar(mapa);
                    break;
                case 4:
                    mapa="maze4.txt";
                    tablero.Inicializar(mapa);
                    break;
            }
            tablero.Inicializar(mapa);
            introducirBola(tablero);
        }
    }

}
