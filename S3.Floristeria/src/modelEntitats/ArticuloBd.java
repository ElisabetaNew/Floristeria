package modelEntitats;

public class ArticuloBd {
	
	//atributos
	protected static int referenciaArticulo = 1; //static porque es compartida en todas las instancias. (incremento 1)
	protected int numeroArticulo;
	protected double precio;

	//constructor
	public ArticuloBd(double precio) {
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

	@Override
	public String toString() {
		return "Articulo [numeroArticulo=" + numeroArticulo + ", precio=" + precio +  "]";
	}
		

	
	

}
