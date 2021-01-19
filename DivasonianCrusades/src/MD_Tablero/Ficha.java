package MD_Tablero;
import java.io.Serializable;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import Utilidades.Facci�n;

public abstract class Ficha implements Cloneable, Serializable{
    protected int da�o;

    protected int vida;
    
    protected int vidaM�xima;

    protected int da�oVariable;

    protected HachaDivas�nica hachaDivas�nica;

	protected Facci�n facci�n;
    
    public boolean puedeMover;
    
    public int getDa�o() {
		return da�o;
	}

	public int getVida() {
		return vida;
	}
    
    public HachaDivas�nica getHachaDivas�nica() {
		return hachaDivas�nica;
	}
    
    public boolean tieneHacha() {
		return (hachaDivas�nica != null);
	}

	public Ficha(HachaDivas�nica hachaDivas�nica,
			Facci�n facci�n) {
		this.hachaDivas�nica = hachaDivas�nica;
		this.facci�n = facci�n;
		this.puedeMover = true;
	}
    
    public Ficha(int da�o, int vida, int vidaM�xima, int da�oVariable, HachaDivas�nica hachaDivas�nica,
			Facci�n facci�n) {
		this.da�o = da�o;
		this.vida = vida;
		this.vidaM�xima = vidaM�xima;
		this.da�oVariable = da�oVariable;
		this.hachaDivas�nica = hachaDivas�nica;
		this.facci�n = facci�n;
		this.puedeMover = true;
	}
    
    public int realizarAtaque() {
    	
    	int hd = 0;
    	if(hachaDivas�nica != null) hd = hachaDivas�nica.sumarDa�o();
    	return da�o + (int) Math.floor(Math.random()*2*(da�oVariable)-da�oVariable) + hd;
    	
    }

    public int realizarAtaque(Ficha f) {
    	
    	int hd = 0;
    	if(hachaDivas�nica != null) hd = hachaDivas�nica.sumarDa�o();
    	return da�o + (int) Math.floor(Math.random()*2*(da�oVariable)-da�oVariable) + hd;
    	
    }

    public void sufrirDa�o(int da�o) {
    	
    	vida = vida - da�o;
    	
    }

	public boolean est�Muerta() {
    	
    	return (vida <= 0);
    	
    }

    public Facci�n getFacci�n() {
    	
    	return facci�n;
    	
    }

    public void sufrirHacha() {
    	
    	if(hachaDivas�nica != null) {
    		
    		vida = vida - hachaDivas�nica.sufrirDa�oPorTurno();
    		
    	}
    	
    }

    public void curarse(int v) {
    	
    	if(vida + v < vidaM�xima) {
    		
    		vida = vida + v;
    		
    	}
    	else {
    		
    		vida = vidaM�xima;
    		
    	}
    	
    }

    public boolean equals(Ficha f) {

    	//Si es el mismo tipo y facci�n (ya que cada jugador solo tiene una de cada tipo).
		
		if(f == null) return false;
		else if(f.getFacci�n() != this.getFacci�n()) return false;
		else if(f.getClass() != this.getClass()) return false;
		else return true;
		
	}

    public int realizarCarga(Ficha f) {
    	
    	return (int) Math.floor(this.realizarAtaque(f)*1.2);
    	
    }
    
    public int realizarAtaqueContraHuida(Ficha f) {
    	
    	return this.realizarCarga(f)/2;
    	
    }
    
    public void setHachaDivas�nica(HachaDivas�nica h) {
    	
    	this.hachaDivas�nica = h;
    	
    }
    
    public int getMovs() {
    	 
    	return 2;
    	
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
        
        Element FichaE = doc.createElement("Ficha");
        
        FichaE.setAttribute("tipo", this.getClass().getSimpleName());
		
        Element da�oE = doc.createElement("da�o");
        da�oE.appendChild(doc.createTextNode("" + this.da�o));
        
        Element vidaE = doc.createElement("vida");
        vidaE.appendChild(doc.createTextNode("" + this.vida));
        
        Element vidaM�ximaE = doc.createElement("vidaM�xima");
        vidaM�ximaE.appendChild(doc.createTextNode("" + this.vidaM�xima))
        ;
        Element da�oVariableE = doc.createElement("da�oVariable");
        da�oVariableE.appendChild(doc.createTextNode("" + this.da�oVariable));
        
        if(this.hachaDivas�nica != null) {
        	Element hachaDivas�nicaE = this.hachaDivas�nica.getElemento(doc);
        	FichaE.appendChild(hachaDivas�nicaE);
		}
        
        Element facci�nE = doc.createElement("facci�n");
        if(this.facci�n == Facci�n.Ambos) facci�nE.appendChild(doc.createTextNode("Ambos"));
        else if(this.facci�n == Facci�n.Facci�n1) facci�nE.appendChild(doc.createTextNode("Facci�n1"));
        else /* if(this.facci�n == Facci�n.Facci�n2)*/ facci�nE.appendChild(doc.createTextNode("Facci�n2"));
        
        Element puedeMoverE = doc.createElement("puedeMover");
        puedeMoverE.appendChild(doc.createTextNode("" + this.puedeMover));
		
        FichaE.appendChild(da�oE);
        FichaE.appendChild(vidaE);
        FichaE.appendChild(vidaM�ximaE);
        FichaE.appendChild(da�oVariableE);
        FichaE.appendChild(facci�nE);
        FichaE.appendChild(puedeMoverE);
		
		return FichaE;
    	
    }
    
