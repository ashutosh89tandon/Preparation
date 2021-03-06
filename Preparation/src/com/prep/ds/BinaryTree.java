package com.prep.ds;

public class BinaryTree<T> implements Cloneable
{
	private T data;
	private T summedValue;
	private BinaryTree<T> left;
	private BinaryTree<T> right;
	private BinaryTree<T> next;
	private int level;
	private int arrayIndex;
	private int count;
	private BinaryTree<T> parent;
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public BinaryTree(T data, int level) {
		super();
		this.data = data;
		this.level=level;
	}
	
	public BinaryTree(T data) {
		super();
		this.data = data;
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public BinaryTree<T> getLeft() {
		return left;
	}
	public void setLeft(BinaryTree<T> left) {
		this.left = left;
	}
	public BinaryTree<T> getRight() {
		return right;
	}
	public void setRight(BinaryTree<T> right) {
		this.right = right;
	}
	@Override
	public String toString() {
		return "BinaryTree [data=" + data + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		result = prime * result + ((right == null) ? 0 : right.hashCode());
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BinaryTree<T> other = (BinaryTree<T>) obj;
		if (data != other.data)
			return false;
		if (left == null) {
			if (other.left != null)
				return false;
		} else if (!left.equals(other.left))
			return false;
		if (right == null) {
			if (other.right != null)
				return false;
		} else if (!right.equals(other.right))
			return false;
		return true;
	}
	public int getArrayIndex() {
		return arrayIndex;
	}
	public void setArrayIndex(int arrayIndex) {
		this.arrayIndex = arrayIndex;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public BinaryTree<T> getParent() {
		return parent;
	}
	public void setParent(BinaryTree<T> parent) {
		this.parent = parent;
	}
	
	@Override
	public Object clone()
	{
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public T getSummedValue() {
		return summedValue;
	}
	public void setSummedValue(T summedValue) {
		this.summedValue = summedValue;
	}
	public BinaryTree<T> getNext() {
		return next;
	}
	public void setNext(BinaryTree<T> next) {
		this.next = next;
	}
	
}
