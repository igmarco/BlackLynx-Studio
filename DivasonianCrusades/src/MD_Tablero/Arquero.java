package MD_Tablero;

import Utilidades.Facci�n;

public class Arquero extends Ficha {
    public int da�oFlechas;

    public int rango;

    public int da�oFlechasVariable;
    
    public Arquero(Facci�n f) {
		
		super(null, f);
//		super.da�o =
//		super.vida =
//		super.vidaM�xima =
//		super.da�oVariable =
//		this.da�oFlechas =
//		this.rango =
//		this.da�oFlechasVariable =
		
	}
	
	public Arquero(int da�o, int vida, int vidaM�xima, int da�oVariable, HachaDivas�nica hachaDivas�nica,
			Facci�n facci�n, int da�oFlechas, int rango, int da�oFlechasVariable) {
		super(da�o, vida, vidaM�xima, da�oVariable, hachaDivas�nica, facci�n);
		this.da�oFlechas = da�oFlechas;
		this.rango = rango;
		this.da�oFlechasVariable = da�oFlechasVariable;
	}

    public int realizarDisparo() {
    	
    	return da�oFlechas + (int) Math.floor(Math.random()*2*(da�oFlechasVariable)-da�oFlechasVariable);
    	
    }

    public int getRango() {
    	
    	return rango;
    	
    }

}
