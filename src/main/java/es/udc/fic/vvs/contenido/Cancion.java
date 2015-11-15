package es.udc.fic.vvs.contenido;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class Cancion implements Contenido {

	private String titulo;
	private double duracion;
	private List<Contenido> listaReproduccion;

	/**
	 * Constructor for Cancion.
	 * 
	 * @param titulo
	 *            String
	 * @param duracion
	 *            double
	 * @param listaReproduccion
	 *            List<Contenido>
	 */
	public Cancion(String titulo, double duracion) {
		super();
		this.titulo = titulo;
		this.duracion = duracion;
		this.listaReproduccion = new ArrayList<Contenido>();
		listaReproduccion.add(this);
	}

	/**
	 * Obtener título de una cancion.
	 * 
	 * @return String
	 * @see es.udc.fic.vvs.contenido.Contenido#obtenerTitulo()
	 */
	public String obtenerTitulo() {
		return this.titulo;
	}

	/**
	 * Obtener duracion de una cancion.
	 * 
	 * @return double
	 * @see es.udc.fic.vvs.contenido.Contenido#obtenerDuracion()
	 */
	public double obtenerDuracion() {
		return this.duracion;
	}

	/**
	 * Obtener lista de reproduccion de una cancion.
	 * 
	 * @return List<Contenido>
	 * @see es.udc.fic.vvs.contenido.Contenido#obtenerListaReproduccion()
	 */
	public List<Contenido> obtenerListaReproduccion() {
		return this.listaReproduccion;
	}

	/**
	 * Buscar cancion que contenga la subcadena especificada en su titulo.
	 * 
	 * @param subcadena
	 *            String
	 * @return List<Contenido>
	 * @see es.udc.fic.vvs.contenido.Contenido#buscar(String)
	 */
	public List<Contenido> buscar(String subcadena) {
		List<Contenido> resultado = new ArrayList<Contenido>();

		if (this.titulo.toLowerCase().contains(subcadena.toLowerCase())) {
			resultado.add(this);
		}
		return resultado;
	}

	/**
	 * Agregar una cancion.
	 * 
	 * @param contenido
	 *            Contenido
	 * @param predecesor
	 *            Contenido
	 * @see es.udc.fic.vvs.contenido.Contenido#agregar(Contenido, Contenido)
	 */
	public void agregar(Contenido contenido, Contenido predecesor) {
		System.err.println("'Agregar' no tiene efecto en canciones");
	}

	/**
	 * Eliminar una cancion.
	 * 
	 * @param contenido
	 *            Contenido
	 * @see es.udc.fic.vvs.contenido.Contenido#eliminar(Contenido)
	 */
	public void eliminar(Contenido contenido) {
		System.err.println("'Eliminar' no tiene efecto en canciones");
	}

}
