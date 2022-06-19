package modelPersistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MyBufferedReaderRetornaString {

	public String leer(String fichero) {

		String result = null;
		File file = new File(fichero);
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		try {
			fileReader = new FileReader(file, StandardCharsets.UTF_8);
			bufferedReader = new BufferedReader(fileReader);

			StringBuilder sb = new StringBuilder(); // Concatenar lineas sobre un string
			String linea = bufferedReader.readLine();
			while (linea != null) {
				sb.append(linea);
				linea = bufferedReader.readLine();
			}

			result = sb.toString();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
				if (fileReader != null) {
					fileReader.close();
				}

			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}
		return result;
	}
}
