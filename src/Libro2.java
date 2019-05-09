import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Libro2 {
	private FileReader libro = null;
	private String ruta = "juegotronos.txt";

	public Libro2() {
		super();
		libro = abrirLibro(new File(ruta));
	}

	//En este caso como la excepcion Filenotfound NUNCA va a pasar
	//simepre habra un assertionerror anterior si no existe el archivo
	//Java me obliga a hacert el try
	private FileReader abrirLibro(File ruta2) {
		// He cogido la progrmacion por contrato de java y me he defendido
		assert ruta2.exists() && ruta2.canRead();
		//Si este error nunca va a darse usa throws o try?
		//usa try y hago progrmacion defensiva
		try {
			return new FileReader(ruta2);
		} catch (FileNotFoundException e) {
			return null;
		}
	}

	// Una clase estatica porque si fuese dinamica tendriamos que crear
	// el objeto dentro del propio objeto
	static class Test {

		@org.junit.jupiter.api.Test
		public void testAbrirLibro() {
			Libro2 libro = new Libro2();
			File li2=new File("juegotronos.txt");
			assertNotNull(libro.abrirLibro(li2));
		}
	}
}
