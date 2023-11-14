package dataStructures.binarySearchTree;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.dataStructures.binarySearchTree.bst.SimpleBSTManipulation;
import com.dataStructures.binarySearchTree.bst.SimpleBSTManipulationImpl;
import com.dataStructures.binarySearchTree.bst.extended.FloorCeilBST;
import com.dataStructures.binarySearchTree.bst.extended.FloorCeilBSTImpl;
import com.dataStructures.binarySearchTree.bt.BTNode;

public class StudentBSTTest{

	private FloorCeilBST tree;
	private FloorCeilBST tree2;
	
	private SimpleBSTManipulation<Integer> manipulation = new SimpleBSTManipulationImpl<>();
	
	private BTNode<Integer> NIL = new BTNode<Integer>();

	private void fillTree() {
		Integer[] array = { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 };
		for (int i: array) {
			tree.insert(i);
		}
	}
	
	private void fillTree(Integer[] array, FloorCeilBST tree) {
		for (int i: array) {
			tree.insert(i);
		}
	}

	@Before
	public void setUp() {
		//tree = new BSTImpl<>();
		tree = new FloorCeilBSTImpl();
		tree2 = new FloorCeilBSTImpl();
	}

	@Test
	public void testInit() {
		assertTrue(tree.isEmpty());
		assertEquals(0, tree.size());
		assertEquals(-1, tree.height());

		assertEquals(NIL, tree.getRoot());
		
		assertArrayEquals(new Integer[] {}, tree.preOrder());
		assertArrayEquals(new Integer[] {}, tree.order());
		assertArrayEquals(new Integer[] {}, tree.postOrder());

		assertEquals(NIL, tree.search(12));
		assertEquals(NIL, tree.search(-23));
		assertEquals(NIL, tree.search(0));

		assertEquals(null, tree.minimum());
		assertEquals(null, tree.maximum());

		assertEquals(null, tree.sucessor(12));
		assertEquals(null, tree.sucessor(-23));
		assertEquals(null, tree.sucessor(0));

		assertEquals(null, tree.predecessor(12));
		assertEquals(null, tree.predecessor(-23));
		assertEquals(null, tree.predecessor(0));
	}

	@Test
	public void testMinMax() {
		tree.insert(6);
		assertEquals(new Integer(6), tree.minimum().getData());
		assertEquals(new Integer(6), tree.maximum().getData());

		tree.insert(23);
		assertEquals(new Integer(6), tree.minimum().getData());
		assertEquals(new Integer(23), tree.maximum().getData());

		tree.insert(-34);
		assertEquals(new Integer(-34), tree.minimum().getData());
		assertEquals(new Integer(23), tree.maximum().getData());

		tree.insert(5);
		assertEquals(new Integer(-34), tree.minimum().getData());
		assertEquals(new Integer(23), tree.maximum().getData());

		tree.insert(9);
		assertEquals(new Integer(-34), tree.minimum().getData());
		assertEquals(new Integer(23), tree.maximum().getData());
	}

	@Test 
	public void testSucessorPredecessor() {

		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		assertEquals(null, tree.predecessor(-40));
		assertEquals(new Integer(-34), tree.sucessor(-40).getData());

		assertEquals(new Integer(-40), tree.predecessor(-34).getData());
		assertEquals(new Integer(0), tree.sucessor(-34).getData());

		assertEquals(new Integer(-34), tree.predecessor(0).getData());
		assertEquals(new Integer(2), tree.sucessor(0).getData());

		assertEquals(new Integer(0), tree.predecessor(2).getData());
		assertEquals(new Integer(5), tree.sucessor(2).getData());
	}

	@Test
	public void testSize() {
		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		int size = 12;
		assertEquals(size, tree.size());

		while (!tree.isEmpty()) {
			tree.remove(tree.getRoot().getData());
			assertEquals(--size, tree.size());
		}
	}

