package LN;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import MD_Tablero.Arquero;
import MD_Tablero.B�rbaro;
import MD_Tablero.Caballero;
import MD_Tablero.Casilla;
import MD_Tablero.Catapulta;
import MD_Tablero.Colina;
import MD_Tablero.Copa;
import MD_Tablero.Curaci�n;
import MD_Tablero.Ficha;
import MD_Tablero.Guerrero;
import MD_Tablero.HachaDivas�nica;
import MD_Tablero.Lancero;
import MD_Tablero.Nodo;
import MD_Tablero.Normal;
import Utilidades.Direcci�n;
import Utilidades.Facci�n;

public class Tablero implements Cloneable,Serializable{
    private Nodo[] nodos = new Nodo[45];

    public Tablero() {
    	nodos[18] = new Nodo(new Copa(Facci�n.Facci�n1));
		nodos[26] = new Nodo(new Copa(Facci�n.Facci�n2));
		
		nodos[5] = new Nodo(new Colina());
		nodos[39] = new Nodo(new Colina());
		
		nodos[20] = new Nodo(new Catapulta(1));
		nodos[24] = new Nodo(new Catapulta(2));
		
		nodos[2] = new Nodo(new Curaci�n(1));
		nodos[42] = new Nodo(new Curaci�n(2)); 
		
		nodos[22] = new Nodo(new Normal(new HachaDivas�nica()));
		
		nodos[1] = new Nodo(new Normal(null, true));
		nodos[3] = new Nodo(new Normal(null, true));
		nodos[10] = new Nodo(new Normal(null, true));
		nodos[11] = new Nodo(new Normal(null, true));
		nodos[12] = new Nodo(new Normal(null, true));
		
		nodos[32] = new Nodo(new Normal(null, true));
		nodos[33] = new Nodo(new Normal(null, true));
		nodos[34] = new Nodo(new Normal(null, true));
		nodos[41] = new Nodo(new Normal(null, true));
		nodos[43] = new Nodo(new Normal(null, true));
		
		nodos[0] = new Nodo(new Lancero(Facci�n.Facci�n1));
		nodos[4] = new Nodo();
		nodos[6] = new Nodo();
		nodos[7] = new Nodo();
		
		nodos[8] = new Nodo(new Lancero(Facci�n.Facci�n2));
		nodos[9] = new Nodo(new Arquero(Facci�n.Facci�n1));
		nodos[13] = new Nodo();
		nodos[14] = new Nodo();
		nodos[15] = new Nodo();
		
		nodos[16] = new Nodo();
		nodos[17] = new Nodo(new Arquero(Facci�n.Facci�n2));
		nodos[19] = new Nodo(new Guerrero(Facci�n.Facci�n1));
		nodos[21] = new Nodo();
		nodos[23] = new Nodo();
		
		nodos[25] = new Nodo(new Guerrero(Facci�n.Facci�n2));
		nodos[27] = new Nodo(new B�rbaro(Facci�n.Facci�n1));
		nodos[28] = new Nodo();
		nodos[29] = new Nodo();
		nodos[30] = new Nodo();
		
		nodos[31]= new Nodo();
		nodos[35] = new Nodo(new B�rbaro(Facci�n.Facci�n2));
		nodos[36] = new Nodo(new Caballero(Facci�n.Facci�n1));
		nodos[37] = new Nodo();
		nodos[38] = new Nodo();
		
		nodos[40] = new Nodo();
		nodos[44] = new Nodo(new Caballero(Facci�n.Facci�n2));
	}
    
    public Tablero(Nodo[] nodos) {
		super();
		this.nodos = nodos;
	}
    
    public boolean movimientoPosible(Ficha f) {
    	
    	// Devuelve false si la ficha ha sido trabada en combate en este turno (en una operaci�n anterior a la siguiente).
    	return (nodos[this.d�ndeEst�(f)]).puedeMover(f);
    	
    }
    
    public boolean est�Trabada(Ficha f) {
    	
    	// Devuelve true si la ficha est� trabada en combate.
    	return (this.hayDosFichas(this.d�ndeEst�(f)));
    	
    }
    
