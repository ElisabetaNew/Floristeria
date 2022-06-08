package herencia;

public class Decoracion extends Articulo{
	
	private static int referenciaDecoracion = 1; //static porque es compartida en todas las instancias. (incremento 1)
	private String id;
	//private boolean isMadera = false;
	//private boolean isPlastico = false;
	private String material;
	
	public Decoracion(double precio, String material) {
		super(precio);
		this.id = "decoracion -" + referenciaDecoracion;
		++referenciaDecoracion;
		this.material = material;	
	}

	@Override
	public String toString() {
		return "Decoracion [id=" + this.id + ", material=" + this.material + ", precio=" + super.precio + "]";
	}

}
