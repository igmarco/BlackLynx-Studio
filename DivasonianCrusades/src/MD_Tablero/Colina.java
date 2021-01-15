package MD_Tablero;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Colina extends Casilla {
	private int da�oExtra;

	public Colina() {
		super();
		this.da�oExtra = 10;
	}
	
	public Colina(int da�oExtra, HachaDivas�nica hachaDivas�nica) {
		super(hachaDivas�nica);
		this.da�oExtra = da�oExtra;
	}
    
    public Colina(int da�oExtra, HachaDivas�nica hachaDivas�nica, boolean casillaDeCuraci�n) {
		super(hachaDivas�nica, casillaDeCuraci�n);
		this.da�oExtra = da�oExtra;
	}
    
    public int getDa�oExtra() {
    	
    	return this.da�oExtra;
    	
    }
    
    public Element getElemento(Document doc) {
        
        Element CasillaE = super.getElemento(doc);
        
        Element da�oExtraE = doc.createElement("da�oExtra");
        da�oExtraE.appendChild(doc.createTextNode("" + this.da�oExtra));
		
        CasillaE.appendChild(da�oExtraE);
		
		return CasillaE;
    	
    }
	
} 
