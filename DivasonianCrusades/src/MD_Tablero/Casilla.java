package MD_Tablero;

public abstract class Casilla {
	protected HachaDivas�nica hachaDivas�nica;
	protected boolean casillaDeCura;
	
	public Casilla() {
		
		this.hachaDivas�nica = null;
		this.casillaDeCura = false;
		
	}
	
	public Casilla(HachaDivas�nica hachaDivas�nica) {
		
		this.hachaDivas�nica = hachaDivas�nica;
		this.casillaDeCura = false;
		
	}

	
	public Casilla(HachaDivas�nica hachaDivas�nica, boolean casillaDeCura) {
		
		this.hachaDivas�nica = hachaDivas�nica;
		this.casillaDeCura = casillaDeCura;
		
	}

    public void setHachaDivas�nica(HachaDivas�nica hachaDivas�nica) {
    	
    	this.hachaDivas�nica = hachaDivas�nica;
    	
    }
    
public HachaDivas�nica getHachaDivas�nica() {
    	
    	return hachaDivas�nica;
    	
    }
    
    public boolean equals(Casilla c) {

    	//Si tiene el mismo tipo de casilla (en caso de la copa tiene que ser de la misma facci�n).
		
		if(c == null) return false;
//		else if(c.getFacci�n() != this.getFacci�n()) return false;
		else if(c.getClass() != this.getClass()) return false;
		else return true;
		
	}

    public boolean tieneHacha() {
    	
    	return (hachaDivas�nica != null);
    	
    }

}
