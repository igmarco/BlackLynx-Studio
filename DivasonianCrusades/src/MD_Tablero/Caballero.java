package MD_Tablero;

import Utilidades.Facci�n;

public class Caballero extends Ficha {
    public int da�oCarga;
    
    public Caballero(Facci�n f) {
		
		super(null, f);
		super.da�o = 20;
		super.vida = 100;
		super.vidaM�xima = 100;
		super.da�oVariable = 10;
		this.da�oCarga = 30;
		
	}
	
	public Caballero(int da�o, int vida, int vidaM�xima, int da�oVariable, HachaDivas�nica hachaDivas�nica,
			Facci�n facci�n, int da�oCarga) {
		super(da�o, vida, vidaM�xima, da�oVariable, hachaDivas�nica, facci�n);
		this.da�oCarga = da�oCarga;
	}
    
    public int realizarCarga(Ficha f) {
    	
    	int hd = 0;
    	if(hachaDivas�nica != null) hd = hachaDivas�nica.sumarDa�o();
    	return (int) Math.floor((da�oCarga + (int) Math.floor(Math.random()*2*(da�oVariable)-da�oVariable) + hd)*1.2);
    	
    }
    
    public int getMovs() {
    	
    	return 3; 
    	
    }

}
