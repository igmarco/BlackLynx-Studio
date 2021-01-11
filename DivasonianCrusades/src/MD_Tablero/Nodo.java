package MD_Tablero;
import Utilidades.Facci�n;

public class Nodo implements Cloneable{
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
    
    public Nodo(Ficha fichaDefensora, Ficha fichaAtacante) {
    	
    	this.casilla = new Normal();
    	this.fichaDefensora = fichaDefensora;
    	this.fichaAtacante = fichaAtacante;
    	
    }

    public boolean est�Aqu�(Ficha f) {
    	
    	boolean est� = false;
    	
    	if (f == null) est� = false;
    	else if (f.equals(fichaDefensora) || f.equals(fichaAtacante)) est� = true;
    	
    	return est�;
    	
    }

    public boolean est�Aqu�(Casilla c) {
    	
    	boolean est� = false;
    	
    	if (c == null) est� = false;
    	else if (casilla.equals(c)) est� = true;
    	
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
    		
    		//Voy a intentar que el da�o se haga en Tablero.
//    		this.fichaDefensora.sufrirDa�o(this.fichaAtacante.realizarCarga(this.fichaDefensora));
//    		if(!this.fichaDefensora.est�Muerta()) {
//    			
//    			if(this.casilla instanceof Colina) this.fichaAtacante.sufrirDa�o((this.fichaDefensora.realizarAtaque(this.fichaAtacante)) + ((Colina) this.casilla).getDa�oExtra());
//    			else this.fichaAtacante.sufrirDa�o(this.fichaDefensora.realizarAtaque(this.fichaAtacante));
//    			
//    		}
//    		//Falta en el else quitar la ficha, creo.
    		
    	}
    	
    }

    public Ficha quitarFicha(Ficha f) {
    	
    	Ficha freturn = null;
    	
    	if(f == null) return null;
    	
    	if(f.equals(this.fichaDefensora)) {
    		
    		freturn = this.fichaDefensora;
    		
    		//Voy a intentar que el da�o se haga en Tablero.
    		
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
    		
    		freturn = this.fichaAtacante;
    		
    		if(this.fichaAtacante != null) {
    			
    			this.fichaDefensora.sufrirDa�o(this.fichaAtacante.realizarAtaque(this.fichaDefensora));
    			
    		}
    		
    		this.fichaAtacante = null;
    		
    	}
    	
    	return freturn;
    	
    }

    public void resolverTurno() {
    	
    	//Resolvemos combate, damos curaci�n y sufrimos hacha. �Algo m�s? Qui�n sabe. Puede que resolver el disparo autom�tico.
    	//Vale, no, resolver el disparo autom�tico DESCARTADO.
    	//Claro, ten�a que contemplar que hubiese hacha y que se la diese al �ltimo en pie (si lo hay).
    	//Epa, queda una cosa, saber si es una copa y resolver el da�o tambi�n.
    	//Falta una �ltima cosa. Si est� el hacha divas�nica tirada en el suelo, entonces la recoge la tropa.
    	
    	this.resolverCombate();
    	this.darCuraci�n();
    	this.sufrirHacha();
    	
    	this.comprobarMuertes();
    	
    	this.fichaAtacante.puedeMover = true;
    	
    	if(this.casilla.tieneHacha() && this.fichaDefensora != null && this.fichaAtacante == null) {
    		
    		this.fichaDefensora.setHachaDivas�nica(this.casilla.getHachaDivas�nica());
    		this.casilla.setHachaDivas�nica(null);
    		
    	}
    	
    	if(casilla.getHachaDivas�nica() != null && fichaDefensora != null && fichaAtacante == null && fichaDefensora.getHachaDivas�nica() == null) {
    		
    		this.fichaDefensora.setHachaDivas�nica(casilla.getHachaDivas�nica());
    		
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
    	
    	if(this.casilla instanceof Curaci�n) {
    		
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
    	
    	this.comprobarMuertes();
    	
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
    
    //ESTO LO AGREGO PARA GESTIONAR LAS CARGAS Y LAS HUIDAS DESDE Tablero.
    public void ejecutarCrga() {
    	
    	this.fichaDefensora.sufrirDa�o(this.fichaAtacante.realizarCarga(this.fichaDefensora));
		if(!this.fichaDefensora.est�Muerta()) {
			
			if(this.casilla instanceof Colina) this.fichaAtacante.sufrirDa�o((this.fichaDefensora.realizarAtaque(this.fichaAtacante)) + ((Colina) this.casilla).getDa�oExtra());
			else this.fichaAtacante.sufrirDa�o(this.fichaDefensora.realizarAtaque(this.fichaAtacante));
			
		}

		this.comprobarMuertes();
    	
    }
    
    public void ejecutarCrgasRespectivas() {
    	
    	this.fichaDefensora.sufrirDa�o(this.fichaAtacante.realizarCarga(this.fichaDefensora));
    	this.fichaAtacante.sufrirDa�o(this.fichaDefensora.realizarCarga(this.fichaAtacante));
    	
    	this.comprobarMuertes();
    	
    }
    
    public void ejecutarAtaqueContraHuida(Ficha f) {
    	//OJO, f ES LA FICHA QUE HUYE!! NO LA QUE ATACA
    	
    	if(f != null) {
    		
    		if(f.equals(this.fichaDefensora)) this.fichaDefensora.sufrirDa�o(this.fichaAtacante.realizarCarga(this.fichaDefensora));
    		else if(f.equals(this.fichaAtacante)) this.fichaAtacante.sufrirDa�o(this.fichaDefensora.realizarCarga(this.fichaAtacante));
    		
    		this.comprobarMuertes();
    		
    	}
    	
    }
    
    private void comprobarMuertes() {
    	
    	if(this.fichaAtacante != null && this.fichaAtacante.est�Muerta()) {
    		
    		if(fichaAtacante.tieneHacha() && fichaDefensora.getHachaDivas�nica() == null) {
    			
    			fichaDefensora.setHachaDivas�nica(fichaAtacante.getHachaDivas�nica());
    			
    		}
    		this.fichaAtacante = null;
    		
    	}
    	if(this.fichaDefensora != null && this.fichaDefensora.est�Muerta()) {
    		
    		if(fichaDefensora.tieneHacha() && casilla.getHachaDivas�nica() == null) {
    			
    			casilla.setHachaDivas�nica(fichaDefensora.getHachaDivas�nica());
    			
    		}
    		
    		//ADVERTENCIA: POSIBLES PROBLEMAS DE PROG3
    		this.fichaDefensora = this.fichaAtacante;
    		this.fichaAtacante = null;
    		
    	}
    	
    }
    
    //POR SI SE HA TRABADO EN COMBATE ESTE TURNETT.
    public void noPuedeMover(Ficha f) {
    	
    	if (f != null) {
    		
    		if(f.equals(this.fichaAtacante)) this.fichaAtacante.puedeMover = false;
        	else if(f.equals(this.fichaDefensora)) this.fichaDefensora.puedeMover = false;
    		
    	}
    	
    }
    
    public boolean puedeMover(Ficha f) {
    	
    	if (f == null) return false;
    	if(f.equals(this.fichaAtacante)) return this.fichaAtacante.puedeMover;
    	else if(f.equals(this.fichaDefensora)) return this.fichaDefensora.puedeMover;
    	else return false;
    }
    
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
	
	public Ficha getFicha(Facci�n faccion) {
		Ficha f=null;
		if(this.getFichaDefensora().getFacci�n() == faccion) {
			f = this.getFichaDefensora();
		}else if(this.getFichaAtacante().getFacci�n() == faccion) {
			f = this.getFichaAtacante();
		}
		return f;
	}
	
	public Object clone() {
    	
    	Object clone = null;
    	
    	Casilla c = null;
    	Ficha fD = null;
    	Ficha fA = null;
    	
    	if(this.casilla != null) c = (Casilla) this.casilla.clone();
    	if(this.fichaDefensora != null) fD = (Ficha) this.fichaDefensora.clone();
    	if(this.fichaAtacante != null) fA = (Ficha) this.fichaAtacante.clone();
    	
    	clone = new Nodo(c, fD, fA);
    	
    	return clone;
    	
    }

}
