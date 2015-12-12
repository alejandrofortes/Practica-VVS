package es.udc.fic.vvs.servidor;

import java.util.ArrayList;
import java.util.List;

import org.javatuples.Pair;

import es.udc.fic.vvs.contenido.Contenido;
import es.udc.fic.vvs.util.exceptions.InstanceNotFoundException;

/**
 */
public class ServidorConRespaldoImpl extends ServidorImpl {

	private Servidor respaldo;

	/**
	 * Constructor for ServidorConRespaldoImpl.
	 * 
	 * @param nombre
	 *            String
	 * @param contenidos
	 *            List<Contenido>
	 * @param tokens
	 *            List<Pair<String,Integer>>
	 * @param respaldo
	 *            Servidor
	 */
	public ServidorConRespaldoImpl(String nombre, List<Contenido> contenidos, List<Pair<String, Integer>> tokens,
			Servidor respaldo) {
		super(nombre, contenidos, tokens);
		this.respaldo = respaldo;
	}

	/**
	 * Buscar contenido en el servidor que contenga la subcadena especificada
	 * como titulo
	 * 
	 * @param subcadena
	 *            String
	 * @param token
	 *            String
	 * @return List<Contenido>
	 * @throws InstanceNotFoundException
	 * @see es.udc.fic.vvs.servidor.Servidor#buscar(String, String)
	 */
	@Override
	public List<Contenido> buscar(String subcadena, String token) {
		List<Contenido> resultados = super.buscar(subcadena, token);
		if (resultados.size() == 0) {
			return respaldo.buscar(subcadena, token);
		} else {
			return resultados;
		}			
	}

}
