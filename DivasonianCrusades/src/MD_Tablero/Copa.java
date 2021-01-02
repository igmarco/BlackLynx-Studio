package MD_Tablero;
import Utilidades.Facci�n;

public class Copa extends Casilla {
	
    private Facci�n facci�n;

    private int vida;
    
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
    
    public Copa(Facci�n facci�n, int vida, HachaDivas�nica hachaDivas�nica) {
		super(hachaDivas�nica);
		this.facci�n = facci�n;
		this.vida = vida;
	}
    
    public void sufrirDa�o(int da�o) {
    	
    	vida = vida - da�o;
    	
    }
    
    public boolean est�Muerta() {
    	
    	return (vida <= 0);
    	
    }
    
    public Facci�n getFacci�n() {
    	
    	return this.facci�n;
    	
    }
    
    public boolean equals(Casilla c) {

    	//Si tiene el mismo tipo de casilla (en caso de la copa (este en concreto) tiene que ser de la misma facci�n).
		
		if(c == null) return false;
		else if(c.getClass() != this.getClass()) return false;
		else if(((Copa) c).getFacci�n() != this.getFacci�n()) return false;
		else return true;
		
	}

}
