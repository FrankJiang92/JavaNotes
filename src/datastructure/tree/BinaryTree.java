package datastructure.tree;

import java.util.Scanner;

public class BinaryTree {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		
		Scanner scan = new Scanner(System.in);
		TreeNode treeNode = new TreeNode();
		treeNode.data = "jiangfan";
		tree.setData(treeNode, "jiangfan");
//		tree.createBinaryTree(treeNode, scan);
		System.out.println("====================");
//		tree.PreOrderTraverse(treeNode);
	}
	
	public void createBinaryTree(TreeNode node, Scanner scan) {
		String data = scan.next();
		
		if (data.equals(";"))
			return;
		
		if (data.equals("#")) {
			node = null;
			System.out.println("---->" + node);
		} else {
//			TreeNode newnode = new TreeNode();
//			newnode.data = data;
//			node = newnode;
			node.data = data;
			node.lChild = new TreeNode();
			createBinaryTree(node.lChild, scan);
			node.rChild = new TreeNode();
			createBinaryTree(node.rChild, scan);
		}
	}
	
	public void PreOrderTraverse(TreeNode node) {
		if (node == null)
			return ;
		System.out.println(node.data);
		PreOrderTraverse(node.lChild);
		PreOrderTraverse(node.rChild);
	}
	
	public void setData(TreeNode node, Object data) {
//		node = new TreeNode();
// 		node.data = data;
		node = null;
	}
	
}
