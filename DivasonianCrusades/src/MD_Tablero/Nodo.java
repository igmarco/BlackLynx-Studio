package MD_Tablero;
import Utilidades.Facci�n;

public class Nodo {
    public Casilla casilla;

    public Ficha fichaDefensora;

    public Ficha fichaAtacante;

    public boolean est�Aqu�(Ficha f, Facci�n fc) {
    	
    	boolean est� = false;
    	
    	//�OJO! �����SI NO HAY FICHA Y ES NULL NO LO ESTAMOS CONTEMPLANDO!!!!!
    	
    	if (fichaDefensora.equals(f) || fichaAtacante.equals(f)) est� = true;
    	
    	return est�;
    	
    }

    public boolean est�Aqu�(Casilla c) {
    	
    	boolean est� = false;
    	
    	if (casilla.equals(c)) est� = true;
    	
    	return est�;
    	
    }

    public boolean est�Aqu�(Facci�n fc) {
    	
    	boolean est� = false;
    	
    	if (fichaDefensora.getFacci�n() == fc || fichaAtacante.getFacci�n() == fc) est� = true;
    	
    	return est�;
    	
    }

    public void ponerFicha() {
    	
    	//Por aqu� me quedo, que estoy cansado. De todos modos no creo que esto sea sin par�metros, necesitar� saber qu� maldita ficha es.
    	
    }

    public void quitarFicha() {
    	
    	//Aqu� lo mismo.
    	
    }

    public void resolverTurno() {
    	
    	//Resolvemos combate, damos curaci�n y sufrimos hacha. �Algo m�s? Qui�n sabe.
    	
    }

    private void resolverCombate() {
    }

    private void darCuraci�n() {
    }

    private void sufrirHacha() {
    }

    public void recibirDisparo(int da�o) {
    }

    public boolean hayFicha() {
    }

    public boolean hayFicha(Facci�n fc) {
    }

}
