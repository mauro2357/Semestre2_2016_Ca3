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
public class Peon extends Ficha {
    public Peon(int PosicionX, int PosicionY, String Signo, int Color) {
        super(PosicionX, PosicionY, Signo, Color);
    }
    Icon Peon = new ImageIcon("C:\\Users\\SONY\\Documents\\NetBeansProjects\\Ajedrez\\Peon.png");
    Icon PeonX = new ImageIcon("C:\\Users\\SONY\\Documents\\NetBeansProjects\\Ajedrez\\PeonX.png");              
    /**
     * Revisa si puede cambiar su movimiento para eliminar una ficha de color contrario
     * @param A varibale tipo Ajedrez para la llamada de métodos
     * @param Y String de la posición en Y a donde se desea mover.
     * @param X Entero de la Posición en X a donde se desea mover.
     */
    public void Commer(Ajedrez A,String Y, int X)
    {
        int CY = this.ConvertirLetra(Y);
        int CX = X-1;
        if ((A.getTableroMaquina()[CY][CX].getColor()) != this.getColor()) {
           A.getTableroMaquina()[CY][CX] = null; 
           A.getTableroMaquina()[this.getPosicionY()][this.getPosicionX()] = null;
           A.getTableroInter()[this.getPosicionY()][this.getPosicionX()] = null;
           this.setPosicionX(CX);
           this.setPosicionY(CY);
           A.getTableroInter()[this.getPosicionY()][this.getPosicionX()] = this.getSigno();
           A.getTableroMaquina()[this.getPosicionY()][this.getPosicionX()] = this; 
           JOptionPane.showMessageDialog(null, "¡Felicitaciones! Movimiento hecho con éxito","Información",JOptionPane.WARNING_MESSAGE,Peon);
           System.out.flush();
           A.TableroString();
           return;
        }
        else{
            JOptionPane.showMessageDialog(null, "No coma fichas iguales","Información",JOptionPane.WARNING_MESSAGE,PeonX);
            return;
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
    public void Movimiento(Ajedrez A,String Y,int X) {
        if ((this.ConvertirLetra(Y)<0)|| (X<0 && X>7)) {
            JOptionPane.showMessageDialog(null, "La Posición ingresada no es correcta, "
                    + "está por fuera del rango del tablero  por favor intente de nuevo");
            return;
        }
        int CY = this.ConvertirLetra(Y);
        int CX = X-1;
        if ((A.getTableroMaquina()[CY][CX] != null) &&
                (CY+1 == this.getPosicionY())&&(CX-1 == this.getPosicionX() || CX+1 == this.getPosicionX())) {
            this.Commer(A, Y, X);
            return;
        }
        if ((A.getTableroMaquina()[CY][CX] != null) &&
                (CY-1 == this.getPosicionY())&&(CX-1 == this.getPosicionX() || CX+1 == this.getPosicionX())) {
            this.Commer(A, Y, X);
            return;
        }
        if(A.getTableroMaquina()[CY][CX] != null){
            JOptionPane.showMessageDialog(null,"Vuelvase serio, está ocupado","Información",JOptionPane.WARNING_MESSAGE,PeonX);
            return;
        }        
        if (this.getColor() == A.getNegro()) {
            if((CY < 0) || (CX<0) ||(CX>8)){
                JOptionPane.showMessageDialog(null, "¡ALERTA!\n"+"No sea hpta y juegue bien","Información",JOptionPane.WARNING_MESSAGE,PeonX);
                return;
            }
            if (((CY == this.getPosicionY()-1)||(CY == this.getPosicionY()-2))&& (this.getPosicionX() == CX)) {
                if (this.getPosicionY() == 6) {
                    A.getTableroMaquina()[this.getPosicionY()][this.getPosicionX()] = null;
                    A.getTableroInter()[this.getPosicionY()][this.getPosicionX()] = null;
                    this.setPosicionX(CX);
                    this.setPosicionY(CY);
                    A.getTableroMaquina()[this.getPosicionY()][this.getPosicionX()] = this;
                    A.getTableroInter()[this.getPosicionY()][this.getPosicionX()] = this.getSigno();
                    JOptionPane.showMessageDialog(null, "¡Felicitaciones! Movimiento hecho con éxito","Información",JOptionPane.WARNING_MESSAGE,Peon);
                    System.out.flush();
                    A.TableroString();
                    return;
                }
                else{
                    if (CY == this.getPosicionY()-1) {
                        A.getTableroMaquina()[this.getPosicionY()][this.getPosicionX()] = null;
                        A.getTableroInter()[this.getPosicionY()][this.getPosicionX()] = null;
                        this.setPosicionX(CX);
                        this.setPosicionY(CY);
                        A.getTableroMaquina()[this.getPosicionY()][this.getPosicionX()] = this;
                        A.getTableroInter()[this.getPosicionY()][this.getPosicionX()] = this.getSigno();
                        JOptionPane.showMessageDialog(null, "¡Felicitaciones! Movimiento hecho con éxito","Información",JOptionPane.WARNING_MESSAGE,Peon);                      
                        A.TableroString();
                        return;                        
                    }
                    JOptionPane.showMessageDialog(null, "POSICIÓN INVALIDA, INTENTE DE NUEVO","Información",JOptionPane.WARNING_MESSAGE,PeonX);
                    return;
                }  
            }
            JOptionPane.showMessageDialog(null, "POSICIÓN INVALIDA, INTENTE DE NUEVO","Información",JOptionPane.WARNING_MESSAGE,PeonX);
            return;            
        }
        // AQUÍ ES EL MOVIMIENTO PARA BLANCOS
        if (this.getColor() == A.getBlanco()) {
            if((CY < 0) || (CX<0) ||(CX>8)){
                JOptionPane.showMessageDialog(null, "¡ALERTA!\n"+"No sea hpta y juegue bien","Información",JOptionPane.WARNING_MESSAGE,PeonX);
                return;
            }
            if (((CY-1 == this.getPosicionY())||(CY -2 == this.getPosicionY()))&& (this.getPosicionX() == CX)) {
                if (this.getPosicionY() == 1) {
                    A.getTableroMaquina()[this.getPosicionY()][this.getPosicionX()] = null;
                    A.getTableroInter()[this.getPosicionY()][this.getPosicionX()] = null;
                    this.setPosicionX(CX);
                    this.setPosicionY(CY);
                    A.getTableroMaquina()[this.getPosicionY()][this.getPosicionX()] = this;
                    A.getTableroInter()[this.getPosicionY()][this.getPosicionX()] = this.getSigno();
                    JOptionPane.showMessageDialog(null, "¡Felicitaciones! Movimiento hecho con éxito","Información",JOptionPane.WARNING_MESSAGE,Peon);                    
                    A.TableroString();
                    return;
                }
                else{
                    if (CY-1 == this.getPosicionY()) {
                        A.getTableroMaquina()[this.getPosicionY()][this.getPosicionX()] = null;
                        A.getTableroInter()[this.getPosicionY()][this.getPosicionX()] = null;
                        this.setPosicionX(CX);
                        this.setPosicionY(CY);
                        A.getTableroMaquina()[this.getPosicionY()][this.getPosicionX()] = this;
                        A.getTableroInter()[this.getPosicionY()][this.getPosicionX()] = this.getSigno();
                        JOptionPane.showMessageDialog(null, "¡Felicitaciones! Movimiento hecho con éxito","Información",JOptionPane.WARNING_MESSAGE,Peon);                        
                        A.TableroString();
                        return;                        
                    }
                    JOptionPane.showMessageDialog(null, "POSICIÓN INVALIDA, INTENTE DE NUEVO","Información",JOptionPane.WARNING_MESSAGE,PeonX);
                    return;
                }  
            }
            JOptionPane.showMessageDialog(null, "POSICIÓN INVALIDA, INTENTE DE NUEVO","Información",JOptionPane.WARNING_MESSAGE,PeonX);
            return;            
        }     
    }
    /**
     * Muestra los posibles movimientos que tiene el peón según sus restricciones, modicando el TableroInter
     * @param A Variable de tipo Ajedrez
     */
    @Override
    public void MostrarMovimiento(Ajedrez A) {
        int CX = this.getPosicionX();
        int CY = this.getPosicionY();
        try {
            if (A.getTableroMaquina()[CY-1][CX-1]!= null && this.getColor() == A.getNegro()) {
                A.getTableroInter()[CY-1][CX-1]= " X ";
            }            
        } catch (Exception e) {
        }
        try {
            if (A.getTableroMaquina()[CY-1][CX+1]!= null && this.getColor() == A.getNegro()) {
                A.getTableroInter()[CY-1][CX+1]= " X ";
            }            
        } catch (Exception e) {
        }
        try {
            if (A.getTableroMaquina()[CY+1][CX-1]!= null && this.getColor() == A.getBlanco()) {
                A.getTableroInter()[CY+1][CX-1]= " X ";
            }
        } catch (Exception e) {
        }
        try {
            if (A.getTableroMaquina()[CY+1][CX+1]!= null && this.getColor() == A.getBlanco()) {
                A.getTableroInter()[CY+1][CX+1]= " X ";
            }            
        } catch (Exception e) {
        }     
        if ( CY == 6 && this.getColor() == A.getNegro()) {
            A.getTableroInter()[5][CX] = " X ";
            A.getTableroInter()[4][CX] = " X ";
        }
        try {
            if (CY != 6 && this.getColor() == A.getNegro()) {
                A.getTableroInter()[CY-1][CX] = " X ";
            }            
        } catch (Exception e) {
        }        
        if ( CY == 1 && this.getColor() == A.getBlanco()) {
            A.getTableroInter()[2][CX] = " X ";
            A.getTableroInter()[3][CX] = " X ";
        }
        try {
            if (CY != 1 && this.getColor() == A.getBlanco()) {
                A.getTableroInter()[CY+1][CX] = " X ";
            }            
        } catch (Exception e) {
        }           
        A.TableroPosibles();
        A.ResetTableroString();
        return;
    } 
}