package MD_Tablero;
import java.util.ArrayList;
import java.util.List;

import MD_Instrucci�n.Instrucci�n;
import Utilidades.Facci�n;

public class Tablero {
    public Nodo[] nodos = new Nodo[45];

    public Tablero() {
//		this.nodos = 
	}
    
    public Tablero(Nodo[] nodos) {
		super();
		this.nodos = nodos;
	}
    
    public boolean movimientoPosible(Ficha f, Facci�n fc) {
    	
    	// Devuelve false si una ficha ha sido trabada en combate en este turno (en una operaci�n anterior a la siguiente).
    	
    }
    
	public void moverFicha(int casillaOrigen, int casillaDestino) {
		
		//Si puede, mueve la ficha.
		
    }

    public void resolverTurno() {
    	
    	//Resuelve el turno, haciendo en cada nodo lo que deba.
    	
    }

    public boolean haTerminado() {
    	
    	boolean terminado = false;
    	
    	if(((Copa) nodos[this.d�ndeEst�(new Copa(Facci�n.Facci�n1))].getCasilla()).est�Muerta()) terminado = true;
    	
    	return terminado;
    	
    }

    public Facci�n getGanador() {
    	
    	//Indica qu� facci�n ha ganado.
    	
    }

    public boolean comprobarInstrucci�n(Instrucci�n i, Facci�n fc) {
    }

    public int d�ndeEst�(Ficha f, Facci�n fc) {
    	
    	for(int i = 0; i < 45; i++) {
    		
    		if(nodos[i].est�Aqu�(f, fc)) return i;
    		
    	}
    	
    }

    public int d�ndeEst�(Casilla c) {
    	
    	for(int i = 0; i < 45; i++) {
    		
    		if(nodos[i].est�Aqu�(c)) return i;
    		
    	}
    	
    }

    public void dispararProyectiles(int casillaObjetivo) {
    	
    	//Hace da�o de catapulta a los bichos que haya en la casilla casillaObjetivo.
    	
    }

    private boolean hayFicha(int casilla) {
    	
    	return (nodos[casilla].hayFicha());
    	
    }

    private boolean hayFicha(Facci�n fc, int casilla) {
    	
    	return (nodos[casilla].hayFicha());
    	
    }

    private List<Integer> d�ndeDisparar(Catapulta cp) {
    	
    	//Devuelve una lista de enteros que representan las posiciones de las casillas a las que le llega el rango la catapulta dada.
    	List<Integer> posiciones = new ArrayList<Integer>();
    	
    	if()
    	
    	return posiciones;
    	
    }

}
