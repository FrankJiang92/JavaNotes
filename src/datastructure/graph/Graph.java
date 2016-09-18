package datastructure.graph;

public class Graph implements Cloneable {
	
	/*
	 * Graph类的不变式
	 * 1. 顶点编号从0到labels.length - 1
	 * 2. 对于每个编号i，labels[i]包含顶点i的标签
	 * 3. 对于任何两个顶点i和j,如果包含从i到j的边，则edges[i][j]为true，否则为false
	 */
	private boolean[][] edges;
	private Object[] labels;
	
	public Graph(int n) {
		edges = new boolean[n][n];
		labels = new Object[n];
	}
	
	public void addEdge(int source, int target) {
		edges[source][target] = true;
	}
	
	public Object getLabel(int vertex) {
		return labels[vertex];
	}
	
	public boolean isEdge(int source, int target) {
		return edges[source][target];
	}
	
	public int[] neighbors(int vertex) {
		int i;
		int count;
		int[] answer;
		
		count = 0;
		for (i = 0; i < labels.length; i++) {
			if (edges[vertex][i])
				count++;
		}
		
		answer = new int[count];
		count = 0;
		for (i = 0; i < labels.length; i++) {
			if (edges[vertex][i])
				answer[count++] = i;
		}
		return answer;
	}
	
	public void removeEdge(int source, int target) {
		edges[source][target] = false;
	}
	
	public void setLabel(int vertex, Object newLabel) {
		labels[vertex] = newLabel;
	}
	
	public int size() {
		return labels.length;
	}
	
	public Object clone() {
		Graph answer;
		try {
			answer = (Graph) super.clone();
		} catch (Exception e) {
			throw new RuntimeException("This class does not implement Cloneable");
		}
		
		answer.edges = (boolean[][]) edges.clone();
		answer.labels = (Object[]) labels.clone();
		
		return answer;
	}
	
}
