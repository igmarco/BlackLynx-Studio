package MD_Tablero;

public class HachaDivas�nica {
    public int da�oExtra;
    
    public int da�oExtraVariable;

    public int vidaPorTurno;
    
    public int vidaPorTurnoVariable;
    
    public HachaDivas�nica() {
    	
    	da�oExtra = 10;
        da�oExtraVariable = 7;
        vidaPorTurno = 5;
        vidaPorTurnoVariable = 4;
    	
    }

    public HachaDivas�nica(int da�oExtra, int da�oExtraVariable, int vidaPorTurno, int vidaPorTurnoVariable) {
		super();
		this.da�oExtra = da�oExtra;
		this.da�oExtraVariable = da�oExtraVariable;
		this.vidaPorTurno = vidaPorTurno;
		this.vidaPorTurnoVariable = vidaPorTurnoVariable;
	}

	public int sumarDa�o() {
    	
    	return da�oExtra + (int) Math.floor(Math.random()*2*(da�oExtraVariable)-1);
    	
    }

    public int sufrirDa�oPorTurno() {
    	
    	return vidaPorTurno + (int) Math.floor(Math.random()*2*(vidaPorTurnoVariable)-1);
    	
    }

}
