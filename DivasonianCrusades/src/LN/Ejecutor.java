package LN;

import MD_Tablero.Catapulta;
import MD_Tablero.Ficha;
import Utilidades.Direcci�n;
import Utilidades.Facci�n;

public class Ejecutor {
	
	//--------------------------------------------------------
	//--------------------------------------------------------
	//----------------------- ATENCI�N -----------------------
	//--------------------------------------------------------
	//--------------------------------------------------------
	//
	//  ESTA CLASE YA NO EST� EN USO. OFREC�A FUNCIONALIDAD
	//     ADICIONAL A LA CLASE Tablero, POR LO QUE HEMOS
	//     INTEGRADO LOS M�TODOS DE Ejecutor EN LA PROPIA
	//                     CLASE Tablero.
	//
	//--------------------------------------------------------
	//--------------------------------------------------------
	
    public Tablero tablero;
    
    public Ejecutor(Tablero tablero) {
		
		this.tablero = tablero;
		
	}

	public Ejecutor() {
	
		this.tablero = new Tablero();
	
	}

	public void moverFicha(Ficha f, Direcci�n d) {
    	
//    	if(tablero.movimientoPosible(f)) {
    		
    		int desde = tablero.d�ndeEst�(f);
    		int hasta; //Ojito porque aqu� hay que pasar de coordenadas a posici�n en el vector.
    		
//    		if(d == Direcci�n.derecha) hasta = desde + 1;
//    		else if(d == Direcci�n.izquierda) hasta = desde - 1;
//    		else if(d == Direcci�n.abajo) hasta = desde + 9;
//    		else hasta = desde - 9;
    		
    		if(d == Direcci�n.norte) hasta = desde - 9;
    		else if(d == Direcci�n.sur) hasta = desde + 9;
    		else if(d == Direcci�n.este) hasta = desde + 1;
    		else if(d == Direcci�n.oeste) hasta = desde - 1;
    		else if(d == Direcci�n.noreste) hasta = desde - 8;
    		else if(d == Direcci�n.noroeste) hasta = desde - 10;
    		else if(d == Direcci�n.sureste) hasta = desde + 10;
    		else /*if(d == Direcci�n.suroeste)*/ hasta = desde + 8;
    		 
    		tablero.moverFicha(f, desde, hasta); 
    		
//    	}
    	
    }
    public void dispararProyectiles(Catapulta c, int x, int y, Ficha f) {
    	
    	tablero.dispararProyectiles(c, (5-y)*9 + x-1, f);
    	
    }

    public boolean haTerminado() {
    	
    	return tablero.haTerminado();
    	
    }

    public Facci�n getGanador() {
    	
    	return tablero.getGanador();
    	
    }

    public void resolverTurno() {
    	
    	tablero.resolverTurno();
    	//Puede que haya que hacer algo m�s
    	//Pues puede ser, bro, no s�, t� sabr�s
    	
    }
    
    //EN CASO DE QUE UNA MUEVA Y OTRA HAGA OTRA COSA USAMOS moverFicha(), Y SI HAY QUE MOVER DOS ENTONCES LE METEMOS A moverFichasALaVez()
    public void moverFichasALaVez(Ficha f1, Direcci�n d1, Ficha f2, Direcci�n d2) {
    		
    		int desde1 = tablero.d�ndeEst�(f1);
    		int hasta1;
    		
//    		if(d1 == Direcci�n.derecha) hasta1 = desde1 + 1;
//    		else if(d1 == Direcci�n.izquierda) hasta1 = desde1 - 1;
//    		else if(d1 == Direcci�n.abajo) hasta1 = desde1 + 9;
//    		else hasta1 = desde1 - 9;
    		
    		if(d1 == Direcci�n.norte) hasta1 = desde1 - 9;
    		else if(d1 == Direcci�n.sur) hasta1 = desde1 + 9;
    		else if(d1 == Direcci�n.este) hasta1 = desde1 + 1;
    		else if(d1 == Direcci�n.oeste) hasta1 = desde1 - 1;
    		else if(d1 == Direcci�n.noreste) hasta1 = desde1 - 8;
    		else if(d1 == Direcci�n.noroeste) hasta1 = desde1 - 10;
    		else if(d1 == Direcci�n.sureste) hasta1 = desde1 + 10;
    		else /*if(d == Direcci�n.suroeste)*/ hasta1 = desde1 + 8;
    		
    		int desde2 = tablero.d�ndeEst�(f2);
    		int hasta2;
    		
//    		if(d2 == Direcci�n.derecha) hasta2 = desde2 + 1;
//    		else if(d2 == Direcci�n.izquierda) hasta2 = desde2 - 1;
//    		else if(d2 == Direcci�n.abajo) hasta2 = desde2 + 9;
//    		else hasta2 = desde2 - 9;
    		
    		if(d2 == Direcci�n.norte) hasta2 = desde2 - 9;
    		else if(d2 == Direcci�n.sur) hasta2 = desde2 + 9;
    		else if(d2 == Direcci�n.este) hasta2 = desde2 + 1;
    		else if(d2 == Direcci�n.oeste) hasta2 = desde2 - 1;
    		else if(d2 == Direcci�n.noreste) hasta2 = desde2 - 8;
    		else if(d2 == Direcci�n.noroeste) hasta2 = desde2 - 10;
    		else if(d2 == Direcci�n.sureste) hasta2 = desde2 + 10;
    		else /*if(d == Direcci�n.suroeste)*/ hasta2 = desde2 + 8;
    		
    		//Comrpobaciones y �rdenes
    		if(hasta1 == desde2) {
    			
    			tablero.moverFicha(f2, desde2, hasta2);
    			tablero.moverFicha(f1, desde1, hasta1);
    			
    		}
    		else if(hasta2 == desde1) {
    			
    			tablero.moverFicha(f1, desde1, hasta1);
    			tablero.moverFicha(f2, desde2, hasta2);
    			
    		}
    		else if(hasta1 == hasta2) {
    			
    			tablero.moverFichasALaMismaCasilla(f1, f2, desde1, desde2, hasta1);
    			
    		}
    	
    }
    
}
