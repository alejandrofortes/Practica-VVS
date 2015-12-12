package es.udc.fic.vvs.contenido.mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.udc.fic.vvs.contenido.Anuncio;
import es.udc.fic.vvs.contenido.Contenido;

public class MockAnuncioTest {

	private Anuncio anuncio;
	private List<Contenido> listaReproduccion = new ArrayList<Contenido>();

	@Before
	public void setUp() {
		anuncio = mock(Anuncio.class);
		listaReproduccion.add(anuncio);
		when(anuncio.obtenerTitulo()).thenReturn("PUBLICIDAD");
		when(anuncio.obtenerDuracion()).thenReturn(5.0);
		when(anuncio.obtenerListaReproduccion()).thenReturn(listaReproduccion);
		when(anuncio.buscar("PUBLICIDAD")).thenReturn(listaReproduccion);
		when(anuncio.buscar("PUBLI")).thenReturn(listaReproduccion);
		when(anuncio.buscar("FALLO")).thenReturn(new ArrayList<Contenido>());
	}

	@Test
	public void testObtenerTitulo() {
		assertEquals(anuncio.obtenerTitulo(), "PUBLICIDAD");
	}

	@Test
	public void testObtenerDuracion() {
		assertTrue(anuncio.obtenerDuracion() == 5.0);
	}

	@Test
	public void testObtenerListaReproduccion() {
		assertEquals(anuncio.obtenerListaReproduccion(), listaReproduccion);
	}

	@Test
	public void testBuscar() {
		assertEquals(anuncio.buscar("PUBLICIDAD"), listaReproduccion);
		assertEquals(anuncio.buscar("PUBLI"), listaReproduccion);
		assertTrue(anuncio.buscar("FALLO").size() == 0);
	}

}
