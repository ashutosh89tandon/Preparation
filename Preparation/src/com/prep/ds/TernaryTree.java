package com.prep.ds;

public class TernaryTree<T> {
	private T data;
	private TernaryTree<T> left;
	private TernaryTree<T> right;
	private TernaryTree<T> middle;
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public TernaryTree<T> getLeft() {
		return left;
	}
	public void setLeft(TernaryTree<T> left) {
		this.left = left;
	}
	public TernaryTree<T> getRight() {
		return right;
	}
	public void setRight(TernaryTree<T> right) {
		this.right = right;
	}
	public TernaryTree<T> getMiddle() {
		return middle;
	}
	public void setMiddle(TernaryTree<T> middle) {
		this.middle = middle;
	}
	public TernaryTree(T data) {
		super();
		this.data = data;
	}
	@Override
	public String toString() {
		return "TernaryTree [data=" + data + "]";
	}
	
	
}
