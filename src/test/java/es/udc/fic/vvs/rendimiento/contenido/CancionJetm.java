package es.udc.fic.vvs.rendimiento.contenido;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import es.udc.fic.vvs.contenido.Cancion;
import es.udc.fic.vvs.contenido.Contenido;
import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.monitor.EtmPoint;

public class CancionJetm {

	private static final EtmMonitor etmMonitor = EtmManager.getEtmMonitor();

	private static final int NUMBER_ELEMENTS = 1000;

	public void obtenerTituloTest() {
		List<Contenido> canciones = crearCanciones(NUMBER_ELEMENTS);

		EtmPoint point = etmMonitor.createPoint("Cancion:obtenerTitulo");

		Iterator<Contenido> iterator = canciones.iterator();
		while (iterator.hasNext()) {
			iterator.next().obtenerTitulo();
		}

		point.collect();
	}

	public void obtenerDuracionTest() {
		List<Contenido> canciones = crearCanciones(NUMBER_ELEMENTS);

		EtmPoint point = etmMonitor.createPoint("Cancion:obtenerDuracion");

		Iterator<Contenido> iterator = canciones.iterator();
		while (iterator.hasNext()) {
			iterator.next().obtenerDuracion();
		}

		point.collect();
	}

	public void obtenerListaReproduccionTest() {
		List<Contenido> canciones = crearCanciones(NUMBER_ELEMENTS);

		EtmPoint point = etmMonitor.createPoint("Cancion:obtenerListaReproduccion");

		Iterator<Contenido> iterator = canciones.iterator();
		while (iterator.hasNext()) {
			iterator.next().obtenerListaReproduccion();
		}

		point.collect();
	}

	public void buscarTest() {
		List<Contenido> canciones = crearCanciones(NUMBER_ELEMENTS);

		EtmPoint point = etmMonitor.createPoint("Cancion:buscar");

		Iterator<Contenido> iterator = canciones.iterator();
		while (iterator.hasNext()) {
			iterator.next().buscar("cancion");
		}

		point.collect();
	}

	private List<Contenido> crearCanciones(int elements) {
		List<Contenido> canciones = new ArrayList<Contenido>();
		for (int i = 0; i < elements; i++) {
			canciones.add(new Cancion("cancion", 5));
		}
		return canciones;
	}
}
