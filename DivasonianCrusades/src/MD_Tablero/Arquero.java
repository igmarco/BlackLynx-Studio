package MD_Tablero;

public class Arquero extends Ficha {
    public int da�oFlechas;

    public int rango;

    public int da�oFlechasVariable;

    public int realizarDisparo() {
    	
    	return da�oFlechas + (int) Math.floor(Math.random()*2*(da�oFlechasVariable)-1);
    	
    }

    public int getRango() {
    	
    	return rango;
    	
    }

}
