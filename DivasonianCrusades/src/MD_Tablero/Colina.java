package MD_Tablero;

public class Colina extends Casilla {
	private int da�oExtra;

	public Colina() {
		super();
//		this.da�oExtra = 
	}
	
	public Colina(int da�oExtra, HachaDivas�nica hachaDivas�nica) {
		super(hachaDivas�nica);
		this.da�oExtra = da�oExtra;
	}
    
    public Colina(int da�oExtra, HachaDivas�nica hachaDivas�nica, boolean casillaDeCuraci�n) {
		super(hachaDivas�nica, casillaDeCuraci�n);
		this.da�oExtra = da�oExtra;
	}
    
    public int getDa�oExtra() {
    	
    	return this.da�oExtra;
    	
    }
	
} 
