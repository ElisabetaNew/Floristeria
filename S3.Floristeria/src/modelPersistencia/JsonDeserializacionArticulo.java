package modelPersistencia;

import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import modelEntitats.ArticuloBd;


public class JsonDeserializacionArticulo {

	public ArticuloBd deserializaArticulo(String nombreFichero) {
		ArticuloBd articulo = null;
		MyBufferedReaderRetornaString myBufferedReader = new MyBufferedReaderRetornaString();
		String contenido = myBufferedReader.leer(nombreFichero);
		articulo = this.getArticuloFromJson(contenido);
		
		return articulo;
	}
	
	public ArrayList<ArticuloBd> deserializaVariosArticulos(String nombreFichero){	
		MyBufferedReaderRetornaString myBufferedReader = new MyBufferedReaderRetornaString();
		String contenido = myBufferedReader.leer(nombreFichero);
		ArrayList<ArticuloBd>articulos = getArrayArticulosFromJsom (contenido);
		return articulos;
	}
	
	private ArticuloBd getArticuloFromJson(String contenidoJson) {
		Gson gson = new Gson();
		ArticuloBd articulo = gson.fromJson(contenidoJson, ArticuloBd.class);
		return articulo;
	}
	
	private ArrayList<ArticuloBd> getArrayArticulosFromJsom (String contenidoJson){
		Type listaTipo = new TypeToken<ArrayList<ArticuloBd>>() {
		}.getType();
		
		ArrayList<ArticuloBd>articulos=null;
		
		
		Gson gson = new Gson();
		
		try {
			articulos = gson.fromJson(contenidoJson, listaTipo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
		return articulos;
	}
}
