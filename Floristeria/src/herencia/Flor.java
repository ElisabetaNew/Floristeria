package herencia;

public class Flor extends Articulo{
	
	private static int referenciaFlor = 001; //static porque es compartida en todas las instancias. (incremento 1)
	private String referenciaTipo;
	private String color;
	

	public Flor(double precio, String color) {
		super(precio);
		this.referenciaTipo();
		this.color = color;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String referenciaTipo() {
		this.referenciaTipo = "FL " + referenciaFlor;
		++referenciaFlor;
		return referenciaTipo;
	}


	@Override
	public String toString() {
		return "Flor [numeroArticulo "+ super.numeroArticulo + ",referenciaTipo=" + this.referenciaTipo + ", color=" + this.color + ", precio=" + this.precio
				+ "]";
	}


	






	
	
}
