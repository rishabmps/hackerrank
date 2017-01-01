/**
 * @author Rishabh Agarwal
 * https://www.hackerrank.com/challenges/the-quickest-way-up
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

	static class Vertex {
		public int v;
		public int d;

		public Vertex(int d, int v) {
			this.d = d;
			this.v = v;
		}

		public boolean equals(Object o) {
			Vertex m = (Vertex) o;
			return m.v == v;
		}
	}

	public static void djkstra(ArrayList<Integer>[] list, int s, int e) {
		int[] dist = new int[100];
		for (int i = 0; i < 100; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		PriorityQueue<Vertex> q = new PriorityQueue<Vertex>(new Comparator<Vertex>() {
			public int compare(Vertex v1, Vertex v2) {
				return v1.d - v2.d;
			}
		});

		q.add(new Vertex(0, 0));
		dist[0] = 0;

		ArrayList<Integer> l;
		Vertex temp;
		while (!q.isEmpty()) {
			temp = q.poll();
			int v = temp.v;
			l = list[v];
			for (Integer i : l) {
				if (dist[i] == Integer.MAX_VALUE) {
					dist[i] = temp.d + 1;
					q.add(new Vertex(dist[i], i));
				} else if (dist[i] > temp.d + 1) {
					q.remove(new Vertex(dist[i], i));

					dist[i] = temp.d + 1;

					q.add(new Vertex(dist[i], i));
				}
			}
		}
		System.out.println(dist[99] != Integer.MAX_VALUE ? dist[99] : -1);
	}

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner in = new Scanner(System.in);
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] list = new ArrayList[100];
		int t = in.nextInt();
		int n, m, x, y;

		while (t > 0) {
			for (int i = 0; i < 100; i++) {
				list[i] = new ArrayList<Integer>();
				for (int j = 1; j <= 6; j++) {
					if (i + j <= 99) {
						list[i].add(i + j);
					}
				}
			}
			n = in.nextInt();

			while (n > 0) {
				x = in.nextInt();
				y = in.nextInt();
				list[x - 1].clear();
				for (int i = x - 1 - 6; i < x - 1; i++) {
					if (i >= 0 && list[i].size() != 0) {
						list[i].remove(x - 1 - i - 1);
						list[i].add(y - 1);
					}
				}
				n--;
			}
			m = in.nextInt();
			while (m > 0) {
				x = in.nextInt();
				y = in.nextInt();
				list[x - 1].clear();
				for (int i = x - 1 - 6; i < x - 1; i++) {
					if (i >= 0 && list[i].size() != 0) {
						list[i].remove(x - 1 - i - 1);
						list[i].add(y - 1);
					}
				}

				m--;
			}
			djkstra(list, 0, 100);
			t--;
		}
		in.close();
	}
}
