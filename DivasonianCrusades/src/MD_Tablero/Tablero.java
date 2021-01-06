package MD_Tablero;
import java.util.ArrayList;
import java.util.List;

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
    
    //ESTE M�TODO ESTOY BASTANTE SEGURO DE QUE NO SE REQUIERE AQU�, YA QUE ESTA COMPROBACI�N SE TENDR� QUE HACER EN LA CLASE Partida.
//    public boolean movimientoPosible(Ficha f) {
//    	
//    	// Devuelve false si la ficha ha sido trabada en combate en este turno (en una operaci�n anterior a la siguiente).
//    	
//    }
    
    //A CAMBIO DEL ANTERIOR NECESITAREMOS ESTE PARA SABER EST� TRABADO.
    public boolean est�Trabada(Ficha f) {
    	
    	// Devuelve true si la ficha est� trabada en combate.
    	return (this.hayDosFichas(this.d�ndeEst�(f)));
    	
    }
    
	public void moverFicha(Ficha f, int casillaOrigen, int casillaDestino) {
		
		//Mueve y resuelve combate
		
    }
	
	//NUEVO M�TODO, PARA CUANDO DOS FICHAS SE MUEVEN A UNA SOLA CASILLA COM�N
	public void moverFichasALaMismaCasilla(Ficha f1, Ficha f2, int casillaOrigen, int casillaDestino) {
		
		//Mueve y resuelve combate
		
    }

    public void resolverTurno() {
    	
    	//Resuelve el turno, haciendo en cada nodo lo que deba.
    	for(Nodo n : nodos) {
    		
    		n.resolverTurno();
    		
    	}
    	//As�? un poco simple en demas�a, no creo que con esto est� todo.
    	
    }

    public boolean haTerminado() {
    	
    	boolean perdido = false;
    	
    	int posCopa1 = this.d�ndeEst�(new Copa(Facci�n.Facci�n1));
    	int posCopa2 = this.d�ndeEst�(new Copa(Facci�n.Facci�n2));
    	
    	boolean algunoVivo1 = false;
    	boolean algunoVivo2 = false;
    	
    	if(((Copa) this.nodos[posCopa1].getCasilla()).est�Muerta()) {
    		
    		return true;
    		
    	}
    	if(((Copa) this.nodos[posCopa2].getCasilla()).est�Muerta()) {
    		
    		return true;
    		
    	}
    	
    	for(int i = 0; i < 45; i++) {
    		
    		if(nodos[i].est�Aqu�(Facci�n.Facci�n1)) algunoVivo1 = true;
    		
    	}
    	
    	if(!algunoVivo1) return true;
    	
    	for(int i = 0; i < 45; i++) {
    		
    		if(nodos[i].est�Aqu�(Facci�n.Facci�n2)) algunoVivo2 = true;
    		
    	}
    	
    	if(!algunoVivo1) return true;
    	
    	return (false);
    	
    }

    public Facci�n getGanador() {
    	
    	//Indica qu� facci�n ha ganado.
    	int posCopa1 = this.d�ndeEst�(new Copa(Facci�n.Facci�n1));
    	int posCopa2 = this.d�ndeEst�(new Copa(Facci�n.Facci�n2));
    	
    	boolean perdedor1 = false;
    	boolean perdedor2 = false;
    	boolean algunoVivo1 = false;
    	boolean algunoVivo2 = false;
    	
    	if(((Copa) this.nodos[posCopa1].getCasilla()).est�Muerta()) {
    		
    		perdedor1 = true;
    		
    	}
    	if(((Copa) this.nodos[posCopa2].getCasilla()).est�Muerta()) {
    		
    		perdedor2 = true;
    		
    	}
    	for(int i = 0; i < 45; i++) {
    		
    		if(nodos[i].est�Aqu�(Facci�n.Facci�n1)) algunoVivo1 = true;
    		
    	}
    	for(int i = 0; i < 45; i++) {
    		
    		if(nodos[i].est�Aqu�(Facci�n.Facci�n2)) algunoVivo2 = true;
    		
    	}
    	
    	if((perdedor1||!algunoVivo1) && (perdedor1||!algunoVivo1)) return Facci�n.Ambos;
    	else if(perdedor1||!algunoVivo1) return Facci�n.Facci�n2;
    	else if(perdedor2||!algunoVivo2) return Facci�n.Facci�n1;
    	else return null;
    	
    }

    //ESTO SER� NECESARIO SI QUEREMOS HACER UNA PRESENTACI�N CON CONSOLA, SUPONGO.
