package MD_Tablero;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Catapulta extends Casilla {
	private int da�oProyectiles;

	private int da�oProyectilesVariable;
	
	private int identificador;
	
	public Catapulta() {
		super();
		this.da�oProyectiles = 15;
		this.da�oProyectilesVariable = 7;
		this.identificador = 0;
	}
	
	public Catapulta(int identificador) {
		super();
		this.da�oProyectiles = 15;
		this.da�oProyectilesVariable = 7;
		this.identificador = identificador;
	}
	
	public Catapulta(int identificador, boolean casillaDeCuraci�n) {
		super(null, casillaDeCuraci�n);
		this.da�oProyectiles = 15;
		this.da�oProyectilesVariable = 7;
		this.identificador = identificador;
	}
    
    public Catapulta(int da�oProyectiles, int da�oProyectilesVariable, HachaDivas�nica hachaDivas�nica, int identificador, boolean casillaDeCuraci�n) {
		super(hachaDivas�nica);
		this.da�oProyectiles = da�oProyectiles;
		this.da�oProyectilesVariable = da�oProyectilesVariable;
		this.identificador = identificador;
	}

    public int realizarDisparo() {
    	
    	return da�oProyectiles + (int) Math.floor(Math.random()*2*(da�oProyectilesVariable)-1);
    	
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
    
    public Element getElemento(Document doc) {
        
        Element CasillaE = super.getElemento(doc);
        
        Element da�oProyectilesE = doc.createElement("da�oProyectiles");
        da�oProyectilesE.appendChild(doc.createTextNode("" + this.da�oProyectiles));
        
        Element da�oProyectilesVariableE = doc.createElement("da�oProyectilesVariable");
        da�oProyectilesVariableE.appendChild(doc.createTextNode("" + this.da�oProyectilesVariable));
        
        Element identificadorE = doc.createElement("identificador");
        identificadorE.appendChild(doc.createTextNode("" + this.identificador));
		
        CasillaE.appendChild(da�oProyectilesE);
        CasillaE.appendChild(da�oProyectilesVariableE);
        CasillaE.appendChild(identificadorE);
		
		return CasillaE;
    	
    }

}
