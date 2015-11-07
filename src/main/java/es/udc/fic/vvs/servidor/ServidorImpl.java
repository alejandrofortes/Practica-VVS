package es.udc.fic.vvs.servidor;

import java.util.List;

import org.javatuples.Pair;

import es.udc.fic.vvs.contenido.Contenido;

public class ServidorImpl implements Servidor {

	private String nombre;
	private List<Contenido> contenidos;
	private Pair<String, Integer> tokens;

	public ServidorImpl(String nombre, List<Contenido> contenidos, Pair<String, Integer> tokens) {
		super();
		this.nombre = nombre;
		this.contenidos = contenidos;
		this.tokens = tokens;
	}

	public String obtenerNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	public String alta() {
		// TODO Auto-generated method stub
		return null;
	}

	public String baja(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	public void agregar(Contenido contenido, String token) {
		// TODO Auto-generated method stub

	}

	public void eliminar(Contenido contenido, String token) {
		// TODO Auto-generated method stub

	}

	public List<Contenido> buscar(String subcadena, String token) {
		// TODO Auto-generated method stub
		return null;
	}

}
