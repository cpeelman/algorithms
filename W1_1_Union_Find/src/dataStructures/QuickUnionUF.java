package dataStructures;

import java.util.Properties;

public class QuickUnionUF implements UF {
	private int[] parent;
	private int count;

	public QuickUnionUF(Properties properties) {
		int n = Integer.valueOf(properties.getProperty("n"));
		parent = new int[n];
		count = n;
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
	}

	public void union(int p, int q) {
		parent[root(p)] = root(q);
		count--;
	}

	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}

	public int count() {
		return count;
	}

	public int root(int p) {
		while (p != parent[p])
			p = parent[p];
		return p;
	}
}