package example6;


public class Example6
{
	public static void main(String[] args) {
		
		Node root=new Node(8);
		root.left=new Node(1);
		root.left.right=new Node(1);
		root.left.left=new Node(2);
		root.right=new Node(1);
		root.right.left=new Node(1);
		root.right.left.right=new Node(1);
		root.left.left.right=new Node(1);
		System.out.println("Tree balanced : "+isTreeBalanced(root));
		
	}
	
	public static boolean isTreeBalanced(Node node)
	{
		if(node==null)
			return true;
		if(!isTreeBalanced(node.left))
			return false;
		
		if(!isTreeBalanced(node.right))
			return false;
		
		int leftSize=getSize(node.left);
		int rightSize=getSize(node.right);
		
		if(Math.abs(leftSize-rightSize)>1)
			return false;
		
		return true;
	}

	private static int getSize(Node node)
	{
		if(node==null)
			return 0;
		
		int leftSize =1+getSize(node.left);
		int rightSize = 1+getSize(node.right);
		
		return Math.max(leftSize, rightSize);
	}
}

class Node
{
	public int data;
	public Node left;
	public Node right;
	public Node(int data, Node left, Node right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}
	public Node(int data) {
		super();
		this.data = data;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	
	@Override
	public String toString()
	{
		return "Node : "+data;
	}
	
}