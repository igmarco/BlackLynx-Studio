package LN;

import MD_Instrucci�n.Instrucci�n;
import MD_Tablero.Ficha;
import MD_Tablero.Tablero;
import Utilidades.Direcci�n;
import Utilidades.Facci�n;

public class Ejecutor {
    public Tablero tablero;
    
    public Ejecutor(Tablero tablero) {
		
		this.tablero = tablero;
		
	}

	public Ejecutor() {
	
		this.tablero = new Tablero();
	
	}

    public void moverFicha(Ficha f, Facci�n fc, Direcci�n d) {
    	
    	if(tablero.movimientoPosible(f, fc)) {
    		
    		int desde = tablero.d�ndeEst�(f,fc);
//    		int hasta = //Ojito porque aqu� hay que pasar de coordenadas a posici�n en el vector.
    		
    		tablero.moverFicha(desde, hasta);
    		
    	}
    	
    }
    public void dispararProyectiles(int x, int y) {
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
    	
    }

}
