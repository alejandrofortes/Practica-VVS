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
import es.udc.fic.vvs.contenido.Emisora;

public class MockEmisoraTest {

	private Emisora emisora;
	private Cancion cancion;
	private List<Contenido> listaReproduccion = new ArrayList<Contenido>();

	@Before
	public void SetUp() {
		emisora = mock(Emisora.class);
		cancion = mock(Cancion.class);
		listaReproduccion.add(emisora);
		listaReproduccion.add(cancion);
		when(emisora.obtenerTitulo()).thenReturn("Emisora");
		when(emisora.obtenerDuracion()).thenReturn(120.0);
		when(emisora.obtenerListaReproduccion()).thenReturn(listaReproduccion);
		when(emisora.buscar("Emisora")).thenReturn(listaReproduccion);
		when(emisora.buscar("Emi")).thenReturn(listaReproduccion);
		when(emisora.buscar("FALLO")).thenReturn(new ArrayList<Contenido>());
	}

	@Test
	public void testObtenerTitulo() {
		assertTrue(emisora.obtenerTitulo() == "Emisora");
	}

	@Test
	public void testObtenerDuracion() {
		assertTrue(emisora.obtenerDuracion() == 120.0);
	}

	@Test
	public void testObtenerListaReproduccion() {
		assertEquals(emisora.obtenerListaReproduccion(), listaReproduccion);
	}

	@Test
	public void testBuscar() {
		assertEquals(emisora.buscar("Emisora"), listaReproduccion);
		assertEquals(emisora.buscar("Emi"), listaReproduccion);
		assertTrue(emisora.buscar("FALLO").size() == 0);
	}

	@Test
	public void testAgregar() {
		emisora.agregar(cancion, emisora);
		assertEquals(emisora.obtenerListaReproduccion(), listaReproduccion);
	}

	@Test
	public void testEliminar() {
		emisora.agregar(cancion, emisora);
		emisora.eliminar(cancion);
		assertTrue(emisora.obtenerDuracion() == 120.0);
	}

}
