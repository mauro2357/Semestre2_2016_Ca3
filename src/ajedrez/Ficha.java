package ajedrez;
/**
 * Clase Abstracta que contiene todos los metodos en común que tiene cada ficha en especial
 * @author Julian Carvajal Montoya
 * @author  Alejandro Castañeda
 */
public abstract class Ficha {    
    private int PosicionX;
    private int PosicionY;
    private String Signo;
    private int Color;
    /**
     * Constructor de todas las fichas
     * @param PosicionX Entero de la posición que estará en el TableroMaquina y TableroInter en la cordenada X
     * @param PosicionY String de la posición que estará en el TableroMaquina y TableroInter en la cordenada Y
     * @param Signo String que representa cada Ficha en el TableroMaquina y TableroInter
     * @param Color Entero que determina el color de cada ficha
     */
    public Ficha(int PosicionX, int PosicionY,String Signo,int Color) {
        this.PosicionX = PosicionX;
        this.PosicionY = PosicionY;
        this.Signo = Signo;
        this.Color = Color;
    }
    /**
     * Mueve la ficha de acuerdo a su tipo
     * @param A Variable Tipo Ajedrez, para la aplicación de ciertos métodos
     * @param Y Cordenada en Y del tablero representado por un String para luego ser convertido en entero
     * @param X Cordenada en X del tablero representado por se mayor una unidad a la posición verdadera 
     */
    public abstract void Movimiento(Ajedrez A, String Y,int X);
    /**
     * Muestra los posibles movimientos de cada tipo de ficha
     * @param A Variable Ajedrez para la llamada de ciertos métodos. 
     */
    public abstract void MostrarMovimiento(Ajedrez A);       
     /**
     * Convierte la Cordenada en Y del tablero(letra del alfabeto) a un numero entero.
     * @param L Cordenada en Y del tablero
     * @return Entero significando la posición en y de la ficha que se quiere mover. Si la letra no está en el rango de "A" hasta "H" retorna -100, para sus respectivos cálculos.
     */
    public int ConvertirLetra(String L)
    {
        if(L.equals("A")) return 0;
        if(L.equals("B")) return 1;
        if(L.equals("C")) return 2;
        if(L.equals("D")) return 3;
        if(L.equals("E")) return 4;
        if(L.equals("F")) return 5;
        if(L.equals("G")) return 6;
        if(L.equals("H")) return 7;
        return -100;         
    }
    /**
     * Modifica la posición en X de la ficha
     * @param PosicionX Nuevo valor de la variable en X
     */
    public void setPosicionX(int PosicionX) {
        this.PosicionX = PosicionX;
    }
    /**
     * Modifica la posición en Y de la ficha
     * @param PosicionY Nuevo valor de la variable en Y
     */
    public void setPosicionY(int PosicionY) {
        this.PosicionY = PosicionY;
    }
    /**
     * Devuelve la Posición en X de la ficha actual
     * @return Entero 
     */
    public int getPosicionX() {
        return PosicionX;
    }
    /**
     * Devuelve La posición en Y de la ficha actual
     * @return Entero
     */
    public int getPosicionY() {
        return PosicionY;
    }
    /**
     * Devuelve el valor en letras de cada ficha
     * @return String
     */
    public String getSigno() {
        return Signo;
    }
    /**
     * Devuelve el valor representativo del color
     * @return Entero
     */
    public int getColor() {
        return Color;
    }   
}