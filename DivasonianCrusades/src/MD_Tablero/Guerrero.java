package MD_Tablero;

import Utilidades.Facci�n;

public class Guerrero extends Ficha {
	
	public Guerrero(Facci�n f) {
		
		super(null, f);
//		super.da�o =
//		super.vida =
//		super.vidaM�xima =
//		super.da�oVariable =
		
	}
	
	public Guerrero(int da�o, int vida, int vidaM�xima, int da�oVariable, HachaDivas�nica hachaDivas�nica,
			Facci�n facci�n) {
		super(hachaDivas�nica,facci�n);
		this.da�o = da�o;
		this.vida = vida;
		this.vidaM�xima = vidaM�xima;
		this.da�oVariable = da�oVariable;
	}
	
}
