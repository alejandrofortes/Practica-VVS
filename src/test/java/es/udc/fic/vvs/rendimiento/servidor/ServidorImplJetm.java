package es.udc.fic.vvs.rendimiento.servidor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.javatuples.Pair;

import es.udc.fic.vvs.contenido.Cancion;
import es.udc.fic.vvs.contenido.Contenido;
import es.udc.fic.vvs.servidor.Servidor;
import es.udc.fic.vvs.servidor.ServidorImpl;
import es.udc.fic.vvs.util.exceptions.InstanceNotFoundException;
import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.monitor.EtmPoint;

public class ServidorImplJetm {

	private static final EtmMonitor etmMonitor = EtmManager.getEtmMonitor();

	private static final int NUMBER_ELEMENTS = 1000;

	public void obtenerNombreTest() {
		List<Servidor> servidores = crearServidores(NUMBER_ELEMENTS);

		EtmPoint point = etmMonitor.createPoint("Servidor:obtenerNombre");

		Iterator<Servidor> iterator = servidores.iterator();
		while (iterator.hasNext()) {
			iterator.next().obtenerNombre();
		}

		point.collect();
	}

	public void altaTest() {
		List<String> servidores = new ArrayList<String>();

		EtmPoint point = etmMonitor.createPoint("Servidor:alta");

		for (int i = 0; i < NUMBER_ELEMENTS; i++) {
			Servidor servidor = new ServidorImpl("servidor", new ArrayList<Contenido>(),
					new ArrayList<Pair<String, Integer>>());
			servidores.add(servidor.alta());
		}

		point.collect();
	}

	public void bajaTest() {
		List<String> servidores = new ArrayList<String>();

		Servidor servidor = new ServidorImpl("servidor", new ArrayList<Contenido>(),
				new ArrayList<Pair<String, Integer>>());
		for (int i = 0; i < NUMBER_ELEMENTS; i++) {
			servidores.add(servidor.alta());
		}

		EtmPoint point = etmMonitor.createPoint("Servidor:baja");

		Iterator<String> iterator = servidores.iterator();
		while (iterator.hasNext()) {
			try {
				servidor.baja(iterator.next());
			} catch (InstanceNotFoundException e) {

			}
		}

		point.collect();
	}

	public void agregarTest() {
		Servidor servidor = new ServidorImpl("servidor", new ArrayList<Contenido>(),
				new ArrayList<Pair<String, Integer>>());

		EtmPoint point = etmMonitor.createPoint("Servidor:agregar");

		for (int i = 0; i < NUMBER_ELEMENTS; i++) {
			servidor.agregar(new Cancion("cancion", 5), "token");
		}

		point.collect();
	}

	public void eliminarTest() {
		Servidor servidor = new ServidorImpl("servidor", new ArrayList<Contenido>(),
				new ArrayList<Pair<String, Integer>>());

		List<Cancion> canciones = new ArrayList<Cancion>();
		for (int i = 0; i < NUMBER_ELEMENTS; i++) {
			canciones.add(new Cancion("cancion", 5));
		}

		Iterator<Cancion> iterator = canciones.iterator();
		while (iterator.hasNext()) {
			servidor.agregar(iterator.next(), "token");
		}

		EtmPoint point = etmMonitor.createPoint("Servidor:eliminar");

		for (int i = 0; i < NUMBER_ELEMENTS; i++) {
			servidor.eliminar(canciones.get(i), "token");
		}

		point.collect();
	}

	public void buscarTest() {
		Servidor servidor = new ServidorImpl("servidor", null, null);
		Contenido cancion = new Cancion("Cancion", 180);
		servidor.agregar(cancion, "tokenmas");

		EtmPoint point = etmMonitor.createPoint("Servidor:buscar");

		for (int i = 0; i < NUMBER_ELEMENTS; i++) {
			servidor.buscar("Cancion", "");
		}

		point.collect();
	}

	private List<Servidor> crearServidores(int elements) {
		List<Servidor> servidores = new ArrayList<Servidor>();
		for (int i = 0; i < elements; i++) {
			servidores.add(
					new ServidorImpl("servidor", new ArrayList<Contenido>(), new ArrayList<Pair<String, Integer>>()));
		}
		return servidores;
	}
}
