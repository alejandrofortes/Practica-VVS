package es.udc.fic.vvs.servidor.mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.udc.fic.vvs.contenido.Anuncio;
import es.udc.fic.vvs.contenido.Contenido;
import es.udc.fic.vvs.servidor.ServidorImpl;

public class MockServidorImplTest {

	private ServidorImpl servidor;
	
	@Before
	public void SetUp() {
		servidor = mock(ServidorImpl.class);
		when(servidor.obtenerNombre()).thenReturn("servidor");
		when(servidor.alta()).thenReturn("token");
	}
	
	@Test
	public void testObtenerNombre() {
		assertEquals(servidor.obtenerNombre(), "servidor");
	}

	@Test
	public void testAlta() {
		assertEquals(servidor.alta(), "token");
	}
	
	@Test
	public void testBuscar() {
		List<Contenido> contenido = new ArrayList<Contenido>();
		Anuncio anuncio = new Anuncio();
		contenido.add(anuncio);
		when(servidor.buscar("subcadena", "token")).thenReturn(contenido);
		assertEquals(servidor.buscar("subcadena", "token"), contenido);
		assertEquals(servidor.buscar("subcadena", "token").get(0), anuncio);
	}
	
}
