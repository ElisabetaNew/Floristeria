package vista;

import java.util.ArrayList;
import java.util.Scanner;

import modelEntitats.Arbol;
import modelEntitats.Articulo;
import modelEntitats.Decoracion;
import modelEntitats.Factura;
import modelEntitats.Flor;
import modelEntitats.Floristeria;
import modelPersistencia.JsonDeserializacionArticulo;
import modelPersistencia.JsonDeserializacionFactura;
import modelPersistencia.JsonSerializacionArticulo;
import modelPersistencia.JsonSerializacionFactura;

import java.io.*;


public class ProgramaGestion {

	public static ArrayList<Floristeria> floristerias = new ArrayList<Floristeria>();
	
	//marcar ruta para fichero:
	private static final String RUTA_FICHERO = "c:/cursoJava";

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

		floristeria1.agregarArbol(arbol1);
		floristeria1.agregarArbol(arbol2);
		floristeria1.agregarFlor(flor1);
		floristeria1.agregarDecoracion(decoracion1);

		Factura factura1 = new Factura("Paco");
		floristeria1.agregarFactura(factura1);

		serializaVariosArticulos();
		serializaVariasFacturas();
		// fin datos prueba
		
		boolean salir = false;
		String referencia;
		int floristeriaActiva = escogerFloristeria();

		do {
			switch (menu()) {
			case 1:
				altaFloristeria();
				break;
			case 2:
				altaArbol(floristeriaActiva);
				serializaVariosArticulos();
				break;
			case 3:
				altaFlor(floristeriaActiva);
				serializaVariosArticulos();
				break;
			case 4:
				altaDecoracion(floristeriaActiva);
				serializaVariosArticulos();
				break;
			case 5:
				stockPorArticulo(floristeriaActiva);
				break;
			case 6:
				referencia = buscarArbol();
				eliminar(referencia, floristeriaActiva);
				serializaVariosArticulos();
				break;
			case 7:
				referencia = buscarFlor();
				eliminar(referencia, floristeriaActiva);
				serializaVariosArticulos();
				break;
			case 8:
				referencia = buscarDecoracion(floristeriaActiva);
				eliminar(referencia, floristeriaActiva);
				serializaVariosArticulos();
				break;
			case 9:
				stockCantidad(floristeriaActiva);
				break;
			case 10:
				valorFloristeria(floristeriaActiva);
				break;
			case 11:
				int factura = crearFacturas(floristeriaActiva);
				articulosFactura(factura, floristeriaActiva);
				break;
			case 12:
				facturasAnteriores(floristeriaActiva);
				break;
			case 13:
				beneficios(floristeriaActiva);
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
			System.out.println("\nMEN?? PRINCIPAL");
			System.out.println("1. Crear Floristeria");
			System.out.println("2. A??adir Arbol");
			System.out.println("3. A??adir Flor");
			System.out.println("4. A??adir Decoracion");
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

	// Metodo escogerFloristeria (podria ser un programa de gestion para varias
	// floristerias). Cuando utilicemos este valor como posicion de una Array
	// recordad que es valor-1
	public static int escogerFloristeria() {
		int i = 0;

		for (i = 0; i < floristerias.size(); i++) {
			System.out.println((i + 1) + " --> " + floristerias.get(i).getNombre());
		}

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce la posicion de la floristeria que quieres operar");
		int floristeriaEscogida = sc.nextInt();
		sc.nextLine();

		return floristeriaEscogida;
	}

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
	public static void altaArbol(int floristeriaActiva) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce precio");
		double precio = sc.nextDouble();
		System.out.println("Introduce altura");
		int altura = sc.nextInt();

		Arbol arbolNuevo = new Arbol(precio, altura);
		floristerias.get(floristeriaActiva - 1).agregarArbol(arbolNuevo);
		System.out.println("Ha sido creado el arbol: " + arbolNuevo.toString());
	}

	// Metodo altaflor - ok -
	public static void altaFlor(int floristeriaActiva) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce precio");
		double precio = sc.nextDouble();
		sc.nextLine();
		System.out.println("Introduce color");
		String color = sc.nextLine();
		//String color1 = sc.nextLine();
		//sc.nextLine();
		
		Flor florNueva = new Flor(precio, color);
		floristerias.get(floristeriaActiva - 1).agregarFlor(florNueva);
		System.out.println("Ha sido creada la flor: " + florNueva.toString());
	}

