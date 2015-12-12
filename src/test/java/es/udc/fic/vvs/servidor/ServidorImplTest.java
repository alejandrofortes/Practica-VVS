package es.udc.fic.vvs.servidor;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.javatuples.Pair;
import org.junit.Test;

import es.udc.fic.vvs.contenido.Cancion;
import es.udc.fic.vvs.contenido.Contenido;
import es.udc.fic.vvs.util.exceptions.InstanceNotFoundException;

public class ServidorImplTest {

	/**
	 * Run the String obtenerNombre() method test
	 */
	@Test
	public void testObtenerNombre() {
		Servidor servidor = new ServidorImpl("servidor", null, null);
		assertEquals(servidor.obtenerNombre(), "servidor");
	}

	/**
	 * Run the Alta, Agregar, Buscar method test
	 */
	@Test
	public void testAltaAgregarBuscar() {
		Servidor servidor = new ServidorImpl("servidor", null, null);
		Contenido cancion = new Cancion("Cancion", 180);
		servidor.agregar(cancion, "tokenmas");
		String token = servidor.alta();
		List<Contenido> canciones = servidor.buscar("Can", token);
		assertEquals(canciones.get(0), cancion);
	}

	/**
	 * Run the Baja method test
	 * 
	 * @throws InstanceNotFoundException
	 */
	@Test(expected = InstanceNotFoundException.class)
	public void testBajaNotFound() throws InstanceNotFoundException {
		Servidor servidor = new ServidorImpl("servidor", new ArrayList<Contenido>(),
				new ArrayList<Pair<String, Integer>>());
		String token = servidor.alta();
		servidor.baja(token);
		servidor.baja(token);
	}

	/**
	 * Run the Eliminar method test
	 */
	@Test
	public void testEliminar() {

		Servidor servidor = new ServidorImpl("servidor", null, null);
		String token = servidor.alta();
		Contenido cancion = new Cancion("Cancion", 180);
		servidor.agregar(cancion, "tokenmas");

		List<Contenido> canciones = canciones = servidor.buscar("Can", token);

		assertEquals(canciones.get(0), cancion);
		servidor.eliminar(cancion, "tokenmas");

		canciones = servidor.buscar("Can", token);

		assertEquals(canciones.size(), 0);
	}

	/**
	 * Run the Buscar token vacio method test
	 */
	@Test
	public void testBuscarTokenVacio() {
		Servidor servidor = new ServidorImpl("servidor", null, null);
		Contenido cancion = new Cancion("Cancion", 180);
		Contenido cancion2 = new Cancion("Cancion2", 180);
		Contenido cancion3 = new Cancion("Cancion3", 180);
		Contenido cancion4 = new Cancion("Cancion4", 180);

		servidor.agregar(cancion, "tokenmas");
		servidor.agregar(cancion2, "tokenmas");
		servidor.agregar(cancion3, "tokenmas");
		servidor.agregar(cancion4, "tokenmas");

		List<Contenido> canciones = canciones = servidor.buscar("Can", "");

		assertEquals(canciones.get(0).obtenerTitulo(), "PUBLICIDAD");
		assertEquals(canciones.get(1).obtenerTitulo(), "Cancion");
		assertEquals(canciones.get(2).obtenerTitulo(), "Cancion2");
		assertEquals(canciones.get(3).obtenerTitulo(), "Cancion3");
		assertEquals(canciones.get(4).obtenerTitulo(), "PUBLICIDAD");
		assertEquals(canciones.get(5).obtenerTitulo(), "Cancion4");

		assertEquals(canciones.size(), 6);
	}

}
