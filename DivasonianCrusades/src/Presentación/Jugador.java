package Presentaci�n;
import MD_Instrucci�n.Instrucci�n;
import MD_Instrucci�n.Operaci�n;
import MD_Tablero.Tablero;
import Utilidades.Facci�n;

public class Jugador {
    public Facci�n facci�n;

    public String nombre;

    public Tablero tablero;

    public void intoducirInstrucci�n(Instrucci�n i) {
    }

    public boolean comprobarInstrucci�n(Instrucci�n i) {
    	
    	boolean posible = true;
    	
    	//Supongo que har� esto, aunque no estoy nada seguro.
    	for(int op = 0; op < 5; op++) {
    		
    		posible = posible && this.comprobarOperaci�n(i.getOperacion(op));
    		
    		if(posible) {
    			
    			//Aqu� realiza la operaci�n en su tablero y tal porque hay que ir actualizando los movimientos. Claro, para ello hay que guardar una copia original del tablero, ya que si no es posible hay que devolver a su posici�n original a las fichas.
    			
    		}
    		else {
    			
    			//Retornamos el tablero a su posici�n original y devolvemos false.
    			
    		}
    		
    	}
    	
    	return posible;
    	
    }

    public boolean comprobarOperaci�n(Operaci�n o) {
    	
    	//Utiliza los m�todos tablero.comprobarMovimiento y tablero.comprobarDisparo y esos, que con casi total seguridad no est�n puestos en la clase tablero todav�a
    	return false;
    	
    }

    public void rendirse() {
    	
    	//Pues F la partida.
    	
    }

    public void pintar() {
    	
    	//De este m�todo desconf�o.
    	
    }

    public void setTablero(Tablero t) {
    	
    	tablero = t;
    	
    }

}
