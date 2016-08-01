package ajedrez;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 * Contiene El tablero de Juego, el tablero de los posibles movimientos,
 * color de ficha representado por valores enteros 1 y 0, variables constantes no modificables
 * @author Julián Carvajal Montoya
 * @author Alejandro Castañeda Ramírez
 */
public class Ajedrez {           
    private final int Blanco = 0;
    private final int Negro = 1;
    private Ficha tableroMaquina[][] = new Ficha[8][8];
    private String[][] tableroInter = new String[8][8];
    private final String[] PosicionLetras = {" ", "A", "B", "C", "D", "E", "F", "G", "H"};
    /**
    * Constructor por defecto utilizado para la invocación de métodos.
    */
    public Ajedrez(){}
    /**
     * Devuelve un valor que respresenta el color blanco
     * @return Un entero constante 0.
     */
    public int getBlanco() {
        return Blanco;
    }
    /**
     * Devuelve un valor que respresenta el color Negro
     * @return Un entero constante 1.     
     */
    public int getNegro() {
        return Negro;
    }
    /**
     * Devuelve el tablero donde se hará una representación de los posibles movimientos de una ficha determinada
     * @return matriz de 8x8 con valores string
     */
    public String[][] getTableroInter() {
        return tableroInter;
    }
    /**
     * Dibuja un tablero de ajedrez en la consola mostrando los posibles movimientos de 
     * determinada ficha, es decir dibuja la matriz de String: TableroInter
     */
    public void TableroPosibles()
    {
        System.out.println("Te recordamos que este tablero no es el"
                          + " original solo es un tablero\n"
                          + " con los posiles movimientos");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if ( i == 0) {
                    if(j<8)
                    {
                        if (i == 0 && j == 0) 
                            System.out.print("  ");                                                        
                        else
                            System.out.print("  "+(j)+"  ");                        
                    }
                    else 
                        System.out.println("  "+(j)+"  \n");                   
                }
                else
                {
                    if (j == 0) 
                        System.out.print(PosicionLetras[i]+"  ");
                    else
                    {
                        if (tableroInter[i-1][j-1] != null) {
                            if(j == 8)
                                System.out.println(" "+tableroInter[i-1][j-1]+" \n");
                            else
                                System.out.print(" "+tableroInter[i-1][j-1]+" ");                            
                        }
                        else 
                        {
                            if (j == 8)
                                System.out.println("  *  \n");
                            else
                                System.out.print("  *  ");
                        }                        
                    }                    
                }                          
            }
        }
        return;
    }
    /**
     * Determina si existe los dos reyes en el tablero, para dar o no por terminado el Juego
     * @return 2 si están los dos reyes
     * @return 1 si está solo un rey
     */
    public int RevisarRey(){
        int cont= 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (this.tableroMaquina[i][j]!= null && this.tableroMaquina[i][j] instanceof Rey ) 
                   cont++;                 
            }           
        }
        return cont;
    }
    /**
     * Dibuja el tablero de juego en la consola, con sus respectivas fichas actualizados.
     * es decir dibuja el TableroMaquina[][]
     */
    public void TableroString()
    {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if ( i == 0) {
                    if(j<8)
                    {
                        if (i == 0 && j == 0) 
                            System.out.print("  ");                                                    
                        else 
                            System.out.print("  "+(j)+"  ");                        
                    }
                    else 
                        System.out.println("  "+(j)+"  \n");                   
                }
                else
                {
                    if (j == 0)
                        System.out.print(PosicionLetras[i]+"  ");
                    else
                    {
                        if (tableroMaquina[i-1][j-1] != null) {
                            if(j == 8)System.out.println(" "+tableroMaquina[i-1][j-1].getSigno()+" \n");
                            else System.out.print(" "+tableroMaquina[i-1][j-1].getSigno()+" ");                            
                        }
                        else 
                        {
                            if (j == 8)
                                System.out.println("  *  \n");
                            else
                                System.out.print("  *  ");
                        }                        
                    }                    
                }                          
            }
        }
        return;
    }
    /**
     * Devuelve la matriz donde están ubicadas las fichas
     * @return  Matriz 8x8 tipo ficha
     */
    public Ficha[][] getTableroMaquina() {
        return tableroMaquina;
    }
    /**
     * Convierte la Cordenada en Y del tablero(letra del alfabeto) a un numero entero.
     * @param L Cordenada en Y del tablero
     * @return Entero significando la posición en y de la ficha que se quiere mover. Si la letra no está en el rango de "A" hasta "H" retorna -100, para sus respectivos cálculos.
     */
    public int ConvertirLetraEntrada(String L)
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
     * Inserta o posicionan todas las fichas en el TableroMaquina y en el TableroInter, cada ficha es agregada con su respectiva Posición inicial, Símbolo o representación de su tipo y su respectivo color.
     */
    public void agregarFichas()
    {
        // AQUÍ SE AGREGAN LOS PEONES NEGROS AL TABLERO
        Ficha P1N = new Peon(0,6,"P1N",Negro);
        Ficha P2N = new Peon(1,6,"P2N",Negro);
        Ficha P3N = new Peon(2,6,"P3N",Negro);
        Ficha P4N = new Peon(3,6,"P4N",Negro);
        Ficha P5N = new Peon(4,6,"P5N",Negro);
        Ficha P6N = new Peon(5,6,"P6N",Negro);
        Ficha P7N = new Peon(6,6,"P7N",Negro);
        Ficha P8N = new Peon(7,6,"P8N",Negro);
       
        tableroMaquina[P1N.getPosicionY()][P1N.getPosicionX()]=P1N;
        tableroInter[P1N.getPosicionY()][P1N.getPosicionX()] = P1N.getSigno();
        
        tableroMaquina[P2N.getPosicionY()][P2N.getPosicionX()]=P2N;
        tableroInter[P2N.getPosicionY()][P2N.getPosicionX()] = P2N.getSigno();
        
        tableroMaquina[P3N.getPosicionY()][P3N.getPosicionX()]=P3N;
        tableroInter[P3N.getPosicionY()][P3N.getPosicionX()] = P3N.getSigno();
        
        tableroMaquina[P4N.getPosicionY()][P4N.getPosicionX()]=P4N;
        tableroInter[P4N.getPosicionY()][P4N.getPosicionX()] = P4N.getSigno();
        
        tableroMaquina[P5N.getPosicionY()][P5N.getPosicionX()]=P5N;
        tableroInter[P5N.getPosicionY()][P5N.getPosicionX()] = P5N.getSigno();
        
        tableroMaquina[P6N.getPosicionY()][P6N.getPosicionX()]=P6N;
        tableroInter[P6N.getPosicionY()][P6N.getPosicionX()] = P6N.getSigno();
        
        tableroMaquina[P7N.getPosicionY()][P7N.getPosicionX()]=P7N;
        tableroInter[P7N.getPosicionY()][P7N.getPosicionX()] = P7N.getSigno();
        
        tableroMaquina[P8N.getPosicionY()][P8N.getPosicionX()]=P8N;
        tableroInter[P8N.getPosicionY()][P8N.getPosicionX()] = P8N.getSigno();
        
        // AQUÍ SE AGREGAN LOS PEONES BLANCOS AL TABLERO 
        Ficha P1B = new Peon(0,1,"P1B",Blanco);
        Ficha P2B = new Peon(1,1,"P2B",Blanco);
        Ficha P3B = new Peon(2,1,"P3B",Blanco);
        Ficha P4B = new Peon(3,1,"P4B",Blanco);
        Ficha P5B = new Peon(4,1,"P5B",Blanco);
        Ficha P6B = new Peon(5,1,"P6B",Blanco);
        Ficha P7B = new Peon(6,1,"P7B",Blanco);
        Ficha P8B = new Peon(7,1,"P8B",Blanco);
        tableroMaquina[P1B.getPosicionY()][P1B.getPosicionX()]=P1B;
        tableroInter[P1B.getPosicionY()][P1B.getPosicionX()] = P1B.getSigno();
        
        tableroMaquina[P2B.getPosicionY()][P2B.getPosicionX()]=P2B;
        tableroInter[P2B.getPosicionY()][P2B.getPosicionX()] = P2B.getSigno();
        
        tableroMaquina[P3B.getPosicionY()][P3B.getPosicionX()]=P3B;
        tableroInter[P3B.getPosicionY()][P3B.getPosicionX()] = P3B.getSigno();
        
        tableroMaquina[P4B.getPosicionY()][P4B.getPosicionX()]=P4B;
        tableroInter[P4B.getPosicionY()][P4B.getPosicionX()] = P4B.getSigno();
        
        tableroMaquina[P5B.getPosicionY()][P5B.getPosicionX()]=P5B;
        tableroInter[P5B.getPosicionY()][P5B.getPosicionX()] = P5B.getSigno();
        
        tableroMaquina[P6B.getPosicionY()][P6B.getPosicionX()]=P6B;
        tableroInter[P6B.getPosicionY()][P6B.getPosicionX()] = P6B.getSigno();
        
        tableroMaquina[P7B.getPosicionY()][P7B.getPosicionX()]=P7B;
        tableroInter[P7B.getPosicionY()][P7B.getPosicionX()] = P7B.getSigno();
        
        tableroMaquina[P8B.getPosicionY()][P8B.getPosicionX()]=P8B;
        tableroInter[P8B.getPosicionY()][P8B.getPosicionX()] = P8B.getSigno();
        
        // AQUÍ SE AGREGAN LAS TORRES NEGRAS
        Ficha Torre1N = new Torre(0,7,"T1N",Negro);
        Ficha Torre2N = new Torre(7,7,"T2N",Negro);
        tableroMaquina[Torre1N.getPosicionY()][Torre1N.getPosicionX()] = Torre1N;
        tableroInter[Torre1N.getPosicionY()][Torre1N.getPosicionX()] = Torre1N.getSigno();
        
        tableroMaquina[Torre2N.getPosicionY()][Torre2N.getPosicionX()] = Torre2N;
        tableroInter[Torre2N.getPosicionY()][Torre2N.getPosicionX()] = Torre2N.getSigno();
        
        //AQUÍ SE AGREGAN LAS TORRES BLANCAS
        Ficha Torre1B = new Torre(0,0,"T1B",Blanco);
        Ficha Torre2B = new Torre(7,0,"T2B",Blanco);
        tableroMaquina[Torre1B.getPosicionY()][Torre1B.getPosicionX()] = Torre1B;
        tableroInter[Torre1B.getPosicionY()][Torre1B.getPosicionX()] = Torre1B.getSigno();
        
        tableroMaquina[Torre2B.getPosicionY()][Torre2B.getPosicionX()] = Torre2B;
        tableroInter[Torre2B.getPosicionY()][Torre2B.getPosicionX()] = Torre2B.getSigno();
        
        //AQUÍ SE AGREGAN LOS CABALLOS NEGROS
        Ficha Caballo1N = new Caballo(1,7,"C1N",Negro);
        Ficha Caballo2N = new Caballo(6,7,"C2N",Negro);
        tableroMaquina[Caballo1N.getPosicionY()][Caballo1N.getPosicionX()] = Caballo1N;
        tableroInter[Caballo1N.getPosicionY()][Caballo1N.getPosicionX()] = Caballo1N.getSigno();
        
        tableroMaquina[Caballo2N.getPosicionY()][Caballo2N.getPosicionX()] = Caballo2N;
        tableroInter[Caballo2N.getPosicionY()][Caballo2N.getPosicionX()] = Caballo2N.getSigno();
        
        //AQUÍ SE AGREGAN LOS CABALLOS BLANCOS
        Ficha Caballo1B = new Caballo(1,0,"C1B",Blanco);
        Ficha Caballo2B = new Caballo(6,0,"C2B",Blanco);
        tableroMaquina[Caballo1B.getPosicionY()][Caballo1B.getPosicionX()] = Caballo1B;
        tableroInter[Caballo1B.getPosicionY()][Caballo1B.getPosicionX()] = Caballo1B.getSigno();
        
        tableroMaquina[Caballo2B.getPosicionY()][Caballo2B.getPosicionX()] = Caballo2B;
        tableroInter[Caballo2B.getPosicionY()][Caballo2B.getPosicionX()] = Caballo2B.getSigno();
        
        //AQUÍ SE AGREGAN LOS ALFILES NEGROS
        Ficha Alfil1N = new Alfil(2,7,"A1N",Negro);
        Ficha Alfil2N = new Alfil(5,7,"A2N",Negro);
        tableroMaquina[Alfil1N.getPosicionY()][Alfil1N.getPosicionX()] = Alfil1N;
        tableroInter[Alfil1N.getPosicionY()][Alfil1N.getPosicionX()] = Alfil1N.getSigno();
        
        tableroMaquina[Alfil2N.getPosicionY()][Alfil2N.getPosicionX()] = Alfil2N;
        tableroInter[Alfil2N.getPosicionY()][Alfil2N.getPosicionX()] = Alfil2N.getSigno();
        
        // AQUÍ SE AGREGAN LOS ALFILES BLANCOS
        Ficha Alfil1B = new Alfil(2,0,"A1B",Blanco);
        Ficha Alfil2B = new Alfil(5,0,"A2B",Blanco);
        tableroMaquina[Alfil1B.getPosicionY()][Alfil1B.getPosicionX()] = Alfil1B;
        tableroInter[Alfil1B.getPosicionY()][Alfil1B.getPosicionX()] = Alfil1B.getSigno();
        
        tableroMaquina[Alfil2B.getPosicionY()][Alfil2B.getPosicionX()] = Alfil2B;
        tableroInter[Alfil2B.getPosicionY()][Alfil2B.getPosicionX()] = Alfil2B.getSigno();
        
        // AQUÍ SE AGREGA EL REY NEGRO
        Ficha ReyN = new Rey(3,7,"ReN",Negro);
        tableroMaquina[ReyN.getPosicionY()][ReyN.getPosicionX()] = ReyN;
        tableroInter[ReyN.getPosicionY()][ReyN.getPosicionX()] = ReyN.getSigno();
        
        // AQUÍ SE AGREGA EL REY BLANCO
        Ficha ReyB = new Rey(3,0,"ReB",Blanco);
        tableroMaquina[ReyB.getPosicionY()][ReyB.getPosicionX()] = ReyB;
        tableroInter[ReyB.getPosicionY()][ReyB.getPosicionX()] = ReyB.getSigno();
        
        // AQUÍ SE AGREGA LA REYNA NEGRA
        Ficha ReinaN = new Reina(4,7,"QUN",Negro);
        tableroMaquina[ReinaN.getPosicionY()][ReinaN.getPosicionX()] =ReinaN;
        tableroInter[ReinaN.getPosicionY()][ReinaN.getPosicionX()] =ReinaN.getSigno();
        
        //AQUÍ SE AGREGA LA REYNA BLANCA
        Ficha ReinaB = new Reina(4,0,"QUB",Blanco);
        tableroMaquina[ReinaB.getPosicionY()][ReinaB.getPosicionX()] =ReinaB;
        tableroInter[ReinaB.getPosicionY()][ReinaB.getPosicionX()] =ReinaB.getSigno();        
    }
    

    /**
     * Quita las " X " que son colocadas por cada ficha para mostrar sus posibles movimientos, es decir, modifica 
     * el TableroInter para una nueva consulta
     */
    public void ResetTableroString(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (this.getTableroMaquina()[i][j]!= null) 
                    this.getTableroInter()[i][j] = this.getTableroMaquina()[i][j].getSigno();
                else                    
                    this.getTableroInter()[i][j] = null;                                    
            }            
        }
    }
    

    /**
     * Desarrollo total del juego
     * Recibe nombre de Jugadores
     * Controla los turnos 
     */
    public static void main(String[] args) {
        Icon JugadorBlanco = new ImageIcon("C:\\Users\\SONY\\Documents\\NetBeansProjects\\Ajedrez\\JugadorBlanco.png");
        Icon JugadorNegro = new ImageIcon("C:\\Users\\SONY\\Documents\\NetBeansProjects\\Ajedrez\\JugadorNegro.png");
        Icon Pino = new ImageIcon("C:\\Users\\SONY\\Documents\\NetBeansProjects\\Ajedrez\\Pino.png");
        Icon Chess = new ImageIcon("C:\\Users\\SONY\\Documents\\NetBeansProjects\\Ajedrez\\Ajedrez.png");
        Icon Rendirse = new ImageIcon("C:\\Users\\SONY\\Documents\\NetBeansProjects\\Ajedrez\\Rendirse.png");
        Ajedrez Juego = new Ajedrez();
        Juego.agregarFichas();
        Juego.TableroString();
        JOptionPane.showMessageDialog(null,"Bienvenidos al Juego Ajedrez","Presentación",JOptionPane.WARNING_MESSAGE,Chess);
        String NombreJ1 = (String)JOptionPane.showInputDialog(null,"Jugador1","Ingrese Su nombre");
        String NombreJ2 = JOptionPane.showInputDialog(null,"Jugador 2","Ingrese Su nombre");
        Jugador J1 = new Jugador(NombreJ1);
        Jugador J2 = new Jugador(NombreJ2);
        JOptionPane.showMessageDialog(null, J1.getNombre()+" Juegas con Fichas Blancas","Información",JOptionPane.WARNING_MESSAGE,JugadorBlanco);
        JOptionPane.showMessageDialog(null, J2.getNombre()+" Juegas con Fichas Negras","Información",JOptionPane.WARNING_MESSAGE,JugadorNegro);
        J1.cambiarTurno();       
        while(true)
        {
            if (J1.isTurno() == true) {
                if (Juego.RevisarRey() < 2) {
                    JOptionPane.showMessageDialog(null,J1.getNombre()+ " Has perdido, Juego terminado\n Felicitaciones "+J2.getNombre()+" has ganado");
                    break;
                }
                String b = JOptionPane.showInputDialog(J1.getNombre()+" Ahora empecemos el juego selecciona las opciones:\n"
                + "1: Para mover una ficha\n 2: Para mirar los posibles movimientos de una ficha\n"
                + " 3: Rendirse");
                if(!b.equals("1")&&!b.equals("2")&&!b.equals("3")){
                    JOptionPane.showMessageDialog(null,J1.getNombre()+" Ingresaste un valor incorrecto intenta de nuevo","Alerta!",JOptionPane.WARNING_MESSAGE,Pino);
                    continue;
                } 
                if (b.equals("1")) {
                    String a = JOptionPane.showInputDialog(null,J1.getNombre()+" Por favor digite ficha a mover y a donde desea hacer el movimiento\n "
                        + "Ejemplo G-2-E-2","Datos");
                    String[] pos = a.split("-");
                    try {
                        if(Juego.tableroMaquina[Juego.ConvertirLetraEntrada(pos[0])][Integer.parseInt(pos[1])-1].
                            getColor() == 1) {
                        JOptionPane.showMessageDialog(null,J1.getNombre()+" Recuerda que juega con fichas blancas","Alerta",JOptionPane.WARNING_MESSAGE,Pino);
                        continue;
                        }
                        else{                        
                            Juego.tableroMaquina[Juego.ConvertirLetraEntrada(pos[0])][Integer.parseInt(pos[1])-1].
                            Movimiento(Juego,pos[2], Integer.parseInt(pos[3]));                                                 
                        }                        
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null,J1.getNombre()
                            + " Has ingresado Posiciones Inválidas, intenta de nuevo Recuerda que este mensaje aparece\n"
                            + " por datos incorrectos, o por que estás intentando mover una ficha que no existe ","Alerta",JOptionPane.WARNING_MESSAGE,Pino);
                        continue;
                    }
                    if (Juego.getTableroMaquina()[Juego.ConvertirLetraEntrada(pos[0])][Integer.parseInt(pos[1])-1]== null) {
                        J1.cambiarTurno();
                        J2.cambiarTurno();
                    }                   
                }
                if (b.equals("2")) {
                    String a = JOptionPane.showInputDialog(J1.getNombre()+" Por favor digite la ficha que desea consultar movimiento \n Ejemplo A-1");
                    String[] pos = a.split("-");
                    Juego.tableroMaquina[Juego.ConvertirLetraEntrada(pos[0])][Integer.parseInt(pos[1])-1].
                            MostrarMovimiento(Juego);
                    continue;
                }
                if (b.equals("3")) {
                    JOptionPane.showMessageDialog(null,J2.getNombre()+" Ha ganado\n"+J1.getNombre()+
                            " Juego Terminado te has rendido","Fin del juego",JOptionPane.WARNING_MESSAGE,Rendirse);
                    break;
                }               
            }
            if (J2.isTurno() == true) {
                if (Juego.RevisarRey() < 2) {
                    JOptionPane.showMessageDialog(null,J2.getNombre()+ " Has perdido, Juego terminado\n Felicitaciones "+J1.getNombre()+" has ganado");
                    break;
                }
                String b = JOptionPane.showInputDialog(J2.getNombre()+" Es tu turno selecciona las opciones:\n"
                + "1: Para mover una ficha\n 2: Para mirar los posibles movimientos de una ficha\n"
                + " 3: Rendirse");
                if(!b.equals("1")&&!b.equals("2")&&!b.equals("3")){
                    JOptionPane.showMessageDialog(null,J2.getNombre()+" Ingresaste un valor incorrecto intenta de nuevo","Alerta!",JOptionPane.WARNING_MESSAGE,Pino);
                    continue;
                } 
                if (b.equals("1")) {
                    String a = JOptionPane.showInputDialog(J2.getNombre()+" Por favor digite ficha a mover y a donde desea hacer el movimiento\n"
                            + "Ejemplo G-2-E-2");
                    String[] pos = a.split("-");
                    try {
                        if(Juego.tableroMaquina[Juego.ConvertirLetraEntrada(pos[0])][Integer.parseInt(pos[1])-1].
                                getColor() == 0) {
                            JOptionPane.showMessageDialog(null,J2.getNombre()+" Recuerda que juega con fichas blancas","Alerta",JOptionPane.WARNING_MESSAGE,Pino);
                            continue;
                        }
                        else{
                            Juego.tableroMaquina[Juego.ConvertirLetraEntrada(pos[0])][Integer.parseInt(pos[1])-1].
                                Movimiento(Juego,pos[2], Integer.parseInt(pos[3]));                                                   
                        }                        
                    }   
                    catch (Exception e){
                        JOptionPane.showMessageDialog(null,J2.getNombre()
                            + " Has ingresado Posiciones Inválidas, intenta de nuevo Recuerda que este mensaje aparece\n"
                            + " por datos incorrectos, o por que estás intentando mover una ficha que no existe ","Alerta",JOptionPane.WARNING_MESSAGE,Pino);
                        continue;
                    }                                            
                    if (Juego.getTableroMaquina()[Juego.ConvertirLetraEntrada(pos[0])][Integer.parseInt(pos[1])-1]== null) {
                        J1.cambiarTurno();
                        J2.cambiarTurno();
                    }
                }                
                if (b.equals("2")) {
                    String a = JOptionPane.showInputDialog(J2.getNombre()+" Por favor digite la ficha que desea consultar movimiento \n Ejemplo A-1");
                    String[] pos = a.split("-");
                    Juego.tableroMaquina[Juego.ConvertirLetraEntrada(pos[0])][Integer.parseInt(pos[1])-1].
                            MostrarMovimiento(Juego);
                    continue;
                }
                if (b.equals("3")) {
                    JOptionPane.showMessageDialog(null,J1.getNombre()+" Has ganado\n"+J2.getNombre()+
                            " Juego Terminado te has rendido","Fin del juego",JOptionPane.WARNING_MESSAGE,Rendirse);
                    break;
                }                  
            }            
        }       
    }
}

