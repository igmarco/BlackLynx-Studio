package MD_Tablero;

public class Catapulta extends Casilla {
    public int da�oProyectiles;

    public int da�oProyectilesVariable;

    public int rango;

    public int realizarDisparo() {
    	
    	return da�oProyectiles + (int) Math.floor(Math.random()*2*(da�oProyectilesVariable)-1);
    	
    }

    public int getRango() {
    }

}
