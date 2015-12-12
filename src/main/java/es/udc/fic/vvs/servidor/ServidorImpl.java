package es.udc.fic.vvs.servidor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.javatuples.Pair;

import es.udc.fic.vvs.contenido.Anuncio;
import es.udc.fic.vvs.contenido.Contenido;
import es.udc.fic.vvs.util.exceptions.InstanceNotFoundException;

/**
 */
public class ServidorImpl implements Servidor {

	private String nombre;
	private List<Contenido> contenidos = new ArrayList<Contenido>();
	private List<Pair<String, Integer>> tokens;

	private static final String TOKEN_MAESTRO = "tokenmas";

	private static final char[] elementos = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
			'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
			'z' };

	private static final char[] conjunto = new char[8];

	/**
	 * Constructor for ServidorImpl.
	 * 
	 * @param nombre
	 *            String
	 * @param contenidos
	 *            List<Contenido>
	 * @param tokens
	 *            List<Pair<String,Integer>>
	 */
	public ServidorImpl(String nombre, List<Contenido> contenidos, List<Pair<String, Integer>> tokens) {
		super();
		this.nombre = nombre;
		this.contenidos = contenidos;
		this.tokens = tokens;
	}

	/**
	 * Obtener nombre del servidor.
	 * 
	 * @return String
	 * @see es.udc.fic.vvs.servidor.Servidor#obtenerNombre()
	 */
	public String obtenerNombre() {
		return this.nombre;
	}

	/**
	 * Agregar un token al servidor.
	 * 
	 * @return String
	 * @see es.udc.fic.vvs.servidor.Servidor#alta()
	 */
	public String alta() {
		String token = generarToken();
		if (tokens == null) {
			tokens = new ArrayList<Pair<String, Integer>>();
		}
		tokens.add(new Pair<String, Integer>(token, 10));
		return token;
	}

	/**
	 * Eliminar un token del servidor.
	 * 
	 * @param token
	 *            String
	 * @throws InstanceNotFoundException
	 * @see es.udc.fic.vvs.servidor.Servidor#baja(String)
	 */
	public void baja(String token) throws InstanceNotFoundException {
		boolean fin = false;
		Iterator<Pair<String, Integer>> iterator = tokens.iterator();
		Pair<String, Integer> aux;
		while (iterator.hasNext() && !fin) {
			if ((aux = iterator.next()).getValue0().equals(token)) {
				fin = true;
				tokens.remove(aux);
			}
		}

		if (!fin) {
			throw new InstanceNotFoundException(tokens, "Tokens");
		}
	}

	/**
	 * Agregar contenido al servidor. Solo un token especial puede agregar
	 * contenidos.
	 * 
	 * @param contenido
	 *            Contenido
	 * @param token
	 *            String
	 * @see es.udc.fic.vvs.servidor.Servidor#agregar(Contenido, String)
	 */
	public void agregar(Contenido contenido, String token) {
		if (token.equals(TOKEN_MAESTRO)) {
			if (contenidos == null) {
				contenidos = new ArrayList<Contenido>();
			}
			this.contenidos.add(contenido);

		}
	}

	/**
	 * Eliminar contenido del servidor. Solo un token especial puede eliminar
	 * contenidos.
	 * 
	 * @param contenido
	 *            Contenido
	 * @param token
	 *            String
	 * @see es.udc.fic.vvs.servidor.Servidor#eliminar(Contenido, String)
	 */
	public void eliminar(Contenido contenido, String token) {
		if (token.equals(TOKEN_MAESTRO)) {
			this.contenidos.remove(contenido);
		}
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
	public List<Contenido> buscar(String subcadena, String token) {

		boolean fin = false;
		Iterator<Pair<String, Integer>> iterTokens;
		if (tokens == null)
			tokens = new ArrayList<Pair<String, Integer>>();
		iterTokens = tokens.iterator();
		Pair<String, Integer> auxPair = null;
		while (iterTokens.hasNext() && !fin) {
			auxPair = iterTokens.next();
			if ((auxPair.getValue0()).equals(token)) {
				fin = true;
				tokens.remove(auxPair);
			}
		}

		Pair<String, Integer> tokenGuardado = auxPair;

		List<Contenido> resultados = new ArrayList<Contenido>();

		if (token.equals("")) { // Se usa token vacio para la busqueda
			resultados.add(new Anuncio());
			Iterator<Contenido> iterator;
			iterator = contenidos.iterator();
			int i = 0;
			while (iterator.hasNext()) {
				if (i > 2) {
					resultados.add(new Anuncio());
					i = 0;
				} else {
					resultados.add(iterator.next());
					i++;
				}
			}
		} else {
			Iterator<Contenido> iterator;
			iterator = contenidos.iterator();
			Contenido aux;
			while (iterator.hasNext()) {
				aux = iterator.next();
				if (aux.obtenerTitulo().contains(subcadena)) {
					resultados.add(aux);
				}
			}
			// Actualizar el numero de contenidos que quedan por devolver si no
			// ha caducado.
			if (tokenGuardado.getValue1() > 0)
				tokens.add(new Pair<String, Integer>(token, tokenGuardado.getValue1() - 1));
		}

		return resultados;
	}

	/**
	 * Permite generar tokens aleatorios
	 * 
	 * @return String token
	 */
	private String generarToken() {
		for (int i = 0; i < 8; i++) {
			int el = (int) (Math.random() * 37);
			conjunto[i] = elementos[el];
		}
		return new String(conjunto);
	}

}
