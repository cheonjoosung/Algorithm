package etc.dataStructure;

public class BinarySearchTree {
	private TreeNode root;

	private class TreeNode {
		private int data;
		private TreeNode left, right;

		public TreeNode(int data) {
			this.data = data;
			this.right = null;
			this.left = null;
		}

		public int getData() { return this.data; }
	}

	public TreeNode insertKey(TreeNode root, int data) {
		TreeNode p = root;
		TreeNode newNode = new TreeNode(data);

		if(p == null) return newNode;
		else if(p.data > newNode.getData()) {
			p.left = insertKey(p.left, data);
			return p;
		} else if(p.data < newNode.getData()){
			p.right = insertKey(p.right, data);
			return p;
		}  else {
			return p;
		}
	}

	public void insertBST(int data) { 
		if(root == null) root = new TreeNode(data);
		else insertKey(root, data); 
	}

	public TreeNode searchBST(int data) {
		TreeNode p = root;

		while(p != null) {
			if(data < p.getData() ) p = p.left;
			else if(data > p.getData() ) p = p.right;
			else return p;
		}

		return p;
	}

	public void inOrder(TreeNode root) { //left -> root -> right
		if(root != null) {
			inOrder(root.left);
			System.out.println(root.getData() + " ");
			inOrder(root.right);
		}
	}

	public void preOrder(TreeNode root) { // root -> left -> right
		if(root != null) {
			System.out.println(root.getData());
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	public void postOrder(TreeNode root) { // left -> right -> root
		if(root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.println(root.getData());
		}
	}

	public void print() { 
		inOrder(root); System.out.println();
		preOrder(root); System.out.println();
		postOrder(root);
	}
}
