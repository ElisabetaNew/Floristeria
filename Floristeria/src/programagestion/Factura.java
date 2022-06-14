package programagestion;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import herencia.Articulo;

public class Factura {
	private static int contadorIds = 1; //static porque es compartida en todas las instancias. (incremento 1)
	private int numeroFactura;
	private Date fecha;
	private String cliente;
	private double total; 
	private List<Articulo> articulosVenta; //crear lista de articulos incluidos en el ticket utilizando su ID
	
	//constructor
	public Factura(String cliente) {
		numeroFactura = contadorIds;
		++contadorIds; // una vez asignado valor a id sumamos 1 al contador para el proximo objeto.
		fecha = new Date(); //trae la fech de hoy
		this.cliente = cliente;
		articulosVenta = new ArrayList<>(); //inicializar la lista articulosVenta
										 //Puedo omitir el tipo parametrico <> y no especifica porque ya lo especificamos al declarar la lista 
		this.total = calcularTotal();
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
	public void agregarArticulosVenta(Articulo articulo) {
		articulosVenta.add(articulo);
	}

	//metodo listar lista
	public List<Articulo> getArticulosVenta() {
		return articulosVenta;
	}
	
	//metodo calcular total factura
	public double calcularTotal () {
		double totalFactura = 0;

		for (int i = 0; i < this.articulosVenta.size(); i++) {
			totalFactura += this.articulosVenta.get(i).getPrecio();
		}
			return totalFactura;
		}

	@Override
	public String toString() {
		return "Factura [numeroFactura=" + numeroFactura + ", fecha=" + fecha + ", cliente=" + cliente + ", total="
				+ total + ", articulosVenta=" + articulosVenta + "]";
	}
	
}
	
	

