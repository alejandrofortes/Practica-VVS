package es.udc.fic.vvs.contenido;

import java.util.List;

public class Emisora implements Contenido {

	private String titulo;
	private float duracion;
	private List<Contenido> listaReproduccion;
	
	public Emisora(String titulo, float duracion, List<Contenido> listaReproduccion) {
		super();
		this.titulo = titulo;
		this.duracion = duracion;
		this.listaReproduccion = listaReproduccion;
	}

	public String obtenerTitulo() {
		// TODO Auto-generated method stub
		return null;
	}

	public int obtenerDuracion() {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Contenido> obtenerListaReproduccion() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Contenido> buscar(String subcadena) {
		// TODO Auto-generated method stub
		return null;
	}

	public void agregar(Contenido contenido, Contenido predecesor) {
		// TODO Auto-generated method stub
		
	}

	public void eliminar(Contenido contenido) {
		// TODO Auto-generated method stub
		
	}

}
