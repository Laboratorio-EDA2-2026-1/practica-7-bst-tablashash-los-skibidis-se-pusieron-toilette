/**
 *  Disculpe profe, pero no pudimos hacer la deducción con el patron 
 *  de frecuencia. No supimos asignarles valor. Perdon :(
 */

import java.util.*;

public class practica7 {

    static String mesaje = "(/-.-4%(+28.%#+2/($(6(#(3(8%.-/2(+(/(6.(";
    public static void main(String[] args) {

        
		String mensaje = "(/-.-4%(+28.%#+2/($(6(#(3(8%.-/2(+(/(6.(";
		BSTconFrecuencia bst = new BSTconFrecuencia();

		// Se toma el tiempo de ejecución con nanoTime
		long inicio = System.nanoTime();

		for (char c : mensaje.toCharArray()) {
			bst.insertar(c);
		}

		// Cuando termina, se toma el tiempo de finalización
		long fin = System.nanoTime();
		long tiempoTotal = (fin - inicio); // Este tiempo AUN está en nanosegundos

		System.out.println("Frecuencias en orden:");
		bst.recorrerInOrder(bst.raiz);
        System.out.println("TOTAL: "+Nodo.frec_global);

		// Por lo que se divide en 1,000,000
		System.out.println("Tiempo de ejecución: " + (tiempoTotal / 1_000_000.0) + " milisegundos");

        System.out.println("Mensaje: "+mesaje);
        System.out.println("Mensaje: " + mesaje
            .replace('(', 'a')
            .replace('.', 'e')
            .replace('/', 't')
            .replace('-', 'o')
        );
        
    }


    static void arrprint(int[] arr) {
        
        System.out.print("[ ");
        for (int i : arr) {
            System.out.print(i+". ");
        } System.out.println("]");
    }
    static void arrprint(float[] arr) {
        
        System.out.print("[ ");
        for (float i : arr) {
            System.out.print(i+", ");
        } System.out.println("]");
    }

}

class Fn {

    static int M = 31, TREINTAIDOS = 32;
    static double A = (1+Math.sqrt(5))/2; // phi ??

    static float[] topercent(int[] nums) {

        int mayor=0;

        for (int n : nums) {
            mayor+=n;
        }

        //char[] chars = practica7.mesaje.toCharArray();

        float[] porcentajes = new float[nums.length];

        for (int i=0; i<nums.length; i++) {
            porcentajes[i] = (nums[i]*100)/mayor;
            System.out.println(nums[i]+": "+porcentajes[i]+"%");
        }
        return porcentajes;
    }

    static int[] key(String str) {

        char[] chararr = str.toCharArray();
        int[]  intarr = new int[chararr.length];

        for (int i=0; i<chararr.length; i++) {
            intarr[i] = (int) chararr[i];
        }
        practica7.arrprint(intarr);
        return intarr;
    }

    

    static int hashmultindex(int k) {

        return (int) Math.floor( M * (k * A) % M ) + TREINTAIDOS;
    } 

    static int hashdivindex(int k) {

        return (int) k % M + TREINTAIDOS;
    } 

    
}



class Nodo {						// Cada nodo contiene:
	char clave;						// Una clave o valor
	int frecuencia;					// La frecuencia con que aparece
	Nodo izq, der;					// Sus hijos
    float frec_porc;               // Porcentaje de cuantas veces ocurre
    static int frec_global = 40;

	Nodo(char valor) {		// Cuando se crea, no tiene hijos y su frecuencia es 1
		this.clave = valor;
		this.frecuencia = 1;
		this.izq = this.der = null;
	}
}

class BSTconFrecuencia {

	Nodo raiz; // Esta mas facil que poner ancestro jaja

	public void insertar (char clave) {		// Funcion para inserción
		raiz = insertarNodo(raiz, clave);
	}

	//										key solo para evitar confusion en clave
	private Nodo insertarNodo(Nodo nodo, char key) {

		if (nodo == null) {					// Si no hay nodo entonces se vuelve la raiz
			return new Nodo(key);
		}

		if (key == nodo.clave) { 			// si la clave dada es igual a la de la raiz
			nodo.frecuencia++;				// la frecuencia aumenta
            
		} 

		if (key < nodo.clave) {				// Si no, se añade al lado izq o
			nodo.izq = insertarNodo(nodo.izq, key);	// der depende de su valor
		} else if (key > nodo.clave) {
			nodo.der = insertarNodo(nodo.der, key);
		}

		return nodo;
	}

	void recorrerInOrder(Nodo raiz) {

        if (raiz != null) { // TOTAL ES 40

			recorrerInOrder (raiz.izq);
			System.out.println(raiz.clave + " -> " + raiz.frecuencia + ": "+ ((float) raiz.frecuencia*100 / Nodo.frec_global ) + "%");
			recorrerInOrder (raiz.der);
		}
	}

    
}

// Ahora si se viene lo chido
