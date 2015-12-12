package es.udc.fic.vvs.servidor;

import java.util.List;

import es.udc.fic.vvs.contenido.Contenido;
import es.udc.fic.vvs.util.exceptions.InstanceNotFoundException;

/**
 */
public interface Servidor {

	/**
	 * Obtener nombre del servidor.
	 * @return String
	 */
	public String obtenerNombre();

	/**
	 * Agregar un token al servidor.
	 * @return String
	 */
	public String alta();

	/**
	 * Eliminar un token del servidor.
	 * @param token String
	 * @throws InstanceNotFoundException
	 */
	public void baja(String token) throws InstanceNotFoundException;

	/**
	 * Agregar contenido al servidor.
	 * Solo un token especial puede agregar contenidos.
	 * @param contenido Contenido
	 * @param token String
	 */
	public void agregar(Contenido contenido, String token);

	/**
	 * Eliminar contenido del servidor.
	 * Solo un token especial puede eliminar contenidos.
	 * @param contenido Contenido
	 * @param token String
	 */
	public void eliminar(Contenido contenido, String token);

	/**
	 * Buscar contenido en el servidor con la subcadena especificada
	 * 
	 * @param subcadena
	 *            String
	 * @param token
	 *            String
	 * @return List<Contenido>
	 * @throws InstanceNotFoundException
	 */
	public List<Contenido> buscar(String subcadena, String token);

}
