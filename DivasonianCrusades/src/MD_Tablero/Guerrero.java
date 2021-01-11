package MD_Tablero;

import Utilidades.Facci�n;

public class Guerrero extends Ficha {
	
	public Guerrero(Facci�n f) {
		
		super(null, f);
		super.da�o = 15;
		super.vida = 200;
		super.vidaM�xima = 200;
		super.da�oVariable = 2;
		
	}
	
	public Guerrero(int da�o, int vida, int vidaM�xima, int da�oVariable, HachaDivas�nica hachaDivas�nica,
			Facci�n facci�n) {
		super(da�o, vida, vidaM�xima, da�oVariable, hachaDivas�nica, facci�n);
	}
	
}
