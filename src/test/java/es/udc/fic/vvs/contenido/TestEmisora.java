package es.udc.fic.vvs.contenido;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

/**
 * The class <code>TestEmisora</code> contains tests for the class {@link
 * <code>Emisora</code>}
 *
 * @pattern JUnit Test Case
 *
 * @generatedBy CodePro at 15/11/15 0:27
 *
 * @author alejandro
 *
 * @version $Revision$
 */
public class TestEmisora extends TestCase {

	/**
	 * Construct new test instance
	 *
	 * @param name the test name
	 */
	public TestEmisora(String name) {
		super(name);
	}

	/**
	 * Run the String obtenerTitulo() method test
	 */
	public void testObtenerTitulo() {
		Emisora emisora = new Emisora("Emisora", 120.0);
		assertEquals(emisora.obtenerTitulo(), "Emisora");
	}
	
	/**
	 * Run the double obtenerDuracion() method test
	 */
	public void testObtenerDuracion() {
		Emisora emisora = new Emisora("Emisora", 120.0);
		assertEquals(emisora.obtenerDuracion(), 120.0);
	}

	/**
	 * Run the List<Contenido> obtenerListaReproduccion() method test
	 */
	public void testObtenerListaReproduccion() {
		Emisora emisora = new Emisora("Emisora", 120.0);
		List<Contenido> listaReproduccion = new ArrayList<Contenido>();
		listaReproduccion.add(emisora);
		assertEquals(emisora.obtenerListaReproduccion(), listaReproduccion);
	}
	
	/**
	 * Run the List<Contenido> buscar(String) method test
	 */
	public void testBuscar() {
		Emisora emisora = new Emisora("Emisora 1", 120.0);
		List<Contenido> listaReproduccion = new ArrayList<Contenido>();
		listaReproduccion.add(emisora);
		assertEquals(emisora.buscar("Emisora 1"), listaReproduccion);
		assertEquals(emisora.buscar("Emisora"), listaReproduccion);
		assertTrue(emisora.buscar("FALLO").size() == 0);
	}

	/**
	 * Run the void agregar(Contenido, Contenido) method test
	 */
	public void testAgregar() {
		Emisora emisora = new Emisora("Emisora", 120.0);
		Cancion cancion = new Cancion("Cancion", 5.0);
		List<Contenido> listaReproduccion = new ArrayList<Contenido>();
		emisora.agregar(cancion, emisora);
		listaReproduccion.add(emisora);
		listaReproduccion.add(cancion);
		assertEquals(emisora.obtenerListaReproduccion(), listaReproduccion);
	}

	/**
	 * Run the void eliminar(Contenido) method test
	 */
	public void testEliminar() {
		Emisora emisora = new Emisora("Emisora", 120.0);
		Cancion cancion = new Cancion("Cancion", 5.0);
		List<Contenido> listaReproduccion = new ArrayList<Contenido>();
		emisora.agregar(cancion, emisora);
		listaReproduccion.add(emisora);
		listaReproduccion.add(cancion);
		assertEquals(emisora.obtenerDuracion(), 125.0);
		emisora.eliminar(cancion);
		assertEquals(emisora.obtenerDuracion(), 120.0);
	}

}
