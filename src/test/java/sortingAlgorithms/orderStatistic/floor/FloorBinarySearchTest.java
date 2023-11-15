package sortingAlgorithms.orderStatistic.floor;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sortingAlgorithms.orderStatistic.floor.Floor;
import com.sortingAlgorithms.orderStatistic.floor.FloorBinarySearchImpl;

public class FloorBinarySearchTest<T extends Comparable<T>>{

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;

	public Floor floor;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23, 31 });
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49, 11, 18, 36 });
		populaVetorRepetido(new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });

		getImplementation();
	}

	// // MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a implementação
	 * do aluno
	 */
	private void getImplementation() {
		this.floor = new FloorBinarySearchImpl();
	}

	public void populaVetorTamanhoPar(Integer[] arrayPadrao) {
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorRepetido(Integer[] arrayPadrao) {
		this.vetorValoresRepetidos = Arrays.copyOf(arrayPadrao,
				arrayPadrao.length);
	}

	public void populaVetorIgual(Integer[] arrayPadrao) {
		this.vetorValoresIguais = Arrays
				.copyOf(arrayPadrao, arrayPadrao.length);
	}

	// FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO

	// TESTES DO FLOOR

	@Test
	public void testSort01() {
		Integer x = 6; 
		Integer gabarito = 5;
		Integer resultado = floor.floor(vetorValoresRepetidos, x);
		Assert.assertEquals(gabarito, resultado);
	}

	@Test
	public void testSort02() {
		Integer x = 7; 
		Integer gabarito = 6;
		Integer resultado = floor.floor(vetorValoresIguais, x);
		Assert.assertEquals(gabarito, resultado);
	}

	@Test
	public void testSort03() {
		Integer x = 6; 
		Integer gabarito = 6;
		Integer resultado = floor.floor(vetorValoresIguais, x);
		Assert.assertEquals(gabarito, resultado);
	}
	
	@Test
	public void testSort04() {
		Integer x = 11; 
		Integer gabarito = 11;
		Integer resultado = floor.floor(vetorTamPar, x);
		Assert.assertEquals(gabarito, resultado);
	}
	
	@Test
	public void testSort05() {
		Integer x = 340; 
		Integer gabarito = 49;
		Integer resultado = floor.floor(vetorTamImpar, x);
		Assert.assertEquals(gabarito, resultado);
	}
	
	@Test
	public void testSort06() {
		Integer x = 2; 
		Integer gabarito = null;
		Integer resultado = floor.floor(vetorVazio, x);
		Assert.assertEquals(gabarito, resultado);
	}
	
	@Test
	public void testSort07() {
		Integer x = 1; 
		Integer gabarito = null;
		Integer resultado = floor.floor(vetorTamImpar, x);
		Assert.assertEquals(gabarito, resultado);
	}
	
	@Test
	public void testSort08() {
		Integer x = 4; 
		Integer gabarito = 4;
		Integer resultado = floor.floor(vetorTamImpar, x);
		Assert.assertEquals(gabarito, resultado);
	}
	
	@Test
	public void testSort09() {
		Integer x = 0; 
		Integer gabarito = null;
		Integer resultado = floor.floor(vetorTamImpar, x);
		Assert.assertEquals(gabarito, resultado);
	}

	// MÉTODOS QUE OS ALUNOS PODEM CRIAR
	/**
	 * O ALUNO PODE IMPLEMENTAR METODOS DE ORDENAÇÃO TESTANDO O SORT COM TRES
	 * ARGUMENTOS PARA TESTAR A ORDENACAO EM UM PEDAÇO DO ARRAY. DICA: PROCUREM
	 * SEGUIR A ESTRUTURA DOS MÉTODOS DE TESTE ACIMA DESCRITOS, ORDENANDO APENAS
	 * UMA PARTE DO ARRAY.
	 */
}