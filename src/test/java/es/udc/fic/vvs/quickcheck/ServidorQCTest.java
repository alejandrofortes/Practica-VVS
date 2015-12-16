package es.udc.fic.vvs.quickcheck;

import static net.java.quickcheck.generator.PrimitiveGenerators.integers;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import net.java.quickcheck.Generator;
import net.java.quickcheck.generator.support.StringGenerator;

import org.javatuples.Pair;
import org.junit.Test;

import es.udc.fic.vvs.contenido.Cancion;
import es.udc.fic.vvs.contenido.Contenido;
import es.udc.fic.vvs.servidor.Servidor;
import es.udc.fic.vvs.servidor.ServidorConRespaldoImpl;
import es.udc.fic.vvs.servidor.ServidorImpl;

public class ServidorQCTest {
	StringGenerator generador = new StringGenerator();
	Generator<Integer> iGen = integers(1,50);


	public String generarString(){
		return generador.next();
	}

	public Double generarDouble(){
		return (iGen.next()* 1.0);
	}


	@Test
	public void obtenerNombreServidorQC(){
		String titulo = generarString();
		Double duracion = generarDouble();
		Contenido cancion = new Cancion(titulo,duracion);
		List<Contenido> contenidos = new ArrayList<Contenido>();
		contenidos.add(cancion);
		String nombre = generarString();
		Servidor servidor = new ServidorImpl(nombre, contenidos, null);

		assertTrue(servidor.obtenerNombre().equals(nombre));
	}

	@Test
	public void altaBuscarServidorQC(){
		String titulo = generarString();
		Double duracion = generarDouble();
		Contenido cancion = new Cancion(titulo,duracion);
		List<Contenido> contenidos = new ArrayList<Contenido>();
		contenidos.add(cancion);
		String nombre = generarString();
		Servidor servidor = new ServidorImpl(nombre, contenidos, null);
		String token = servidor.alta();
		List<Contenido> resultado = servidor.buscar(titulo, token);

		assertEquals(contenidos,resultado);
	}

	@Test
	public void altaBuscarServidorRespaldoQC(){
		List<Pair<String, Integer>> tokens = new ArrayList<Pair<String, Integer>>();
		String titulo = generarString();
		Double duracion = generarDouble();
		Contenido cancion = new Cancion(titulo,duracion);
		String nombre = generarString();
		String nombre2 = generarString();

		Servidor respaldo = new ServidorImpl(nombre, new ArrayList<Contenido>(), tokens);
		Servidor servidor = new ServidorConRespaldoImpl(nombre2,new ArrayList<Contenido>(),tokens,respaldo);

		servidor.agregar(cancion, "tokenmas");
		String token = respaldo.alta();
		List<Contenido> canciones = servidor.buscar(titulo, token);
		assertEquals(canciones.get(0), cancion);
	}
}
