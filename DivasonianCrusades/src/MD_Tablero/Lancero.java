package MD_Tablero;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import Utilidades.Facci�n;

public class Lancero extends Ficha {
	
    public int da�oACaballer�a;
    
    public Lancero(Facci�n f) {
		
		super(null, f);
		super.da�o = 15;
		super.vida = 100;
		super.vidaM�xima = 100;
		super.da�oVariable = 5;
		this.da�oACaballer�a = 35;
		
	}
	
	public Lancero(int da�o, int vida, int vidaM�xima, int da�oVariable, HachaDivas�nica hachaDivas�nica,
			Facci�n facci�n, int da�oACaballer�a) {
		super(da�o, vida, vidaM�xima, da�oVariable, hachaDivas�nica, facci�n);
		this.da�oACaballer�a = da�oACaballer�a;
	}
	
	public int realizarAtaque(Ficha f) {
    	
		int hd = 0;
    	if(hachaDivas�nica != null) hd = hachaDivas�nica.sumarDa�o();
		if(f instanceof Caballero) return da�oACaballer�a + (int) Math.floor(Math.random()*2*(da�oVariable)-da�oVariable) + hd;
		else return da�o + (int) Math.floor(Math.random()*2*(da�oVariable)-da�oVariable) + hd;
    	
    }
	
//	Creo que no hay por qu� redefinir realizarCarga() porque en Ficha hace referencia a realizarAtaque().
	
	public Element getElemento(Document doc) {
        
        Element FichaE = super.getElemento(doc);
		
        Element da�oACaballer�aE = doc.createElement("da�oACaballer�a");
        da�oACaballer�aE.appendChild(doc.createTextNode("" + this.da�oACaballer�a));
        
        FichaE.appendChild(da�oACaballer�aE);
		
		return FichaE;
    	
    }
    
}
