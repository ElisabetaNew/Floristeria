package programagestion;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Factura {
	private static int contadorIds = 1; //static porque es compartida en todas las instancias. (incremento 1)
	private int numeroFactura;
	private Date fecha;
	private String cliente;
	private double total; //¿como conseguirlo?
	private List<Integer> articulosVenta; //crar lista de articulos incluidos en el ticket utilizando su ID
	
	//constructor
	public Factura(String cliente) {
		numeroFactura = contadorIds;
		++contadorIds; // una vez asignado valor a id sumamos 1 al contador para el proximo objeto.
		fecha = new Date(); //trae la fech de hoy
		this.cliente = cliente;
		articulosVenta = new ArrayList<>(); //inicializar la lista articulosVenta
										 //Puedo omitir el tipo parametrico <> y no especificar Interger porque ya lo especificamos al declarar la lista 
	}

	//Getters y setters (excepto lista)
	public int getNumeroFactura() {
		return numeroFactura;
	}

	public Date getFecha() {
		return fecha;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	//metodo agregar a la lista
	public void agregarArticulosVenta(int idArticulo) {
		articulosVenta.add(idArticulo);
	}

	//metodo listar lista
	public List<Integer> getArticulosVenta() {
		return articulosVenta;
	}
	
	//metodo calcular total factura
	public void calcularTotal (List articulosVenta) {
		for (int i = 0; i < articulosVenta.size(); i++) {
			
		}
			
		}
	}
	