    //VIENE DEL ANTIGUO Ejecutor, SIRVE PARA MOVER CON UNA DIRECCI�N EN LUGAR DE CON LOS intS.
    public void moverFicha(Ficha f, Direcci�n d) { 
    		
    	System.out.println(f.getClass().getSimpleName() + ": " + this.d�ndeEst�(f) + " " + d);
    	
    	int desde = this.d�ndeEst�(f);
    	int hasta; //Ojito porque aqu� hay que pasar de coordenadas a posici�n en el vector.
    		
    	if(d == Direcci�n.norte) hasta = desde - 9;
    	else if(d == Direcci�n.sur) hasta = desde + 9;
    	else if(d == Direcci�n.este) hasta = desde + 1;
    	else if(d == Direcci�n.oeste) hasta = desde - 1;
    	else if(d == Direcci�n.noreste) hasta = desde - 8;
    	else if(d == Direcci�n.noroeste) hasta = desde - 10;
    	else if(d == Direcci�n.sureste) hasta = desde + 10;
    	else /*if(d == Direcci�n.suroeste)*/ hasta = desde + 8;
    	
    	System.out.println(f.getClass().getSimpleName() + ": " + desde + " " + hasta);
    		
    	this.moverFicha(f, desde, hasta);
    	
    }
    
	public void moverFicha(Ficha f, int casillaOrigen, int casillaDestino) {
		
		//Mueve y resuelve combate
		if(nodos[casillaOrigen].hayDosFichas()) {
			
			nodos[casillaOrigen].ejecutarAtaqueContraHuida(f);
			
		}
		
		if(nodos[casillaOrigen].est�Aqu�(f)) {
			
			Ficha freal = nodos[casillaOrigen].quitarFicha(f);
			nodos[casillaDestino].ponerFicha(freal);
			
			//Si se pone en una cercana al arquero enemigo le dispara
			
			
			if(nodos[casillaDestino].hayDosFichas()) {
				
				nodos[casillaDestino].ejecutarCrga();
				nodos[casillaDestino].noPuedenMover(); //En caso de que haya muerto este m�todo no har� nada.
				
			}
			
		}
		
    }
	
	//VIENE DEL ANTIGUO Ejecutor, SIRVE PARA MOVER CON UNA DIRECCI�N EN LUGAR DE CON LOS intS.
	//EN CASO DE QUE UNA MUEVA Y OTRA HAGA OTRA COSA USAMOS moverFicha(), Y SI HAY QUE MOVER DOS ENTONCES LE METEMOS A moverFichasALaVez()
    public void moverFichasALaVez(Ficha f1, Direcci�n d1, Ficha f2, Direcci�n d2) {
    		
    		System.out.println(f1.getClass().getSimpleName() + ": " + this.d�ndeEst�(f1) + " " + d1);
    		System.out.println(f2.getClass().getSimpleName() + ": " + this.d�ndeEst�(f2) + " " + d2);
    	
    		int desde1 = this.d�ndeEst�(f1);
    		int hasta1;
    		
    		if(d1 == Direcci�n.norte) hasta1 = desde1 - 9;
    		else if(d1 == Direcci�n.sur) hasta1 = desde1 + 9;
    		else if(d1 == Direcci�n.este) hasta1 = desde1 + 1;
    		else if(d1 == Direcci�n.oeste) hasta1 = desde1 - 1;
    		else if(d1 == Direcci�n.noreste) hasta1 = desde1 - 8;
    		else if(d1 == Direcci�n.noroeste) hasta1 = desde1 - 10;
    		else if(d1 == Direcci�n.sureste) hasta1 = desde1 + 10;
    		else /*if(d == Direcci�n.suroeste)*/ hasta1 = desde1 + 8;
    		
    		int desde2 = this.d�ndeEst�(f2);
    		int hasta2;
    		
    		if(d2 == Direcci�n.norte) hasta2 = desde2 - 9;
    		else if(d2 == Direcci�n.sur) hasta2 = desde2 + 9;
    		else if(d2 == Direcci�n.este) hasta2 = desde2 + 1;
    		else if(d2 == Direcci�n.oeste) hasta2 = desde2 - 1;
    		else if(d2 == Direcci�n.noreste) hasta2 = desde2 - 8;
    		else if(d2 == Direcci�n.noroeste) hasta2 = desde2 - 10;
    		else if(d2 == Direcci�n.sureste) hasta2 = desde2 + 10;
    		else /*if(d == Direcci�n.suroeste)*/ hasta2 = desde2 + 8;
    		
    		System.out.println(f1.getClass().getSimpleName() + ": " + desde1 + " " + hasta1);
    		System.out.println(f2.getClass().getSimpleName() + ": " + desde2 + " " + hasta2);
    		
    		//Comrpobaciones y �rdenes
    		
    		if(desde1 == desde2) {
    			
    			moverFichasDeLaMismaCasilla(f1, f2, desde1, hasta1, hasta2);
    			
    		}
    		else if(hasta1 == desde2 && hasta2 == desde1) {
    			
    			cruzarFichas(f1, f2, desde1, desde2); 
    			
    		}
    		else if(hasta1 == desde2) {
    			
    			this.moverFicha(f2, desde2, hasta2);
    			this.moverFicha(f1, desde1, hasta1);
    			
    		}
    		else if(hasta2 == desde1) {
    			
    			this.moverFicha(f1, desde1, hasta1);
    			this.moverFicha(f2, desde2, hasta2);
    			
    		}
    		else if(hasta1 == hasta2) {
    			
    			this.moverFichasALaMismaCasilla(f1, f2, desde1, desde2, hasta1);
    			
    		}
    		else {
    			
    			this.moverFicha(f1, desde1, hasta1);
    			this.moverFicha(f2, desde2, hasta2);
    			
    		}
    	
    }
	
