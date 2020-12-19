package MD_Tablero;
import Utilidades.Facci�n;

public class Ficha {
    public int da�o;

    public int vida;
    
    public int vidaM�xima;

    public int da�oVariable;

    public HachaDivas�nica hachaDivas�nica;

    public Facci�n facci�n;

    public int realizarAtaque(Ficha f) {
    	
    	return da�o + (int) Math.floor(Math.random()*2*(da�oVariable)-1);
    	
    }

    public void sufrirDa�o(int da�o) {
    	
    	vida = vida - da�o;
    	
    }

    public boolean est�Muerta() {
    	
    	return (vida<=0);
    	
    }

    public Facci�n getFacci�n() {
    	
    	return facci�n;
    	
    }

    public void sufrirHacha() {
    	
    	if(hachaDivas�nica != null) {
    		
    		vida = vida - hachaDivas�nica.getVidaPorTurno();
    		
    	}
    	
    }

    public void curarse(int v) {
    	
    	if(vida + v < vidaM�xima) {
    		
    		vida = vida + v;
    		
    	}
    	else {
    		
    		vida = vidaM�xima;
    		
    	}
    	
    }

    public boolean equals(Ficha f) {
    	
    	//Si es el mismo tipo y facci�n (ya que cada jugador solo tiene una de cada tipo.)
    	
    }

    public int realizarCarga(Ficha f) {
    	
    	return this.realizarAtaque(f);
    	
    }

}
