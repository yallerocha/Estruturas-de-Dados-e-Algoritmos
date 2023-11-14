package sortingAlgorithms.quickSelect;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sortingAlgorithms.quickSelect.QuickSelect;

public class QuickSelectTest<T extends Comparable<T>>{

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;

	public QuickSelect<Integer> QuickSelect;

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
		this.QuickSelect =  new QuickSelect<Integer>();
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
	
	// TESTES DO QUICK SELECT
	
	@Test
	public void testSort01() {
		int k = 10;
		int gabarito = 31;
		int resultado = QuickSelect.quickSelect(vetorTamPar, k);
		Assert.assertEquals(gabarito, resultado);
	}

	@Test
	public void testSort02() {
		int k = 5;
		int gabarito = 18;
		int resultado = QuickSelect.quickSelect(vetorTamImpar, k);
		Assert.assertEquals(gabarito, resultado);
	}

	@Test
	public void testSort03() {
		int k = 2;
		Integer resultado = QuickSelect.quickSelect(vetorVazio, k);
		Assert.assertNull(resultado);
	}
	
	@Test
	public void testSort04() {
		int k = 1;
		int gabarito = 6;
		int resultado = QuickSelect.quickSelect(vetorValoresIguais, k);
		Assert.assertEquals(gabarito, resultado);
	}

	@Test
	public void testSort05() {
		int k = 4;
		int gabarito = 4;
		int resultado = QuickSelect.quickSelect(vetorValoresRepetidos, k);
		Assert.assertEquals(gabarito, resultado);
	}
	
	@Test
	public void testSort06() {
		int k = 50;
		Integer resultado = QuickSelect.quickSelect(vetorTamImpar, k);
		Assert.assertNull(resultado);
	}
	
	@Test
	public void testSort07() {
		int k = 1;
		int gabarito = 4;
		int resultado = QuickSelect.quickSelect(vetorTamImpar, k);
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