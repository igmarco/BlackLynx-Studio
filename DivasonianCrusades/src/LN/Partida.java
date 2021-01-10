package LN;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import MD_Instrucci�n.Disparo;
import MD_Instrucci�n.Instrucci�n;
import MD_Instrucci�n.Movimiento;
import MD_Instrucci�n.Operaci�n;
import Utilidades.Facci�n;

public class Partida implements Runnable {
	
	private Socket s1;
	private Socket s2;
	
	private int turno;
	private int movimiento;
    
	private String nombre1;
	private String nombre2;
	
	private boolean rendici�n1;
	private boolean rendici�n2;

	private Instrucci�n instrucci�nFacci�n1;
	private Instrucci�n instrucci�nFacci�n2;

	private Tablero tablero;
	
	ObjectOutputStream oos1 = null;
	ObjectOutputStream oos2 = null;
	ObjectInputStream ois1 = null;
	ObjectInputStream ois2 = null;
    
    public Partida(Socket s1, Socket s2, String nombre1, String nombre2) {
    	
    	this.s1 = s1;
    	this.s2 = s2;
    	this.nombre1 = nombre1;
    	this.nombre2 = nombre2;
    	
    	this.rendici�n1 = false;
    	this.rendici�n1 = false;
    	
    	turno = 0;
    	
    	tablero = new Tablero();
    	
    }
    
    public Partida(Socket s1, Socket s2, String nombre1, String nombre2, Tablero tablero, int turno) {
    	
    	this.s1 = s1;
    	this.s2 = s2;
    	this.nombre1 = nombre1;
    	this.nombre2 = nombre2;
    	
    	this.turno = turno;
    	
    	this.tablero = tablero;
    	
    }
    
