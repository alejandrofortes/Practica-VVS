package es.udc.fic.vvs.quickcheck;

import static net.java.quickcheck.generator.PrimitiveGenerators.integers;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import net.java.quickcheck.Generator;
import net.java.quickcheck.generator.support.StringGenerator;

import org.junit.Test;

import es.udc.fic.vvs.contenido.Cancion;
import es.udc.fic.vvs.contenido.Contenido;
import es.udc.fic.vvs.contenido.Emisora;

public class ContenidoQCTest {
	StringGenerator generador = new StringGenerator();
	Generator<Integer> iGen = integers(1,50);


	public String generarString(){
		return generador.next();

	}

	public Double generarDouble(){
		return (iGen.next()* 1.0);

	}


	@Test
	public void obtenerTituloDuracionYListaReproCancionQC(){
		String titulo = generarString();
		Double duracion = generarDouble();
		Contenido cancion = new Cancion(titulo,duracion);
		assertTrue(cancion.obtenerTitulo().equals(titulo));
		assertTrue(cancion.obtenerDuracion() == duracion);
		List<Contenido> lista = new ArrayList<Contenido>();
		lista.add(cancion);
		assertTrue(cancion.obtenerListaReproduccion().equals(lista));

	}

	@Test
	public void buscarCancionQC(){
		String titulo = generarString();
		Double duracion = generarDouble();
		Contenido cancion = new Cancion(titulo,duracion);
		String subString = titulo;
		List<Contenido> cancionEncontrada = new ArrayList<Contenido>();
		cancionEncontrada = cancion.buscar(subString);

		assertTrue(cancionEncontrada.get(0).obtenerTitulo().equals(titulo));
		assertTrue(cancionEncontrada.get(0).obtenerDuracion() == duracion);
	}

	@Test
	public void AgregarObtenerTituloYDuracionListaReproQC(){
		String titulo = generarString();
		Double duracion = generarDouble();
		Contenido cancion = new Cancion(titulo,duracion);

		String titulo2 = generarString();
		Double duracion2 = generarDouble();
		Contenido cancion2 = new Cancion(titulo2,duracion2);

		String tituloEmi = generarString();
		Contenido emisora = new Emisora(tituloEmi,0);

		emisora.agregar(cancion,null);
		emisora.agregar(cancion2, cancion);

		assertTrue(emisora.obtenerTitulo().equals(tituloEmi));
		assertTrue(emisora.obtenerDuracion() == (duracion + duracion2));
	}






}
