package com.dataStructures.avltree.verifier;

import com.dataStructures.avltree.AVLTree;
import com.dataStructures.avltree.AVLTreeImpl;
import com.dataStructures.binarySearchTree.BSTNode;
import com.dataStructures.binarySearchTree.verifier.BSTVerifierImpl;

/**
 * Performs consistency validations within a AVL Tree instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeVerifierImpl<T extends Comparable<T>> extends BSTVerifierImpl<T> implements AVLTreeVerifier<T> {

	private AVLTreeImpl<T> avlTree;

	public AVLTreeVerifierImpl(AVLTree<T> avlTree) {
		super(avlTree);
		this.avlTree = (AVLTreeImpl<T>) avlTree;
	}

	@SuppressWarnings("unused")
	private AVLTreeImpl<T> getAVLTree() {
		return avlTree;
	}

	@Override
	public boolean isAVLTree () {
		return this.isBST() && this.isAVL();
	}

	private boolean isAVL () {
		return this.avlTree.isEmpty() || this.isAVLRecursive(this.avlTree.getRoot());
	}

	private boolean isAVLRecursive (BSTNode<T> currentNode) {
		boolean resp = true;

		if (!currentNode.isEmpty()) {
			if (Math.abs(this.avlTree.calculateBalance(currentNode)) <= 1) {
				resp = this.isAVLRecursive((BSTNode<T>) currentNode.getLeft())
						&& this.isAVLRecursive((BSTNode<T>) currentNode.getRight());
			} else {
				resp = false;
			}
		}
		return resp;
	}

}