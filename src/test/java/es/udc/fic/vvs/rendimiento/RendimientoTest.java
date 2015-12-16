package es.udc.fic.vvs.rendimiento;

import es.udc.fic.vvs.rendimiento.contenido.AnuncioJetm;
import es.udc.fic.vvs.rendimiento.contenido.CancionJetm;
import es.udc.fic.vvs.rendimiento.contenido.EmisoraJetm;
import es.udc.fic.vvs.rendimiento.servidor.ServidorConRespaldoImplJetm;
import es.udc.fic.vvs.rendimiento.servidor.ServidorImplJetm;
import es.udc.fic.vvs.servidor.ServidorConRespaldoImpl;
import etm.core.configuration.BasicEtmConfigurator;
import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.renderer.SimpleTextRenderer;

public class RendimientoTest {

	private static EtmMonitor monitor;

	private static void setup() {
		BasicEtmConfigurator.configure();
		monitor = EtmManager.getEtmMonitor();
		monitor.start();
	}

	private static void tearDown() {
		monitor.stop();
	}

	public static void main(String[] args) {
		setup();

		AnuncioJetm anuncio = new AnuncioJetm();
		anuncio.obtenerTituloTest();
		anuncio.obtenerDuracionTest();
		anuncio.obtenerListaReproduccionTest();
		anuncio.buscarTest();

		CancionJetm cancion = new CancionJetm();
		cancion.obtenerTituloTest();
		cancion.obtenerDuracionTest();
		cancion.obtenerListaReproduccionTest();
		cancion.buscarTest();

		EmisoraJetm emisora = new EmisoraJetm();
		emisora.obtenerTituloTest();
		emisora.obtenerDuracionTest();
		emisora.obtenerListaReproduccionTest();
		emisora.obtenerBuscarTest();
		emisora.agregarTest();
		emisora.eliminarTest();
		
		ServidorImplJetm servidorImpl = new ServidorImplJetm();
		servidorImpl.obtenerNombreTest();
		servidorImpl.altaTest();
		servidorImpl.bajaTest();
		servidorImpl.agregarTest();
		servidorImpl.eliminarTest();
		servidorImpl.buscarTest();

		ServidorConRespaldoImplJetm conRespaldoImpl = new ServidorConRespaldoImplJetm();
		conRespaldoImpl.buscarTest();
		
		// visualizar resultados
		monitor.render(new SimpleTextRenderer());

		tearDown();
	}
}
