package programagestion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import herencia.Arbol;
import herencia.Articulo;
import herencia.Decoracion;
import herencia.Flor;

public class ProgramaGestion {

	public static ArrayList<Floristeria> floristerias = new ArrayList<Floristeria>();

	public static void main(String[] args) {

		// inicio datos prueba
		// constructor Floristeria(String nombre)
		// constructor Articulo(double precio)
		// constructor Arbol(double precio, int altura)
		// constructor Flor(double precio, String color)
		// constructor Decoracion(double precio, String material)
		// constructor Factura(String cliente);

		Floristeria floristeria1 = new Floristeria("Flor de Noche");
		floristerias.add(floristeria1);

		Arbol arbol1 = new Arbol(35.00, 150);
		Arbol arbol2 = new Arbol(70.00, 350);
		Flor flor1 = new Flor(15.00, "Violeta");
		Decoracion decoracion1 = new Decoracion(65.00, "Madera");

		floristeria1.agregarArticulo(arbol1);
		floristeria1.agregarArticulo(arbol2);
		floristeria1.agregarArticulo(flor1);
		floristeria1.agregarArticulo(decoracion1);

		Factura factura1 = new Factura("Paco");
		floristeria1.agregarFactura(factura1);

		// fin datos prueba

		boolean salir = false;

		do {
				switch (menu()) {
				case 1:
					altaFloristeria();
					break;
				case 2:
					altaArbol();
					break;
				case 3:
					altaFlor();
					break;
				case 4:
					altaDecoracion();
					break;
				case 0:
					System.out.println("Gracias por utilizar la aplicacion. Hasta pronto");
					salir = true;
					break;
				}

		} while (!salir);
	}

	// Metodo menu incial
	public static byte menu() {
		Scanner entrada = new Scanner(System.in);
		byte opcion;
		final byte MINIMO = 0;
		final byte MAXIMO = 13;

		do {
			System.out.println("\nMENú PRINCIPAL");
			System.out.println("1. Crear Floristeria");
			System.out.println("2. Añadir Arbol");
			System.out.println("3. Añadir Flor");
			System.out.println("4. Añadir Decoracion");
			System.out.println("5. Stock: Visto por tipo de articulo");
			System.out.println("6. Retirar arbol");
			System.out.println("7. Retirar flor");
			System.out.println("8. Retirar decoracion");
			System.out.println("9. Stock: Con unidades");
			System.out.println("10. Valor actual total de lafloristeria");
			System.out.println("11. Crear factura");
			System.out.println("12. Lista facturas anteriores");
			System.out.println("13. Total ingresos ventas");
			System.out.println("0. Salir de la aplicacion.\n");
			opcion = entrada.nextByte();
			if (opcion < MINIMO || opcion > MAXIMO) {
				System.out.println("Escoge una opcion valida, por favor.");
			}
		} while (opcion < MINIMO || opcion > MAXIMO);

		return opcion;
	}

	// Metodo buscarFloristeria

	/*
	 * public static int buscarFloristeria() {
	 * 
	 * 
	 * Scanner sc = new Scanner(System.in);
	 * 
	 * System.out.println("Introduce el nombre Floristeria"); String nombreBuscado =
	 * sc.nextLine();
	 * 
	 * boolean encontrado = false; int posicion = -1; int size =
	 * floristerias.size(); int i = 0;
	 * 
	 * while (encontrado == false && posicion == -1 && i < size) { if
	 * (floristerias.get(i).getNombre().equalsIgnoreCase(nombreBuscado)) { posicion
	 * = floristerias.indexOf(floristerias.get(i)); } ++i; } encontrado = true; }
	 * return posicion; }
	 */

	// Metodo altafloristeria - ok -
	public static void altaFloristeria() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce nombre");
		String nombre = sc.nextLine();

		Floristeria floristeriaNueva = new Floristeria(nombre);
		floristerias.add(floristeriaNueva);
		System.out.println("Ha sido creada la floristeria: " + floristeriaNueva.toString());
	}

	// Metodo altaarbol - ok -
	public static void altaArbol() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce precio");
		double precio = sc.nextDouble();
		System.out.println("Introduce altura");
		int altura = sc.nextInt();

		Arbol arbolNuevo = new Arbol(precio, altura);
		floristerias.get(0).agregarArticulo(arbolNuevo);
		System.out.println("Ha sido creado el arbol: " + arbolNuevo.toString());
	}

	// Metodo altaflor - ok - 
	public static void altaFlor() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce precio");
		double precio = sc.nextDouble();
		System.out.println("Introduce color");
		String color = sc.nextLine();

		Flor florNueva = new Flor(precio, color);
		floristerias.get(0).agregarArticulo(florNueva);
		System.out.println("Ha sido creada la flor: " + florNueva.toString());
	}

	// Metodo altadecoracion  - ok -
	public static void altaDecoracion() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce precio");
		double precio = sc.nextDouble();
		System.out.println("Introduce material");
		String material = sc.nextLine();

		Decoracion decoracionNueva = new Decoracion(precio, material);
		floristerias.get(0).agregarArticulo(decoracionNueva);
		System.out.println("Ha sido creada la decoracion: " + decoracionNueva.toString());
	}

	// Metodo Stock por tipo articulo - repaso - 
	public static void stockPorArticulo() {
	for (int i = 0; i < floristerias.size(); i++) {
			System.out.println(floristerias.get(i).getArticulos());
			}
	}

	// Metodo eliminarFlor - repaso - 
	public static void eliminarFlor() {

		// listo todos los articulos que son flores
		for (int i = 0; i < floristerias.size(); i++) {
			for (int j = 0; j < floristerias.get(i).getArticulos().size(); j++) {
				for (int z = 0; z < floristerias.get(i).getArticulos().get(j).getFlores().size(); z++) {
					System.out.println(floristerias.get(i).getArticulos().get(j).getFlores().get(z).getIdFlor());
				}
			}
		}

		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce la referencia de la flor a eliminar");
		String respuesta = sc.nextLine();
	}
}
