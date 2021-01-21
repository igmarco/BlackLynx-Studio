package MD_Tablero;

import java.io.Serializable;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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
		
		if(casillaDeCura) this.curaci�nAuxiliar = 5;
		else this.curaci�nAuxiliar = 0;
		
	}
	
	public Casilla(HachaDivas�nica hachaDivas�nica, int curaci�nAuxiliar) {
		
		this.hachaDivas�nica = hachaDivas�nica; 
		this.curaci�nAuxiliar = curaci�nAuxiliar;
		
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
        
        Element CasillaE = doc.createElement("Casilla"); 
        
        CasillaE.setAttribute("tipo", this.getClass().getSimpleName());
        
        if(this.hachaDivas�nica != null) {
        	Element hachaDivas�nicaE = this.hachaDivas�nica.getElemento(doc);
        	CasillaE.appendChild(hachaDivas�nicaE);
		}
        
        Element curaci�nAuxiliarE = doc.createElement("curaci�nAuxiliar");
        curaci�nAuxiliarE.appendChild(doc.createTextNode("" + this.curaci�nAuxiliar));
		
        CasillaE.appendChild(curaci�nAuxiliarE);
		
		return CasillaE;
    	
    }
    
public static Casilla getFromElemento(Element e) {
        
        NodeList hijos = e.getChildNodes();
        Element hijo;
        
        HachaDivas�nica hachaDivas�nica = null;
        int curaci�nAuxiliar = 0;
        int da�oProyectiles = 0;
        int da�oProyectilesVariable = 0;
    	int identificador = 0;
    	int da�oExtra = 0;
    	Facci�n facci�n = Facci�n.Ambos;
    	int vida = 0;
    	int curaci�n = 0;
    	int curaci�nVariable = 0;
        
        for(int i = 0; i < hijos.getLength(); i++) {
        	
        	if(hijos.item(i).getNodeType() == Node.ELEMENT_NODE) {
        		
        		hijo = (Element) hijos.item(i);
        		
        		if(hijo.getNodeName().equals("curaci�nAuxiliar")) curaci�nAuxiliar = Integer.parseInt(hijo.getFirstChild().getNodeValue());
        		else if(hijo.getNodeName().equals("da�oProyectiles")) da�oProyectiles = Integer.parseInt(hijo.getFirstChild().getNodeValue());
        		else if(hijo.getNodeName().equals("da�oProyectilesVariable")) da�oProyectilesVariable = Integer.parseInt(hijo.getFirstChild().getNodeValue());
        		else if(hijo.getNodeName().equals("identificador")) identificador = Integer.parseInt(hijo.getFirstChild().getNodeValue());
        		
        		else if(hijo.getNodeName().equals("hachaDivas�nica")) hachaDivas�nica = HachaDivas�nica.getFromElemento(hijo);
        		
        		else if(hijo.getNodeName().equals("facci�n")) {
        			
        			if(hijo.getFirstChild().getNodeValue().equals("Ambos")) facci�n = Facci�n.Ambos;
                    else if(hijo.getFirstChild().getNodeValue().equals("Facci�n1")) facci�n = Facci�n.Facci�n1;
                    else /* if(hijo.getFirstChild().getNodeValue().equals("Ambos"))*/ facci�n = Facci�n.Facci�n2;
        			
        		}
        		
        		else if(hijo.getNodeName().equals("da�oExtra")) da�oExtra = Integer.parseInt(hijo.getFirstChild().getNodeValue());
        		else if(hijo.getNodeName().equals("vida")) vida = Integer.parseInt(hijo.getFirstChild().getNodeValue());
        		else if(hijo.getNodeName().equals("curaci�n")) curaci�n = Integer.parseInt(hijo.getFirstChild().getNodeValue());
        		else if(hijo.getNodeName().equals("curaci�nVariable")) curaci�nVariable = Integer.parseInt(hijo.getFirstChild().getNodeValue());
        		
        	}
        	
        }
        
        if(e.getAttribute("tipo").equals("Catapulta")) {
        	
        	return new Catapulta(da�oProyectiles, da�oProyectilesVariable, hachaDivas�nica, identificador, curaci�nAuxiliar);
        	
        }
        else if(e.getAttribute("tipo").equals("Colina")) {
        	
        	return new Colina(da�oExtra, hachaDivas�nica, curaci�nAuxiliar);
        	
        }
        else if(e.getAttribute("tipo").equals("Copa")) {
        	
        	return new Copa(facci�n, vida, hachaDivas�nica);
        	
        }
        else if(e.getAttribute("tipo").equals("Curaci�n")) {
	
        	return new Curaci�n(curaci�n, curaci�nVariable, hachaDivas�nica, identificador);
	
        }
        else if(e.getAttribute("tipo").equals("Normal")) {
	
        	return new Normal(hachaDivas�nica, curaci�nAuxiliar);
	
        }
        else {
        	
        	return null;
        	
        }
    	
    }

}
