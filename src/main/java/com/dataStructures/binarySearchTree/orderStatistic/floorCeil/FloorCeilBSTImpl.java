package com.dataStructures.binarySearchTree.orderStatistic.floorCeil;

import java.lang.Math;

import com.dataStructures.binarySearchTree.BSTImpl;
import com.dataStructures.binarySearchTree.BSTNode;

/**
 * Note que esta classe estende sua implementacao de BST (BSTImpl).
 * Dependendo do design que voce use, sua BSTImpl precisa ter apenas funcionando
 * corretamente o metodo insert para que voce consiga testar esta classe.
 */
public class FloorCeilBSTImpl extends BSTImpl<Integer> implements FloorCeilBST {

	@Override
	public Integer floor(Integer[] array, double numero) {
		BSTImpl<Integer> tree = createTree(array);
		BSTNode<Integer> root = tree.getRoot();
		return floor(root, (int) numero, root.getData());
	}
	
	private BSTImpl<Integer> createTree(Integer[] array) {
		BSTImpl<Integer> tree = new BSTImpl<Integer>();
		
		for(int i: array) {
			tree.insert(i);
		}
		return tree;
	}
	
	private Integer floor(BSTNode<Integer> node, int numero, int floor) {
		if(!node.isEmpty()) {
			if(node.getData() < numero) {
				floor = node.getData();
			}
			if(numero == node.getData()) {
				return numero;
			} else if(numero < node.getData()) {
				node = (BSTNode<Integer>) node.getLeft();
				return floor(node, numero, floor);
			} else {
				node = (BSTNode<Integer>) node.getRight();
				return floor(node, numero, floor);
			}
		}
		if(floor > numero) {
			return null;
		} 
		return floor;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		BSTImpl<Integer> tree = createTree(array);
		BSTNode<Integer> root = tree.getRoot();
		return ceil(root, (int) Math.ceil(numero), root.getData());
	}
	
	private Integer ceil(BSTNode<Integer> node, int numero, int ceil) {
		if(!node.isEmpty()) {
			if(node.getData() > numero) {
				ceil = node.getData();
			}
			if(numero == node.getData()) {
				return numero;
			} else if(numero < node.getData()) {
				node = (BSTNode<Integer>) node.getLeft();
				return ceil(node, numero, ceil);
			} else {
				node = (BSTNode<Integer>) node.getRight();
				return ceil(node, numero, ceil);
			}
		}
		if(ceil < numero) {
			return null;
		} 
		return ceil;
	}
	
}
