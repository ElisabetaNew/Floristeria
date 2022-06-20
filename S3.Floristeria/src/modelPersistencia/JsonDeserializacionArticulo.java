package modelPersistencia;

import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import modelEntitats.Articulo;


public class JsonDeserializacionArticulo {

	public Articulo deserializaArticulo(String nombreFichero) {
		Articulo articulo = null;
		MyBufferedReaderRetornaString myBufferedReader = new MyBufferedReaderRetornaString();
		String contenido = myBufferedReader.leer(nombreFichero);
		articulo = this.getArticuloFromJson(contenido);
		
		return articulo;
	}
	
	public ArrayList<Articulo> deserializaVariosArticulos(String nombreFichero){	
		MyBufferedReaderRetornaString myBufferedReader = new MyBufferedReaderRetornaString();
		String contenido = myBufferedReader.leer(nombreFichero);
		ArrayList<Articulo>articulos = getArrayArticulosFromJsom (contenido);
		return articulos;
	}
	
	private Articulo getArticuloFromJson(String contenidoJson) {
		Gson gson = new Gson();
		Articulo articulo = gson.fromJson(contenidoJson, Articulo.class);
		return articulo;
	}
	
	private ArrayList<Articulo> getArrayArticulosFromJsom (String contenidoJson){
		Type listaTipo = new TypeToken<ArrayList<Articulo>>() {
		}.getType();
		
		ArrayList<Articulo>articulos=null;
		
		
		Gson gson = new Gson();
		
		try {
			articulos = gson.fromJson(contenidoJson, listaTipo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
		return articulos;
	}
}
