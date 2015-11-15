package es.udc.fic.vvs.contenido;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class TestAnuncio extends TestCase {

	/**
	 * Construct new test instance
	 *
	 * @param name the test name
	 */
	public TestAnuncio(String name) {
		super(name);
	}

	/**
	 * Run the String obtenerTitulo() method test
	 */
	public void testObtenerTitulo() {
		Anuncio anuncio = new Anuncio();
		assertEquals(anuncio.obtenerTitulo(), "PUBLICIDAD");
	}

	/**
	 * Run the double obtenerDuracion() method test
	 */
	public void testObtenerDuracion() {
		Anuncio anuncio = new Anuncio();
		assertEquals(anuncio.obtenerDuracion(), 5.0);
	}
	
	/**
	 * Run the List<Contenido> obtenerListaReproduccion() method test
	 */
	public void testObtenerListaReproduccion() {
		Anuncio anuncio = new Anuncio();
		List<Contenido> listaReproduccion = new ArrayList<Contenido>();
		listaReproduccion.add(anuncio);
		assertEquals(anuncio.obtenerListaReproduccion(), listaReproduccion);
	}

	/**
	 * Run the List<Contenido> buscar(String) method test
	 */
	public void testBuscar() {
		Anuncio anuncio = new Anuncio();
		List<Contenido> listaReproduccion = new ArrayList<Contenido>();
		listaReproduccion.add(anuncio);
		assertEquals(anuncio.buscar("PUBLICIDAD"), listaReproduccion);
		assertEquals(anuncio.buscar("PUBLI"), listaReproduccion);
		assertTrue(anuncio.buscar("FALLO").size() == 0);
	}

}
