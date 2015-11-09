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
	public Emisora(String titulo, double duracion, List<Contenido> listaReproduccion) {
		super();
		this.titulo = titulo;
		this.duracion = duracion;
		this.listaReproduccion = listaReproduccion;
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
		int i = 0;
		List<Contenido> resultado = new ArrayList<Contenido>();
		for (Contenido contenido : this.listaReproduccion) {
			if (contenido.obtenerTitulo().equals(subcadena)) {
				resultado.add(contenido);
			}
			i++;
		}
		return resultado;
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
		/*
		 * Buscar en la lista el predecesor Insertarlo en la posicion siguiente
		 */
		int i = 0;
		for (Contenido con : this.listaReproduccion) {
			if (con.obtenerTitulo().equals(predecesor.obtenerTitulo())) {
				this.listaReproduccion.add(i + 1, contenido);
			}
			i++;
		}

	}

	/**
	 * Eliminar una emisora.
	 * 
	 * @param contenido
	 *            Contenido
	 * @see es.udc.fic.vvs.contenido.Contenido#eliminar(Contenido)
	 */
	public void eliminar(Contenido contenido) {
		for (Contenido con : this.listaReproduccion) {
			if (con.obtenerTitulo().equals(contenido.obtenerTitulo())) {
				this.listaReproduccion.remove(con);
			}
		}
	}

}
