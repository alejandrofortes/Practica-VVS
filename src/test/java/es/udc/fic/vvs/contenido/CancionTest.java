package es.udc.fic.vvs.contenido;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class CancionTest {

	/**
	 * Run the String obtenerTitulo() method test
	 */
	@Test
	public void testObtenerTitulo() {
		Cancion cancion = new Cancion("Cancion", 5.5);
		assertEquals(cancion.obtenerTitulo(), "Cancion");
	}
	
	/**
	 * Run the double obtenerDuracion() method test
	 */
	@Test
	public void testObtenerDuracion() {
		Cancion cancion = new Cancion("Cancion", 5.5);
		assertTrue(cancion.obtenerDuracion() == 5.5);
	}
	
	/**
	 * Run the List<Contenido> obtenerListaReproduccion() method test
	 */
	@Test
	public void testObtenerListaReproduccion() {
		Cancion cancion = new Cancion("Cancion", 5.5);
		List<Contenido> listaReproduccion = new ArrayList<Contenido>();
		listaReproduccion.add(cancion);
		assertEquals(cancion.obtenerListaReproduccion(), listaReproduccion);
	}

	/**
	 * Run the List<Contenido> buscar(String) method test
	 */
	@Test
	public void testBuscar() {
		Cancion cancion = new Cancion("Cancion", 5.5);
		List<Contenido> listaReproduccion = new ArrayList<Contenido>();
		listaReproduccion.add(cancion);
		assertEquals(cancion.buscar("Cancion"), listaReproduccion);
		assertEquals(cancion.buscar("Canc"), listaReproduccion);
		assertTrue(cancion.buscar("FALLO").size() == 0);
	}

}
