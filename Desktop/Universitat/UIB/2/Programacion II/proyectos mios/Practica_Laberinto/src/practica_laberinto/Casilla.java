
/*
 * CLASE Casilla

realización: Juan Montes de Oca
*/

package practica_laberinto;

class Casilla {
    //DECLARACIÓN DE ATRIBUTOS
    private boolean ocupada,salida;
    private char norte,sur,este,oeste;
    private  int x,y;
    
    //MÉTODOS CONSTRUCTORES
    public Casilla() {
        ocupada=false;
        salida=false;
    }
    
    public Casilla(int x,int y) {
        ocupada=false;
        salida=false;
        this.x=x;
        this.y=y;
    }   
    
    //MÉTODO QUE LIBERA UNA CASILLA
    public void setLiberada() {
        ocupada=false;
    }
    
    //MÉTODO QUE DEVUELVE EL ESTADO DE UNA CASILLA
    public boolean estado() {
        return ocupada;
    }
    
    //MÉTODO QUE CAMBIA EL ESTADO A OCUPADA DE UNA CASILLA 
    public void setOcupada() {
        ocupada=true;
    }
    
    //MÉTODO QUE CAMCIA EL ESTADO DE UNA CASILLA
    public void cambiarEstado() {
        ocupada=!ocupada;
    }
    
    //MÉTODO DE MODIFICA LA COORDENADA X DE UNA CASILLA
    public void setX(int x) {
        this.x=x;
    }
    
    //MÉTODO DE MODIFICA LA COORDENADA Y DE UNA CASILLA
    public void setY(int y) {
        this.y=y;
    }  
    
    //MÉTODO DE DA ACCESO A LA COORDENADA X DE UNA CASILLA
    public int getX() {
        return x;
    }
    
    //MÉTODO DE DA ACCESO A LA COORDENADA Y DE UNA CASILLA
    public int getY() {
        return y;
    }    

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public char getNorte() {
        return norte;
    }

    public void setNorte(char norte) {
        this.norte = norte;
    }

    public char getSur() {
        return sur;
    }

    public void setSur(char sur) {
        this.sur = sur;
    }

    public char getEste() {
        return este;
    }

    public void setEste(char este) {
        this.este = este;
    }

    public char getOeste() {
        return oeste;
    }

    public void setOeste(char oeste) {
        this.oeste = oeste;
    }
    
    @Override
    public String toString(){
        return "Norte: " + norte + " este: " + este+ " sur: " + sur  + " oeste: " + oeste;
    }

    public boolean isSalida() {
        return salida;
    }

    public void setSalida(boolean salida) {
        this.salida = salida;
    }
    
    

}
