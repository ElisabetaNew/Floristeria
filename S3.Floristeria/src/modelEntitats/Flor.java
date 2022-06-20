package modelEntitats;

public class Flor extends Articulo {

	private static int referenciaFlor = 001; // static porque es compartida en todas las instancias. (incremento 1)
	private String referenciaTipo;
	private String color;

	public Flor(double precio, String color) {
		super(precio);
		this.referenciaTipo = "FL " + referenciaFlor;
		++referenciaFlor;
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getReferenciaTipo() {
		return referenciaTipo;
	}

	public void setReferenciaTipo(String referenciaTipo) {
		this.referenciaTipo = referenciaTipo;
	}

//	@Override
//	public String referenciaTipo() {
//		this.referenciaTipo = "FL " + referenciaFlor;
//		++referenciaFlor;
//		return referenciaTipo;
//	}

	@Override
	public String toString() {
		return "Flor [numeroArticulo " + super.numeroArticulo + ",referenciaTipo=" + this.referenciaTipo + ", color="
				+ this.color + ", precio=" + this.precio + "]";
	}

}
