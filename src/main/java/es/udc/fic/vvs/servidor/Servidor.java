package es.udc.fic.vvs.servidor;

import java.util.List;

import es.udc.fic.vvs.contenido.Contenido;

public interface Servidor {

	public String obtenerNombre();
	
	public String alta();
	
	public String baja(String token);
	
	public void agregar(Contenido contenido, String token);
	
	public void eliminar(Contenido contenido, String token);
	
	public List<Contenido> buscar(String subcadena, String token);
	
}
