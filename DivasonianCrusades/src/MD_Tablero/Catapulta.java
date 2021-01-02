package MD_Tablero;

public class Catapulta extends Casilla {
	private int da�oProyectiles;

	private int da�oProyectilesVariable;

	private int rango;
	
	public Catapulta() {
		super();
//		this.da�oExtra = 
	}
    
    public Catapulta(int da�oProyectiles, int da�oProyectilesVariable, int rango, HachaDivas�nica hachaDivas�nica) {
		super(hachaDivas�nica);
		this.da�oProyectiles = da�oProyectiles;
		this.da�oProyectilesVariable = da�oProyectilesVariable;
		this.rango = rango;
	}

    public int realizarDisparo() {
    	
    	return da�oProyectiles + (int) Math.floor(Math.random()*2*(da�oProyectilesVariable)-1);
    	
    }

    public int getRango() {
    	
    	return this.rango;
    	
    }

}
