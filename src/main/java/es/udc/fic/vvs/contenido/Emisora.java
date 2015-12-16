package es.udc.fic.vvs.contenido;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class Emisora implements Contenido {

	private String titulo;
	private double duracion;
	private List<Contenido> listaReproduccion;

	/**
	 * Constructor for Emisora.
	 * 
	 * @param titulo
	 *            String
	 * @param duracion
	 *            double
	 * @param listaReproduccion
	 *            List<Contenido>
	 */
	public Emisora(String titulo, double duracion) {
		super();
		this.titulo = titulo;
		this.duracion = duracion;
		this.listaReproduccion = new ArrayList<Contenido>();
		listaReproduccion.add(this);
	}

	/**
	 * Obtener título de una emisora.
	 * 
	 * @return String
	 * @see es.udc.fic.vvs.contenido.Contenido#obtenerTitulo()
	 */
	public String obtenerTitulo() {
		return this.titulo;
	}

	/**
	 * Obtener duracion de una emisora.
	 * 
	 * @return double
	 * @see es.udc.fic.vvs.contenido.Contenido#obtenerDuracion()
	 */
	public double obtenerDuracion() {
		return this.duracion;
	}

	/**
	 * Obtener lista de reproduccion de una emisora.
	 * 
	 * @return List<Contenido>
	 * @see es.udc.fic.vvs.contenido.Contenido#obtenerListaReproduccion()
	 */
	public List<Contenido> obtenerListaReproduccion() {
		return this.listaReproduccion;
	}

	/**
	 * Buscar emisora que contenga la subcadena especificada en su titulo.
	 * 
	 * @param subcadena
	 *            String
	 * @return List<Contenido>
	 * @see es.udc.fic.vvs.contenido.Contenido#buscar(String)
	 */
	public List<Contenido> buscar(String subcadena) {
		List<Contenido> resultados = new ArrayList<Contenido>();
		for (Contenido contenido : this.listaReproduccion) {
			if (contenido.obtenerTitulo().toLowerCase().contains(subcadena.toLowerCase())) {
				resultados.add(contenido);
			}
		}
		return resultados;
	}

	/**
	 * Agregar una emisora.
	 * 
	 * @param contenido
	 *            Contenido
	 * @param predecesor
	 *            Contenido
	 * @see es.udc.fic.vvs.contenido.Contenido#agregar(Contenido, Contenido)
	 */
	public void agregar(Contenido contenido, Contenido predecesor) {
		if(predecesor==null){
			this.listaReproduccion.add(contenido);
		}
		else{
			this.listaReproduccion.add(listaReproduccion.indexOf(predecesor) + 1, contenido);
		}
		this.duracion = this.duracion + contenido.obtenerDuracion();

	}

	/**
	 * Eliminar una emisora.
	 * 
	 * @param contenido
	 *            Contenido
	 * @see es.udc.fic.vvs.contenido.Contenido#eliminar(Contenido)
	 */
	public void eliminar(Contenido contenido) {
		this.listaReproduccion.remove(contenido);
		this.duracion = this.duracion - contenido.obtenerDuracion();
	}

}
