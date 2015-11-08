package es.udc.fic.vvs.contenido;

import java.util.ArrayList;
import java.util.List;

public class Emisora implements Contenido {

	private String titulo;
	private double duracion;
	private List<Contenido> listaReproduccion;

	public Emisora(String titulo, double duracion, List<Contenido> listaReproduccion) {
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
		return this.listaReproduccion;
	}

	public List<Contenido> buscar(String subcadena) {
		int i = 0;
		List<Contenido> resultado = new ArrayList<Contenido>();
		for(Contenido con: this.listaReproduccion){
			if(con.obtenerTitulo().equals(subcadena)){
				resultado.add(con);
			}
			i++;
		}	
		return resultado;
	}

	public void agregar(Contenido contenido, Contenido predecesor) {
		//Buscar en la lista el predecesor elemento a elemento
		//al encontrarlo, insertarlo en la posicion siguiente
		int i = 0;
		for(Contenido con: this.listaReproduccion){
			if(con.obtenerTitulo().equals(predecesor.obtenerTitulo())){
				this.listaReproduccion.add(i+1, contenido);
			}
			i++;
		}		

	}

	public void eliminar(Contenido contenido) {
		int i = 0;
		for(Contenido con: this.listaReproduccion){
			if(con.obtenerTitulo().equals(contenido.obtenerTitulo())){
				this.listaReproduccion.remove(i);
			}
			i++;
		}	
	}

}
