package com.avltree.avltree;

import com.avltree.bst.BSTNode;
import com.avltree.bt.UtilRotation;

import java.util.*;

public class AVLCountAndFillImpl<T extends Comparable<T>> extends AVLTreeImpl<T> implements AVLCountAndFill<T> {

	private int LLcounter;
	private int LRcounter;
	private int RRcounter;
	private int RLcounter;

	public AVLCountAndFillImpl() {
		this.LLcounter = 0;
		this.LRcounter = 0;
		this.RRcounter = 0;
		this.RLcounter = 0;
	}

	@Override
	public int LLcount() {
		return LLcounter;
	}

	@Override
	public int LRcount() {
		return LRcounter;
	}

	@Override
	public int RRcount() {
		return RRcounter;
	}

	@Override
	public int RLcount() {
		return RLcounter;
	}

	@Override
	protected void rebalance (BSTNode<T> node) {
		BSTNode<T> newRoot = null;
		int balance = this.calculateBalance(node);

		if (Math.abs(balance) > 1) {
			if (balance > 1) {
				if (this.calculateBalance((BSTNode<T>) node.getLeft()) >= 0) {
					newRoot = UtilRotation.rightRotation(node);
					this.LLcounter++;
				} else {
					newRoot = UtilRotation.doubleRightRotation(node);
					this.LRcounter++;
				}
			} else {
				if (this.calculateBalance((BSTNode<T>) node.getRight()) <= 0) {
					newRoot = UtilRotation.leftRotation(node);
					this.RRcounter++;
				} else {
					newRoot = UtilRotation.doubleLeftRotation(node);
					this.RLcounter++;
				}
			}
		}
		if (this.getRoot().equals(node) && newRoot != null) {
			this.root = newRoot;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void fillWithoutRebalance(T[] array) {
		Set<T> treeSet = new TreeSet<>(Arrays.asList(this.order()));
		treeSet.addAll(Arrays.asList(array));
		array = (T[]) treeSet.toArray(new Comparable[0]);
		this.root = new BSTNode<>();

		int height = 0;
		while (avlIterate(array, 0, array.length, height)) {
			height++;
		}
	}

	private boolean avlIterate (T[] array, int left, int right, int height) {
		boolean result = false;

		if (right > left) {
			int middle = left + (right - left) / 2;

			if (height == 0) {
				this.insert(array[middle]);
				result = true;
			} else {
				boolean result1 = avlIterate(array, left, middle, height - 1);
				boolean result2 = avlIterate(array, middle + 1, right, height - 1);

				result = result1 || result2;
			}
		}
		return result;
	}

}