package sortingAlgorithms.mergeSort;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sortingAlgorithms.AbstractSorting;
import com.sortingAlgorithms.mergeSort.MergeSort;

public class MergeSortTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;
	private Integer[] vetorUnitario;
	private Integer[] vetorTamDois;

	public AbstractSorting<Integer> implementation;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 1, 8, 10, 11 }); 
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49, 11, 18, 36 });
		populaVetorRepetido(new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });
		populaVetorUnitario(new Integer[] { 7 });
		populaVetorTamDois(new Integer[] { 5, 2 });

		getImplementation();
	}

	// // MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a implementação
	 * do aluno
	 */
	private void getImplementation() {
		this.implementation = new MergeSort<Integer>();
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
	
	public void populaVetorUnitario(Integer[] arrayPadrao) {
		this.vetorUnitario = Arrays
				.copyOf(arrayPadrao, arrayPadrao.length);
	}
	
	public void populaVetorTamDois(Integer[] arrayPadrao) {
		this.vetorTamDois = Arrays
				.copyOf(arrayPadrao, arrayPadrao.length);
	}

	// FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO

	// MÉTODOS DE TESTE

	public void genericTest(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);			
		}
		implementation.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}
	
	// MÉTODOS QUE OS ALUNOS PODEM CRIAR
			/**
			 * O ALUNO PODE IMPLEMENTAR METODOS DE ORDENAÇÃO TESTANDO O SORT COM TRES
			 * ARGUMENTOS PARA TESTAR A ORDENACAO EM UM PEDAÇO DO ARRAY. DICA: PROCUREM
			 * SEGUIR A ESTRUTURA DOS MÉTODOS DE TESTE ACIMA DESCRITOS, ORDENANDO APENAS
			 * UMA PARTE DO ARRAY.
			 */
	
	public void specificTest(Integer[] array, int leftIndex, int rightIndex) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);			
		}
		implementation.sort(array, leftIndex, rightIndex);
		Arrays.sort(copy1, leftIndex, rightIndex + 1);
		Assert.assertArrayEquals(copy1, array);
	}
	
	@Test
	public void testSort08() {
		Integer[] vector = vetorTamPar;
		
		int middle = (vector.length - 1) / 2;
		int end = vector.length - 1;
		
		specificTest(vector, 0, middle);
		specificTest(vector, middle + 1, end);
		specificTest(vector, 2, 7);
	}

	@Test
	public void testSort09() {
		Integer[] vector = vetorTamImpar;
		
		int middle = (vector.length - 1) / 2;
		int end = vector.length - 1;
		
		specificTest(vector, 0, middle);
		specificTest(vector, middle + 1, end);
		specificTest(vector, 4, 9);
	}

	@Test
	public void testSort10() {
		Integer[] vector = vetorVazio;
		
		int end = vector.length - 1;
		
		specificTest(vector, 0, end);
	}

	@Test
	public void testSort11() {
		Integer[] vector = vetorValoresIguais;
		
		int middle = (vector.length - 1) / 2;
		int end = vector.length - 1;
		
		specificTest(vector, 0, middle);
		specificTest(vector, middle + 1, end);
		specificTest(vector, 0, 4);
	}

	@Test
	public void testSort12() {	
		Integer[] vector = vetorValoresRepetidos;
		
		int middle = (vector.length - 1) / 2;
		int end = vector.length - 1;
		
		specificTest(vector, 0, middle);
		specificTest(vector, middle + 1, end);
		specificTest(vector, 4, 6);
	}
	
	@Test
	public void testSort13() {	
		Integer[] vector = vetorUnitario;
		
		int middle = (vector.length - 1) / 2;
		int end = vector.length - 1;
		
		specificTest(vector, 0, middle);
		specificTest(vector, middle + 1, end);
		specificTest(vector, 0, end);
	}
	
	@Test
	public void testSort14() {	
		Integer[] vector = vetorTamDois;
		
		int middle = (vector.length - 1) / 2;
		int end = vector.length - 1;
		
		specificTest(vector, 0, middle);
		specificTest(vector, middle + 1, end);
		specificTest(vector, 0, end);
	}
}