	@Test
	public void testHeight() {
		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		Integer[] preOrder = new Integer[] { 6, -34, -40, 5, 2, 0, 23, 9, 12,
				76, 67, 232 };
		assertArrayEquals(preOrder, tree.preOrder());
		assertEquals(4, tree.height());

		tree.remove(0);
		assertEquals(3, tree.height());

		tree.remove(2);
		assertEquals(3, tree.height());
	}

	@Test
	public void testRemove() {
		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		Integer[] order = { -40, -34, 0, 2, 5, 6, 9, 12, 23, 67, 76, 232 };
		assertArrayEquals(order, tree.order());

		tree.remove(9);
		order = new Integer[] {  -40, -34, 0, 2, 5, 6, 12, 23, 67, 76, 232 };
		assertArrayEquals(order, tree.order());

		tree.remove(5);
		order = new Integer[] { -40, -34, 0, 2, 6, 12, 23, 67, 76, 232 };
		assertArrayEquals(order, tree.order());

		assertEquals(NIL, tree.search(5));
		assertEquals(NIL, tree.search(9));

	}

	@Test
	public void testSearch() {

		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		assertEquals(new Integer(-40), tree.search(-40).getData());
		assertEquals(new Integer(-34), tree.search(-34).getData());
		assertEquals(NIL, tree.search(2534));
	}
	
	@Test
	public void testfloorCeil() {
		Integer[] array = { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 };
		assertEquals(new Integer(9), tree.floor(array, 11.5));
		assertEquals(null, tree.floor(array, -80));
		assertEquals(new Integer(-40), tree.floor(array, -39.7));
		assertEquals(new Integer(232), tree.floor(array, 232.0));
		assertEquals(new Integer(2), tree.floor(array, 4.6));
		assertEquals(new Integer(232), tree.floor(array, 580));
		assertEquals(new Integer(67), tree.floor(array, 75.9));
		
		assertEquals(new Integer(12), tree.ceil(array, 11.5));
		assertEquals(new Integer(-40), tree.ceil(array, -80));
		assertEquals(new Integer(-34), tree.ceil(array, -39.7));
		assertEquals(new Integer(232), tree.ceil(array, 232.0));
		assertEquals(new Integer(5), tree.ceil(array, 4.6));
		assertEquals(null, tree.ceil(array, 580));
		assertEquals(new Integer(76), tree.ceil(array, 75.9));
	}
	
	@Test
	public void testManipulation() {
		//TESTE DE EQUALS:
		
		fillTree();
		
		Integer[] array = { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 };
		fillTree(array, tree2);
		boolean test = manipulation.equals(tree, tree2);
		assertTrue(test);
		
		tree2 = new FloorCeilBSTImpl();
		Integer[] array2 = { 6, 23, -34, 5, 9, 2, -1, 76, 12, 67, 232, -40 };
		fillTree(array2, tree2);
		test = manipulation.equals(tree, tree2);
		assertFalse(test);
		
		tree2 = new FloorCeilBSTImpl();
		Integer[] array3 = { 6, 23, -34, 5, 9, 2 };
		fillTree(array3, tree2);
		test = manipulation.equals(tree, tree2);
		assertFalse(test);
		
		tree = new FloorCeilBSTImpl();
		tree2 = new FloorCeilBSTImpl();
		test = manipulation.equals(tree, tree2);
		assertTrue(test);
		
		Integer[] array4 = {2};
		Integer[] array5 = {};
		fillTree(array4, tree);
		fillTree(array5, tree2);
		test = manipulation.equals(tree, tree2);
		assertFalse(test);
		
		//TESTE DE SIMILARIDADE:
		
		tree = new FloorCeilBSTImpl();
		tree2 = new FloorCeilBSTImpl();
		Integer[] array6 = {7, 6};
		Integer[] array7 = {4, 2};
		fillTree(array6, tree);
		fillTree(array7, tree2);
		test = manipulation.isSimilar(tree, tree2);
		assertTrue(test);
		
		//TESTE DE ESTATISTICA DE ORDEM
		
		tree = new FloorCeilBSTImpl();
		fillTree();
		Integer test2 = manipulation.orderStatistic(tree, 12);
		assertEquals(new Integer(232), test2);
		
	}
}
