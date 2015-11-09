package es.udc.fic.vvs.contenido;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class Anuncio implements Contenido {

	private String titulo;
	private double duracion;
	private List<Contenido> listaReproduccion;

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
	}

	/**
	 * Constructor for Anuncio.
	 * 
	 * @param listaReproduccion
	 *            List<Contenido>
	 */
	public Anuncio(List<Contenido> listaReproduccion) {
		super();
		this.titulo = TITULO_POR_DEFECTO;
		this.duracion = DURACION_POR_DEFECTO;
		this.listaReproduccion = listaReproduccion;
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
		List<Contenido> resultado = new ArrayList<Contenido>();
		resultado.add(this);
		return resultado;
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

		if (subcadena.equals(this.titulo)) {
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
		System.err.println("'Agregar' no tiene efecto en anuncios");

	}

	/**
	 * Eliminar un anuncio.
	 * 
	 * @param contenido
	 *            Contenido
	 * @see es.udc.fic.vvs.contenido.Contenido#eliminar(Contenido)
	 */
	public void eliminar(Contenido contenido) {
		System.err.println("'Eliminar' no tiene efecto en anuncios");

	}

}
