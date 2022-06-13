package herencia;

public class Decoracion extends Articulo{
	
	private static int referenciaDecoracion = 1; //static porque es compartida en todas las instancias. (incremento 1)
	private String idDecoracion;
	//private boolean isMadera = false;
	//private boolean isPlastico = false;
	private String material;
	
	public Decoracion(double precio, String material) {
		super(precio);
		this.idDecoracion = "decoracion -" + referenciaDecoracion;
		++referenciaDecoracion;
		this.material = material;	
	}
	
	
	public String getMaterial() {
		return material;
	}


	public void setMaterial(String material) {
		this.material = material;
	}


	public String getIdDecoracion() {
		return idDecoracion;
	}


	@Override
	public String toString() {
		return "Decoracion [idDecoracion=" + this.idDecoracion + ", material=" + this.material + ", precio=" + super.precio + "]";
	}





	

}
