package MD_Instrucci�n;

import java.util.ArrayList;
import java.util.List;

public class Instrucci�n<Operaci�n> extends ArrayList<Operaci�n> {
	
	public Instrucci�n() {
		super();
	}
	
	public Operaci�n getOperacion(int x) {
		return this.get(x);
	}
	
}
