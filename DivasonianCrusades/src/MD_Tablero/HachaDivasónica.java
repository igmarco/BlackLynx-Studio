package MD_Tablero;

import java.io.Serializable;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class HachaDivas�nica implements Serializable {
    public int da�oExtra;
    
    public int da�oExtraVariable;

    public int vidaPorTurno;
    
    public int vidaPorTurnoVariable;
    
    public HachaDivas�nica() {
    	
    	da�oExtra = 10;
        da�oExtraVariable = 7;
        vidaPorTurno = 5;
        vidaPorTurnoVariable = 4;
    	
    }

    public HachaDivas�nica(int da�oExtra, int da�oExtraVariable, int vidaPorTurno, int vidaPorTurnoVariable) {
		super();
		this.da�oExtra = da�oExtra;
		this.da�oExtraVariable = da�oExtraVariable;
		this.vidaPorTurno = vidaPorTurno;
		this.vidaPorTurnoVariable = vidaPorTurnoVariable;
	}

	public int sumarDa�o() {
    	
    	return da�oExtra + (int) Math.floor(Math.random()*2*(da�oExtraVariable)-1);
    	
    }

    public int sufrirDa�oPorTurno() {
    	
    	return vidaPorTurno + (int) Math.floor(Math.random()*2*(vidaPorTurnoVariable)-1);
    	
    }
    
    public Element getElemento(Document doc) {

		Element HachaDivas�nicaE = doc.createElement("HachaDivas�nica");
		
		Element da�oExtraE = doc.createElement("da�oExtra");
		da�oExtraE.appendChild(doc.createTextNode("" + this.da�oExtra));
        
        Element da�oExtraVariableE = doc.createElement("da�oExtraVariableE");
        da�oExtraVariableE.appendChild(doc.createTextNode("" + this.da�oExtraVariable));
        
        Element vidaPorTurnoE = doc.createElement("vidaPorTurno");
        vidaPorTurnoE.appendChild(doc.createTextNode("" + this.vidaPorTurno));
        
        Element vidaPorTurnoVariableE = doc.createElement("vidaPorTurnoVariable");
        vidaPorTurnoVariableE.appendChild(doc.createTextNode("" + this.vidaPorTurnoVariable));
		
        HachaDivas�nicaE.appendChild(da�oExtraE);
        HachaDivas�nicaE.appendChild(da�oExtraVariableE);
        HachaDivas�nicaE.appendChild(vidaPorTurnoE);
        HachaDivas�nicaE.appendChild(vidaPorTurnoVariableE);
		
		return HachaDivas�nicaE;
		
	}

}
