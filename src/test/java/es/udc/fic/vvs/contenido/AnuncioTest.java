package es.udc.fic.vvs.contenido;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class AnuncioTest {

	/**
	 * Run the String obtenerTitulo() method test
	 */
	@Test
	public void testObtenerTitulo() {
		Anuncio anuncio = new Anuncio();
		assertEquals(anuncio.obtenerTitulo(), "PUBLICIDAD");
	}

	/**
	 * Run the double obtenerDuracion() method test
	 */
	@Test
	public void testObtenerDuracion() {
		Anuncio anuncio = new Anuncio();
		assertTrue(anuncio.obtenerDuracion() == 5.0);
	}

	/**
	 * Run the List<Contenido> obtenerListaReproduccion() method test
	 */
	@Test
	public void testObtenerListaReproduccion() {
		Anuncio anuncio = new Anuncio();
		List<Contenido> listaReproduccion = new ArrayList<Contenido>();
		listaReproduccion.add(anuncio);
		assertEquals(anuncio.obtenerListaReproduccion(), listaReproduccion);
	}

	/**
	 * Run the List<Contenido> buscar(String) method test
	 */
	@Test
	public void testBuscar() {
		Anuncio anuncio = new Anuncio();
		List<Contenido> listaReproduccion = new ArrayList<Contenido>();
		listaReproduccion.add(anuncio);
		assertEquals(anuncio.buscar("PUBLICIDAD"), listaReproduccion);
		assertEquals(anuncio.buscar("PUBLI"), listaReproduccion);
		assertTrue(anuncio.buscar("FALLO").size() == 0);
	}

}
