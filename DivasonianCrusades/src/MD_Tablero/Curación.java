package MD_Tablero;

public class Curaci�n extends Casilla {

	private int curaci�n;

	private int curaci�nVariable;

    public Curaci�n() {
    	
		super();
//		this.curaci�n = ;
//		this.curaci�nVariable = ;
	}
    
    public Curaci�n(int curaci�n, int curaci�nVariable, HachaDivas�nica hachaDivas�nica) {
		super(hachaDivas�nica);
		this.curaci�n = curaci�n;
		this.curaci�nVariable = curaci�nVariable;
	}
    
    public int curar() {
    	
    	return curaci�n + (int) Math.floor(Math.random()*2*(curaci�nVariable)-1);
    	
    }

}
