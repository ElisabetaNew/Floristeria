package herencia;

public class Flor extends Articulo{
	
	private static int referenciaFlor = 1; //static porque es compartida en todas las instancias. (incremento 1)
	private String id;
	private String color;
	

	public Flor(double precio, String color) {
		super(precio);
		this.id = "flor -" + referenciaFlor;
		++referenciaFlor;
		this.color = color;
	}


	@Override
	public String toString() {
		return "Flor [id=" + this.id + ", color=" + this.color + ", precio=" + super.precio + "]";
	}

	
}
