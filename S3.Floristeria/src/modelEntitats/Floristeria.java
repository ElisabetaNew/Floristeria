package modelEntitats;

import java.util.ArrayList;


public class Floristeria {

	private String nombre;
	private ArrayList<Articulo>articulos;
	private ArrayList<Factura>facturas;
	
	
	//Constructor
	public Floristeria(String nombre) {
		this.nombre = nombre;
		this.articulos = new ArrayList<Articulo>();
		this.facturas = new ArrayList<Factura>();
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Articulo> getArticulos() {
		return articulos;
	}


	public void setArticulos(ArrayList<Articulo> articulos) {
		this.articulos = articulos;
	}

	public void agregarArticulo(Articulo articuloNuevo) {
		this.articulos.add(articuloNuevo);
	}

	public ArrayList<Factura> getFacturas() {
		return facturas;
	}


	public void setFacturas(ArrayList<Factura> facturas) {
		this.facturas = facturas;
	}

	public void agregarFactura(Factura facturaNueva) {
		this.facturas.add(facturaNueva);
	}


	//metodo listar formato factura
	public void listarFactura(int factura, Articulo listaComprados) {
		System.out.println("Factura de " + this.nombre + "\n" +
				"Nº Factura: " + this.getFacturas().get(factura - 1).getNumeroFactura() + "\n"
				+ "Cliente: " + this.getFacturas().get(factura - 1).getCliente()+ "\n" +
				"Fecha factura: " + this.getFacturas().get(factura - 1).getFecha() + "\n"
				+ "Articulos: " + listaComprados + "\n" + 
				"Total Factura: "+ this.getFacturas().get(factura - 1).calcularTotal()+ "€.");
	}
	
	@Override
	public String toString() {
		return "Floristeria [nombre=" + nombre + ", articulos=" + articulos + ", facturas=" + facturas + "]";
	}
	
	
}