    public static Ficha getFromElemento(Element e) {
        
        NodeList hijos = e.getChildNodes();
        Element hijo;
        
        int da�o = 0;
        int vida = 0;
        int vidaM�xima = 0;
        int da�oVariable = 0;
        HachaDivas�nica hachaDivas�nica = null;
    	Facci�n facci�n = Facci�n.Ambos;
        boolean puedeMover = true;
        int da�oFlechas = 0;
        int da�oFlechasVariable = 0;
        int da�oCarga = 0;
        int da�oACaballer�a = 0;
        
        for(int i = 0; i < hijos.getLength(); i++) {
        	
        	if(hijos.item(i).getNodeType() == Node.ELEMENT_NODE) {
        		
        		hijo = (Element) hijos.item(i);
        		
        		if(hijo.getNodeName().equals("da�o")) da�o = Integer.parseInt(hijo.getFirstChild().getNodeValue());
        		else if(hijo.getNodeName().equals("vida")) vida = Integer.parseInt(hijo.getFirstChild().getNodeValue());
        		else if(hijo.getNodeName().equals("vidaM�xima")) vidaM�xima = Integer.parseInt(hijo.getFirstChild().getNodeValue());
        		else if(hijo.getNodeName().equals("da�oVariable")) da�oVariable = Integer.parseInt(hijo.getFirstChild().getNodeValue());
        		
        		else if(hijo.getNodeName().equals("hachaDivas�nica")) hachaDivas�nica = HachaDivas�nica.getFromElemento(hijo);
        		
        		else if(hijo.getNodeName().equals("facci�n")) {
        			
        			if(hijo.getFirstChild().getNodeValue().equals("Ambos")) facci�n = Facci�n.Ambos;
                    else if(hijo.getFirstChild().getNodeValue().equals("Facci�n1")) facci�n = Facci�n.Facci�n1;
                    else /* if(hijo.getFirstChild().getNodeValue().equals("Ambos"))*/ facci�n = Facci�n.Facci�n2;
        			
        		}
        		
        		else if(hijo.getNodeName().equals("puedeMover")) puedeMover = Boolean.parseBoolean(hijo.getFirstChild().getNodeValue());
        		else if(hijo.getNodeName().equals("da�oFlechas")) da�oFlechas = Integer.parseInt(hijo.getFirstChild().getNodeValue());
        		else if(hijo.getNodeName().equals("da�oFlechasVariable")) da�oFlechasVariable = Integer.parseInt(hijo.getFirstChild().getNodeValue());
        		else if(hijo.getNodeName().equals("da�oCarga")) da�oCarga = Integer.parseInt(hijo.getFirstChild().getNodeValue());
        		else if(hijo.getNodeName().equals("da�oACaballer�a")) da�oACaballer�a = Integer.parseInt(hijo.getFirstChild().getNodeValue());
        		
        	}
        	
        }
        
        if(e.getAttribute("tipo").equals("Arquero")) {
        	
        	return new Arquero(da�o, vida, vidaM�xima, da�oVariable, hachaDivas�nica, facci�n, da�oFlechas, da�oFlechasVariable);
        	
        }
        else if(e.getAttribute("tipo").equals("B�rbaro")) {
        	
        	return new B�rbaro(da�o, vida, vidaM�xima, da�oVariable, hachaDivas�nica, facci�n);
        	
        }
        else if(e.getAttribute("tipo").equals("Caballero")) {
        	
        	return new Caballero(da�o, vida, vidaM�xima, da�oVariable, hachaDivas�nica, facci�n, da�oCarga);
        	
        }
        else if(e.getAttribute("tipo").equals("Guerrero")) {
	
        	return new Guerrero(da�o, vida, vidaM�xima, da�oVariable, hachaDivas�nica, facci�n);
	
        }
        else if(e.getAttribute("tipo").equals("Lancero")) {
	
        	return new Lancero(da�o, vida, vidaM�xima, da�oVariable, hachaDivas�nica, facci�n, da�oACaballer�a);
	
        }
        else {
        	
        	return null;
        	
        }
    	
    }

}
