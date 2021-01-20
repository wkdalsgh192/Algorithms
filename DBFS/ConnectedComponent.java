package DBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ConnectedComponent {

	private static int N, M, res;
	private static boolean[] visit;
	private static List<ArrayList<Integer>> list = new ArrayList<>();
	private void Solution() {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		for (int i = 0; i < N+1; i++) list.add(new ArrayList<>());
		
		for (int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			list.get(u).add(v);
			list.get(v).add(u);
		}
		
		visit = new boolean[N+1];
		for (int i = 1; i < N+1; i++) {
			if (!visit[i]) {
				BFS(i);
				res++;
			}
		}
		
		System.out.println(res);
		sc.close();
		
	}
	private static void BFS(int start) {
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 0; i < list.get(start).size(); i++) q.add(list.get(start).get(i));
		visit[start] = true;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			if (!visit[curr]) {
				for (int i = 0; i < list.get(curr).size(); i++) {
					q.add(list.get(curr).get(i));
				}
				visit[curr] = true;
			}
		}
	}
	public static void main(String[] args) {
		new ConnectedComponent().Solution();
	}
}
