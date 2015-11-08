package es.udc.fic.vvs.servidor;

import java.util.List;

import org.javatuples.Pair;

import es.udc.fic.vvs.contenido.Contenido;

public class ServidorImpl implements Servidor {

	private String nombre;
	private List<Contenido> contenidos;
	private Pair<String, Integer> tokens;
	private static final String TOKEN_MAESTRO = "tokenmas";


	// ------------------------ Código para generar tokens aleatorios ----------------------------
	char[] elementos={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i',
			'j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z'};

	char[] conjunto = new char[8];
	String pass;

	private String creaPass(){
		for(int i=0;i<8;i++){
			int el = (int)(Math.random()*37);
			conjunto[i] = elementos[el];
		}
		return pass = new String(conjunto);
	}
	// -------------------------------------------------------------------------------------------


	public ServidorImpl(String nombre, List<Contenido> contenidos, Pair<String, Integer> tokens) {
		super();
		this.nombre = nombre;
		this.contenidos = contenidos;
		this.tokens = tokens;
	}

	public String obtenerNombre() {
		return this.nombre;
	}

	public String alta() {
		String token = creaPass();
		tokens.add(token,10);
		return token;
	}

	public void baja(String token) {
		//TODO buscar modo de eliminar un Pair
	}

	public void agregar(Contenido contenido, String token) {
		if (token.equals(TOKEN_MAESTRO)){
			this.contenidos.add(contenido);
		}
		else{
			System.out.print("El token introducido no es un token 'maestro'");
		}
	}

	public void eliminar(Contenido contenido, String token) {
		if (token.equals(TOKEN_MAESTRO)){
			this.contenidos.remove(contenido);
		}
		else{
			System.out.print("El token introducido no es un token 'maestro'");
		}
	}

	public List<Contenido> buscar(String subcadena, String token) {
		// TODO Auto-generated method stub
		// Aqui es donde iriamos decrementando el token.
		return null;
	}

}
