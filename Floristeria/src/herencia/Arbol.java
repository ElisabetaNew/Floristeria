package herencia;

public class Arbol extends Articulo{
	
	private static int referenciaArbol = 1; //static porque es compartida en todas las instancias. (incremento 1)
	private String idArbol;
	private int altura;
	


	public Arbol(double precio, int altura) {
		super(precio);
		this.idArbol = "arbol -" + referenciaArbol;
		++referenciaArbol;
		this.altura = altura;
	}


	public int getAltura() {
		return altura;
	}


	public void setAltura(int altura) {
		this.altura = altura;
	}


	public String getIdArbol() {
		return idArbol;
	}


	@Override
	public String toString() {
		return "Arbol [idArbol=" + this.idArbol + ", altura=" + this.altura + ", precio=" + super.precio + "]";
	}






	
	
	
}
