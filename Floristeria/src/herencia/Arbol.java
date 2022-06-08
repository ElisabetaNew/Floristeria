package herencia;

public class Arbol extends Articulo{
	
	private static int referenciaArbol = 1; //static porque es compartida en todas las instancias. (incremento 1)
	private String id;
	private int altura;
	

	public Arbol(double precio, int altura) {
		super(precio);
		this.id = "arbol -" + referenciaArbol;
		++referenciaArbol;
		this.altura = altura;
	}


	@Override
	public String toString() {
		return "Arbol [id=" + this.id + ", altura=" + this.altura + ", precio=" + super.precio + "]";
	}
	
	
}