	//NUEVO M�TODO, PARA CUANDO DOS FICHAS SE MUEVEN A UNA SOLA CASILLA COM�N
	public void moverFichasALaMismaCasilla(Ficha f1, Ficha f2, int casillaOrigen1, int casillaOrigen2, int casillaDestino) {
		
		//Mueve y resuelve combate
		if(nodos[casillaOrigen1].hayDosFichas()) {
			
			nodos[casillaOrigen1].ejecutarAtaqueContraHuida(f1);
			nodos[casillaOrigen2].ejecutarAtaqueContraHuida(f2);
			
		}
		
		if(nodos[casillaOrigen2].hayDosFichas()) {
			
			nodos[casillaOrigen2].ejecutarAtaqueContraHuida(f2);
			
		}
		
		if(nodos[casillaOrigen1].est�Aqu�(f1) && nodos[casillaOrigen2].est�Aqu�(f2)) {
			
			Ficha freal1 = nodos[casillaOrigen1].quitarFicha(f1);
			nodos[casillaDestino].ponerFicha(freal1);
			
			Ficha freal2 = nodos[casillaOrigen2].quitarFicha(f2);
			nodos[casillaDestino].ponerFicha(freal2);
			
			nodos[casillaDestino].ejecutarCrgasRespectivas();
			
			nodos[casillaDestino].noPuedenMover(); //En caso de que haya muerto este m�todo no har� nada.
			
		}
		else if(nodos[casillaOrigen1].est�Aqu�(f1)) {
			
			Ficha freal1 = nodos[casillaOrigen1].quitarFicha(f1);
			nodos[casillaDestino].ponerFicha(freal1);
			
		}
		else if(nodos[casillaOrigen2].est�Aqu�(f2)) {
			
			Ficha freal2 = nodos[casillaOrigen2].quitarFicha(f2);
			nodos[casillaDestino].ponerFicha(freal2);
			
		}
		
    }
	
	public void moverFichasDeLaMismaCasilla(Ficha f1, Ficha f2, int casillaOrigen, int casillaDestino1, int casillaDestino2) {
		
		nodos[casillaOrigen].ejecutarAtaquesDeHuidas();
		
		if(nodos[casillaOrigen].est�Aqu�(f1)) {
			
			Ficha freal1 = nodos[casillaOrigen].quitarFicha(f1);
			nodos[casillaDestino1].ponerFicha(freal1);
			
			if(nodos[casillaDestino1].hayDosFichas()) {
				
				nodos[casillaDestino1].ejecutarCrga();
				nodos[casillaDestino1].noPuedenMover(); //En caso de que haya muerto este m�todo no har� nada.
				
			}
			
		}
		
		if(nodos[casillaOrigen].est�Aqu�(f2)) {
			
			Ficha freal2 = nodos[casillaOrigen].quitarFicha(f2);
			nodos[casillaDestino2].ponerFicha(freal2);
			
			if(nodos[casillaDestino2].hayDosFichas()) {
				
				nodos[casillaDestino2].ejecutarCrga();
				nodos[casillaDestino2].noPuedenMover(); //En caso de que haya muerto este m�todo no har� nada.
				
			}
			
		}
		
    }
	
