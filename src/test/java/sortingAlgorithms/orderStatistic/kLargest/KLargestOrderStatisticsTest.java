package sortingAlgorithms.orderStatistic.kLargest;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sortingAlgorithms.orderStatistic.kLargest.KLargest;
import com.sortingAlgorithms.orderStatistic.kLargest.KLargestOrderStatisticsImpl;

public class KLargestOrderStatisticsTest<T extends Comparable<T>>{

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;

	public KLargest<Integer> KLargest;

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
		this.KLargest = new KLargestOrderStatisticsImpl<Integer>();
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
	// TESTES DO K LARGEST ORDER STATISTICS IMPL
	
	@Test
	public void testSort08() {
		int k = 2; 
		int[] gabarito = {30, 31};
		Integer[] resultado = KLargest.getKLargest(vetorTamPar, k);
		Assert.assertEquals(Arrays.toString(gabarito), Arrays.toString(resultado));
	}
	
	@Test
	public void testSort09() {
		int k = 70; 
		int[] gabarito = {};
		Integer[] resultado = KLargest.getKLargest(vetorTamPar, k);
		Assert.assertEquals(Arrays.toString(gabarito), Arrays.toString(resultado));
	}
	
	@Test
	public void testSort10() {
		int k = 6; 
		int[] gabarito = {4, 3, 4, 4, 9, 5};
		Integer[] resultado = KLargest.getKLargest(vetorValoresRepetidos, k);
		Assert.assertEquals(Arrays.toString(gabarito), Arrays.toString(resultado));
	}
	
	@Test
	public void testSort11() {
		int k = 6; 
		int[] gabarito = {6, 6, 6, 6, 6, 6};
		Integer[] resultado = KLargest.getKLargest(vetorValoresIguais, k);
		Assert.assertEquals(Arrays.toString(gabarito), Arrays.toString(resultado));
	}
	
	@Test
	public void testSort12() {
		int k = 1; 
		int[] gabarito = {49};
		Integer[] resultado = KLargest.getKLargest(vetorTamImpar, k);
		Assert.assertEquals(Arrays.toString(gabarito), Arrays.toString(resultado));
	}
	
	@Test
	public void testSort13() {
		int k = 3; 
		int[] gabarito = {};
		Integer[] resultado = KLargest.getKLargest(vetorVazio, k);
		Assert.assertEquals(Arrays.toString(gabarito), Arrays.toString(resultado));
	}
	
	@Test
	public void testSort14() {
		int k = 0; 
		int[] gabarito = {};
		Integer[] resultado = KLargest.getKLargest(vetorValoresRepetidos, k);
		Assert.assertEquals(Arrays.toString(gabarito), Arrays.toString(resultado));
	}
	

	// MÉTODOS QUE OS ALUNOS PODEM CRIAR
	/**
	 * O ALUNO PODE IMPLEMENTAR METODOS DE ORDENAÇÃO TESTANDO O SORT COM TRES
	 * ARGUMENTOS PARA TESTAR A ORDENACAO EM UM PEDAÇO DO ARRAY. DICA: PROCUREM
	 * SEGUIR A ESTRUTURA DOS MÉTODOS DE TESTE ACIMA DESCRITOS, ORDENANDO APENAS
	 * UMA PARTE DO ARRAY.
	 */
}