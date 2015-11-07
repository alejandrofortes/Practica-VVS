package es.udc.fic.vvs.contenido;

import java.util.List;

public class Anuncio implements Contenido {

	private String titulo;
	private float duracion;
	private List<Contenido> listaReproduccion;
	
	public static final String TITULO_POR_DEFECTO = "PUBLICIDAD";
	
	public static final float DURACION_POR_DEFECTO = (float) 5;
		
	public Anuncio(List<Contenido> listaReproduccion) {
		super();
		this.titulo = TITULO_POR_DEFECTO;
		this.duracion = DURACION_POR_DEFECTO;
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
