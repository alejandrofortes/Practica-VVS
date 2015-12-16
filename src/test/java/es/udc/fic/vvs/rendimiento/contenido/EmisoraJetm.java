package es.udc.fic.vvs.rendimiento.contenido;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import es.udc.fic.vvs.contenido.Cancion;
import es.udc.fic.vvs.contenido.Contenido;
import es.udc.fic.vvs.contenido.Emisora;
import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.monitor.EtmPoint;

public class EmisoraJetm {

	private static final EtmMonitor etmMonitor = EtmManager.getEtmMonitor();

	private static final int NUMBER_ELEMENTS = 1000;

	public void obtenerTituloTest() {
		List<Contenido> emisoras = crearEmisoras(NUMBER_ELEMENTS);

		EtmPoint point = etmMonitor.createPoint("Emisora:obtenerTitulo");

		Iterator<Contenido> iterator = emisoras.iterator();
		while (iterator.hasNext()) {
			iterator.next().obtenerTitulo();
		}

		point.collect();
	}

	public void obtenerDuracionTest() {
		List<Contenido> emisoras = crearEmisoras(NUMBER_ELEMENTS);

		EtmPoint point = etmMonitor.createPoint("Emisora:obtenerDuracion");

		Iterator<Contenido> iterator = emisoras.iterator();
		while (iterator.hasNext()) {
			iterator.next().obtenerDuracion();
		}

		point.collect();
	}

	public void obtenerListaReproduccionTest() {
		List<Contenido> emisoras = crearEmisoras(NUMBER_ELEMENTS);

		EtmPoint point = etmMonitor.createPoint("Emisora:obtenerListaReproduccion");

		Iterator<Contenido> iterator = emisoras.iterator();
		while (iterator.hasNext()) {
			iterator.next().obtenerListaReproduccion();
		}

		point.collect();
	}

	public void obtenerBuscarTest() {
		List<Contenido> emisoras = crearEmisoras(NUMBER_ELEMENTS);

		EtmPoint point = etmMonitor.createPoint("Emisora:buscar");

		Iterator<Contenido> iterator = emisoras.iterator();
		while (iterator.hasNext()) {
			iterator.next().buscar("emisora");
		}

		point.collect();
	}

	public void agregarTest() {
		List<Contenido> emisoras = crearEmisoras(NUMBER_ELEMENTS);

		EtmPoint point = etmMonitor.createPoint("Emisora:agregar");

		Iterator<Contenido> iterator = emisoras.iterator();
		while (iterator.hasNext()) {
			Emisora emisora = (Emisora) iterator.next();
			emisora.agregar(new Cancion("cancion", 120), emisora);
		}

		point.collect();
	}

	public void eliminarTest() {
		List<Contenido> emisoras = crearEmisoras(NUMBER_ELEMENTS);

		EtmPoint point = etmMonitor.createPoint("Emisora:eliminar");

		Iterator<Contenido> iterator = emisoras.iterator();
		while (iterator.hasNext()) {
			Emisora emisora = (Emisora) iterator.next();
			emisora.eliminar(emisora);
		}

		point.collect();
	}

	
	private List<Contenido> crearEmisoras(int elements) {
		List<Contenido> emisoras = new ArrayList<Contenido>();
		for (int i = 0; i < elements; i++) {
			emisoras.add(new Emisora("emisora", 120));
		}
		return emisoras;
	}
}
