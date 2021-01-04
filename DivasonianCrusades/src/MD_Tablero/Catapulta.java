package MD_Tablero;

public class Catapulta extends Casilla {
	private int da�oProyectiles;

	private int da�oProyectilesVariable;

	private int rango;
	
	private int identificador;
	
	public Catapulta() {
		super();
//		this.da�oProyectiles = ;
//		this.da�oProyectilesVariable = ;
//		this.rango = ;
		this.identificador = 0;
	}
	
	public Catapulta(int identificador) {
		super();
//		this.da�oProyectiles = ;
//		this.da�oProyectilesVariable = ;
//		this.rango = ;
		this.identificador = identificador;
	}
    
    public Catapulta(int da�oProyectiles, int da�oProyectilesVariable, int rango, HachaDivas�nica hachaDivas�nica, int identificador) {
		super(hachaDivas�nica);
		this.da�oProyectiles = da�oProyectiles;
		this.da�oProyectilesVariable = da�oProyectilesVariable;
		this.rango = rango;
		this.identificador = identificador;
	}

    public int realizarDisparo() {
    	
    	return da�oProyectiles + (int) Math.floor(Math.random()*2*(da�oProyectilesVariable)-1);
    	
    }

    public int getRango() {
    	
    	return this.rango;
    	
    }
    
    public int getIdentificador() {
    	
    	return this.identificador;
    	
    }
    
    public boolean equals(Casilla c) {

    	//Si tiene el mismo tipo de casilla (en caso de la catapulta y la curaci�n hay que tener un identificador que determine la posici�n).
		
		if(c == null) return false;
		else if(c.getClass() != this.getClass()) return false;
		else if((((Catapulta) c).getIdentificador() != this.getIdentificador()) && (((Catapulta) c).getIdentificador() != 0)) return false;
		else return true;
		
	}

}
