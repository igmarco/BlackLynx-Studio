package DivasonianCrusades;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// Ejecuta el este, Pablo
		
		Scanner sc = new Scanner(System.in);
		
		int n�mero;
		
		do {
			
			System.out.println("Introduzca un n�mero del 1 al 100.");
			
			n�mero = sc.nextInt();
			
		}while(n�mero > 100 || n�mero < 0);
		
		if(n�mero <= 20) {
			
			System.out.println("El gay tiene el autoestima baja. M�s te valdr�a comer m�s champillones que te suban la moral y dejes de ser tan tremendo maric�n. Los lunes no son tan malos como para que llegues tarde a clase tarde porque te pasas la primera parte de la ma�ana en la cama lloriqueando, pedazo de nenaza.");
			
		}
		else if(n�mero < 80) {
			
			System.out.println("Ah bueno disculpe no sab�a que usted era una nenaza normi con peinado de maric�n. Pens� que podr�a tratarle con un cierto respeto porque tendr�a algo especial que le diferenciase de la basura, pero ya veo que todo lo que puedo encontrar es un mont�n de mierda ponzo�osa. Gracias entonces bobalic�n chupa escrotos.");
			
		}
		else {
			
			System.out.println("Pero mira a qui�n tenemos aqu�. M�s de 80, eh gay? Seguro que te crees s�per poderoso por tener una pija de m�s de 8 cm y por depilarte las cejas con cera. Pues que sepas que dormir con tu osito de peluche y rascarte los pelos del culo te delata como pedazo de verga infecta culo roto.");
			
		}
	}

}
