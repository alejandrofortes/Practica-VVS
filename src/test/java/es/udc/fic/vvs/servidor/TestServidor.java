package es.udc.fic.vvs.servidor;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import es.udc.fic.vvs.contenido.Cancion;
import es.udc.fic.vvs.contenido.Contenido;
import es.udc.fic.vvs.servidor.Servidor;
import es.udc.fic.vvs.servidor.ServidorImpl;
import es.udc.fic.vvs.util.exceptions.InstanceNotFoundException;

public class TestServidor extends TestCase {

	/**
	 * Construct new test instance
	 *
	 * @param name the test name
	 */
	public TestServidor(String name) {
		super(name);
	}

	/**
	 * Run the String obtenerNombre() method test
	 */
	public void testObtenerNombre() {
		Servidor servidor = new ServidorImpl("servidor",null,null);
		assertEquals(servidor.obtenerNombre(), "servidor");
	}

	/**
	 * Run the Alta, Agregar, Buscar method test
	 */
	public void testAltaAgregarBuscar() {
		Servidor servidor = new ServidorImpl("servidor",null,null);
		Contenido cancion = new Cancion("Cancion",180);
		servidor.agregar(cancion, "tokenmas");
		String token = servidor.alta();
		List<Contenido> canciones = new ArrayList<Contenido>();

		try {
			canciones = servidor.buscar("Can", token);
		} catch (InstanceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(canciones.get(0), cancion);
	}
	/**
	 * Run the Baja method test
	 */
	public void testBaja(){
		try {
			Servidor servidor = new ServidorImpl("servidor",null,null);
			String token = servidor.alta();
			servidor.baja(token);
			servidor.buscar("Hola", token);
		}
		catch (InstanceNotFoundException e) {
			return;
		}
		fail("Expected InstanceNotFoundException");

	}

	/**
	 * Run the Eliminar method test
	 */
	public void testEliminar(){

		Servidor servidor = new ServidorImpl("servidor",null,null);
		String token = servidor.alta();
		Contenido cancion = new Cancion("Cancion",180);
		servidor.agregar(cancion, "tokenmas");

		List<Contenido> canciones = new ArrayList<Contenido>();

		try {
			canciones = servidor.buscar("Can", token);
		} catch (InstanceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(canciones.get(0), cancion);
		servidor.eliminar(cancion, "tokenmas");

		try {
			canciones = servidor.buscar("Can", token);
		} catch (InstanceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals(canciones.size(),0);
	}

	/**
	 * Run the Buscar token vacio method test
	 */
	public void testBuscarTokenVacio() {
		Servidor servidor = new ServidorImpl("servidor",null,null);
		Contenido cancion = new Cancion("Cancion",180);
		Contenido cancion2 = new Cancion("Cancion2",180);
		Contenido cancion3 = new Cancion("Cancion3",180);
		Contenido cancion4 = new Cancion("Cancion4",180);

		servidor.agregar(cancion, "tokenmas");
		servidor.agregar(cancion2, "tokenmas");
		servidor.agregar(cancion3, "tokenmas");
		servidor.agregar(cancion4, "tokenmas");

		List<Contenido> canciones = new ArrayList<Contenido>();

		try {
			canciones = servidor.buscar("Can", "");
		} catch (InstanceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals(canciones.get(0).obtenerTitulo(),"PUBLICIDAD");
		assertEquals(canciones.get(1).obtenerTitulo(),"Cancion");
		assertEquals(canciones.get(2).obtenerTitulo(),"Cancion2");
		assertEquals(canciones.get(3).obtenerTitulo(),"Cancion3");
		assertEquals(canciones.get(4).obtenerTitulo(),"PUBLICIDAD");
		assertEquals(canciones.get(5).obtenerTitulo(),"Cancion4");

		assertEquals(canciones.size(),6);
	}

}
