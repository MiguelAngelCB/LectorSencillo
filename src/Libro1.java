import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Libro1 {
	private FileReader libro = null;
	private String ruta = "juegotronos.txt";

	public Libro1() {
		super();
		libro = abrirLibro(ruta);
	}

	private FileReader abrirLibro(String ruta2) {
		//He cogido la progrmacion por contrato de java y me he defendido
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
		Libro1 libro=new Libro1();
		//El libro no existe
		assertNull(libro.abrirLibro("no existe"));
		//El libro no se puede abrir
		//Se puede abrir y existe
		assertNotNull(libro.abrirLibro("juegotronos.txt"));
		}
	}
}
