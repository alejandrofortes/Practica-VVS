package es.udc.fic.vvs.contenido;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class Anuncio implements Contenido {

	private String titulo;
	private double duracion;
	private final List<Contenido> listaReproduccion;

	/**
	 * Titulo por defecto del anuncio
	 */
	private static final String TITULO_POR_DEFECTO = "PUBLICIDAD";

	/**
	 * Duracion por defecto del anuncio
	 */
	private static final double DURACION_POR_DEFECTO = 5;

	/**
	 * Constructor
	 */
	public Anuncio() {
		super();
		this.titulo = TITULO_POR_DEFECTO;
		this.duracion = DURACION_POR_DEFECTO;
		this.listaReproduccion = new ArrayList<Contenido>();
		listaReproduccion.add(this);
	}

	/**
	 * Obtener titulo del anuncio.
	 * 
	 * @return String
	 * @see es.udc.fic.vvs.contenido.Contenido#obtenerTitulo()
	 */
	public String obtenerTitulo() {
		return this.titulo;
	}

	/**
	 * Obtener duracion del anuncio.
	 * 
	 * @return double
	 * @see es.udc.fic.vvs.contenido.Contenido#obtenerDuracion()
	 */
	public double obtenerDuracion() {
		return this.duracion;
	}

	/**
	 * Obtener lista de reproduccion del anuncio.
	 * 
	 * @return List<Contenido>
	 * @see es.udc.fic.vvs.contenido.Contenido#obtenerListaReproduccion()
	 */
	public List<Contenido> obtenerListaReproduccion() {
		return this.listaReproduccion;
	}

	/**
	 * Buscar anuncio que contenga la subcadena especificada en su titulo.
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
	 * Agregar un anuncio.
	 * 
	 * @param contenido
	 *            Contenido
	 * @param predecesor
	 *            Contenido
	 * @see es.udc.fic.vvs.contenido.Contenido#agregar(Contenido, Contenido)
	 */
	public void agregar(Contenido contenido, Contenido predecesor) {

	}

	/**
	 * Eliminar un anuncio.
	 * 
	 * @param contenido
	 *            Contenido
	 * @see es.udc.fic.vvs.contenido.Contenido#eliminar(Contenido)
	 */
	public void eliminar(Contenido contenido) {

	}

}
