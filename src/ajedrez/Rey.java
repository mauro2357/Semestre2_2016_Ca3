package ajedrez;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 * Es un tipo de ficha en la cual se realizan sus respectivas acciones
 * @author Julián Carvajal Montoya
 * @author Alejandro Castañeda Ramírez
 */
public class Rey extends Ficha {
    public Rey(int PosicionX, int PosicionY, String Signo, int Color) {
        super(PosicionX, PosicionY, Signo, Color);
    }
    Icon Rey = new ImageIcon("C:\\Users\\SONY\\Documents\\NetBeansProjects\\Ajedrez\\Rey.png");
    Icon ReyX = new ImageIcon("C:\\Users\\SONY\\Documents\\NetBeansProjects\\Ajedrez\\ReyX.png"); 
    public void Enroque(boolean Validar, String Y, int X){
        if (Validar) {
            JOptionPane.showMessageDialog(null, "El enroque no se puede realizar");
        }
    }
    /**
    * Realiza el movimiento del Peón de acuerdo a sus restricciones, modificando si se puede su posición en TableroMaquina y TableroInter
    * sobrescribiendo el método de ficha.
    * @param A varibale tipo Ajedrez para la llamada de métodos
    * @param Y String de la posición en Y a donde se desea mover.
    * @param X Entero de la Posición en X a donde se desea mover. 
    */
    @Override
    public void Movimiento(Ajedrez A, String Y, int X) {
        if ((this.ConvertirLetra(Y)<0)|| (X<0 && X>7)) {
            JOptionPane.showMessageDialog(null, "La Posición ingresada no es correcta, "
                    + "está por fuera del rango del tablero  por favor intente de nuevo","Información",JOptionPane.WARNING_MESSAGE,ReyX);
            return;
        }       
        int CY = this.ConvertirLetra(Y);
        int CX = X-1;
        if (A.getTableroMaquina()[CY][CX]!= null && A.getTableroMaquina()[CY][CX].getColor() == this.getColor()) {
            JOptionPane.showMessageDialog(null, "Ten Cuidado, el Rey no se puede mover así","Información",JOptionPane.WARNING_MESSAGE,ReyX);
            return;    
        }
        // Movimiento ARriba o abajo
        if ((CX == this.getPosicionX() && (CY - 1 == this.getPosicionY() || CY+1 == this.getPosicionY()))) {
            A.getTableroMaquina()[this.getPosicionY()][this.getPosicionX()] = null;
            A.getTableroInter()[this.getPosicionY()][this.getPosicionX()] = null;
            this.setPosicionX(CX);
            this.setPosicionY(CY);
            A.getTableroInter()[this.getPosicionY()][this.getPosicionX()] = this.getSigno();
            A.getTableroMaquina()[this.getPosicionY()][this.getPosicionX()] = this; 
            JOptionPane.showMessageDialog(null, "¡Felicitaciones! Movimiento hecho con éxito","Información",JOptionPane.WARNING_MESSAGE,Rey);
            A.TableroString();
            return;    
        }
        // Movimiento Derehca o Izquierda
        if ((CY == this.getPosicionY())&&(CX - 1 == this.getPosicionX() || CX+1 == this.getPosicionX())) {
            A.getTableroMaquina()[this.getPosicionY()][this.getPosicionX()] = null;
            A.getTableroInter()[this.getPosicionY()][this.getPosicionX()] = null;
            this.setPosicionX(CX);
            this.setPosicionY(CY);
            A.getTableroInter()[this.getPosicionY()][this.getPosicionX()] = this.getSigno();
            A.getTableroMaquina()[this.getPosicionY()][this.getPosicionX()] = this; 
            JOptionPane.showMessageDialog(null, "¡Felicitaciones! Movimiento hecho con éxito","Información",JOptionPane.WARNING_MESSAGE,Rey);
            A.TableroString();
            return; 
        }
        //Movimiento Diagonales Arriba
        if ((CX-1 == this.getPosicionX() && CY+1 == this.getPosicionY())||(CX+1 == this.getPosicionX() 
                && CY+1 == this.getPosicionY())) {
            A.getTableroMaquina()[this.getPosicionY()][this.getPosicionX()] = null;
            A.getTableroInter()[this.getPosicionY()][this.getPosicionX()] = null;
            this.setPosicionX(CX);
            this.setPosicionY(CY);
            A.getTableroInter()[this.getPosicionY()][this.getPosicionX()] = this.getSigno();
            A.getTableroMaquina()[this.getPosicionY()][this.getPosicionX()] = this; 
            JOptionPane.showMessageDialog(null, "¡Felicitaciones! Movimiento hecho con éxito","Información",JOptionPane.WARNING_MESSAGE,Rey);
            A.TableroString();
            return; 
        }
        //Movimiento Diagonales Abajo
        if ((CX-1 == this.getPosicionX() && CY-1 == this.getPosicionY())||(CX+1 == this.getPosicionX() 
                && CY-1 == this.getPosicionY())) {
            A.getTableroMaquina()[this.getPosicionY()][this.getPosicionX()] = null;
            A.getTableroInter()[this.getPosicionY()][this.getPosicionX()] = null;
            this.setPosicionX(CX);
            this.setPosicionY(CY);
            A.getTableroInter()[this.getPosicionY()][this.getPosicionX()] = this.getSigno();
            A.getTableroMaquina()[this.getPosicionY()][this.getPosicionX()] = this; 
            JOptionPane.showMessageDialog(null, "¡Felicitaciones! Movimiento hecho con éxito","Información",JOptionPane.WARNING_MESSAGE,Rey);
            A.TableroString();
            return; 
        }
        JOptionPane.showMessageDialog(null, "Ten Cuidado, el Rey no se puede mover así","Información",JOptionPane.WARNING_MESSAGE,ReyX);
        return; 
    }    
    /**
    * Muestra los posibles movimientos que tiene el peón según sus restricciones, modicando el TableroInter
    * @param A 
    */
    @Override
    public void MostrarMovimiento(Ajedrez A) {
        int CX = this.getPosicionX();
        int CY = this.getPosicionY();
        try {
           if(A.getTableroMaquina()[CY-1][CX+1] == null || (A.getTableroMaquina()[CY-1][CX+1] != null && A.getTableroMaquina()[CY-1][CX+1].getColor() != this.getColor())){
               A.getTableroInter()[CY-1][CX+1] = " X ";
           }
        } catch (Exception e) {
        }
        try {
           if(A.getTableroMaquina()[CY-1][CX-1] == null || (A.getTableroMaquina()[CY-1][CX-1] != null && A.getTableroMaquina()[CY-1][CX-1].getColor() != this.getColor())){
               A.getTableroInter()[CY-1][CX-1] = " X ";
           }
        } catch (Exception e) {
        }
        try {
           if(A.getTableroMaquina()[CY+1][CX+1] == null || (A.getTableroMaquina()[CY+1][CX+1] != null && A.getTableroMaquina()[CY+1][CX+1].getColor() != this.getColor())){
               A.getTableroInter()[CY+1][CX+1] = " X ";
           }
        } catch (Exception e) {
        }
        try {
           if(A.getTableroMaquina()[CY+1][CX-1] == null || (A.getTableroMaquina()[CY+1][CX-1] != null && A.getTableroMaquina()[CY+1][CX-1].getColor() != this.getColor())){
               A.getTableroInter()[CY+1][CX-1] = " X ";
           }
        } catch (Exception e) {
        }
        try {
           if(A.getTableroMaquina()[CY-1][CX] == null || (A.getTableroMaquina()[CY-1][CX] != null && A.getTableroMaquina()[CY-1][CX].getColor() != this.getColor())){
               A.getTableroInter()[CY-1][CX] = " X ";
           }
        } catch (Exception e) {
        }
        try {
           if(A.getTableroMaquina()[CY+1][CX] == null || (A.getTableroMaquina()[CY+1][CX] != null && A.getTableroMaquina()[CY+1][CX].getColor() != this.getColor())){
               A.getTableroInter()[CY+1][CX] = " X ";
           }
        } catch (Exception e) {
        }
        try {
           if(A.getTableroMaquina()[CY][CX+1] == null || (A.getTableroMaquina()[CY][CX+1] != null && A.getTableroMaquina()[CY][CX+1].getColor() != this.getColor())){
               A.getTableroInter()[CY][CX+1] = " X ";
           }
        } catch (Exception e) {
        }
        try {
           if(A.getTableroMaquina()[CY][CX-1] == null || (A.getTableroMaquina()[CY][CX-1] != null && A.getTableroMaquina()[CY][CX-1].getColor() != this.getColor())){
               A.getTableroInter()[CY][CX-1] = " X ";
           }
        } catch (Exception e) {
        }
        A.TableroPosibles();
        A.ResetTableroString();      
    }       
}