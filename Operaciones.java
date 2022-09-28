import java.util.Scanner;

public class Operaciones extends Thread{
	
    public void run()
	{
		
		int valor_1 = 0;
		int valor_2 = 0;
		float res;
  
		Scanner leer = new Scanner(System.in);
		
		System.out.print("Ingrese el primer valor entero: ");    
		valor_1 = leer.nextInt();
		
		System.out.print("Ingrese el segundo valor entero: ");
		valor_2 = leer.nextInt();
		
		if (valor_2 <= 0)
		{
			res = 0;
		}
		else
		{
			res = (float)valor_1 / (float)valor_2;
		}
		System.out.println("\nEl primer valor ingresado es: " + valor_1 + " y el segundo fue: " + valor_2 + "\nEl resultado de las operaciones basicas son: \n");
		System.out.println("Multiplicacion: " + (valor_1 * valor_2) + "\n"+
							"Suma: "  + (valor_1 + valor_2) + "\n"+
							"Resta: "  + (valor_1 - valor_2) + "\n"+
							"Division: " + res);
		
    }
	
}