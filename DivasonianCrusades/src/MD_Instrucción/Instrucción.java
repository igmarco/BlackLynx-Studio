package MD_Instrucci�n;

public class Instrucci�n {
	private Operaci�n[] operaciones = new Operaci�n[6];
	
	public Instrucci�n() {
		
		for(int i = 0; i<6; i++) {
			
			operaciones[i] = null;
			
		}
		
	}
	
	public Instrucci�n(Operaci�n[] operaciones) {
		
		this.operaciones = operaciones;
		
	}

    public Operaci�n getOperacion(int n) {
    	
    	return operaciones[n];
    	
    }

}
