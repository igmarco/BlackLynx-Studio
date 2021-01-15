package MD_Tablero;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import Utilidades.Facci�n;

public class Copa extends Casilla {
	
    private Facci�n facci�n;

    private int vida;
    
    public Copa() {
		super();
		this.facci�n = Facci�n.Ambos;
		this.vida = 50;
	}
    
    public Copa(Facci�n facci�n) {
		super();
		this.facci�n = facci�n;
		this.vida = 50;
	}
    
    public Copa(Facci�n facci�n, int vida, HachaDivas�nica hachaDivas�nica) {
		super(hachaDivas�nica);
		this.facci�n = facci�n;
		this.vida = vida;
	}
    
    public void sufrirDa�o(int da�o) {
    	
    	vida = vida - da�o;
    	
    }
    
    public boolean est�Muerta() {
    	
    	return (vida <= 0);
    	
    }
    
    public Facci�n getFacci�n() {
    	
    	return this.facci�n;
    	
    }
    
    public int getVida() {
    	
    	return this.vida;
    	
    }
    
    public boolean equals(Casilla c) {

    	//Si tiene el mismo tipo de casilla (en caso de la copa (este en concreto) tiene que ser de la misma facci�n).
		
		if(c == null) return false;
		else if(c.getClass() != this.getClass()) return false;
		else if(((Copa) c).getFacci�n() != this.getFacci�n()) return false;
		else return true;
		
	}
    
    public Element getElemento(Document doc) {
        
        Element CasillaE = super.getElemento(doc);
        
        Element facci�nE = doc.createElement("facci�n");
        if(this.facci�n == Facci�n.Ambos) facci�nE.appendChild(doc.createTextNode("Ambos"));
        else if(this.facci�n == Facci�n.Facci�n1) facci�nE.appendChild(doc.createTextNode("Facci�n1"));
        else /* if(this.facci�n == Facci�n.Facci�n2)*/ facci�nE.appendChild(doc.createTextNode("Facci�n2"));
        
        Element vidaE = doc.createElement("vida");
        vidaE.appendChild(doc.createTextNode("" + this.vida));
		
        CasillaE.appendChild(vidaE);
        CasillaE.appendChild(facci�nE);
		
		return CasillaE;
    	
    }

}
