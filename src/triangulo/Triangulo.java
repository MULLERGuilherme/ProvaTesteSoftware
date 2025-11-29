package triangulo;

import triangulo.Exceptions.LadoInvalidoException;
import triangulo.Exceptions.SomaLadosInvalidaException;
import triangulo.Exceptions.TodosOsLadosInvalidosException;

public class Triangulo {

	private final Tipo tipo;
	private final int lado1;
	private final int lado2;
	private final int lado3;

	public Triangulo(int a, int b, int c) throws Exception {
		validar(a, b, c);
		this.tipo = resolveTipo(a, b, c);
		this.lado1 = a;
		this.lado2 = b;
		this.lado3 = c;
	}

	private void validar(int a, int b, int c) throws Exception {

		if (a == 0 && b == 0 && c == 0) {
			throw new TodosOsLadosInvalidosException("Todos os lados são iguais a zero ");
		}

		if (a <= 0 || b <= 0 || c <= 0) {
			throw new LadoInvalidoException("Um dos lados do triangulo é menor ou igual a 0");
		}

		if (a + b <= c || a + c <= b || b + c <= a) {
			throw new SomaLadosInvalidaException("A soma dos lados do triângulo é inválida ");
		}
	}

	private Tipo resolveTipo(int a, int b, int c) {
		for (var tipo : Tipo.values()) {
			if (tipo.matches(a, b, c)) {
				return tipo;
			}
		}
		throw new IllegalStateException("Tipo de triângulo desconhecido");
	}

	public Tipo getTipo() {
		return tipo;
	}

	public int getLado1() {
		return lado1;
	}

	public int getLado2() {
		return lado2;
	}

	public int getLado3() {
		return lado3;
	}

}
