package MD_Tablero;

import Utilidades.Facci�n;

public class Lancero extends Ficha {
	
    public int da�oACaballer�a;
    
    public Lancero(Facci�n f) {
		
		super(null, f);
//		super.da�o =
//		super.vida =
//		super.vidaM�xima =
//		super.da�oVariable =
//		this.da�oACaballer�a =
		
	}
	
	public Lancero(int da�o, int vida, int vidaM�xima, int da�oVariable, HachaDivas�nica hachaDivas�nica,
			Facci�n facci�n, int da�oACaballer�a) {
		super(da�o, vida, vidaM�xima, da�oVariable, hachaDivas�nica, facci�n);
		this.da�oACaballer�a = da�oACaballer�a;
	}
	
	public int realizarAtaque(Ficha f) {
    	
		if(f instanceof Caballero) return da�oACaballer�a + (int) Math.floor(Math.random()*2*(da�oVariable)-1);
		else return da�o + (int) Math.floor(Math.random()*2*(da�oVariable)-1);
    	
    }
	
	//Creo que no hay por qu� redefinir realizarCarga() porque en Ficha hace referencia a realizarAtaque().
    
}
