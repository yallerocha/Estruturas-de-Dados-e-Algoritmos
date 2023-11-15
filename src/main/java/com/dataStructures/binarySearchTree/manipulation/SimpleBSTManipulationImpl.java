package com.dataStructures.binarySearchTree.manipulation;

import com.dataStructures.binarySearchTree.BST;
import com.dataStructures.binarySearchTree.BSTNode;

/**
 * - Esta eh a unica classe que pode ser modificada 
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public class SimpleBSTManipulationImpl<T extends Comparable<T>> implements SimpleBSTManipulation<T> {

	@Override
	public boolean equals(BST<T> tree1, BST<T> tree2) {
		BSTNode<T> root1 = (BSTNode<T>) tree1.getRoot();
		BSTNode<T> root2 = (BSTNode<T>) tree2.getRoot();
		
		return equals(root1, root2, true);
	}
	
	private boolean equals(BSTNode<T> node1, BSTNode<T> node2, boolean var) {
		if(!node1.isEmpty() && node2.isEmpty() || node1.isEmpty() && !node2.isEmpty()) {
			return false;
		}
		if(!node1.isEmpty() && !node2.isEmpty()) {
			if(nodeDataFormatEquals(node1, node2)) {
				if(!equals((BSTNode<T>) node1.getLeft(), (BSTNode<T>) node2.getLeft(), var)) {
					return false;
				}
				return equals((BSTNode<T>) node1.getRight(), (BSTNode<T>) node2.getRight(), var);
			} 
			return false;
		}
		return var; 
	}
	
	private boolean nodeDataFormatEquals(BSTNode<T> node1, BSTNode<T> node2) {
		if(node1.equals(node2) && nodeFormatEquals(node1, node2)) {
			return true;
		}
		return false;
	}
	
	private boolean nodeFormatEquals(BSTNode<T> node1, BSTNode<T> node2) {
		if(!node1.getLeft().isEmpty() && !node2.getLeft().isEmpty() || node1.getLeft().isEmpty() && node2.getLeft().isEmpty()) {
			if(!node1.getRight().isEmpty() && !node2.getRight().isEmpty() || node1.getRight().isEmpty() && node2.getRight().isEmpty()) {
				if(!node1.getParent().isEmpty() && !node2.getParent().isEmpty() || node1.getParent().isEmpty() && node2.getParent().isEmpty()) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean isSimilar(BST<T> tree1, BST<T> tree2) {
		BSTNode<T> root1 = (BSTNode<T>) tree1.getRoot();
		BSTNode<T> root2 = (BSTNode<T>) tree2.getRoot();
		
		return isSimilar(root1, root2, true);
	}
	
	private boolean isSimilar(BSTNode<T> node1, BSTNode<T> node2, boolean var) {
		if(!node1.isEmpty() && node2.isEmpty() || node1.isEmpty() && !node2.isEmpty()) {
			return false;
		}
		if(!node1.isEmpty() && !node2.isEmpty()) {
			if(nodeFormatEquals(node1, node2)) {
				if(!isSimilar((BSTNode<T>) node1.getLeft(), (BSTNode<T>) node2.getLeft(), var)) {
					return false;
				}
				return isSimilar((BSTNode<T>) node1.getRight(), (BSTNode<T>) node2.getRight(), var);
			} 
			return false;
		}
		return var;
	}
	
	@Override
	public T orderStatistic(BST<T> tree, int k) {
		BSTNode<T> root = (BSTNode<T>) tree.getRoot();
		BSTNode<T> result = new BSTNode<T>();
		orderStatistic(root, k, result);
		return result.getData();
	}
	private int orderStatistic(BSTNode<T> node, int k, BSTNode<T> result) {
		if(!node.isEmpty()) {
			k = orderStatistic((BSTNode<T>) node.getLeft(), k, result);
			if(result.getData() != null) {
				return k;
			}
			k--;
			if(k == 0 && result.getData() == null) {
				result.setData(node.getData());
				return k;
			}
			k = orderStatistic((BSTNode<T>) node.getRight(), k, result);
		}
		return k;
	}
	
}
