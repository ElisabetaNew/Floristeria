package modelPersistencia;

import java.util.ArrayList;

import com.google.gson.Gson;

import modelEntitats.Factura;

public class JsonSerializacionFactura {

	public void serializaFactura(Factura factura, String nombreFichero) {
		String contenidoJson = this.getJSONString(factura);
		MyBufferedWriter myBufferredWriter = new MyBufferedWriter();
		myBufferredWriter.escribir(nombreFichero, contenidoJson, false); // false para que lo agregue todo
	}

	public void serializaVariasFacturas(ArrayList<Factura> facturas, String nombreFichero) {
		String contenidoJson = this.getJSONString(facturas);
		//System.out.println(contenidoJson);
		MyBufferedWriter myBufferredWriter = new MyBufferedWriter();
		myBufferredWriter.escribir(nombreFichero, contenidoJson, false);
	}
	
	private String getJSONString(Factura factura) {
		Gson gson = new Gson(); // instanciamos Gson
		String json = gson.toJson(factura); // me devuelve un String
		return json;
	}
	
	//Sobre carga de metodos
	private String getJSONString(ArrayList<Factura> facturas) {
		Gson gson = new Gson(); // instanciamos Gson
		String json = gson.toJson(facturas); // me devuelve un String
		return json;
	}
}