    public void run() {
		
		try {
			
			oos1 = new ObjectOutputStream(s1.getOutputStream());
			oos2 = new ObjectOutputStream(s2.getOutputStream());
			ois1 = new ObjectInputStream(s1.getInputStream());
			ois2 = new ObjectInputStream(s2.getInputStream());
			
			boolean haTerminado = false;
			
			while(!haTerminado) {
				
				rendici�n1 = (boolean) ois1.readObject();
				rendici�n2 = (boolean) ois2.readObject();
				
				if(rendici�n1 && rendici�n2) {
					
					haTerminado = true;
					
					oos1.writeBytes("SURR-El oponente se ha rendido.\r\n");
					oos2.writeBytes("SURR-El oponente se ha rendido.\r\n");
					
				}
				else if(rendici�n1) {
					
					haTerminado = true;
					oos2.writeBytes("SURR-El oponente se ha rendido.\r\n");
					
				}
				else if(rendici�n2) {
					
					haTerminado = true;
					oos1.writeBytes("SURR-El oponente se ha rendido.\r\n");
					
				}
				else {
					
					oos1.writeBytes("OK-La partida contin�a.\r\n");
					oos2.writeBytes("OK-La partida contin�a.\r\n");
					
					instrucci�nFacci�n1 = (Instrucci�n) ois1.readObject();
					instrucci�nFacci�n2 = (Instrucci�n) ois2.readObject();
					
					for(movimiento = 0; movimiento < 6; movimiento++) {
						
						this.ejecutarOperaci�n();
						
						this.mandarTableros(oos1, oos2);
						
					}
					
					turno++;
					
					this.resolverTurno();
					
					haTerminado = this.tablero.haTerminado();
					
					this.mandarTableros(oos1, oos2);
					
				}
				
			}
			
			oos1.writeObject(this.tablero.getGanador());
			oos2.writeObject(this.tablero.getGanador());
			
			
			
			//Esto habr� que quitarlo, pero de momento lo voy a dejar porque siempre est� bien que el se�or del servidor cotillee qui�n gana y qui�n pierde.
			if(this.tablero.getGanador() == Facci�n.Facci�n1) System.out.println("�Enhorabuena! Ha ganado el azul " + nombre1 + " en el turno " + turno);
			else System.out.println("�Nada mal! Ha ganado el rojo " + nombre2 + " en el turno " + turno);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

//    public void iniciarPartida(String nombre1, String nombre2) {
//    	
//    	//Preparamos los socketes y todo eso para iniciarse la partidella.
//    	
//    }

//    public void finalizarPartida() {
//    	
//    	//Cerrando el chiringuito y los sockets.
//    	
//    }

    public void ejecutarOperaci�n() {
    	
    	//Hacemos lo que haya que hacer con el ejecutor.
    	Operaci�n op1 = instrucci�nFacci�n1.getOperacion(movimiento);
    	Operaci�n op2 = instrucci�nFacci�n2.getOperacion(movimiento);
    	
    	if(op1 == null) {
    		
    		if(op2 == null) {
        		
        		//No hacer nada
        		
        	}
    		else {
    			
    			//Hace cosas solo el 2
    			if(op2 instanceof Movimiento) {
    				
    				this.tablero.moverFicha(((Movimiento) op2).getFicha(), ((Movimiento) op2).getDirecci�n());
    				
    			}
    			else if(op2 instanceof Disparo) {
    				
    				this.tablero.dispararProyectiles(((Disparo) op2).getCatapulta(), ((Disparo) op2).getX(), ((Disparo) op2).getY());
    				
    			}
    			
    		}
    		
    	}
    	else if(op2 == null) {
    		
    		//Hace cosas solo el 1
    		if(op1 instanceof Movimiento) {
				
				this.tablero.moverFicha(((Movimiento) op1).getFicha(), ((Movimiento) op1).getDirecci�n());
				
			}
			else if(op1 instanceof Disparo) {
				
				this.tablero.dispararProyectiles(((Disparo) op1).getCatapulta(), ((Disparo) op1).getX(), ((Disparo) op1).getY());
				
			}
    		
    	}
    	else {
    		
    		//Hacen cosas los dos
			if(op2 instanceof Disparo) {
				
				//Ahora hace cosas el 1
				if(op1 instanceof Movimiento) {
					
					this.tablero.moverFicha(((Movimiento) op1).getFicha(), ((Movimiento) op1).getDirecci�n());
					
				}
				else if(op1 instanceof Disparo) {
					
					this.tablero.dispararProyectiles(((Disparo) op1).getCatapulta(), ((Disparo) op1).getX(), ((Disparo) op1).getY());
					
				}
				
				//Y despu�s caen los disparos
				this.tablero.dispararProyectiles(((Disparo) op2).getCatapulta(), ((Disparo) op2).getX(), ((Disparo) op2).getY());
				
			}
			else if(op1 instanceof Disparo) {
				
				//Ahora hace cosas el 2
				if(op2 instanceof Movimiento) {
					
					this.tablero.moverFicha(((Movimiento) op2).getFicha(), ((Movimiento) op2).getDirecci�n());
					
				}
				else if(op2 instanceof Disparo) {
					
					//No entrar� aqu�, pero dejamos el c�digo para recordar cu�l es el modo de completar la casu�stica de Operaciones.
					this.tablero.dispararProyectiles(((Disparo) op2).getCatapulta(), ((Disparo) op2).getX(), ((Disparo) op2).getY());
					
				}
				
				//Y despu�s caen los disparos
				this.tablero.dispararProyectiles(((Disparo) op1).getCatapulta(), ((Disparo) op1).getX(), ((Disparo) op1).getY());
				
			}
			else {
				
				//Los dos hacen movimientos
				this.tablero.moverFichasALaVez(((Movimiento) op1).getFicha(), ((Movimiento) op1).getDirecci�n(), ((Movimiento) op2).getFicha(), ((Movimiento) op2).getDirecci�n());
				
			}
    		
    	}
    	
    }

    public void pasarTurno(Instrucci�n i1, Instrucci�n i2) {
    	
    	instrucci�nFacci�n1 = i1;
    	instrucci�nFacci�n2 = i2;
    	turno++;
    	movimiento = 0;
    	
    }

    public boolean haTerminado() {
    	
    	return tablero.haTerminado();
    	
    }

    public Facci�n getGanador() {
    	
    	return tablero.getGanador();
    	
    }

    public void resolverTurno() {
    	
    	//Imagino que ser� solo esto:
    	tablero.resolverTurno();
    	
    }

    public void mandarTableros(ObjectOutputStream oos1, ObjectOutputStream oos2) {
    	
    	//Abran sus sockets que les vamos a meter tremendos tableros
    	
    	try {
    		
			oos1.writeObject(this.tablero);
			oos2.writeObject(this.tablero);
			
			oos1.writeObject(this.tablero.haTerminado());
			oos2.writeObject(this.tablero.haTerminado());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

}
