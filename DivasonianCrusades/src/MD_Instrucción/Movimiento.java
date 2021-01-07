package MD_Instrucci�n;
import MD_Tablero.Ficha;
import Utilidades.Direcci�n;

public class Movimiento extends Operaci�n {
	private Direcci�n direcci�n;
	
	public Movimiento(Ficha f, Direcci�n direcci�n) {
		
		super(f);
		this.direcci�n = direcci�n;
		
	}

    public Direcci�n getDirecci�n() {
    	
    	return direcci�n;
    	
    }

}
