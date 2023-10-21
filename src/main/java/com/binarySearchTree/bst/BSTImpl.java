package com.binarySearchTree.bst;

import java.util.ArrayList;
import java.util.List;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
		root.setParent(new BSTNode<T>());
	}
	
	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return height(this.root);
	}
	
	public int height(BSTNode<T> node) {
	    if(node.isEmpty()) {
	        return -1;
	    } 
	    int left = height((BSTNode<T>) node.getLeft());
	    int right = height((BSTNode<T>) node.getRight());
	        
	    if(left > right) {
	    	return left + 1;
	    } else {
	    	return right + 1;
	    }
	}
	
	@Override
	public BSTNode<T> search(T element) {
		return search(this.root, element);
	}
	
	public BSTNode<T> search(BSTNode<T> node, T element) {
		if(node.isEmpty() || node.getData() == element) {
			return node;
		} 
		if (node.getData().compareTo(element) > 0) {
			return search((BSTNode<T>) node.getLeft(), element);
		} else {
			return search((BSTNode<T>) node.getRight(), element);
		}
	}

	@Override
	public void insert(T element) {
		insert(root, (BSTNode<T>) root.getParent(), element);
	}
	
	public void insert(BSTNode<T> node, BSTNode<T> parent, T element) {
		if(node.isEmpty()) {
			node.setData(element);
			node.setParent(parent);
			node.setLeft(new BSTNode<T>());
			node.setRight(new BSTNode<T>());
		} else {
			if(element.compareTo(node.getData()) < 0) {
				insert((BSTNode<T>) node.getLeft(), node, element);
			} else {
				insert((BSTNode<T>) node.getRight(), node, element);
			}
		}
	}

	@Override
	public BSTNode<T> maximum() {
		return maximum(this.root);
	}
	
	private BSTNode<T> maximum(BSTNode<T> node) {
		if(node.isEmpty()) {
			return null;
		}
		while(!node.getRight().isEmpty()) {
			node = (BSTNode<T>) node.getRight();
		}
		return node;
	}

	@Override
	public BSTNode<T> minimum() {
		return minimum(this.root);
	}
	
	private BSTNode<T> minimum(BSTNode<T> node) {
		if(node.isEmpty()) {
			return null;
		}
		while(!node.getLeft().isEmpty()) {
			node = (BSTNode<T>) node.getLeft();
		}
		return node;
	}
	
	@Override
	public BSTNode<T> sucessor(T element) {
		
		BSTNode<T> node = search(element);
		
		if(node == maximum() || node.isEmpty()) {
			return null;
		}
		if(!node.getRight().isEmpty()) {
			return minimum((BSTNode<T>) node.getRight());
		} 
		return ancestralSuccessor(node);
	}

	private BSTNode<T> ancestralSuccessor(BSTNode<T> node) {
		BSTNode<T> father = (BSTNode<T>) node.getParent();
		
		while(!father.isEmpty() && node == father.getRight()) {
			node = father;
			father = (BSTNode<T>) father.getParent();
		}
		return father;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		
		BSTNode<T> node = search(element);
		
		if(node == minimum() || node.isEmpty()) {
			return null;
		}
		if(!node.getLeft().isEmpty()) {
			return maximum((BSTNode<T>) node.getLeft());
		}
		return ancestralPredecessor(node);	
	}
	
	private BSTNode<T> ancestralPredecessor(BSTNode<T> node) {
		BSTNode<T> father = (BSTNode<T>) node.getParent();
		
		while(!father.isEmpty() && node == father.getLeft()) {
			node = father;
			father = (BSTNode<T>) father.getParent();
		}
		return father;
	}

	@Override
	public void remove(T element) {
		BSTNode<T> node = search(element);
		remove(node);
	}
	private void remove(BSTNode<T> node) {

		if(!node.isEmpty()) {
			if(node.isLeaf()) {
				node.setData(null);
				node.setParent(null);
			} else if (nodeHasOneChild(node)) {
				if(node != this.root) {
					if(nodeIsLeftChild(node)) {
						if(!node.getLeft().isEmpty()) {
							node.getParent().setLeft(node.getLeft());
							node.getLeft().setParent(node.getParent());
						} else {
							node.getParent().setLeft(node.getRight());
							node.getRight().setParent(node.getParent());
						}
					} else {
						if(!node.getLeft().isEmpty()) {
							node.getParent().setRight(node.getLeft());
							node.getLeft().setParent(node.getParent());
						} else {
							node.getParent().setRight(node.getRight());
							node.getRight().setParent(node.getParent());
						}
					}
				} else {
					if(!node.getLeft().isEmpty()) {
						this.root = (BSTNode<T>) node.getLeft();
						this.root.setParent(new BSTNode<T>());
					} else {
						this.root = (BSTNode<T>) node.getRight();
						this.root.setParent(new BSTNode<T>());
					}
				}
			} else {
				BSTNode<T> sucessor = sucessor(node.getData());
				node.setData(sucessor.getData());
				remove(sucessor);
			}
		}
	}
	
	private Boolean nodeHasOneChild(BSTNode<T> node) {
		return node.getLeft().isEmpty() && !node.getRight().isEmpty() || 
				!node.getLeft().isEmpty() && node.getRight().isEmpty();
	}
	
	private Boolean nodeIsLeftChild(BSTNode<T> node) {
		BSTNode<T> father = (BSTNode<T>) node.getParent();
		return father.getLeft() == node;
	}

	@Override
	public T[] preOrder() {
		List<T> list = new ArrayList<T>();
		preOrder(this.root, list);
		return listToArray(list);
	}
	
	private void preOrder(BSTNode<T> node, List<T> list) {
		if(!node.isEmpty()) {
			visit(node, list);
			preOrder((BSTNode<T>) node.getLeft(), list);
			preOrder((BSTNode<T>) node.getRight(), list);
		}
	}
	
	private void visit(BSTNode<T> node, List<T> list) {
		list.add(node.getData());
	}
	
	private T[] listToArray(List<T> list) {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Comparable[size()];
		
		int index = 0;
		for(T data: list) {
			array[index] = data;
			index++;
		}
		return array;
	}

	@Override
	public T[] order() {
		List<T> list = new ArrayList<T>();
		order(this.root, list);
		return listToArray(list);
	}
	
	private void order(BSTNode<T> node, List<T> list) {
		if(!node.isEmpty()) {
			order((BSTNode<T>) node.getLeft(), list);
			visit(node, list);
			order((BSTNode<T>) node.getRight(), list);
		}
	}

	@Override
	public T[] postOrder() {
		List<T> list = new ArrayList<T>();
		postOrder(this.root, list);
		return listToArray(list);
	}
	
	private void postOrder(BSTNode<T> node, List<T> list) {
		if(!node.isEmpty()) {
			postOrder((BSTNode<T>) node.getLeft(), list);
			postOrder((BSTNode<T>) node.getRight(), list);
			visit(node, list);
		}
	}
	
	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
