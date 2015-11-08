package es.udc.fic.vvs.contenido;

import java.util.ArrayList;
import java.util.List;

public class Cancion implements Contenido {

	private String titulo;
	private double duracion;
	private List<Contenido> listaReproduccion;

	public Cancion(String titulo, double duracion, List<Contenido> listaReproduccion) {
		super();
		this.titulo = titulo;
		this.duracion = duracion;
		this.listaReproduccion = listaReproduccion;
	}

	public String obtenerTitulo() {
		return this.titulo;
	}

	public double obtenerDuracion() {
		return this.duracion;
	}

	public List<Contenido> obtenerListaReproduccion() {
		List<Contenido> resultado = new ArrayList<Contenido>();
		resultado.add(this); //Devolver la propia cancion, en una lista.
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
		System.out.println("'Agregar' no tiene efecto en canciones");
	}

	public void eliminar(Contenido contenido) {
		System.out.println("'Eliminar' no tiene efecto en canciones");		
	}

}
