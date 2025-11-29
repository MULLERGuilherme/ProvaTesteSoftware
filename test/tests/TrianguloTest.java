package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import triangulo.Tipo;
import triangulo.Triangulo;
import triangulo.Exceptions.LadoInvalidoException;
import triangulo.Exceptions.SomaLadosInvalidaException;
import triangulo.Exceptions.TodosOsLadosInvalidosException;

class TrianguloTest {

	@Test
	void deveCriarTrianguloEscalenoValido() throws Exception {
		Triangulo triangulo = new Triangulo(3, 4, 5);
		assertEquals(Tipo.ESCALENO, triangulo.getTipo());
	}

	@Test
	void deveCriarTrianguloEquilateroValido() throws Exception {
		Triangulo triangulo = new Triangulo(3, 3, 3);
		assertEquals(Tipo.EQUILATERO, triangulo.getTipo());
	}

	@Test
	void deveCriarTrianguloIsocelesValido() throws Exception {
		Triangulo triangulo = new Triangulo(4, 3, 4);
		assertEquals(Tipo.ISOCELES, triangulo.getTipo());
	}

	@Test
	void deveCriarTrianguloIsocelesValidoPermutacao1() throws Exception {
		Triangulo triangulo = new Triangulo(4, 5, 5);
		assertEquals(Tipo.ISOCELES, triangulo.getTipo());
	}

	@Test
	void deveCriarTrianguloIsocelesValidoPermutacao2() throws Exception {
		Triangulo triangulo = new Triangulo(5, 4, 5);
		assertEquals(Tipo.ISOCELES, triangulo.getTipo());
	}

	@Test
	void deveCriarTrianguloIsocelesValidoPermutacao3() throws Exception {
		Triangulo triangulo = new Triangulo(5, 5, 4);
		assertEquals(Tipo.ISOCELES, triangulo.getTipo());
	}

	@Test
	void deveGerarErroCasoAlgumLadoDoTrianguloSejaZero() {
		LadoInvalidoException thrown = assertThrows(LadoInvalidoException.class, () -> new Triangulo(0, 5, 5));
		assertEquals("Um dos lados do triangulo é menor ou igual a 0", thrown.getMessage());
	}

	@Test
	void deveGerarErroCasoAlgumLadoDoTrianguloSejaNegativo() {
		LadoInvalidoException thrown = assertThrows(LadoInvalidoException.class, () -> new Triangulo(-1, 5, 5));
		assertEquals("Um dos lados do triangulo é menor ou igual a 0", thrown.getMessage());
	}

	@Test
	void deveGerarErroCasoASomaDeDoisLadosSejaIgualAoTerceiroLado() {
		SomaLadosInvalidaException thrown = assertThrows(SomaLadosInvalidaException.class,
				() -> new Triangulo(1, 2, 3));
		assertEquals("A soma dos lados do triângulo é inválida ", thrown.getMessage());
	}

	@Test
	void deveGerarErroCasoASomaDeDoisLadosSejaIgualAoTerceiroLadoPermutacao1() {
		SomaLadosInvalidaException thrown = assertThrows(SomaLadosInvalidaException.class,
				() -> new Triangulo(4, 2, 2));
		assertEquals("A soma dos lados do triângulo é inválida ", thrown.getMessage());
	}

	@Test
	void deveGerarErroCasoASomaDeDoisLadosSejaIgualAoTerceiroLadoPermutacao2() {
		SomaLadosInvalidaException thrown = assertThrows(SomaLadosInvalidaException.class,
				() -> new Triangulo(2, 4, 2));
		assertEquals("A soma dos lados do triângulo é inválida ", thrown.getMessage());
	}

	@Test
	void deveGerarErroCasoASomaDeDoisLadosSejaIgualAoTerceiroLadoPermutacao3() {
		SomaLadosInvalidaException thrown = assertThrows(SomaLadosInvalidaException.class,
				() -> new Triangulo(2, 2, 4));
		assertEquals("A soma dos lados do triângulo é inválida ", thrown.getMessage());
	}

	@Test
	void deveGerarErroCasoASomaDeDoisLadosSejaMenorQueOTerceiroLado() {
		SomaLadosInvalidaException thrown = assertThrows(SomaLadosInvalidaException.class,
				() -> new Triangulo(1, 2, 4));
		assertEquals("A soma dos lados do triângulo é inválida ", thrown.getMessage());
	}

	@Test
	void deveGerarErroCasoASomaDeDoisLadosSejaMenorQueOTerceiroLadoPermutacao1() {
		SomaLadosInvalidaException thrown = assertThrows(SomaLadosInvalidaException.class,
				() -> new Triangulo(5, 2, 2));
		assertEquals("A soma dos lados do triângulo é inválida ", thrown.getMessage());
	}

	@Test
	void deveGerarErroCasoASomaDeDoisLadosSejaMenorQueOTerceiroLadoPermutacao2() {
		SomaLadosInvalidaException thrown = assertThrows(SomaLadosInvalidaException.class,
				() -> new Triangulo(2, 5, 2));
		assertEquals("A soma dos lados do triângulo é inválida ", thrown.getMessage());
	}

	@Test
	void deveGerarErroCasoASomaDeDoisLadosSejaMenorQueOTerceiroLadoPermutacao3() {
		SomaLadosInvalidaException thrown = assertThrows(SomaLadosInvalidaException.class,
				() -> new Triangulo(2, 2, 5));
		assertEquals("A soma dos lados do triângulo é inválida ", thrown.getMessage());
	}

	@Test
	void deveGerarErroCasoOsTresLadosSejamIguaisAZero() {
		TodosOsLadosInvalidosException thrown = assertThrows(TodosOsLadosInvalidosException.class,
				() -> new Triangulo(0, 0, 0));
		assertEquals("Todos os lados são iguais a zero ", thrown.getMessage());
	}

}
