package modelPersistencia;

import java.util.ArrayList;

import com.google.gson.Gson;

import modelEntitats.Articulo;


public class JsonSerializacionArticulo {

	public void serializaArticulo(Articulo articulo, String nombreFichero) {
		String contenidoJson = this.getJSONString(articulo);
		MyBufferedWriter myBufferredWriter = new MyBufferedWriter();
		myBufferredWriter.escribir(nombreFichero, contenidoJson, false); // false para que lo agregue todo
	}

	public void serializaVariosArticulos(ArrayList<Articulo>articulos, String nombreFichero) {
		String contenidoJson = this.getJSONString(articulos);
		MyBufferedWriter myBufferredWriter = new MyBufferedWriter();
		myBufferredWriter.escribir(nombreFichero, contenidoJson, false);
	}
	
	private String getJSONString(Articulo articulo) {
		Gson gson = new Gson(); // instanciamos Gson
		String json = gson.toJson(articulo); // me devuelve un String
		return json;
	}
	
	
	
	//Sobre carga de metodos
	private String getJSONString(ArrayList<Articulo>articulos) {
		Gson gson = new Gson(); // instanciamos Gson
		String json = gson.toJson(articulos); // me devuelve un String
		return json;
	}
}
