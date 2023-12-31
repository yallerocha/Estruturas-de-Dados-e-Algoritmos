package com.dataStructures.avltree;

import com.dataStructures.binarySearchTree.BSTImpl;
import com.dataStructures.binarySearchTree.BSTNode;
import com.dataStructures.binarySearchTree.binaryTree.UtilRotation;

/**
 * 
 * Implementacao de uma arvore AVL
 * A CLASSE AVLTree herda de BSTImpl. VOCE PRECISA SOBRESCREVER A IMPLEMENTACAO
 * DE BSTIMPL RECEBIDA COM SUA IMPLEMENTACAO "OU ENTAO" IMPLEMENTAR OS SEGUITNES
 * METODOS QUE SERAO TESTADOS NA CLASSE AVLTREE:
 *  - insert
 *  - preOrder
 *  - postOrder
 *  - remove
 *  - height
 *  - size
 *
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements AVLTree<T> {

	// TODO Do not forget: you must override the methods insert and remove
	// conveniently.

	// AUXILIARY
	public int calculateBalance (BSTNode<T> node) {
		int resp = 0;

		if (!node.isEmpty()) {
			resp = this.heightRecursive((BSTNode<T>) node.getLeft())
					- this.heightRecursive((BSTNode<T>) node.getRight());
		}
		return resp;
	}

	// AUXILIARY
	protected void rebalance (BSTNode<T> node) {
		BSTNode<T> newRoot = null;
		int balance = this.calculateBalance(node);

		if (Math.abs(balance) > 1) {
			if (balance > 1) {
				if (this.calculateBalance((BSTNode<T>) node.getLeft()) >= 0) {
					newRoot = UtilRotation.rightRotation(node);
				} else {
					newRoot = UtilRotation.doubleRightRotation(node);
				}
			} else {
				if (this.calculateBalance((BSTNode<T>) node.getRight()) <= 0) {
					newRoot = UtilRotation.leftRotation(node);
				} else {
					newRoot = UtilRotation.doubleLeftRotation(node);
				}
			}
		}
		if (this.getRoot().equals(node) && newRoot != null) {
			this.root = newRoot;
		}
	}

	// AUXILIARY
	protected void rebalanceUp (BSTNode<T> node) {
		if (!node.getParent().isEmpty()) {
			this.rebalance((BSTNode<T>) node.getParent());
			this.rebalanceUp((BSTNode<T>) node.getParent());
		}
	}

	@Override
	public void insert (T element) {
		if (element != null)
			this.insertRecursive(this.root, element);
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
			rebalance(currentNode);
		}
	}

	@Override
	public void remove (T element) {
		if (element != null) {
			BSTNode<T> node = this.search(element);

			if (!node.isEmpty()) {
				if (node.isLeaf()) { 
					node.setData(null);
					node.setLeft(null);
					node.setRight(null);
					rebalanceUp(node);
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
					}
					else {
						childNode.setParent(node.getParent());
						if (node.getParent().getLeft().equals(node)) {
							node.getParent().setLeft(childNode);
						} else {
							node.getParent().setRight(childNode);
						}
					}
					rebalanceUp(node);
				} else { 
					T sucessor = this.sucessor(node.getData()).getData();
					this.remove(sucessor);
					node.setData(sucessor);
				}
			}
		}
	}

}