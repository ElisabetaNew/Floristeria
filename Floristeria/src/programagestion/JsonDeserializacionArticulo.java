package programagestion;

import com.google.gson.Gson;

import herencia.Articulo;

public class JsonDeserializacionArticulo {

	public Articulo deserializaArticulo(String nombreFichero) {
		Articulo articulo = null;
		MyBufferedReaderRetornaString myBufferedReader = new MyBufferedReaderRetornaString();
		String contenido = myBufferedReader.leer(nombreFichero);
		articulo = this.getArticuloFromJson(contenido);
		
		return articulo;
	}
	
	private Articulo getArticuloFromJson(String contenidoJson) {
		Gson gson = new Gson();
		Articulo articulo = gson.fromJson(contenidoJson, Articulo.class);
		return articulo;
	}
}
