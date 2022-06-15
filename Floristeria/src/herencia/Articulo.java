package herencia;

import java.util.ArrayList;

import programagestion.Factura;

public abstract class Articulo {
	
	//atributos
	protected static int referenciaArticulo = 1; //static porque es compartida en todas las instancias. (incremento 1)
	protected int numeroArticulo;
	protected double precio;

	//constructor
	public Articulo(double precio) {
		this.numeroArticulo = referenciaArticulo;
		++referenciaArticulo;
		this.precio = precio;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getId() {
		return numeroArticulo;
	}

	
	//metodo abstracto referenciaTipo
	public abstract String referenciaTipo();

	@Override
	public String toString() {
		return "Articulo [numeroArticulo=" + numeroArticulo + ", precio=" + precio +  "]";
	}
		

	
	

}