//    public boolean comprobarInstrucci�n(Instrucci�n i, Facci�n fc) {
//    	
//    	//Comprobar si se puede ejecutar el conjunto de operaciones o no.
//    	
//    }

    public int d�ndeEst�(Ficha f) {
    	
    	for(int i = 0; i < 45; i++) {
    		
    		if(nodos[i].est�Aqu�(f)) return i;
    		
    	}
    	
    	return -1;
    	
    }

    public int d�ndeEst�(Casilla c) {
    	
    	for(int i = 0; i < 45; i++) {
    		
    		if(nodos[i].est�Aqu�(c)) return i;
    		
    	}
    	
    	return -1;
    	
    }
    
    public void dispararProyectiles(Catapulta catapulta, int casillaObjetivo) {
    	
    	//Hace da�o de catapulta a los bichos que haya en la casilla casillaObjetivo.
    	nodos[casillaObjetivo].recibirDisparo(catapulta.realizarDisparo());
    	
    }

    private boolean hayFicha(int casilla) {
    	
    	return (nodos[casilla].hayFicha());
    	
    }
    
    //OJOOOO ESTE LO HE A�ADIDO DE FREE TOTALMENTE
    private boolean hayDosFichas(int casilla) {
    	
    	return (nodos[casilla].hayDosFichas());
    	
    }

    private boolean hayFicha(Facci�n fc, int casilla) {
    	
    	return (nodos[casilla].hayFicha());
    	
    }
    
    //ESTE M�TODO NO CREO QUE LO UTILICEMOS. F
    public List<Integer> d�ndeDispararProyectiles(Catapulta cp) {
    	
    	//Devuelve una lista de enteros que representan las posiciones de las casillas a las que le llega el rango la catapulta dada.
    	List<Integer> posiciones = new ArrayList<Integer>();
    	
    	if(cp.getIdentificador() == 1) {
    		
    		int posArr[] = {4,5,6,7,8,14,15,16,17,23,24,25,26,32,33,34,35,40,41,42,43,44};
    		
    		for(int i = 0; i < posArr.length; i++) {
    			
    			posiciones.add(posArr[i]);
    			
    		}
    		
    	}
    	else if(cp.getIdentificador() == 2) {
    		
    		int posArr[] = {0,1,2,3,4,9,10,11,12,18,19,20,21,27,28,29,30,36,37,38,39,40};
    		
    		for(int i = 0; i < posArr.length; i++) {
    			
    			posiciones.add(posArr[i]);
    			
    		}
    		
    	}
    	
    	return posiciones;
    	
    }
    
    public List<Integer> d�ndeDispararFlechas(Facci�n fc) {
    	
    	//Devuelve una lista de enteros que representan las posiciones de las casillas a las que le llega el rango la catapulta dada.
    	List<Integer> posiciones = new ArrayList<Integer>();
    	
    	int whereIsTheArcher = this.d�ndeEst�(new Arquero(fc));
    	
    	posiciones.add(whereIsTheArcher - 9 - 1);
    	posiciones.add(whereIsTheArcher - 9);
    	posiciones.add(whereIsTheArcher - 9 + 1);
    	posiciones.add(whereIsTheArcher - 1);
    	posiciones.add(whereIsTheArcher + 1);
    	posiciones.add(whereIsTheArcher + 9 - 1);
    	posiciones.add(whereIsTheArcher + 9);
    	posiciones.add(whereIsTheArcher + 9 + 1); 
    	if(fc == Facci�n.Facci�n1) {
    		
    		posiciones.add(whereIsTheArcher - 9 + 2);
        	posiciones.add(whereIsTheArcher + 2);
        	posiciones.add(whereIsTheArcher + 9 + 2); 
    		
    	}
    	else if(fc == Facci�n.Facci�n2) {
    		
    		posiciones.add(whereIsTheArcher - 9 - 2);
        	posiciones.add(whereIsTheArcher - 2);
        	posiciones.add(whereIsTheArcher + 9 - 2); 
    		
    	}
    	
    	int j;
    	
    	for(int i = 0; i < posiciones.size(); i++) {
    		
    		if(posiciones.get(i) < 0 || posiciones.get(i) >= 45) {
    			
    			j = posiciones.remove(i);
    			
    		}
    		
    	}
    	
    	return posiciones;
    	
    }

}
