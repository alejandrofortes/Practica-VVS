package es.udc.fic.vvs.contenido.mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.udc.fic.vvs.contenido.Cancion;
import es.udc.fic.vvs.contenido.Contenido;

public class MockCancionTest {

	private Cancion cancion;
	private List<Contenido> listaReproduccion = new ArrayList<Contenido>();

	@Before
	public void setUp() {
		cancion = mock(Cancion.class);
		listaReproduccion.add(cancion);
		when(cancion.obtenerTitulo()).thenReturn("Cancion");
		when(cancion.obtenerDuracion()).thenReturn(5.5);
		when(cancion.obtenerListaReproduccion()).thenReturn(listaReproduccion);
		when(cancion.buscar("Cancion")).thenReturn(listaReproduccion);
		when(cancion.buscar("Canc")).thenReturn(listaReproduccion);
		when(cancion.buscar("FALLO")).thenReturn(new ArrayList<Contenido>());
	}

	@Test
	public void testObtenerTitulo() {
		assertEquals(cancion.obtenerTitulo(), "Cancion");
	}

	@Test
	public void testObtenerDuracion() {
		assertTrue(cancion.obtenerDuracion() == 5.5);
	}

	@Test
	public void testObtenerListaReproduccion() {
		assertEquals(cancion.obtenerListaReproduccion(), listaReproduccion);
	}

	@Test
	public void testBuscar() {
		assertEquals(cancion.buscar("Cancion"), listaReproduccion);
		assertEquals(cancion.buscar("Canc"), listaReproduccion);
		assertTrue(cancion.buscar("FALLO").size() == 0);
	}

}
