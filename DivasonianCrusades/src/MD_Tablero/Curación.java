package MD_Tablero;


//TERMINADA SALVO PAR�METROS


public class Curaci�n extends Casilla {

	public int curaci�n;

    public int curaci�nVariable;

    public Curaci�n() {
    	
		super();
//		this.curaci�n = ;
//		this.curaci�nVariable = ;
	}
    
    public Curaci�n(int curaci�n, int curaci�nVariable) {
		super();
		this.curaci�n = curaci�n;
		this.curaci�nVariable = curaci�nVariable;
	}
    
    public int curar() {
    	
    	return curaci�n + (int) Math.floor(Math.random()*2*(curaci�nVariable)-1);
    	
    }

}
