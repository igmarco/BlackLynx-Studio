package MD_Tablero;

public class Normal extends Casilla {
	
	public Normal() {
    	
		super();
	}
    
    public Normal(HachaDivas�nica hachaDivas�nica) {
		super(hachaDivas�nica);
	}
    
    public Normal(HachaDivas�nica hachaDivas�nica, boolean casillaDeCuraci�n) {
		super(hachaDivas�nica, casillaDeCuraci�n);
	}
    
    public Normal(HachaDivas�nica hachaDivas�nica, int curaci�nAuxiliar) {
		
    	super(hachaDivas�nica, curaci�nAuxiliar);
		
	}
    
}
