package MD_Tablero;

public class Curaci�n extends Casilla {

	private int curaci�n;

	private int curaci�nVariable;
	
	private int identificador;
	
	public Curaci�n() {
    	
		super();
//		this.curaci�n = ;
//		this.curaci�nVariable = ;
		this.identificador = 0;
	}

    public Curaci�n(int identificador) {
    	
		super();
//		this.curaci�n = ;
//		this.curaci�nVariable = ;
		this.identificador = identificador;
	}
    
    public Curaci�n(int curaci�n, int curaci�nVariable, HachaDivas�nica hachaDivas�nica,int identificador) {
		super(hachaDivas�nica);
		this.curaci�n = curaci�n;
		this.curaci�nVariable = curaci�nVariable;
		this.identificador = identificador;
	}
    
    public int curar() {
    	
    	return curaci�n + (int) Math.floor(Math.random()*2*(curaci�nVariable)-1);
    	
    }
    
    public int getIdentificador() {
    	
    	return this.identificador;
    	
    }
    
    public boolean equals(Casilla c) {

    	//Si tiene el mismo tipo de casilla (en caso de la catapulta y la curaci�n tiene que tener el identificador igual (o 0)).
		
		if(c == null) return false;
		else if(c.getClass() != this.getClass()) return false;
		else if((((Curaci�n) c).getIdentificador() != this.getIdentificador()) && (((Curaci�n) c).getIdentificador() != 0)) return false;
		else return true;
		
	}

}
