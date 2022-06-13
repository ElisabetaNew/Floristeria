package herencia;

public class Flor extends Articulo{
	
	private static int referenciaFlor = 1; //static porque es compartida en todas las instancias. (incremento 1)
	private String idFlor;
	private String color;
	

	public Flor(double precio, String color) {
		super(precio);
		this.idFlor = "flor -" + referenciaFlor;
		++referenciaFlor;
		this.color = color;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}

	


	public String getIdFlor() {
		return idFlor;
	}


	@Override
	public String toString() {
		return "Flor [idFlor=" + this.idFlor + ", color=" + this.color + ", precio=" + super.precio + "]";
	}






	
	
}
