package MD_Instrucci�n;
import java.io.Serializable;

import MD_Tablero.Ficha;

public class Operaci�n implements Serializable{
    private Ficha ficha;
    
    public Operaci�n(Ficha ficha) {
    	
    	this.ficha = ficha;
    	
    }

    public Ficha getFicha() {
    	
    	return ficha;
    	
    }

}
