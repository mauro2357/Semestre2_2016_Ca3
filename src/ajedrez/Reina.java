/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * Es un tipo de ficha en la cual se realizan sus respectivas acciones
 * @author Julián Carvajal Montoya
 * @author Alejandro Castañeda Ramírez
 */
public class Reina extends Ficha {
    public Reina(int PosicionX, int PosicionY, String Signo, int Color) {
        super(PosicionX, PosicionY, Signo, Color);
    }
    Icon Reina = new ImageIcon("C:\\Users\\SONY\\Documents\\NetBeansProjects\\Ajedrez\\Reina.png");
    Icon ReinaX = new ImageIcon("C:\\Users\\SONY\\Documents\\NetBeansProjects\\Ajedrez\\ReinaX.png");
    /**
    * Verifica y si es posible mueve la reina de forma Diagonal
    * @param A varibale tipo Ajedrez para la llamada de métodos
    * @param Y String de la posición en Y a donde se desea mover.
    * @param X Entero de la Posición en X a donde se desea mover.
    */
    private void MovimientoDiagonal(Ajedrez A, String Y, int X){
        int CY = this.ConvertirLetra(Y);
        int CX = X-1;
        if ((CY<0)|| (CX<0 && CX>7)) {
            JOptionPane.showMessageDialog(null, "La Posicición ingresada no es correcta, "
                    + "está por fuera del rango del tablero  por favor intente de nuevo","Información",JOptionPane.WARNING_MESSAGE,ReinaX);
            return;
        }
        int MaxX = Math.max(this.getPosicionX(), CX);
        int MaxY = Math.max(this.getPosicionY(), CY);
        int MinX = Math.min(this.getPosicionX(), CX);
        int MinY = Math.min(this.getPosicionY(), CY);
        if((MaxX-MinX)!=(MaxY-MinY)){
            JOptionPane.showMessageDialog(null, "La Reina no puede realizar este movimiento","Información",JOptionPane.WARNING_MESSAGE,ReinaX);
            return;
        }
        if(CY<this.getPosicionY()){
            //VALIDAR SI ESTÁ OCUPADO DEECHA SUPERRIOR
            int y = this.getPosicionY()-1;
            for (int i = this.getPosicionX()+1; i < CX; i++){
                if (A.getTableroMaquina()[y][i] != null) {
                    JOptionPane.showMessageDialog(null, "La Reina No puede saltar Fichas","Información",JOptionPane.WARNING_MESSAGE,ReinaX);
                    return;
                }
                y--;
            }
           // VALIDAR SI ESTÁ OCUPADO IZQUIERDA SUPERIOR
            y = this.getPosicionY()-1;
            for (int i = this.getPosicionX()-1; i > CX; i--) {
                if (A.getTableroMaquina()[y][i] != null) {
                    JOptionPane.showMessageDialog(null, "La Reina No puede saltar Fichas","Información",JOptionPane.WARNING_MESSAGE,ReinaX);
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
                    JOptionPane.showMessageDialog(null, "La Reina No puede saltar Fichas","Información",JOptionPane.WARNING_MESSAGE,ReinaX);
                    return;
                }
                y++;
            }
            // VALIDAR SI ESTÁ OCUPADO INFERIOR IZQUIERDA
            y = this.getPosicionY()+1;
            for (int i = this.getPosicionX()-1; i > CX; i--) {
                if (A.getTableroMaquina()[y][i]!= null) {
                    JOptionPane.showMessageDialog(null, "La Reina No puede saltar Fichas","Información",JOptionPane.WARNING_MESSAGE,ReinaX);
                    return;
                }
                y++;
            }
        }
        if (A.getTableroMaquina()[CY][CX]!=null) {
            if (A.getTableroMaquina()[CY][CX].getColor() == this.getColor()) {
                JOptionPane.showMessageDialog(null, "No puedes comer fichas del mismo color","Información",JOptionPane.WARNING_MESSAGE,ReinaX);
                return;
            } 
        }
        A.getTableroMaquina()[this.getPosicionY()][this.getPosicionX()] = null;
        A.getTableroInter()[this.getPosicionY()][this.getPosicionX()] = null;
        this.setPosicionX(CX);
        this.setPosicionY(CY);
        A.getTableroMaquina()[this.getPosicionY()][this.getPosicionX()] = this;
        A.getTableroInter()[this.getPosicionY()][this.getPosicionX()] = this.getSigno();
        JOptionPane.showMessageDialog(null, "¡Felicitaciones! Movimiento hecho con éxito","Información",JOptionPane.WARNING_MESSAGE,Reina);
        A.TableroString();
        return;
    }
    /**
    * Verifica y si es posible mueve la reina de forma Horizontal o Vertical
    * @param A varibale tipo Ajedrez para la llamada de métodos
    * @param Y String de la posición en Y a donde se desea mover.
    * @param X Entero de la Posición en X a donde se desea mover.
    */
    private void MovimientoRecto(Ajedrez A, String Y, int X){
        int CX = X-1;
        int CY = this.ConvertirLetra(Y);
        if ((this.ConvertirLetra(Y)<0)|| (X<0 && X>7)) {
            JOptionPane.showMessageDialog(null, "La Posición ingresada no es correcta, "
                    + "está por fuera del rango del tablero  por favor intente de nuevo","Información",JOptionPane.WARNING_MESSAGE,ReinaX);
            return;
        }
        if (CX != this.getPosicionX() && CY != this.getPosicionY() ) {
            JOptionPane.showMessageDialog(null, "La Reina no puede realizar este movimiento","Información",JOptionPane.WARNING_MESSAGE,ReinaX);
            return;
        }
        if( A.getTableroMaquina()[CY][CX]!= null && A.getTableroMaquina()[CY][CX].getColor()== this.getColor()){
            JOptionPane.showMessageDialog(null, "La Reina no puede realizar este movimiento","Información",JOptionPane.WARNING_MESSAGE,ReinaX);            
            return;
        } 
        if (CX == this.getPosicionX() && CY != this.getPosicionY()) {
            if (CY < this.getPosicionY()) {       
                for (int i = this.getPosicionY()-1; i > CY; i--) {  
                    if (A.getTableroMaquina()[i][CX] != null ){
                        JOptionPane.showMessageDialog(null, "La Reina no puede realizar este movimiento","Información",JOptionPane.WARNING_MESSAGE,ReinaX);
                        return;
                    }
                }    
            }
            else{                   
                for (int i = this.getPosicionY()+1; i < CY ; ++i) {
                    if (A.getTableroMaquina()[i][CX] != null ){                       
                        JOptionPane.showMessageDialog(null, "La Reina no puede realizar este movimiento,\"Información\",JOptionPane.WARNING_MESSAGE,ReinaX");
                        return;
                    } 
                }
            }
            A.getTableroMaquina()[this.getPosicionY()][this.getPosicionX()] = null;
            A.getTableroInter()[this.getPosicionY()][this.getPosicionX()] = null;
            this.setPosicionX(CX);
            this.setPosicionY(CY);
            A.getTableroInter()[this.getPosicionY()][this.getPosicionX()] = this.getSigno();
            A.getTableroMaquina()[this.getPosicionY()][this.getPosicionX()] = this; 
            JOptionPane.showMessageDialog(null, "¡Felicitaciones! Movimiento hecho con éxito","Información",JOptionPane.WARNING_MESSAGE,Reina);
            A.TableroString();
            return;            
        }
        if (CX != this.getPosicionX() && CY == this.getPosicionY()) {
            if (CX < this.getPosicionX()) {
                for (int i = this.getPosicionX()-1; i > CX; i--) {  
                    if (A.getTableroMaquina()[CY][i] != null ){
                        JOptionPane.showMessageDialog(null, "La Reina no puede realizar este movimiento","Información",JOptionPane.WARNING_MESSAGE,ReinaX);
                        return;
                    }
                }    
            }
            else{                   
                for (int i = this.getPosicionX()+1; i < CX ; ++i) {
                    if (A.getTableroMaquina()[CY][i] != null ){                       
                        JOptionPane.showMessageDialog(null, "La Reina no puede realizar este movimiento","Información",JOptionPane.WARNING_MESSAGE,ReinaX);
                        return;
                    } 
                }
            }
            A.getTableroMaquina()[this.getPosicionY()][this.getPosicionX()] = null;
            A.getTableroInter()[this.getPosicionY()][this.getPosicionX()] = null;
            this.setPosicionX(CX);
            this.setPosicionY(CY);
            A.getTableroInter()[this.getPosicionY()][this.getPosicionX()] = this.getSigno();
            A.getTableroMaquina()[this.getPosicionY()][this.getPosicionX()] = this; 
            JOptionPane.showMessageDialog(null, "¡Felicitaciones! Movimiento hecho con éxito","Información",JOptionPane.WARNING_MESSAGE,Reina);
            A.TableroString();
            return;            
        }
    }
    /**
     * Encargado de mostrar los posibles movimientos de forma diagonal de la Reina
     * @param A 
     */
    private void MovimientoDiagonal(Ajedrez A){
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
        return;
       
    }
    /**
     * Encargado de mostrar los posibles movimientos de forma Horizontal o Vertical de la Reina
     * @param A 
     */
    private void MovimientoRecto(Ajedrez A){
        int CX = this.getPosicionX();
        int CY = this.getPosicionY();
        int i = 0;
        if(CY-1 >= 0){
            i = CY-1;
            while(i>=0 && A.getTableroMaquina()[i][CX] == null){
                A.getTableroInter()[i][CX] = " X ";
                i--;
            }
            if(i>= 0){
                if (A.getTableroMaquina()[i][CX] != null && A.getTableroMaquina()[i][CX].getColor() != this.getColor()) {
                    A.getTableroInter()[i][CX] = " X ";
                }
            }
        }
        if(CY+1 <= 7){
            i = CY+1;
            while(i<=7 && A.getTableroMaquina()[i][CX] == null){
                A.getTableroInter()[i][CX] = " X ";
                i++;            
            }
            if (i<=7){
                if (A.getTableroMaquina()[i][CX] != null && A.getTableroMaquina()[i][CX].getColor() != this.getColor()) {
                    A.getTableroInter()[i][CX] = " X ";
                }
            }
        }
        // AQUÍ LOS MOVIMIENTOS HACIA LOS LADOS
        if(CX-1 >=0){
            i = CX-1;
            while(i>=0 && A.getTableroMaquina()[CY][i] == null){
                A.getTableroInter()[CY][i] = " X ";
                i--;
            }
            if(i>= 0){
                if (A.getTableroMaquina()[CY][i] != null && A.getTableroMaquina()[CY][i].getColor() != this.getColor()) {
                    A.getTableroInter()[CY][i] = " X ";
                }
            }
        }
        if(CX +1 <= 7){
            i = CX+1;
            while( i<=7 && A.getTableroMaquina()[CY][i] == null){
                A.getTableroInter()[CY][i] = " X ";
                i++;
            }
            if (i<=7){
                if (A.getTableroMaquina()[CY][i] != null && A.getTableroMaquina()[CY][i].getColor() != this.getColor()) {
                    A.getTableroInter()[CY][i] = " X ";
                }
            }
        }
        return;
        
    }
    
    /**
     * Muestra los posibles movimientos que tiene la Reina según sus restricciones, modicando el TableroInter
     * @param A 
     */
    @Override
    public void MostrarMovimiento(Ajedrez A) {
        this.MovimientoRecto(A);
        this.MovimientoDiagonal(A);
        A.TableroPosibles();
        A.ResetTableroString();
    }
    /**
    * Realiza el movimiento de la Reina de acuerdo a sus restricciones, modificando si se puede su posición en TableroMaquina y TableroInter
    * sobrescribiendo el método de ficha.
    * @param A varibale tipo Ajedrez para la llamada de métodos
    * @param Y String de la posición en Y a donde se desea mover.
    * @param X Entero de la Posición en X a donde se desea mover. 
    */
    @Override
    public void Movimiento(Ajedrez A, String Y, int X) {
        int CX = X-1;
        int CY = this.ConvertirLetra(Y);
        if (CX == this.getPosicionX() && CY != this.getPosicionY()) {
            this.MovimientoRecto(A, Y, X);
            return;
        }
        if (CY == this.getPosicionY() && CX != this.getPosicionX()) {
            this.MovimientoRecto(A, Y, X);
            return;
        }
        this.MovimientoDiagonal(A, Y, X);
        return;
    }
}
