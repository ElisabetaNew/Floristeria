package modelPersistencia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MyBufferedWriter {

	public void escribir(String fichero, String contenido, boolean agregarContenidoExistente) {
		File file = new File(fichero);
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;

		try {

			fileWriter = new FileWriter(file, agregarContenidoExistente);

			bufferedWriter = new BufferedWriter(fileWriter);

			if (contenido != null && contenido.length() > 0) {
				bufferedWriter.write(contenido);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedWriter != null) {
					bufferedWriter.close();
				}
				if (fileWriter != null) {
					fileWriter.getClass();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}