	public void moverFichasDeLaMismaCasillaALaMismaCasilla(Ficha f1, Ficha f2, int casillaOrigen, int casillaDestino) /*Modo retranqueta*/ {
		
		
		nodos[casillaOrigen].ejecutarAtaquesDeHuidas();
		
		if(nodos[casillaOrigen].est�Aqu�(f1)) {
			
			Ficha freal1 = nodos[casillaOrigen].quitarFicha(f1);
			nodos[casillaDestino].ponerFicha(freal1);
			
		}
		
		if(nodos[casillaOrigen].est�Aqu�(f2)) {
			
			Ficha freal2 = nodos[casillaOrigen].quitarFicha(f2);
			nodos[casillaDestino].ponerFicha(freal2);
			
		}
		
    }
	
	public void cruzarFichas(Ficha f1, Ficha f2, int casillaOrigen1, int casillaOrigen2) {
		
		if (Math.random()>=0.5) {
		
			this.moverFicha(f1, casillaOrigen1, casillaOrigen2);
			
			nodos[casillaOrigen2].ejecutarCrgasRespectivas();
			
			nodos[casillaOrigen2].noPuedenMover(); //En caso de que haya muerto este m�todo no har� nada.
		
		}
		else {
			
			this.moverFicha(f2, casillaOrigen2, casillaOrigen1);
			
			nodos[casillaOrigen1].ejecutarCrgasRespectivas();
			
			nodos[casillaOrigen1].noPuedenMover(); //En caso de que haya muerto este m�todo no har� nada.
			
		}
		
    }

    public void resolverTurno() {
    	
    	//Resuelve el turno, haciendo en cada nodo lo que debe.
    	
    	List<Integer> d�ndeDisparar1 = this.d�ndeDispararFlechas(Facci�n.Facci�n1);
    	List<Integer> d�ndeDisparar2 = this.d�ndeDispararFlechas(Facci�n.Facci�n2);
    	
    	int i = 0;
    	
    	for(Nodo n : nodos) {
    		
    		//No hay temor de que dispare un arquero inexistente (muerto), ya que en ese caso d�ndeDispararX no contendr�a i.
    		if(d�ndeDisparar1.contains(i) && !n.hayDosFichas() && n.est�Aqu�(Facci�n.Facci�n2)) {
    			
    			n.recibirDisparo(((Arquero) (nodos[this.d�ndeEst�(new Arquero(Facci�n.Facci�n1))].getFichaDefensora())).realizarDisparo());
    			
    		}
    		if(d�ndeDisparar2.contains(i) && !n.hayDosFichas() && n.est�Aqu�(Facci�n.Facci�n1)) {
    			
    			n.recibirDisparo(((Arquero) (nodos[this.d�ndeEst�(new Arquero(Facci�n.Facci�n2))].getFichaDefensora())).realizarDisparo());
    			
    		}
    		n.resolverTurno();
    		
    		i++;
    		
    	}
    	//As�? un poco simple en demas�a, no creo que con esto est� todo.
    	//No, faltaba a�adir el hecho de que hay que disparar a quien hay que disparar
    	
    }

