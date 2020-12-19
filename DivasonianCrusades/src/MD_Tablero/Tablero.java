package MD_Tablero;
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
    }
	public void moverFicha(int casillaOrigen, int casillaDestino) {
    }

    public void resolverTurno() {
    }

    public boolean haTerminado() {
    	
    	boolean terminado = false;
    	
    	if(((Copa) nodos[this.d�ndeEst�(new Copa(Facci�n.Facci�n1))].getCasilla()).est�Muerta()) terminado = true;
    	
    	return terminado;
    	
    }

    public Facci�n getGanador() {
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
    }

    private boolean hayFicha(int casilla) {
    	
    	return (nodos[casilla].hayFicha());
    	
    }

    private boolean hayFicha(Facci�n fc, int casilla) {
    	
    	return (nodos[casilla].hayFicha());
    	
    }

    private List<int> d�ndeDisparar(Catapulta cp) {
    	
    	//Devuelve una lista de enteros que representan las posiciones de las casillas a las que le llega el rango la catapulta dada.
    	
    }

}
