package onlinetest.didi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 图最短路径
 * TODO 未全部完成
4 4 10
1 0 0 1
1 1 1 1
0 1 1 1
0 0 1 1
 */
public class Main {

	public static int power;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n=0,m=0,p=0;
		if(scan.hasNextLine()) {
			n = scan.nextInt();
			m = scan.nextInt();
			p = scan.nextInt();
		}
		power = p;
		Graph graph = new Graph(n, m);
		for(int i = 0;i < n;i++) {
			for(int j = 0; j < m; j++) {
				graph.pass[i][j] = false;
				int temp = scan.nextInt();
				if (temp == 0)
					graph.edges[i][j] = false;
				else 
					graph.edges[i][j] = true;
			}
		}
		
		String route = "[0,0]";
		String result = getRoute(graph, 0, 0, power, route);
		if (result == null)
			System.out.println("Can not escape!");
		else {
			String[] resList = result.split(";");
			if (Integer.parseInt(resList[0]) >= 0)
				System.out.println(resList[1]);
			else 
				System.out.println("Can not escape!");
		}
	}
	
	public static String getRoute(Graph graph, int i, int j, int np, String route) {
		if (np < 0)
			return null;
		if (i == 0 && j == graph.maxM) {
			return np + ";" + route;
		}
		ArrayList<String> next = graph.next(i, j);
		int nextSize = next.size();
		if (nextSize <= 0) {
			return null;
		}
		graph.pass[i][j] = true;
		int minP = Integer.MIN_VALUE;
		String minRoute = null;
		for (String s : next) {
			String[] ss = s.split(",");
			int ii = Integer.parseInt(ss[0]);
			int jj = Integer.parseInt(ss[1]);
			int tempNp = np;
			if (ii > i) {
				//���ϣ����3
				tempNp -= 3;
			}
			if (jj != j) {
				tempNp -= 1;
			}
			
			String rr =  getRoute((Graph)graph.clone(), ii, jj, tempNp, route + ",[" + ii + "," + jj + "]");
			if (rr == null)
				continue;
			String[] rrs = rr.split(";");
			int rrsP = Integer.parseInt(rrs[0]);
			if (rrsP < 0)
				continue;
			if (rrsP > minP) {
				minRoute = rr;
				minP = rrsP;
			}
			System.out.println("-------------->" + rr);
		}
		System.out.println("-------------->" + minRoute);
		return minRoute;
	}
	
	public static class Graph implements Cloneable {
		
		public boolean[][] edges;
		public boolean[][] pass;
		public int maxN = 0, maxM = 0;
		public Graph(int n, int m) {
			this.maxN = n - 1;
			this.maxM = m - 1;
			edges = new boolean[n][m];
			pass = new boolean[n][m];
		}
		
		public void addEdge(int source, int target) {
			edges[source][target] = true;
		}
		
		
		public boolean isEdge(int source, int target) {
			return edges[source][target];
		}
		
		public ArrayList<String> next(int n, int m) {
			ArrayList<String> res = new ArrayList<String>();
			if (n > 0) {
				if (edges[n-1][m] && !pass[n-1][m])
					res.add((n-1) + "," + m);
			}
			if (n < maxN) {
				if (edges[n+1][m] && !pass[n+1][m])
					res.add((n+1) + "," + m);
			}
			if (m > 0) {
				if (edges[n][m-1] && !pass[n][m-1])
					res.add(n + "," + (m-1));
			}
			if (m < maxM) {
				if (edges[n][m+1] && !pass[n][m+1])
					res.add(n + "," + (m+1));
			}
			return res;
		}
		
		public Object clone() {
			Graph answer;
			try {
				answer = (Graph) super.clone();
			} catch (Exception e) {
				throw new RuntimeException("This class does not implement Cloneable");
			}
			
			answer.edges = (boolean[][]) edges.clone();
			answer.pass = (boolean[][]) pass.clone();
			
			return answer;
		}
		
	}
}
