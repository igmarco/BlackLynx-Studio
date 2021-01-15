package MD_Tablero;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Curaci�n extends Casilla {

	private int curaci�n;

	private int curaci�nVariable;
	
	private int identificador;
	
	public Curaci�n() {
    	
		super();
		this.curaci�n = 10;
		this.curaci�nVariable = 5;
		this.identificador = 0;
	}

    public Curaci�n(int identificador) {
    	
		super();
		this.curaci�n = 10;
		this.curaci�nVariable = 5;
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
    
    public int getCuraci�n() {
    	
    	return this.curaci�n;
    	
    }
    
    public boolean equals(Casilla c) {

    	//Si tiene el mismo tipo de casilla (en caso de la catapulta y la curaci�n tiene que tener el identificador igual (o 0)).
		
		if(c == null) return false;
		else if(c.getClass() != this.getClass()) return false;
		else if((((Curaci�n) c).getIdentificador() != this.getIdentificador()) && (((Curaci�n) c).getIdentificador() != 0)) return false;
		else return true;
		
	}
    
    public Element getElemento(Document doc) {
        
        Element CasillaE = super.getElemento(doc);
        
        Element curaci�nE = doc.createElement("curaci�n");
        curaci�nE.appendChild(doc.createTextNode("" + this.curaci�n));
        
        Element curaci�nVariableE = doc.createElement("curaci�nVariable");
        curaci�nVariableE.appendChild(doc.createTextNode("" + this.curaci�nVariable));
        
        Element identificadorE = doc.createElement("identificador");
        identificadorE.appendChild(doc.createTextNode("" + this.identificador));
		
        CasillaE.appendChild(curaci�nE);
        CasillaE.appendChild(curaci�nVariableE);
        CasillaE.appendChild(identificadorE);
		
		return CasillaE;
    	
    }

}
