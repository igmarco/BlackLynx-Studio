package MD_Tablero;

public class Caballero extends Ficha {
    public int daņoCarga;
    
    public int realizarCarga(Ficha f) {
    	
    	return daņoCarga + (int) Math.floor(Math.random()*2*(daņoVariable)-1);
    	
    }

}
