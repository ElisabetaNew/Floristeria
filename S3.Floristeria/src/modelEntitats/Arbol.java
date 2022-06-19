package modelEntitats;

public class Arbol extends Articulo {

	private static int referenciaArbol = 001; // static porque es compartida en todas las instancias. (incremento 1)
	private String referenciaTipo;
	private int altura;

	public Arbol(double precio, int altura) {
		super(precio);
		this.referenciaTipo = referenciaTipo();
		this.altura = altura;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public String getReferenciaTipo() {
		return referenciaTipo;
	}

	public void setReferenciaTipo(String referenciaTipo) {
		this.referenciaTipo = referenciaTipo;
	}

	@Override
	public String referenciaTipo() {
		this.referenciaTipo = "AR " + referenciaArbol;
		++referenciaArbol;
		return referenciaTipo;
	}

	@Override
	public String toString() {
		return "Arbol [numeroArticulo " + super.numeroArticulo + ",referenciaTipo=" + this.referenciaTipo + ", altura="
				+ this.altura + ", precio=" + super.precio + "]";
	}

}
