package es.udc.fic.vvs.rendimiento.servidor;

import es.udc.fic.vvs.contenido.Cancion;
import es.udc.fic.vvs.contenido.Contenido;
import es.udc.fic.vvs.servidor.Servidor;
import es.udc.fic.vvs.servidor.ServidorConRespaldoImpl;
import es.udc.fic.vvs.servidor.ServidorImpl;
import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.monitor.EtmPoint;

public class ServidorConRespaldoImplJetm {

	private static final EtmMonitor etmMonitor = EtmManager.getEtmMonitor();

	private static final int NUMBER_ELEMENTS = 1000;

	public void buscarTest() {
		Servidor respaldo = new ServidorImpl("respaldo", null, null);
		Servidor servidor = new ServidorConRespaldoImpl("servidor", null, null, respaldo);
		Contenido cancion = new Cancion("Cancion", 180);
		servidor.agregar(cancion, "tokenmas");

		EtmPoint point = etmMonitor.createPoint("ServidorConRespaldo:buscar");

		for (int i = 0; i < NUMBER_ELEMENTS; i++) {
			servidor.buscar("Cancion", "");
		}

		point.collect();
	}

}
