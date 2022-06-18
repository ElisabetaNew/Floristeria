package programagestion;

import com.google.gson.Gson;

import herencia.Articulo;

public class JsonSerializacionArticulo {

	public void serializaArticulo(Articulo articulo, String nombreFichero) {

		String contenidoJson = this.getJSONStringFromArticulo(articulo);
		MyBufferedWriter myBufferredWriter = new MyBufferedWriter();
		myBufferredWriter.escribir(nombreFichero, contenidoJson, false); // false para que lo agregue todo
	}

	private String getJSONStringFromArticulo(Articulo articulo) {

		Gson gson = new Gson(); // instanciamos Gson
		String json = gson.toJson(articulo); // me devuelve un String
		return json;

	}

}
