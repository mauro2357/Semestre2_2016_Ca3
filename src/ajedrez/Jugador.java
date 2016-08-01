package ajedrez;
/**
 *
 * @author Julián Carvajal Montoya
 * @author Alejadro Castañeda Ramírez
 */
public class Jugador {
    private String Nombre;
    private boolean Turno = false;
    /**
     * Constructor utilizado para dar orden al Juego
     * @param Nombre  Nombre del Jugador
     */
    public Jugador(String Nombre) {
        this.Nombre = Nombre;
    }
    /**
     * Utilizado para cambiar el turno del jugador
     */
    public void cambiarTurno() {
        if (this.Turno == true) {
            this.Turno = false;
        }
        else {
            this.Turno = true;
        }
    }
    /**
     * Devuelve El nombre del Jugador
     * @return String con el mobre del Jugador
     */
    public String getNombre() {
        return Nombre;
    }
    /**
     * Devuelve el turno del Jugador
     * @return Boleano, True: Está en Turno, False: No está en turno
     */
    public boolean isTurno() {
        return Turno;
    }
}