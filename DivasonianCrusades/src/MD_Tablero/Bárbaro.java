package MD_Tablero;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import Utilidades.Facci�n;

public class B�rbaro extends Ficha {
	
	public B�rbaro(Facci�n f) {
		
		super(null, f);
		super.da�o = 30;
		super.vida = 100;
		super.vidaM�xima = 100;
		super.da�oVariable = 15;
		
	}
	
	public B�rbaro(int da�o, int vida, int vidaM�xima, int da�oVariable, HachaDivas�nica hachaDivas�nica,
			Facci�n facci�n) {
		super(da�o, vida, vidaM�xima, da�oVariable, hachaDivas�nica, facci�n);
	}
	
}
