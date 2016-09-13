package datastructure.tree;


public class TreeNode {

	public Object data;
	public TreeNode lChild;
	public TreeNode rChild;
	
	// 判断是否为叶子节点
	public boolean isLeaf() {
		return (lChild == null) && (rChild == null);
	}
}
