package LN;
import java.util.ArrayList;
import java.util.List;

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

public class Tablero {
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
    		
    		int desde = this.d�ndeEst�(f);
    		int hasta; //Ojito porque aqu� hay que pasar de coordenadas a posici�n en el vector.
    		
    		if(d == Direcci�n.derecha) hasta = desde + 1;
    		else if(d == Direcci�n.izquierda) hasta = desde - 1;
    		else if(d == Direcci�n.abajo) hasta = desde + 9;
    		else hasta = desde - 9;
    		
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
				nodos[casillaDestino].noPuedeMover(f); //En caso de que haya muerto este m�todo no har� nada.
				
			}
			
		}
		
    }
	
	//VIENE DEL ANTIGUO Ejecutor, SIRVE PARA MOVER CON UNA DIRECCI�N EN LUGAR DE CON LOS intS.
	//EN CASO DE QUE UNA MUEVA Y OTRA HAGA OTRA COSA USAMOS moverFicha(), Y SI HAY QUE MOVER DOS ENTONCES LE METEMOS A moverFichasALaVez()
    public void moverFichasALaVez(Ficha f1, Direcci�n d1, Ficha f2, Direcci�n d2) {
    		
    		int desde1 = this.d�ndeEst�(f1);
    		int hasta1;
    		
    		if(d1 == Direcci�n.derecha) hasta1 = desde1 + 1;
    		else if(d1 == Direcci�n.izquierda) hasta1 = desde1 - 1;
    		else if(d1 == Direcci�n.abajo) hasta1 = desde1 + 9; 
    		else hasta1 = desde1 - 9;
    		
    		int desde2 = this.d�ndeEst�(f2);
    		int hasta2;
    		
    		if(d2 == Direcci�n.derecha) hasta2 = desde2 + 1;
    		else if(d2 == Direcci�n.izquierda) hasta2 = desde2 - 1;
    		else if(d2 == Direcci�n.abajo) hasta2 = desde2 + 9;
    		else hasta2 = desde2 - 9;
    		
    		//Comrpobaciones y �rdenes
    		if(hasta1 == desde2) {
    			
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
    	
    }
	
	//NUEVO M�TODO, PARA CUANDO DOS FICHAS SE MUEVEN A UNA SOLA CASILLA COM�N
	public void moverFichasALaMismaCasilla(Ficha f1, Ficha f2, int casillaOrigen1, int casillaOrigen2, int casillaDestino) {
		
		//Mueve y resuelve combate
		if(nodos[casillaOrigen1].hayDosFichas()) {
			
			nodos[casillaOrigen1].ejecutarAtaqueContraHuida(f1);
			
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
			
			nodos[casillaDestino].noPuedeMover(f1); //En caso de que haya muerto este m�todo no har� nada.
			nodos[casillaDestino].noPuedeMover(f2); //En caso de que haya muerto este m�todo no har� nada.
			
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
    	
    	this.dispararProyectiles(c, (5-y)*9 + x-1, f);
    	
    }
    
    public void dispararProyectiles(Catapulta catapulta, int casillaObjetivo, Ficha f) {
    	
    	//Hace da�o de catapulta a los bichos que haya en la casilla casillaObjetivo.
    	//Ojo! Solo en caso de que la ficha siga ah� o no se haya trabado en combate.
    	if(f != null && f.equals(this.nodos[this.d�ndeEst�(catapulta)].getFichaDefensora()) && !this.nodos[this.d�ndeEst�(catapulta)].hayDosFichas()) {
    		
    		nodos[casillaObjetivo].recibirDisparo(catapulta.realizarDisparo());
    		
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
    
    //ESTE M�TODO NO CREO QUE LO UTILICEMOS. F
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
    	
    	int j;
    	
    	if(whereIsTheArcher == 0) {
			
			j = posiciones.remove(8);
			j = posiciones.remove(17);
			
		}
		else if(whereIsTheArcher == 9) {
			
			j = posiciones.remove(8);
			j = posiciones.remove(17);
			j = posiciones.remove(26);
			
		}
		else if(whereIsTheArcher == 18) {
			
			j = posiciones.remove(17);
			j = posiciones.remove(26);
			j = posiciones.remove(35);
			
		}
		else if(whereIsTheArcher == 27) {
			
			j = posiciones.remove(26);
			j = posiciones.remove(35);
			j = posiciones.remove(44);
			
		}
		else if(whereIsTheArcher == 36) {
			
			j = posiciones.remove(35);
			j = posiciones.remove(44);
			
		}
		else if(whereIsTheArcher == 8) {
			
			j = posiciones.remove(0);
			j = posiciones.remove(1);
			j = posiciones.remove(9);
			j = posiciones.remove(10);
			
		}
		else if(whereIsTheArcher == 17) {
			
			j = posiciones.remove(0);
			j = posiciones.remove(1);
			j = posiciones.remove(9);
			j = posiciones.remove(10);
			j = posiciones.remove(18);
			j = posiciones.remove(19);
			
		}
		else if(whereIsTheArcher == 26) {

			j = posiciones.remove(9);
			j = posiciones.remove(10);
			j = posiciones.remove(18);
			j = posiciones.remove(19);
			j = posiciones.remove(27);
			j = posiciones.remove(28);
			
		}
		else if(whereIsTheArcher == 35) {
			
			j = posiciones.remove(18);
			j = posiciones.remove(19);
			j = posiciones.remove(27);
			j = posiciones.remove(28);
			j = posiciones.remove(36);
			j = posiciones.remove(37);
			
		}
		else if(whereIsTheArcher == 44) {
			
			j = posiciones.remove(27);
			j = posiciones.remove(28);
			j = posiciones.remove(36);
			j = posiciones.remove(37);
			
		}
    	
    	for(int i = 0; i < posiciones.size(); i++) {
    		
    		if(posiciones.get(i) < 0 || posiciones.get(i) >= 45) {
    			
    			j = posiciones.remove(i);
    			
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
    		
    		if(movPosibles.get(i) < 0 || movPosibles.get(i) >= 45) {
    			
    			j = movPosibles.remove(i);
    			
    		}
    		else if(nodos[movPosibles.get(i)].est�Aqu�(f.getFacci�n())) {
    			
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
    
}
