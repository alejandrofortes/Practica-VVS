package es.udc.fic.vvs.servidor;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.javatuples.Pair;
import org.junit.Test;

import es.udc.fic.vvs.contenido.Cancion;
import es.udc.fic.vvs.contenido.Contenido;

public class ServidorConRespaldoImplTest {

	@Test
	public void testBuscar() {
		List<Pair<String, Integer>> tokens = new ArrayList<Pair<String, Integer>>();
		Servidor respaldo = new ServidorImpl("respaldo", new ArrayList<Contenido>(), tokens);
		Servidor servidor = new ServidorConRespaldoImpl("servidor", new ArrayList<Contenido>(), tokens, respaldo);
		Contenido cancion = new Cancion("Cancion", 180);
		respaldo.agregar(cancion, "tokenmas");
		String token = respaldo.alta();
		List<Contenido> canciones = servidor.buscar("Can", token);
		assertEquals(canciones.get(0), cancion);
	}

	@Test
	public void testBuscarEnRespaldo() {
		List<Pair<String, Integer>> tokens = new ArrayList<Pair<String, Integer>>();
		Servidor respaldo = new ServidorImpl("respaldo", new ArrayList<Contenido>(), tokens);
		Servidor servidor = new ServidorConRespaldoImpl("servidor", new ArrayList<Contenido>(), tokens, respaldo);
		Contenido cancion = new Cancion("Cancion", 180);
		servidor.agregar(cancion, "tokenmas");
		String token = respaldo.alta();
		List<Contenido> canciones = servidor.buscar("Can", token);
		assertEquals(canciones.get(0), cancion);
	}
	
	
}
