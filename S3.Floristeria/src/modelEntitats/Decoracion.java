package modelEntitats;

public class Decoracion extends Articulo{
	
	private static int referenciaDecoracion = 001; //static porque es compartida en todas las instancias. (incremento 1)
	private String referenciaTipo;
	//private boolean isMadera = false;
	//private boolean isPlastico = false;
	private String material;
	
	public Decoracion(double precio, String material) {
		super(precio);
		this.referenciaTipo="DE " + referenciaDecoracion;
		++referenciaDecoracion;
		this.material = material;	
	}
	
	
	public String getMaterial() {
		return material;
	}


	public void setMaterial(String material) {
		this.material = material;
	}


//	@Override
//	public String referenciaTipo() {
//		this.referenciaTipo = "DE " + referenciaDecoracion;
//		++referenciaDecoracion;
//		return referenciaTipo;
//	}


	@Override
	public String toString() {
		return "Decoracion [numeroArticulo "+ super.numeroArticulo + ",referenciaTipo=" + this.referenciaTipo + ", material=" + this.material + ", precio="
				+ super.precio + "]";
	}


	





	

}