    public boolean haTerminado() {
    	
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
    	
    	if (!algunoVivo2) return true;
    	
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
    
  //VIENE DEL ANTIGUO Ejecutor, SIRVE PARA MOVER CON UNA DIRECCI�N EN LUGAR DE CON LOS intS.
    public void dispararProyectiles(Catapulta c, int x, int y, Ficha f) {
    	
    	this.dispararProyectiles(c, (4-y)*9 + x, f);
    	
    }
    
    public void dispararProyectiles(Catapulta catapulta, int casillaObjetivo, Ficha f) {
    	
    	//Hace da�o de catapulta a los bichos que haya en la casilla casillaObjetivo.
    	//Ojo! Solo en caso de que la ficha siga ah� o no se haya trabado en combate.
    	if(f != null && f.equals(this.nodos[this.d�ndeEst�(catapulta)].getFichaDefensora()) && !this.nodos[this.d�ndeEst�(catapulta)].hayDosFichas()) {
    		
    		nodos[casillaObjetivo].recibirDisparo(catapulta.realizarDisparo()); 
    		nodos[casillaObjetivo].caeProyectil(); //Para indicar que aqu� ha ca�do un proyectil este turno.
    		
    	}
    	
    }

    public boolean hayFicha(int casilla) {
    	
    	return (nodos[casilla].hayFicha());
    	
    }
    
    //OJOOOO ESTE LO HE A�ADIDO DE FREE TOTALMENTE
    public boolean hayDosFichas(int casilla) {
    	
    	return (nodos[casilla].hayDosFichas());
    	
    }

    public boolean hayFicha(Facci�n fc, int casilla) {
    	
    	return (nodos[casilla].hayFicha());
    	
    }
    
    public List<Integer> catapultasQuePuedesDisparar(Facci�n fc){
    	
    	List<Integer> listaCasillas = new ArrayList<Integer>();
    	
    	int d�ndeCata1 = this.d�ndeEst�(new Catapulta(1));
    	int d�ndeCata2 = this.d�ndeEst�(new Catapulta(2));
    	
    	if(this.nodos[d�ndeCata1].est�Aqu�(fc) && !this.nodos[d�ndeCata1].hayDosFichas()) listaCasillas.add(d�ndeCata1);
    	if(this.nodos[d�ndeCata2].est�Aqu�(fc) && !this.nodos[d�ndeCata2].hayDosFichas()) listaCasillas.add(d�ndeCata2);
    	
    	return listaCasillas;
    	
    }
    
    public List<Integer> d�ndeDispararProyectiles(Catapulta cp) {
    	
    	//Devuelve una lista de enteros que representan las posiciones de las casillas a las que le llega el rango la catapulta dada.
    	List<Integer> posiciones = new ArrayList<Integer>();
    	
    	if(cp == null) return posiciones;
    	
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
    	
    	//Devuelve una lista de enteros que representan las posiciones de las casillas a las que le llega el rango el arquero de la facci�n dada.
    	List<Integer> posiciones = new ArrayList<Integer>();
    	
    	int whereIsTheArcher = this.d�ndeEst�(new Arquero(fc));
    	
    	//En caso de que el arquero no est� (haya muerto) o que est� trabado en combate: No dispara a ning�n sitio: F
    	if(whereIsTheArcher == -1 || nodos[whereIsTheArcher].hayDosFichas()) return posiciones;
    	
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
    	
    	if(whereIsTheArcher == 0) {
			
			posiciones.remove((Integer) 8);
			posiciones.remove((Integer) 7);
			
		}
		else if(whereIsTheArcher == 9) {
			
			posiciones.remove((Integer) 8);
			posiciones.remove((Integer) 17);
			posiciones.remove((Integer) 7);
			posiciones.remove((Integer) 16);
			
		}
		else if(whereIsTheArcher == 18) {
			
			posiciones.remove((Integer) 17);
			posiciones.remove((Integer) 26);
			posiciones.remove((Integer) 8);
			posiciones.remove((Integer) 16);
			posiciones.remove((Integer) 25);
			posiciones.remove((Integer) 7);
			
		}
		else if(whereIsTheArcher == 27) {
			
			posiciones.remove((Integer) 26);
			posiciones.remove((Integer) 35);
			posiciones.remove((Integer) 17);
			posiciones.remove((Integer) 25);
			posiciones.remove((Integer) 34);
			posiciones.remove((Integer) 16);
			
		}
		else if(whereIsTheArcher == 36) {
			
			posiciones.remove((Integer) 35);
			posiciones.remove((Integer) 44);
			posiciones.remove((Integer) 34);
			posiciones.remove((Integer) 43);
			posiciones.remove((Integer) 26);
			posiciones.remove((Integer) 25);
			
		}
		else if(whereIsTheArcher == 8) {
			
			posiciones.remove((Integer) 0);
			posiciones.remove((Integer) 1);
			posiciones.remove((Integer) 9);
			posiciones.remove((Integer) 10);
			posiciones.remove((Integer) 18);
			posiciones.remove((Integer) 19);
			
		}
		else if(whereIsTheArcher == 17) {
			
			posiciones.remove((Integer) 27);
			posiciones.remove((Integer) 28);
			posiciones.remove((Integer) 9);
			posiciones.remove((Integer) 10);
			posiciones.remove((Integer) 18);
			posiciones.remove((Integer) 19);
			
		}
		else if(whereIsTheArcher == 26) {

			posiciones.remove((Integer) 36);
			posiciones.remove((Integer) 37);
			posiciones.remove((Integer) 18);
			posiciones.remove((Integer) 19);
			posiciones.remove((Integer) 27);
			posiciones.remove((Integer) 28);
			
		}
		else if(whereIsTheArcher == 35) {
			
			posiciones.remove((Integer) 27);
			posiciones.remove((Integer) 28);
			posiciones.remove((Integer) 36);
			posiciones.remove((Integer) 37);
			
		}
		else if(whereIsTheArcher == 44) {
			
			posiciones.remove((Integer) 36);
			posiciones.remove((Integer) 37);
			
		}
    	
    	for(int i = 0; i < posiciones.size(); i++) {
    		
    		if(posiciones.get(i) < 0 || posiciones.get(i) >= 45) {
    			
    			posiciones.remove((Integer) i);
    			
    		}
    		
    	}
    	
    	return posiciones;
    	
    }
    
    //PARA ASISTIR EL MOVIMIENTO DENTRO DEL CLIENTE
    public List<Integer> d�ndePuedeMover(Ficha f) {
    	List<Integer> movPosibles = new ArrayList<Integer>();
		Integer x;
    	//Faltan cosas
    	int d�ndeEst� = this.d�ndeEst�(f);
    	
    	if(d�ndeEst� -9 >=0)
    		movPosibles.add(d�ndeEst� - 9);
    	
    	if(d�ndeEst� -8 >=0)
    		movPosibles.add(d�ndeEst� - 8);
    	
    	if(d�ndeEst� -10 >=0)
    		movPosibles.add(d�ndeEst� - 10);
    	
    	if(d�ndeEst� -1 >=0)
    		movPosibles.add(d�ndeEst� - 1);
    	
    	if(d�ndeEst� +9 <45)
    		movPosibles.add(d�ndeEst� + 9);
    	
    	if(d�ndeEst� +8 <45)
    		movPosibles.add(d�ndeEst� + 8);
    	
    	if(d�ndeEst� +10 <45)
    		movPosibles.add(d�ndeEst� + 10);
    	
    	if(d�ndeEst� +1 <45)
    		movPosibles.add(d�ndeEst� + 1);
    	
    	int j;
    	
    	if(d�ndeEst� == 0) {
			x = 8;
			movPosibles.remove(x);
			x = 17;
			movPosibles.remove(x);
			x = 26;
			movPosibles.remove(x);
			
		}
		else if(d�ndeEst� == 9) {
			x = 17;
			movPosibles.remove(x);
			x = 8;
			movPosibles.remove(x);
			x = 26;
			movPosibles.remove(x);
			x = 35;
			movPosibles.remove(x);
			
		}
		else if(d�ndeEst� == 18) {
			x = 26;
			movPosibles.remove(x);
			x = 17;
			movPosibles.remove(x);
			x = 35;
			movPosibles.remove(x);
			x = 8;
			movPosibles.remove(x);
		}
		else if(d�ndeEst� == 27) {
			x = 35;
			movPosibles.remove(x);
			x = 26;
			movPosibles.remove(x);
			x = 44;
			movPosibles.remove(x);
		}
		else if(d�ndeEst� == 36) {
			x = 44;
			movPosibles.remove(x);
			x=35;
			movPosibles.remove(x);
		}
		else if(d�ndeEst� == 8) {
			x = 0;
			movPosibles.remove(x);
			x=9;
			movPosibles.remove(x);
			x = 18;
			movPosibles.remove(x);
		}
		else if(d�ndeEst� == 17) {
			x=9;
			movPosibles.remove(x);
			x = 18;
			movPosibles.remove(x);
			x = 27;
			movPosibles.remove(x);
			
		}
		else if(d�ndeEst� == 26) {
			x = 18;
			movPosibles.remove(x);
			x = 9;
			movPosibles.remove(x);
			x = 27;
			movPosibles.remove(x);
			x= 0;
			movPosibles.remove(x);
			x = 36;
			movPosibles.remove(x);
		}
		else if(d�ndeEst� == 35) {
			x = 27;
			movPosibles.remove(x);
			x = 18;
			movPosibles.remove(x);
			x = 36;
			movPosibles.remove(x);
		}
		else if(d�ndeEst� == 44) {
			x = 36;
			movPosibles.remove(x);
			x = 27;
			movPosibles.remove(x);
			
		}
    	
    	for(int i = 0; i < movPosibles.size(); i++) {
    		
//    		if(movPosibles.get(i) < 0 || movPosibles.get(i) >= 45) {
//    			
//    			j = movPosibles.remove(i);
//    			
//    		}
/*    		else */ if(nodos[movPosibles.get(i)].est�Aqu�(f.getFacci�n())) {
    			
    			j = movPosibles.remove(i);
    			
    		}
    		
    	}
    	
    	return movPosibles;
    	
    }
    
    public List<Integer> qui�nesPuedenMover(Facci�n fc) {
    	
    	//A esto hay que quitarle los que ya han movido dos (o si es el caballo tres) veces en este turno.
    	List<Integer> movPosibles = new ArrayList<Integer>();
    	
    	for(int i = 0; i < 45; i++) {
    		
    		if(nodos[i].est�Aqu�(fc)) movPosibles.add(i);
    		
    	}
    	
    	return movPosibles;
    	
    }
    
   public List<Integer> qui�nesNOPuedenMover(Facci�n fc) {
    	
    	//A esto hay que quitarle los que ya han movido dos (o si es el caballo tres) veces en este turno.
    	List<Integer> movPosibles = new ArrayList<Integer>();
    	
    	for(int i = 0; i < 45; i++) {
    		
    		if(!nodos[i].est�Aqu�(fc)) movPosibles.add(i);
    		
    	}
    	
    	return movPosibles;
    	
    }
    
    public Ficha qu�FichaHay(Facci�n fc, int casilla) {
    	
    	if(nodos[casilla].est�Aqu�(fc)) {
    		
    		Ficha f;
    		
    		if((f = nodos[casilla].getFichaDefensora()).getFacci�n() == fc) return f;
    		else return nodos[casilla].getFichaAtacante();
    		
    	}
    	else return null;
    	
    }

    public Nodo getNodo(int i) {
    	
    	return this.nodos[i];
    	
    }
    
    public Object clone() {
    	
    	Object clone = null;
    	
    	Nodo[] nodosClonados = new Nodo[45];
    	
    	for(int i = 0; i < 45; i++) {
    		
    		nodosClonados[i] = (Nodo) this.nodos[i].clone();
    		
    	}
    	
    	clone = new Tablero(nodosClonados);
    	
    	return clone;
    	
    }
    
    //M�todos "mover" para que no se resulva la carga ni los da�os:
    
    public void moverFichaGraficamente(Ficha f, Direcci�n d) {
    		
    		int desde = this.d�ndeEst�(f);
    		int hasta; //Ojito porque aqu� hay que pasar de coordenadas a posici�n en el vector.
    		
    		if(d == Direcci�n.norte) hasta = desde - 9;
    		else if(d == Direcci�n.sur) hasta = desde + 9;
    		else if(d == Direcci�n.este) hasta = desde + 1;
    		else if(d == Direcci�n.oeste) hasta = desde - 1;
    		else if(d == Direcci�n.noreste) hasta = desde - 8;
    		else if(d == Direcci�n.noroeste) hasta = desde - 10;
    		else if(d == Direcci�n.sureste) hasta = desde + 10;
    		else /*if(d == Direcci�n.suroeste)*/ hasta = desde + 8;
    		
    		this.moverFichaGraficamente(f, desde, hasta);
    	
    }
    
	public void moverFichaGraficamente(Ficha f, int casillaOrigen, int casillaDestino) {
		
		Ficha freal = nodos[casillaOrigen].quitarFicha(f);
		nodos[casillaDestino].ponerFicha(freal);
		
    }
	
	public Element getElemento(Document doc) {
		
		Element tableroE = doc.createElement("Tablero");
		
		for(int i = 0; i < 45; i++) {
			
			tableroE.appendChild(this.nodos[i].getElemento(doc));
			
		}
		
		return tableroE;
		
	}
	
	public static Tablero getFromElemento(Element e) {
        
        NodeList hijos = e.getChildNodes();
        Element hijo;
        
        Nodo[] nodos = new Nodo[45];
        int index = 0;
        
        for(int i = 0; i < hijos.getLength(); i++) {
        	
        	if(hijos.item(i).getNodeType() == Node.ELEMENT_NODE) {
        		
        		hijo = (Element) hijos.item(i);
        		
        		nodos[index] = Nodo.getFromElemento(hijo);
        		index++;
        		
        	}
        	
        }
        
        return new Tablero(nodos);
    	
    }
	
	public void limpiarProyectiles() {
		
		for(int i = 0; i < 45; i++) {
			
			nodos[i].limpiarProyectil();
			
		}
		
	}
    
}
