package es.udc.fic.vvs.rendimiento.contenido;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import es.udc.fic.vvs.contenido.Anuncio;
import es.udc.fic.vvs.contenido.Contenido;
import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.monitor.EtmPoint;

public class AnuncioJetm {

	private static final EtmMonitor etmMonitor = EtmManager.getEtmMonitor();

	private static final int NUMBER_ELEMENTS = 1000;

	public void obtenerTituloTest() {
		List<Contenido> anuncios = crearAnuncios(NUMBER_ELEMENTS);

		EtmPoint point = etmMonitor.createPoint("Anuncio:obtenerTitulo");

		Iterator<Contenido> iterator = anuncios.iterator();
		while (iterator.hasNext()) {
			iterator.next().obtenerTitulo();
		}

		point.collect();
	}

	public void obtenerDuracionTest() {
		List<Contenido> anuncios = crearAnuncios(NUMBER_ELEMENTS);

		EtmPoint point = etmMonitor.createPoint("Anuncio:obtenerDuracion");

		Iterator<Contenido> iterator = anuncios.iterator();
		while (iterator.hasNext()) {
			iterator.next().obtenerDuracion();
		}

		point.collect();
	}

	public void obtenerListaReproduccionTest() {
		List<Contenido> anuncios = crearAnuncios(NUMBER_ELEMENTS);

		EtmPoint point = etmMonitor.createPoint("Anuncio:obtenerListaReproduccion");

		Iterator<Contenido> iterator = anuncios.iterator();
		while (iterator.hasNext()) {
			iterator.next().obtenerListaReproduccion();
		}

		point.collect();
	}

	public void buscarTest() {
		List<Contenido> anuncios = crearAnuncios(NUMBER_ELEMENTS);

		EtmPoint point = etmMonitor.createPoint("Anuncio:buscar");

		Iterator<Contenido> iterator = anuncios.iterator();
		while (iterator.hasNext()) {
			iterator.next().buscar("anuncio");
		}

		point.collect();
	}

	private List<Contenido> crearAnuncios(int elements) {
		List<Contenido> anuncios = new ArrayList<Contenido>();
		for (int i = 0; i < elements; i++) {
			anuncios.add(new Anuncio());
		}
		return anuncios;
	}
}
