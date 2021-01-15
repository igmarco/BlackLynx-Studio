package MD_Tablero;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import Utilidades.Facci�n;

public class Arquero extends Ficha {
    public int da�oFlechas;

    public int da�oFlechasVariable;
    
    public Arquero(Facci�n f) {
		
		super(null, f);
		super.da�o = 10;
		super.vida = 50;
		super.vidaM�xima = 50;
		super.da�oVariable = 3;
		this.da�oFlechas = 10;
		this.da�oFlechasVariable = 5;
		
	}
	
	public Arquero(int da�o, int vida, int vidaM�xima, int da�oVariable, HachaDivas�nica hachaDivas�nica,
			Facci�n facci�n, int da�oFlechas, int da�oFlechasVariable) {
		super(da�o, vida, vidaM�xima, da�oVariable, hachaDivas�nica, facci�n);
		this.da�oFlechas = da�oFlechas;
		this.da�oFlechasVariable = da�oFlechasVariable;
	}

    public int realizarDisparo() {
    	
    	return da�oFlechas + (int) Math.floor(Math.random()*2*(da�oFlechasVariable)-da�oFlechasVariable);
    	
    }
    
    public Element getElemento(Document doc) {
        
        Element FichaE = super.getElemento(doc);
		
        Element da�oFlechasE = doc.createElement("da�oFlechas");
        da�oFlechasE.appendChild(doc.createTextNode("" + this.da�oFlechas));
        
        Element da�oFlechasVariableE = doc.createElement("da�oFlechasVariable");
        da�oFlechasVariableE.appendChild(doc.createTextNode("" + this.da�oFlechasVariable));
        
        FichaE.appendChild(da�oFlechasE);
        FichaE.appendChild(da�oFlechasVariableE);
		
		return FichaE;
    	
    }

}
