package es.udc.fic.vvs.servidor;

import java.util.ArrayList;
import java.util.List;

import org.javatuples.Pair;

import es.udc.fic.vvs.contenido.Contenido;
import es.udc.fic.vvs.util.exceptions.InstanceNotFoundException;

public class ServidorConRespaldoImpl extends ServidorImpl {

	private Servidor respaldo;

	public ServidorConRespaldoImpl(String nombre, List<Contenido> contenidos, List<Pair<String, Integer>> tokens,
			Servidor respaldo) {
		super(nombre, contenidos, tokens);
		this.respaldo = respaldo;
	}

	@Override
	public List<Contenido> buscar(String subcadena, String token) throws InstanceNotFoundException {
		List<Contenido> resultados = new ArrayList<Contenido>();
		resultados = super.buscar(subcadena, token);
		return (resultados.size() == 0) ? respaldo.buscar(subcadena, token) : resultados;
	}

}
