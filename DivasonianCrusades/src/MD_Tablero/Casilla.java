package MD_Tablero;

import java.io.Serializable;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import Utilidades.Facci�n;

public abstract class Casilla implements Cloneable, Serializable {
	protected HachaDivas�nica hachaDivas�nica;
	protected int curaci�nAuxiliar;
	
	public Casilla() {
		
		this.hachaDivas�nica = null;
		this.curaci�nAuxiliar = 0;
		
	}
	
	public Casilla(HachaDivas�nica hachaDivas�nica) {
		
		this.hachaDivas�nica = hachaDivas�nica;
		this.curaci�nAuxiliar = 0;
		
	}

	
	public Casilla(HachaDivas�nica hachaDivas�nica, boolean casillaDeCura) {
		
		this.hachaDivas�nica = hachaDivas�nica;
		
		if(casillaDeCura) {/* this.curaci�nAuxiliar = ; */}
		else this.curaci�nAuxiliar = 0;
		
	}

    public void setHachaDivas�nica(HachaDivas�nica hachaDivas�nica) {
    	
    	this.hachaDivas�nica = hachaDivas�nica;
    	
    }
    
    public HachaDivas�nica getHachaDivas�nica() {
    	
    	return hachaDivas�nica;
    	
    }
    
    public boolean equals(Casilla c) {

    	//Si tiene el mismo tipo de casilla (en caso de la copa tiene que ser de la misma facci�n).
		
		if(c == null) return false;
//		else if(c.getFacci�n() != this.getFacci�n()) return false;
		else if(c.getClass() != this.getClass()) return false;
		else return true;
		
	}

    public boolean tieneHacha() {
    	
    	return (hachaDivas�nica != null);
    	
    }
    
    public int getCuraci�nAuxiliar() {
    	
    	return this.curaci�nAuxiliar;
    	
    }
    
    public boolean casillaDeCura() {
    	
    	return (this.curaci�nAuxiliar != 0);
    	
    }
    
    public Object clone() {
    	
    	Object clone = null;
    	
    	try {
    		clone = super.clone();
    	} catch (CloneNotSupportedException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
    	
    	return clone;
    	
    }
    
    public Element getElemento(Document doc) {
        
        Element CasillaE = doc.createElement("Ficha");;
        
        Element hachaDivas�nicaE = this.hachaDivas�nica.getElemento(doc);
        
        Element curaci�nAuxiliarE = doc.createElement("curaci�nAuxiliar");
        curaci�nAuxiliarE.appendChild(doc.createTextNode("" + this.curaci�nAuxiliar));
		
        CasillaE.appendChild(hachaDivas�nicaE);
        CasillaE.appendChild(curaci�nAuxiliarE);
		
		return CasillaE;
    	
    }

}
