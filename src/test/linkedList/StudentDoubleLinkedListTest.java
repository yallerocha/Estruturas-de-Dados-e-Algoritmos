package adt.linkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentDoubleLinkedListTest extends StudentLinkedListTest {

	private DoubleLinkedList<Integer> lista3;

	@Before
	public void setUp() throws Exception {

		getImplementations();
 
		// Lista com 3 elementos.
		lista1.insert(3);
		lista1.insert(2);
		lista1.insert(1); 

	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		
		lista1 = new RecursiveDoubleLinkedListImpl<Integer>();
		lista2 = new RecursiveDoubleLinkedListImpl<Integer>();
		lista3 = new RecursiveDoubleLinkedListImpl<Integer>();
	}

	//Métodos de DoubleLinkedList

	@Test
	public void testInsertFirst() {
		((DoubleLinkedList<Integer>) lista3).insertFirst(4);
		((DoubleLinkedList<Integer>) lista1).insertFirst(4);
		Assert.assertArrayEquals(new Integer[] { 4, 3, 2, 1 }, lista1.toArray());
		Assert.assertArrayEquals(new Integer[] {4}, lista3.toArray());
	}

	@Test
	public void testRemoveFirst() {
		((DoubleLinkedList<Integer>) lista1).removeFirst();
		Assert.assertArrayEquals(new Integer[] { 2, 1 }, lista1.toArray());
		((DoubleLinkedList<Integer>) lista3).removeFirst();
		Assert.assertArrayEquals(new Integer[] {}, lista3.toArray());
		lista3.insert(1);
		((DoubleLinkedList<Integer>) lista3).removeFirst();
		Assert.assertArrayEquals(new Integer[] {}, lista3.toArray());
	}

	@Test
	public void testRemoveLast() {
		((DoubleLinkedList<Integer>) lista1).removeLast();
		Assert.assertArrayEquals(new Integer[] { 3, 2 }, lista1.toArray());
		lista1.insert(5);
		lista1.insert(6);
		lista1.insert(7);
		((DoubleLinkedList<Integer>) lista1).removeLast();
		Assert.assertArrayEquals(new Integer[] { 3, 2, 5, 6}, lista1.toArray());
		((DoubleLinkedList<Integer>) lista3).removeLast();
		Assert.assertArrayEquals(new Integer[] {}, lista3.toArray());
		lista3.insert(1);
		((DoubleLinkedList<Integer>) lista3).removeLast();
		Assert.assertArrayEquals(new Integer[] {}, lista3.toArray());
		lista3.insert(2);
		lista3.insert(3);
		((DoubleLinkedList<Integer>) lista3).removeLast();
		Assert.assertArrayEquals(new Integer[] {2}, lista3.toArray());
	}
}