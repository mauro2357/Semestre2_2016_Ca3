package ajedrez;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 * Es un tipo de ficha en la cual se realizan sus respectivas acciones
 * @author Julián Carvajal Montoya
 * @author Alejandro Castañeda Ramírez
 */
public class Torre extends Ficha {
    public Torre(int PosicionX, int PosicionY, String Signo, int Color) {
        super(PosicionX, PosicionY, Signo, Color);
    }
    Icon Torre = new ImageIcon("C:\\Users\\SONY\\Documents\\NetBeansProjects\\Ajedrez\\Torre.png");
    Icon TorreX = new ImageIcon("C:\\Users\\SONY\\Documents\\NetBeansProjects\\Ajedrez\\TorreX.png");
    /**
    * Realiza el movimiento de la Torre de acuerdo a sus restricciones, modificando si se puede su posición en TableroMaquina y TableroInter
    * sobrescribiendo el método de ficha.
    * @param A varibale tipo Ajedrez para la llamada de métodos
    * @param Y String de la posición en Y a donde se desea mover.
    * @param X Entero de la Posición en X a donde se desea mover. 
    */
    @Override
    public void Movimiento(Ajedrez A, String Y, int X) {
        int CX = X-1;
        int CY = this.ConvertirLetra(Y);
        if ((this.ConvertirLetra(Y)<0)|| (X<0 && X>7)) {
            JOptionPane.showMessageDialog(null, "La Posición ingresada no es correcta, "
                    + "está por fuera del rango del tablero  por favor intente de nuevo");
            return;
        }
        if (CX != this.getPosicionX() && CY != this.getPosicionY() ) {
            JOptionPane.showMessageDialog(null, "Ten cuidad, La torre no se mueve así","Información",JOptionPane.WARNING_MESSAGE,TorreX);
            return;
        }
        if( A.getTableroMaquina()[CY][CX]!= null && A.getTableroMaquina()[CY][CX].getColor()== this.getColor()){
            JOptionPane.showMessageDialog(null, "La Torre no puede hacer este movimiento, intenta de nuevo","Información",JOptionPane.WARNING_MESSAGE,TorreX);            
            return;
        }  
        if (CX == this.getPosicionX() && CY != this.getPosicionY()) {
            if (CY < this.getPosicionY()) {       
                for (int i = this.getPosicionY()-1; i > CY; i--) {  
                    if (A.getTableroMaquina()[i][CX] != null ){
                        JOptionPane.showMessageDialog(null, "La Torre no puede hacer este movimiento, intenta de nuevo","Información",JOptionPane.WARNING_MESSAGE,TorreX);
                        return;
                    }
                }    
            }
            else{                   
                for (int i = this.getPosicionY()+1; i < CY ; ++i) {
                    if (A.getTableroMaquina()[i][CX] != null ){                       
                        JOptionPane.showMessageDialog(null, "La Torre no puede hacer este movimiento, intenta de nuevo","Información",JOptionPane.WARNING_MESSAGE,TorreX);
                        return;
                    } 
                }
            }
            A.getTableroMaquina()[this.getPosicionY()][this.getPosicionX()] = null;
            A.getTableroInter()[this.getPosicionY()][this.getPosicionX()] = null;
            this.setPosicionX(CX);
            this.setPosicionY(CY);
            A.getTableroMaquina()[this.getPosicionY()][this.getPosicionX()] = this;
            A.getTableroInter()[this.getPosicionY()][this.getPosicionX()] = this.getSigno();
            JOptionPane.showMessageDialog(null, "¡Felicitaciones! Movimiento hecho con éxito","Información",JOptionPane.WARNING_MESSAGE,Torre);
            A.TableroString();
            return;            
        }
        if (CX != this.getPosicionX() && CY == this.getPosicionY()) {
            if (CX < this.getPosicionX()) {       
                for (int i = this.getPosicionX()-1; i > CX; i--) {  
                    if (A.getTableroMaquina()[CY][i] != null ){
                        JOptionPane.showMessageDialog(null, "La Torre no puede hacer este movimiento, intenta de nuevo","Información",JOptionPane.WARNING_MESSAGE,TorreX);
                        return;
                    }
                }    
            }
            else{                   
                for (int i = this.getPosicionX()+1; i < CX ; ++i) {
                    if (A.getTableroMaquina()[CY][i] != null ){                       
                        JOptionPane.showMessageDialog(null, "La Torre no puede hacer este movimiento, intenta de nuevo","Información",JOptionPane.WARNING_MESSAGE,TorreX);
                        return;
                    } 
                }
            }
            A.getTableroMaquina()[this.getPosicionY()][this.getPosicionX()] = null;
            A.getTableroInter()[this.getPosicionY()][this.getPosicionX()] = null;
            this.setPosicionX(CX);
            this.setPosicionY(CY);
            A.getTableroMaquina()[this.getPosicionY()][this.getPosicionX()] = this;
            A.getTableroInter()[this.getPosicionY()][this.getPosicionX()] = this.getSigno();
            JOptionPane.showMessageDialog(null, "¡Felicitaciones! Movimiento hecho con éxito","Información",JOptionPane.WARNING_MESSAGE,Torre);
            A.TableroString();
            return;            
        }
    }   
    /**
    * Muestra los posibles movimientos que tiene la torre según sus restricciones, modicando el TableroInter
    * @param A 
    */
    @Override
    public void MostrarMovimiento(Ajedrez A) {
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
        A.TableroPosibles();
        A.ResetTableroString();
        return;    
    }    
}