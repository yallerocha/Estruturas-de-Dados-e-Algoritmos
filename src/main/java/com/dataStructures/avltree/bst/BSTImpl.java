package com.dataStructures.avltree.bst;

import java.util.ArrayList;
import java.util.List;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<>();
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
		return this.heightRecursive(this.root);
	}

	public int heightRecursive (BSTNode<T> currentNode) {
		int resp = -1;

		if (!currentNode.isEmpty()) {
			resp = 1 + Math.max(this.heightRecursive((BSTNode<T>) currentNode.getLeft()),
					this.heightRecursive((BSTNode<T>) currentNode.getRight()));
		}
		return resp;
	}

	@Override
	public BSTNode<T> search(T element) {
		BSTNode<T> result = null;
		
		if(element == null) {
			result = new BSTNode<>();
		} else {
			result = this.searchRecursive(this.root, element);
		}
		return result;
	}

	private BSTNode<T> searchRecursive (BSTNode<T> currentNode, T element) {
		BSTNode<T> resp;

		if (currentNode.isEmpty() || currentNode.getData().equals(element)) {
			resp = currentNode;
		} else if (element.compareTo(currentNode.getData()) > 0) {
			resp = this.searchRecursive((BSTNode<T>) currentNode.getRight(), element);
		} else {
			resp = this.searchRecursive((BSTNode<T>) currentNode.getLeft(), element);
		}
		return resp;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			this.insertRecursive(this.root, element);
		}
	}

	@SuppressWarnings("unchecked")
	private void insertRecursive (BSTNode<T> currentNode, T element) {
		if (currentNode.isEmpty()) {
			currentNode.setData(element);
			currentNode.setRight(new BSTNode.Builder<T>().parent(currentNode).build());
			currentNode.setLeft(new BSTNode.Builder<T>().parent(currentNode).build());
		} else {
			if (element.compareTo(currentNode.getData()) > 0) {
				this.insertRecursive((BSTNode<T>) currentNode.getRight(), element);
			} else {
				this.insertRecursive((BSTNode<T>) currentNode.getLeft(), element);
			}
		}
	}

	@Override
	public BSTNode<T> maximum() {
		BSTNode<T> result = null;
		
		if (!this.isEmpty()) {
			this.maximumRecursive(this.root);
	    }
		return result;
	}

	private BSTNode<T> maximumRecursive (BSTNode<T> currentNode) {
		BSTNode<T> result = null;
		
		if (currentNode.getRight().isEmpty()) {
			result = currentNode;
	    } else {
	    	result = this.maximumRecursive((BSTNode<T>) currentNode.getRight());
	    }
		return result;
	}

	@Override
	public BSTNode<T> minimum() {
	BSTNode<T> result = null;
		
		if (!this.isEmpty()) {
			this.minimumRecursive(this.root);
	    }
		return result;
	}

	private BSTNode<T> minimumRecursive (BSTNode<T> currentNode) {
		BSTNode<T> result = null;
		
		if (currentNode.getLeft().isEmpty()) {
			result = currentNode;
	    } else {
	    	result = this.minimumRecursive((BSTNode<T>) currentNode.getLeft());
	    }
		return result;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> node = this.search(element);

		if (!node.isEmpty() && node != null) {
			if (!node.getRight().isEmpty()) {
				node = this.minimumRecursive((BSTNode<T>) node.getRight());
			} else {
				node = this.sucessorRecursive(node, element);
			}
		} else {
			node = null;
		}
		return node;
	}

	private BSTNode<T> sucessorRecursive (BSTNode<T> currentNode, T element) {
		BSTNode<T> result = null;
		
		if(currentNode != null && currentNode.getData().compareTo(element) <= 0) {
			result = this.sucessorRecursive((BSTNode<T>) currentNode.getParent(), element);
		} else {
			result = currentNode;
		}	
		return result;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> node = this.search(element);

		if (!node.isEmpty() && node != null) {
			if (!node.getLeft().isEmpty()) {
				node = this.maximumRecursive((BSTNode<T>) node.getLeft());
			} else {
				node = this.predecessorRecursive(node, element);
			}
		} else {
			node = null;
		}
		return node;
	}

	private BSTNode<T> predecessorRecursive (BSTNode<T> currentNode, T element) {
		BSTNode<T> result = null;
		
		if(currentNode != null && currentNode.getData().compareTo(element) >= 0) {
			result = this.predecessorRecursive((BSTNode<T>) currentNode.getParent(), element);
		} else {
			result = currentNode;
		}
		return result;
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			BSTNode<T> node = this.search(element);

			if (!node.isEmpty()) {
				if (node.isLeaf()) { 
					node.setData(null);
					node.setLeft(null);
					node.setRight(null);
				} else if (node.getRight().isEmpty() || node.getLeft().isEmpty()) { 			
					BSTNode<T> childNode = null;
					
					if(node.getRight().isEmpty()) {
						childNode = (BSTNode<T>) node.getLeft();
					} else {
						childNode = (BSTNode<T>) node.getRight();
					}
					if (this.root.equals(node)) {
						this.root = childNode;
						this.root.setParent(null);
					} else {
						childNode.setParent(node.getParent());
						if (node.getParent().getLeft().equals(node)) {
							node.getParent().setLeft(childNode);
						} else {
							node.getParent().setRight(childNode);
						}
					}
				} else { 
					T sucessor = this.sucessor(node.getData()).getData();
					this.remove(sucessor);
					node.setData(sucessor);
				}
			}
		}
	}

	@Override
	public T[] preOrder() {
		return this.preOrderRecursive(this.root, new ArrayList<>());
	}

	@SuppressWarnings("unchecked")
	private T[] preOrderRecursive (BSTNode<T> currentNode, List<T> list) {
		if (!currentNode.isEmpty()) {
			list.add(currentNode.getData());
			this.preOrderRecursive((BSTNode<T>) currentNode.getLeft(), list);
			this.preOrderRecursive((BSTNode<T>) currentNode.getRight(), list);
		}
		return (T[]) list.toArray(new Comparable[0]);
	}

	@Override
	public T[] order() {
		return this.orderRecursive(this.root, new ArrayList<>());
	}

	@SuppressWarnings("unchecked")
	private T[] orderRecursive (BSTNode<T> currentNode, List<T> list) {
		if (!currentNode.isEmpty()) {
			this.orderRecursive((BSTNode<T>) currentNode.getLeft(), list);
			list.add(currentNode.getData());
			this.orderRecursive((BSTNode<T>) currentNode.getRight(), list);
		}

		return (T[]) list.toArray(new Comparable[0]);
	}

	@Override
	public T[] postOrder() {
		return this.postOrderRecursive(this.root, new ArrayList<>());
	}

	@SuppressWarnings("unchecked")
	private T[] postOrderRecursive (BSTNode<T> currentNode, List<T> list) {
		if (!currentNode.isEmpty()) {
			this.postOrderRecursive((BSTNode<T>) currentNode.getLeft(), list);
			this.postOrderRecursive((BSTNode<T>) currentNode.getRight(), list);
			list.add(currentNode.getData());
		}

		return (T[]) list.toArray(new Comparable[0]);
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