package es.udc.fic.vvs.contenido;

import java.util.List;

/**
 */
public interface Contenido {

	/**
	 * Obtener título de un contenido.
	 * 
	 * @return String
	 */
	public String obtenerTitulo();

	/**
	 * Obtener duracion de un contenido.
	 * 
	 * @return double
	 */
	public double obtenerDuracion();

	/**
	 * Obtener la lista de reproduccion un contenido.
	 * 
	 * @return List<Contenido>
	 */
	public List<Contenido> obtenerListaReproduccion();

	/**
	 * Buscar contenido que contenga la subcadena especificada en su titulo.
	 * 
	 * @param subcadena
	 *            String
	 * @return List<Contenido>
	 */
	public List<Contenido> buscar(String subcadena);

	/**
	 * Agregar un contenido.
	 * 
	 * @param contenido
	 *            Contenido
	 * @param predecesor
	 *            Contenido
	 */
	public void agregar(Contenido contenido, Contenido predecesor);

	/**
	 * Eliminar un contenido
	 * 
	 * @param contenido
	 *            Contenido
	 */
	public void eliminar(Contenido contenido);
}