	// Metodo altadecoracion - ok -
	public static void altaDecoracion(int floristeriaActiva) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce precio");
		double precio = sc.nextDouble();
		sc.nextLine();
		System.out.println("Introduce material");
		String material = sc.nextLine();

		Decoracion decoracionNueva = new Decoracion(precio, material);
		floristerias.get(floristeriaActiva - 1).agregarDecoracion(decoracionNueva);
		System.out.println("Ha sido creada la decoracion: " + decoracionNueva.toString());
	}

	// Metodo Stock por tipo articulo - ok -
	// utilizo metodo substring para extraer 2 primero caracteres del atributo
	// referenciaTipo para ordenarlos
	public static void stockPorArticulo(int floristeriaActiva) {
		
		String listaArboles = "", listaFlores = "", listaDecoracion = "";

		int j = 0;
		ArrayList<Articulo> articulos = deserializaVariosArticulo();
		//ArrayList<Articulo> articulos = floristerias.get(floristeriaActiva - 1).getArticulos();

		while (j < articulos.size()) {

			if (articulos.get(j).toString().substring(0, 2).equalsIgnoreCase("Ar")) {
				listaArboles += articulos.get(j).toString() + "\n";

			} else if (articulos.get(j).toString().substring(0, 2).equalsIgnoreCase("Fl")) {
				listaFlores += articulos.get(j).toString() + "\n";

			} else if (articulos.get(j).toString().substring(0, 2).equalsIgnoreCase("De")) {
				listaDecoracion += articulos.get(j).toString() + "\n";

			}
			++j;
		}

		System.out.println("FLORISTERIA: " + floristerias.get(floristeriaActiva - 1).getNombre() + "\n");
		System.out
				.println("ARBOLES\n" + listaArboles + "\nFLORES\n" + listaFlores + "\nDECORACION\n" + listaDecoracion);
	}

	// Metodo buscarArbol - ok -
	public static String buscarArbol() {
		int size = floristerias.size();
		int i = 0;
		String lista = "";

		while (i < size) {
			ArrayList<Articulo> articulos = deserializaVariosArticulo();
			//ArrayList<Articulo> articulos = floristerias.get(i).getArticulos();
			int j = 0;

			while (j < articulos.size()) {
				if (articulos.get(j).toString().substring(0, 2).equalsIgnoreCase("Ar")) {
					lista += articulos.get(j).toString() + "\n";

				}
				++j;
			}

			System.out.println("FLORISTERIA: " + floristerias.get(i).getNombre() + "\n");
			System.out.println("ARBOLES\n" + lista);
			++i;
		}

		Scanner sc = new Scanner(System.in);
		System.out.println("??que referenciaTipo desea eliminar?");
		String referencia = sc.nextLine();
		sc.close();
		return referencia;
	}

	// Metodo buscarFlor - ok -
	public static String buscarFlor() {
		int size = floristerias.size();
		int i = 0;
		String lista = "";

		while (i < size) {
			ArrayList<Articulo> articulos = deserializaVariosArticulo();
			//ArrayList<Articulo> articulos = floristerias.get(i).getArticulos();
			int j = 0;

			while (j < articulos.size()) {
				if (articulos.get(j).toString().substring(0, 2).equalsIgnoreCase("Fl")) {
					lista += articulos.get(j).toString() + "\n";

				}
				++j;
			}

			System.out.println("FLORISTERIA: " + floristerias.get(i).getNombre() + "\n");
			System.out.println("FLORES\n" + lista);
			++i;
		}

		Scanner sc = new Scanner(System.in);
		System.out.println("??que referenciaTipo desea eliminar?");
		String referencia = sc.nextLine();
		sc.close();
		return referencia;
	}

	// Metodo buscarDecoracion - ok -
	public static String buscarDecoracion(int floristeriaActiva) {
		int size = floristerias.size();
		int i = 0;
		String lista = "";

		while (i < size) {
			ArrayList<Articulo> articulos = deserializaVariosArticulo();
			//ArrayList<Articulo> articulos = floristerias.get(i).getArticulos();
			int j = 0;

			while (j < articulos.size()) {
				if (articulos.get(j).toString().substring(0, 2).equalsIgnoreCase("De")) {
					lista += articulos.get(j).toString() + "\n";

				}
				++j;
			}

			System.out.println("FLORISTERIA: " + floristerias.get(i).getNombre() + "\n");
			System.out.println("DECORACIONES\n" + lista);
			++i;
		}

		Scanner sc = new Scanner(System.in);
		System.out.println("??que referenciaTipo desea eliminar?");
		String referencia = sc.nextLine();
		sc.close();
		return referencia;
	}


	// Metodo eliminar referencia - ok -
	public static void eliminar(String referencia, int floristeriaActiva) {

		ArrayList<Articulo> articulos = deserializaVariosArticulo();
		//ArrayList<Articulo> articulos = floristerias.get(floristeriaActiva - 1).getArticulos();
		int j = 0;
		boolean encontrado = false;
		try {
			while (j < articulos.size() && encontrado==false ) {
				if (articulos.get(j).toString().substring(0, 4).equalsIgnoreCase(referencia)) {
					articulos.remove(j);
					encontrado = true;
				}
				++j;
			} System.out.println("La referencia: " + referencia + " ha sido eliminada");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

		
	}

	// Metodo listar stock con cantidad - ok -
	public static void stockCantidad(int floristeriaActiva) {
		int sumaArboles = 0, sumaFlores = 0, sumaDecoracion = 0;

		ArrayList<Articulo> articulos = deserializaVariosArticulo();
		//ArrayList<Articulo> articulos = floristerias.get(floristeriaActiva - 1).getArticulos();
		int j = 0;

		while (j < articulos.size()) {
			if (articulos.get(j).toString().substring(0, 2).equalsIgnoreCase("AR")) {
				++sumaArboles;

			} else if (articulos.get(j).toString().substring(0, 2).equalsIgnoreCase("FL")) {
				++sumaFlores;

			} else if (articulos.get(j).toString().substring(0, 2).equalsIgnoreCase("DE")) {
				++sumaDecoracion;

			}
			++j;
		}

		System.out.println("FLORISTERIA: " + floristerias.get(floristeriaActiva - 1).getNombre()
				+ " ---> Total articulos: " + (sumaArboles + sumaFlores + sumaDecoracion) + "\n");
		System.out.println("Total ARBOLES\n" + sumaArboles + "\nTotal FLORES\n" + sumaFlores + "\nTotal DECORACION\n"
				+ sumaDecoracion);

	}


	// Metodo valor total floristeria - ok -
	public static void valorFloristeria(int floristeriaActiva) {
		double valor = 0;
		
		ArrayList<Articulo> articulos = deserializaVariosArticulo();
		//ArrayList<Articulo> articulos = floristerias.get(floristeriaActiva - 1).getArticulos();
		int j = 0;

		for (j = 0; j < articulos.size(); j++) {
			valor += articulos.get(j).getPrecio();
		}
		System.out.println("El valor del stock de: " + floristerias.get(floristeriaActiva - 1).getNombre() + " es: "
				+ valor + " ???.");
	}

	// Metodo crear facturas - ok -
	public static int crearFacturas(int floristeriaActiva) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce nombre cliente");
		String nombreCliente = sc.nextLine();

		Factura facturaNueva = new Factura(nombreCliente);
		floristerias.get(floristeriaActiva - 1).agregarFactura(facturaNueva);

		return facturaNueva.getNumeroFactura();
	}

	// Metodo a??adir articulos factura - retocar -
	public static void articulosFactura(int factura, int floristeriaActiva) {

		boolean salir = false;
		String listaComprados = "";

		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("Escoger idArticulo que desea a??adir a la factura\n");
			String lista = "";

			ArrayList<Articulo> articulos = floristerias.get(floristeriaActiva - 1).getArticulos();
			int i = 0;

			for (i = 0; i < articulos.size(); i++) {
				lista += articulos.get(i).toString() + "\n";
			}
			System.out.println(lista);
			int articuloEscogido = sc.nextInt();
			sc.nextLine();
			Articulo articuloVenta = floristerias.get(floristeriaActiva - 1).getArticulos().get(articuloEscogido - 1);
			floristerias.get(floristeriaActiva - 1).getFacturas().get(factura - 1).agregarArticulosVenta(articuloVenta);
			listaComprados += articuloVenta;
			System.out.println("??Desea a??adir m??s articulos a la factura?");
			String respuesta = sc.nextLine();
			// respuesta.toLowerCase();
			char letraRespuesta = respuesta.toLowerCase().charAt(0);

			if (letraRespuesta == 'n') {
				salir = true;
			}
		} while (!salir);
		System.out.println("Factura de " + floristerias.get(floristeriaActiva - 1).getNombre() + "\n" + "N?? Factura: "
				+ floristerias.get(floristeriaActiva - 1).getFacturas().get(factura - 1).getNumeroFactura() + "\n"
				+ "Cliente: " + floristerias.get(floristeriaActiva - 1).getFacturas().get(factura - 1).getCliente()
				+ "\n" + "Fecha factura: "
				+ floristerias.get(floristeriaActiva - 1).getFacturas().get(factura - 1).getFecha() + "\n"
				+ "Articulos: " + listaComprados + "\n" + "Total Factura: "
				+ floristerias.get(floristeriaActiva - 1).getFacturas().get(factura - 1).calcularTotal() + "???.");
	}

	// Metodo mostrar lista con compras anteriores
	public static void facturasAnteriores(int floristeriaActiva) {

		ArrayList<Factura> facturas = floristerias.get(floristeriaActiva - 1).getFacturas();

		for (Factura factura : facturas) {
			System.out.println(factura.listarFactura());
		}
	}

	// Metodo total beneficios
	public static void beneficios(int floristeriaActiva) {
		double valor = 0;

		ArrayList<Factura> facturas = floristerias.get(floristeriaActiva - 1).getFacturas();
		int i = 0;

		for (i = 0; i < facturas.size(); i++) {
			valor += facturas.get(i).getTotal();
		}
		System.out.println("Los beneficios totales de " + floristerias.get(floristeriaActiva - 1).getNombre() + " es: "
				+ valor + " ???.");
	}

	private static void serializaVariasFacturas() {
		ArrayList<Factura> factura = floristerias.get(0).getFacturas();	
		JsonSerializacionFactura jsonSerializacionFactura = new JsonSerializacionFactura();
		jsonSerializacionFactura.serializaVariasFacturas(factura, RUTA_FICHERO+ "/facturas.json");
	}
	
	private static void serializaVariosArticulos() {
		ArrayList<Articulo> articulo = floristerias.get(0).getArticulos();	
		JsonSerializacionArticulo jsonSerializacionArticulo = new JsonSerializacionArticulo();
		jsonSerializacionArticulo.serializaVariosArticulos(articulo, RUTA_FICHERO+ "/articulos.json");
	}

	private static void deserializaVariasFacturas() {
		JsonDeserializacionFactura jsonDeserializacionFactura = new JsonDeserializacionFactura();
		ArrayList<Factura>facturas = jsonDeserializacionFactura.deserializaVariasFacturas(RUTA_FICHERO + "/facturas.json" );
		for (Factura factura : facturas) {
			System.out.println(facturas);
		}
	}
	
	private static ArrayList<Articulo> deserializaVariosArticulo() {
		JsonDeserializacionArticulo jsonDeserializacionArticulo = new JsonDeserializacionArticulo();
		ArrayList<Articulo> articulos = jsonDeserializacionArticulo.deserializaVariosArticulos(RUTA_FICHERO + "/articulos.json" );
		//for (Articulo articulo : articulos) {
			//System.out.println(articulos);
		
		//}
		return articulos;
	}
	
	
//	private static void deleteFechero(String nombreFichero) {
//		try {
//			File archivo = new File(RUTA_FICHERO + nombreFichero);
//			archivo.delete();
//		}catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		
//	}
	
	
}