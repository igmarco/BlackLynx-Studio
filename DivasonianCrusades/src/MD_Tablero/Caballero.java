package MD_Tablero;

import Utilidades.Facci�n;

public class Caballero extends Ficha {
    public int da�oCarga;
    
    public Caballero(Facci�n f) {
		
		super(null, f);
//		super.da�o =
//		super.vida =
//		super.vidaM�xima =
//		super.da�oVariable =
//		this.da�oCarga =
		
	}
	
	public Caballero(int da�o, int vida, int vidaM�xima, int da�oVariable, HachaDivas�nica hachaDivas�nica,
			Facci�n facci�n, int da�oCarga) {
		super(da�o, vida, vidaM�xima, da�oVariable, hachaDivas�nica, facci�n);
		this.da�oCarga = da�oCarga;
	}
    
    public int realizarCarga(Ficha f) {
    	
    	return da�oCarga + (int) Math.floor(Math.random()*2*(da�oVariable)-1);
    	
    }

}
