package MD_Tablero;
import Utilidades.Facci�n;

public class Copa extends Casilla {
	
    public Facci�n facci�n;

    public int vida;
    
    public Copa() {
		super();
//		this.facci�n = 
//		this.vida = 
	}
    
    public Copa(Facci�n facci�n) {
		super();
		this.facci�n = facci�n;
//		this.vida = 
	}
    
    public Copa(Facci�n facci�n, int vida) {
		super();
		this.facci�n = facci�n;
		this.vida = vida;
	}
    
    public void sufrirDa�o(int da�o) {
    	
    	vida = vida - da�o;
    	
    }
    
    public boolean est�Muerta() {
    	
    	return (vida <= 0);
    	
    }

}
