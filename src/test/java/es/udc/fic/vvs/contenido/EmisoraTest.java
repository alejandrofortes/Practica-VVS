package es.udc.fic.vvs.contenido;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class EmisoraTest {

	/**
	 * Run the String obtenerTitulo() method test
	 */
	@Test
	public void testObtenerTitulo() {
		Emisora emisora = new Emisora("Emisora", 120.0);
		assertEquals(emisora.obtenerTitulo(), "Emisora");
	}
	
	/**
	 * Run the double obtenerDuracion() method test
	 */
	@Test
	public void testObtenerDuracion() {
		Emisora emisora = new Emisora("Emisora", 120.0);
		assertTrue(emisora.obtenerDuracion() == 120.0);
	}

	/**
	 * Run the List<Contenido> obtenerListaReproduccion() method test
	 */
	@Test
	public void testObtenerListaReproduccion() {
		Emisora emisora = new Emisora("Emisora", 120.0);
		List<Contenido> listaReproduccion = new ArrayList<Contenido>();
		listaReproduccion.add(emisora);
		assertEquals(emisora.obtenerListaReproduccion(), listaReproduccion);
	}
	
	/**
	 * Run the List<Contenido> buscar(String) method test
	 */
	@Test
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
	@Test
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
	@Test
	public void testEliminar() {
		Emisora emisora = new Emisora("Emisora", 120.0);
		Cancion cancion = new Cancion("Cancion", 5.0);
		List<Contenido> listaReproduccion = new ArrayList<Contenido>();
		emisora.agregar(cancion, emisora);
		listaReproduccion.add(emisora);
		listaReproduccion.add(cancion);
		assertTrue(emisora.obtenerDuracion() == 125.0);
		emisora.eliminar(cancion);
		assertTrue(emisora.obtenerDuracion() == 120.0);
	}

}
