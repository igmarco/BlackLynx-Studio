package MD_Tablero;

public class Arquero extends Ficha {
    public int daņoFlechas;

    public int rango;

    public int daņoFlechasVariable;

    public int realizarDisparo() {
    	
    	return daņoFlechas + (int) Math.floor(Math.random()*2*(daņoFlechasVariable)-1);
    	
    }

    public int getRango() {
    	
    	return rango;
    	
    }

}
