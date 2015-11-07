package es.udc.fic.vvs.servidor;

import java.util.List;

import org.javatuples.Pair;

import es.udc.fic.vvs.contenido.Contenido;

public class ServidorConRespaldoImpl extends ServidorImpl{

	private Servidor respaldo;
	
	public ServidorConRespaldoImpl(String nombre, List<Contenido> contenidos, Pair<String, Integer> tokens) {
		super(nombre, contenidos, tokens);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<Contenido> buscar(String subcadena, String token) {
		// TODO Auto-generated method stub
		return null;
	}

}
