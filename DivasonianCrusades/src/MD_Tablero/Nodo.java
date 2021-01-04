package MD_Tablero;
import Utilidades.Facci�n;

public class Nodo {
    private Casilla casilla;

    private Ficha fichaDefensora;

    private Ficha fichaAtacante;
    
    public Nodo() {
    	
    	this.casilla = new Normal();
    	this.fichaDefensora = null;
    	this.fichaAtacante = null;
    	
    }
    
    public Nodo(Casilla casilla) {
    	
    	this.casilla = casilla;
    	this.fichaDefensora = null;
    	this.fichaAtacante = null;
    	
    }
    
    public Nodo(Ficha fichaDefensora) {
    	
    	this.casilla = new Normal();
    	this.fichaDefensora = fichaDefensora;
    	this.fichaAtacante = null;
    	
    }
    
    public Nodo(Casilla casilla, Ficha fichaDefensora) {
    	
    	this.casilla = casilla;
    	this.fichaDefensora = fichaDefensora;
    	this.fichaAtacante = null;
    	
    }
    
    public Nodo(Casilla casilla, Ficha fichaDefensora, Ficha fichaAtacante) {
    	
    	this.casilla = casilla;
    	this.fichaDefensora = fichaDefensora;
    	this.fichaAtacante = fichaAtacante;
    	
    }

    public boolean est�Aqu�(Ficha f) {
    	
    	boolean est� = false;
    	
    	if (f.equals(fichaDefensora) || f.equals(fichaAtacante)) est� = true;
    	
    	return est�;
    	
    }

    public boolean est�Aqu�(Casilla c) {
    	
    	boolean est� = false;
    	
    	if (casilla.equals(c)) est� = true;
    	
    	return est�;
    	
    }

    public boolean est�Aqu�(Facci�n fc) {
    	
    	boolean est� = false;
    	
    	if (((fichaDefensora != null) && (fichaDefensora.getFacci�n() == fc)) || ((fichaAtacante != null) && (fichaAtacante.getFacci�n() == fc))) est� = true;
    	
    	return est�;
    	
    }

    public void ponerFicha(Ficha f) {
    	
    	if(this.fichaDefensora == null) this.fichaDefensora = f;
    	else {
    		
    		this.fichaAtacante = f;
    		
    		this.fichaDefensora.sufrirDa�o(this.fichaAtacante.realizarCarga(this.fichaDefensora));
    		if(!this.fichaDefensora.est�Muerta()) {
    			
    			if(this.casilla.equals(new Colina())) this.fichaAtacante.sufrirDa�o((this.fichaDefensora.realizarAtaque(this.fichaAtacante)) + ((Colina) this.casilla).getDa�oExtra());
    			else this.fichaAtacante.sufrirDa�o(this.fichaDefensora.realizarAtaque(this.fichaAtacante));
    			
    		}
    		
    	}
    	
    }

    public void quitarFicha(Ficha f) {
    	
    	//C�mo gestiono el hecho de que hacen pupa los que se quedan a los que se van? T.T
    	
    	if(f.equals(this.fichaDefensora)) {
    		
//    		if(this.fichaAtacante != null) {
//    			
//    			this.fichaDefensora.sufrirDa�o(this.fichaAtacante.realizarAtaque(this.fichaDefensora));
//    			
//    		}
//    		if(this.fichaDefensora.est�Muerta()) {
//    			
//    			asdasdfghasfrhhqarfhafasdfhasdfghasdfhafhrahwerqa
//    			
//    		}
    		
    		this.fichaDefensora = this.fichaAtacante;
    		this.fichaAtacante = null;
    		
    	}
    	else if(f.equals(this.fichaAtacante)) {
    		
    		if(this.fichaAtacante != null) {
    			
    			this.fichaDefensora.sufrirDa�o(this.fichaAtacante.realizarAtaque(this.fichaDefensora));
    			
    		}
    		
    		this.fichaAtacante = null;
    		
    	}
    	
    }

    public void resolverTurno() {
    	
    	//Resolvemos combate, damos curaci�n y sufrimos hacha. �Algo m�s? Qui�n sabe. Puede que resolver el disparo autom�tico.
    	//Vale, no, resolver el disparo autom�tico DESCARTADO.
    	//Claro, ten�a que contemplar que hubiese hacha y que se la diese al �ltimo en pie (si lo hay).
    	//Epa, queda una cosa, saber si es una copa y resolver el da�o tambi�n.
    	
    	this.resolverCombate();
    	this.darCuraci�n();
    	this.sufrirHacha();
    	
    	if(this.fichaAtacante.est�Muerta()) this.fichaAtacante = null;
    	if(this.fichaDefensora.est�Muerta()) {
    		
    		//ADVERTENCIA: POSIBLES PROBLEMAS DE PROG3
    		this.fichaDefensora = this.fichaAtacante;
    		this.fichaAtacante = null;
    		
    	}
    	
    	if(this.casilla.tieneHacha() && this.fichaDefensora != null && this.fichaAtacante == null) {
    		
    		this.fichaDefensora.setHachaDivas�nica(this.casilla.getHachaDivas�nica());
    		this.casilla.setHachaDivas�nica(null);
    		
    	}
    	
    	if (this.casilla instanceof Copa && this.fichaDefensora != null && this.fichaAtacante == null && this.fichaAtacante.getFacci�n() != ((Copa) this.casilla).getFacci�n()) {
    		
    		((Copa) this.casilla).sufrirDa�o(this.fichaDefensora.realizarAtaque());
    		
    	}
    	
    }

	private void resolverCombate() {
		
		if(this.fichaDefensora != null && this.fichaAtacante != null) {
			
			this.fichaDefensora.sufrirDa�o(this.fichaAtacante.realizarAtaque(this.fichaDefensora));
    		this.fichaAtacante.sufrirDa�o(this.fichaDefensora.realizarAtaque(this.fichaAtacante));
			
		}
		
    }

    private void darCuraci�n() {
    	
    	if(this.casilla.equals(new Curaci�n())) {
    		
    		this.fichaDefensora.curarse(((Curaci�n) this.casilla).curar());
        	this.fichaAtacante.curarse(((Curaci�n) this.casilla).curar());
    		
    	}
    	
    }

    private void sufrirHacha() {
    	
    	this.fichaDefensora.sufrirHacha();
    	this.fichaAtacante.sufrirHacha();
    	
    }

    public void recibirDisparo(int da�o) {
    	
    	this.fichaDefensora.sufrirDa�o(da�o);
    	this.fichaAtacante.sufrirDa�o(da�o);
    	
    }

    public boolean hayFicha() {
    	
    	return (this.fichaDefensora != null);
    	
    }
    
    //OJOOOO ESTE LO HE A�ADIDO DE FREE TOTALMENTE
    public boolean hayDosFichas() {
    	
    	return (this.fichaAtacante != null);
    	
    }

    //DE HECHO, CREO QUE ESTE ES IGUAL QUE EL M�TODO est�Aqu�(Facci�n f).
//    public boolean hayFicha(Facci�n fc) {
//    	
//    }
    
    //Getters y setters:
    
    public Casilla getCasilla() {
		return casilla;
	}

	public void setCasilla(Casilla casilla) {
		this.casilla = casilla;
	}

	public Ficha getFichaDefensora() {
		return fichaDefensora;
	}

	public void setFichaDefensora(Ficha fichaDefensora) {
		this.fichaDefensora = fichaDefensora;
	}

	public Ficha getFichaAtacante() {
		return fichaAtacante;
	}

	public void setFichaAtacante(Ficha fichaAtacante) {
		this.fichaAtacante = fichaAtacante;
	}

}
