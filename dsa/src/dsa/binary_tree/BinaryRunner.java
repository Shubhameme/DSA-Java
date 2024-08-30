package dsa.binary_tree;

public class BinaryRunner {

	private TreeNode root;

	private class TreeNode {
		private TreeNode left;
		private TreeNode right;
		private int data;

		public TreeNode(int data) {
			this.data = data;
		}

	}

	public void createBinaryTree() {
		TreeNode first = new TreeNode(1);
		TreeNode second = new TreeNode(2);
		TreeNode third = new TreeNode(3);
		TreeNode fourth = new TreeNode(4);
		TreeNode fifth = new TreeNode(5);
		TreeNode sixth = new TreeNode(6);
		TreeNode seventh = new TreeNode(7);
		
		root = first;
		first.left = second;
		first.right = third;
		second.left = fourth;
		second.right = fifth;
		third.left = sixth;
		third.right= seventh;
	}
	
	 public void printTree(TreeNode node, String prefix, boolean isLeft) {
	        if (node != null) {
	            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.data);
	            printTree(node.left, prefix + (isLeft ? "│   " : "    "), true);
	            printTree(node.right, prefix + (isLeft ? "│   " : "    "), false);
	        }
	    }

	public static void main(String[] args) {
		 BinaryRunner tree = new BinaryRunner();
	        tree.createBinaryTree();
	        tree.printTree(tree.root, "", true);

	}

}
