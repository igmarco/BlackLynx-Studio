package MD_Tablero;

public class Caballero extends Ficha {
    public int da�oCarga;
    
    public int realizarCarga(Ficha f) {
    	
    	return da�oCarga + (int) Math.floor(Math.random()*2*(da�oVariable)-1);
    	
    }

}
