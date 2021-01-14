package MD_Tablero;
import java.io.Serializable;

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
    	
    	return this.realizarAtaque(f)/2;
    	
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

}
