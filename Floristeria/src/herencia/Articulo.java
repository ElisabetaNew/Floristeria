package herencia;

import java.util.ArrayList;

import programagestion.Factura;

public abstract class Articulo {
	
	//atributos
	private static int referenciaArticulo = 1; //static porque es compartida en todas las instancias. (incremento 1)
	private int id;
	protected double precio;
	private ArrayList<Arbol>arboles;
	private ArrayList<Flor>flores;
	private ArrayList<Decoracion>decoraciones;

	

	//constructor
	public Articulo(double precio) {
		this.id = referenciaArticulo;
		++referenciaArticulo;
		this.precio = precio;
		this.arboles = new ArrayList<Arbol>();
		this.flores = new ArrayList<Flor>();
		this.decoraciones = new ArrayList<Decoracion>();
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public ArrayList<Arbol> getArboles() {
		return arboles;
	}

	public void setArboles(ArrayList<Arbol> arboles) {
		this.arboles = arboles;
	}

	public void agregarArbol(Arbol arbolNuevo) {
		this.arboles.add(arbolNuevo);
	}
	public ArrayList<Flor> getFlores() {
		return flores;
	}

	public void setFlores(ArrayList<Flor> flores) {
		this.flores = flores;
	}
	
	public void agregarFlor(Flor florNueva) {
		this.flores.add(florNueva);
	}

	public ArrayList<Decoracion> getDecoraciones() {
		return decoraciones;
	}

	public void setDecoraciones(ArrayList<Decoracion> decoraciones) {
		this.decoraciones = decoraciones;
	}

	public void agregarDecoracion(Decoracion decoracionNuevo) {
		this.decoraciones.add(decoracionNuevo);
	}

	@Override
	public String toString() {
		return "Articulo [id=" + this.id + ", precio=" + this.precio + ", arboles=" + this.arboles + ", flores=" + this.flores
				+ ", decoraciones=" + this.decoraciones + "]";
	}

	
	

}
