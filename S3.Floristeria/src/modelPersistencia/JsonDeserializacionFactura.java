package modelPersistencia;

import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import modelEntitats.Factura;

public class JsonDeserializacionFactura {

	public Factura deserializaFactura(String nombreFichero) {
		Factura factura = null;
		MyBufferedReaderRetornaString myBufferedReader = new MyBufferedReaderRetornaString();
		String contenido = myBufferedReader.leer(nombreFichero);
		factura = this.getFacturaFromJson(contenido);
		
		return factura;
	}
	
	public ArrayList<Factura> deserializaVariasFacturas(String nombreFichero){	
		MyBufferedReaderRetornaString myBufferedReader = new MyBufferedReaderRetornaString();
		String contenido = myBufferedReader.leer(nombreFichero);
		ArrayList<Factura>facturas = getArrayFacturasFromJsom (contenido);
		return facturas;
	}
	
	private Factura getFacturaFromJson(String contenidoJson) {
		Gson gson = new Gson();
		Factura factura = gson.fromJson(contenidoJson, Factura.class);
		return factura;
	}
	
	private ArrayList<Factura> getArrayFacturasFromJsom (String contenidoJson){
		Type listaTipo = new TypeToken<ArrayList<Factura>>() {
		}.getType();
		
		ArrayList<Factura>facturas = null;
		Gson gson = new Gson();
		facturas = gson.fromJson(contenidoJson, listaTipo);
		return facturas;
	}
}
