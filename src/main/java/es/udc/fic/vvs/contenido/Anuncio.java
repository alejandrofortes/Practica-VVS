package es.udc.fic.vvs.contenido;

import java.util.ArrayList;
import java.util.List;

public class Anuncio implements Contenido {

	private String titulo;
	private int duracion;
	private List<Contenido> listaReproduccion;

	public static final String TITULO_POR_DEFECTO = "PUBLICIDAD";

	public static final int DURACION_POR_DEFECTO = 5;

	public Anuncio(List<Contenido> listaReproduccion) {
		super();
		this.titulo = TITULO_POR_DEFECTO;
		this.duracion = DURACION_POR_DEFECTO;
		this.listaReproduccion = listaReproduccion;
	}

	public String obtenerTitulo() {
		return this.titulo;
	}

	public int obtenerDuracion() {
		return this.duracion;
	}

	public List<Contenido> obtenerListaReproduccion() {
		List<Contenido> resultado = new ArrayList<Contenido>();
		resultado.add(this); //Devolver el propio anuncio, en una lista.
		return resultado;
	}

	public List<Contenido> buscar(String subcadena) {
		List<Contenido> resultado = new ArrayList<Contenido>();

		if (subcadena.equals(this.titulo)){
			resultado.add(this); 
		}
		return resultado;	//Si no coincide, lista vacia?
	}

	public void agregar(Contenido contenido, Contenido predecesor) {
		System.out.println("'Agregar' no tiene efecto en anuncios");

	}

	public void eliminar(Contenido contenido) {
		System.out.println("'Eliminar' no tiene efecto en anuncios");

	}

}
