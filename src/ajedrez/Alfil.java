package ajedrez;
import java.util.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 * Es un tipo de ficha en la cual se realizan sus respectivas acciones
 * @author Julián Carvajal Montoya
 * @author Alejandro Castañeda Ramírez
 */
public class Alfil extends Ficha {
    public Alfil(int PosicionX, int PosicionY, String Signo, int Color) {
        super(PosicionX, PosicionY, Signo, Color);
    }
    Icon Alfil = new ImageIcon("C:\\Users\\SONY\\Documents\\NetBeansProjects\\Ajedrez\\Alfil.png");
    Icon AlfilX = new ImageIcon("C:\\Users\\SONY\\Documents\\NetBeansProjects\\Ajedrez\\AlfilX.png");
    /**
     * Muestra los posibles movimientos que tiene el Alfil según sus restricciones, modicando el TableroInter
     * @param A 
     */
    @Override
    public void MostrarMovimiento(Ajedrez A) {
        int CX = this.getPosicionX();
        int CY = this.getPosicionY();
        int x = CX+1;
        int y = CY-1;
        while(y >=0 && x<=7 && A.getTableroMaquina()[y][x] == null){
            A.getTableroInter()[y][x] = " X ";
            x++;
            y--;
        }
        try {
            if(A.getTableroMaquina()[y][x].getColor()!= this.getColor()){
                A.getTableroInter()[y][x] = " X ";
            }
        } catch (Exception e) {
        }
        x = CX-1;
        y = CY-1;
        while(y >= 0 && x>=0 && A.getTableroMaquina()[y][x] == null){
            A.getTableroInter()[y][x] = " X ";
            x--;
            y--;
        }
        try {
            if(A.getTableroMaquina()[y][x].getColor()!= this.getColor()){
                A.getTableroInter()[y][x] = " X ";
            }
        } catch (Exception e) {
        }
        x = CX+1;
        y = CY+1;
        while(y<=7 && x<=7 && A.getTableroMaquina()[y][x] == null){
            A.getTableroInter()[y][x] = " X ";
            x++;
            y++;
        }
        try {
            if(A.getTableroMaquina()[y][x].getColor()!= this.getColor()){
                A.getTableroInter()[y][x] = " X ";
            }
        } catch (Exception e) {
        }
        x = CX-1;
        y = CY+1;
        while(y<=7 && x>=0 && A.getTableroMaquina()[y][x] == null){
            A.getTableroInter()[y][x] = " X ";
            x--;
            y++;
        }
        try {
            if(A.getTableroMaquina()[y][x].getColor()!= this.getColor()){
                A.getTableroInter()[y][x] = " X ";
            }
        } catch (Exception e) {
        }
        A.TableroPosibles();
        A.ResetTableroString();       
    }
    /** 
    * Realiza el movimiento del Alfil de acuerdo a sus restricciones, modificando si se puede su posición en TableroMaquina y TableroInter
    * sobrescribiendo el método de ficha.
    * @param A varibale tipo Ajedrez para la llamada de métodos
    * @param Y String de la posición en Y a donde se desea mover.
    * @param X Entero de la Posición en X a donde se desea mover. 
    */
    @Override
    public void Movimiento(Ajedrez A, String Y, int X) {
        int CY = this.ConvertirLetra(Y);
        int CX = X-1;
        if ((CY<0)|| (CX<0 && CX>7)) {
            JOptionPane.showMessageDialog(null, "La Posiciónn ingresada no es correcta, "
                    + "está¡ por fuera del rango del tablero  por favor intente de nuevo","Información",JOptionPane.WARNING_MESSAGE,AlfilX);
            return;
        }
        int MaxX = Math.max(this.getPosicionX(), CX);
        int MaxY = Math.max(this.getPosicionY(), CY);
        int MinX = Math.min(this.getPosicionX(), CX);
        int MinY = Math.min(this.getPosicionY(), CY);
        if((MaxX-MinX)!=(MaxY-MinY)){
            JOptionPane.showMessageDialog(null, "El alfil no puede realizar este movimiento","Información",JOptionPane.WARNING_MESSAGE,AlfilX);
            return;
        }
        if(CY<this.getPosicionY()){
            //VALIDAR SI ESTÁ OCUPADO DEECHA SUPERRIOR
            int y = this.getPosicionY()-1;
            for (int i = this.getPosicionX()+1; i < CX; i++){
                if (A.getTableroMaquina()[y][i] != null) {
                    JOptionPane.showMessageDialog(null, "El alfil No puede saltar Fichas","Información",JOptionPane.WARNING_MESSAGE,AlfilX);
                    return;
                }
                y--;
            }
           // VALIDAR SI ESTÁ OCUPADO IZQUIERDA SUPERIOR
            y = this.getPosicionY()-1;
            for (int i = this.getPosicionX()-1; i > CX; i--) {
                if (A.getTableroMaquina()[y][i] != null) {
                    JOptionPane.showMessageDialog(null, "El alfil No puede saltar Fichas","Información",JOptionPane.WARNING_MESSAGE,AlfilX);
                    return;
                }
                y--;            
            }
        }
        if(CY>this.getPosicionY()){
        // VALIDAR SI ESTÁ OCUPADO INFERIOR DERECHA
            int y = this.getPosicionY()+1;
            for (int i = this.getPosicionX()+1; i < CX; i++) {
                if (A.getTableroMaquina()[y][i]!=null) {
                    JOptionPane.showMessageDialog(null, "El alfil no puede saltar Fichas","Información",JOptionPane.WARNING_MESSAGE,AlfilX);
                    return;
                }
                y++;
            }
            // VALIDAR SI ESTÁ OCUPADO INFERIOR IZQUIERDA
            y = this.getPosicionY()+1;
            for (int i = this.getPosicionX()-1; i > CX; i--) {
                if (A.getTableroMaquina()[y][i]!= null) {
                    JOptionPane.showMessageDialog(null, "El alfil no puede saltar Fichas","Información",JOptionPane.WARNING_MESSAGE,AlfilX);
                    return;
                }
                y++;
            }
        }
        if (A.getTableroMaquina()[CY][CX]!=null) {
            if (A.getTableroMaquina()[CY][CX].getColor() == this.getColor()) {
                JOptionPane.showMessageDialog(null, "No puedes comer fichas del mismo color","Información",JOptionPane.WARNING_MESSAGE,AlfilX);
                return;
            } 
        }
        A.getTableroMaquina()[this.getPosicionY()][this.getPosicionX()] = null;
        A.getTableroInter()[this.getPosicionY()][this.getPosicionX()] = null;
        this.setPosicionX(CX);
        this.setPosicionY(CY);
        A.getTableroMaquina()[this.getPosicionY()][this.getPosicionX()] = this;
        A.getTableroInter()[this.getPosicionY()][this.getPosicionX()] = this.getSigno();
        JOptionPane.showMessageDialog(null, "¡Felicitaciones! Movimiento hecho con éxito","Información",JOptionPane.WARNING_MESSAGE,Alfil);
        A.TableroString();
        return;
    }   
}
