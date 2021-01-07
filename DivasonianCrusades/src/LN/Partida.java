package LN;
import MD_Instrucci�n.Instrucci�n;
import Utilidades.Facci�n;

public class Partida {
    public int turno;

    public int movimiento;
    
    public String nombre1;
    
    public String nombre2;

    public Instrucci�n instrucci�nFacci�n1;

    public Instrucci�n instrucci�nFacci�n2;

    public Ejecutor ejecutor;
    
    public Partida() {
    	
    	
    	
    }

    public void iniciarPartida(String nombre1, String nombre2) {
    	
    	//Preparamos los socketes y todo eso para iniciarse la partidella.
    	
    }

    public void finalizarPartida() {
    	
    	//Cerrando el chiringuito y los sockets.
    	
    }

    public void ejecutarOperaci�n() {
    	
    	//Hacemos lo que haya que hacer con el ejecutor.
    	
    }

    public void pasarTurno(Instrucci�n i1, Instrucci�n i2) {
    	
    	instrucci�nFacci�n1 = i1;
    	instrucci�nFacci�n2 = i2;
    	turno++;
    	movimiento = 0;
    	
    }

    public boolean haTerminado() {
    	
    	return ejecutor.haTerminado();
    	
    }

    public Facci�n getGanador() {
    	
    	return ejecutor.getGanador();
    	
    }

    public void resolverTurno() {
    	
    	//Imagino que ser� solo esto:
    	ejecutor.resolverTurno();
    	
    }

    public void mandarTableros() {
    	
    	//Abran sus sockets que les vamos a meter tremendos tableros
    	
    }

}
