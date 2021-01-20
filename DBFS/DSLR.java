package DBFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DSLR {

	static class Node {
		int n;
		String str;
		
		public Node(int n, String str) {
			super();
			this.n = n;
			this.str = str;
		}
	}
	private static int T, A, B;
	private static boolean[] visit;
	private void Solution() {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int tc = 0; tc < T; tc++) {
			A = sc.nextInt(); // 시작점
			B = sc.nextInt(); // 목표점
			
			// DSLR 호출하기
			visit = new boolean[10000];
			String res = BFS(A, B);
			
			// 결과 출력
			System.out.println(res);
		}
		sc.close();
	}
	private static String BFS(int a, int b) {
		// 큐 생성
		String res = null;
		Queue<Node> q = new LinkedList<>();
		
		// 큐에다가 시작 점 클래스 형태로 집어넣기
		q.add(new Node(a, ""));
		visit[a] = true;
		// BFS 탐색 시작
		while(!q.isEmpty()) {
			Node curr = q.poll();
			
			if (curr.n == b) return res = curr.str;
			
			int D = (2*curr.n) % 10000;
			int S = (curr.n == 0) ? 9999:curr.n-1;
			int L = (curr.n % 1000)*10 + curr.n/1000;
			int R = (curr.n % 10) * 1000 + curr.n / 10;
			// 만약 안했다면 DSLR 순으로 반복해서 처리하기
			if (!visit[D]) {
				q.add(new Node(D, curr.str+'D'));
				visit[D] = true;
			}
			if (!visit[S]) {
				q.add(new Node(S, curr.str+'S'));
				visit[S] = true;
			}
			if (!visit[L]) {
				q.add(new Node(L, curr.str+'L'));
				visit[L] = true;
			}
			if (!visit[R]) {
				q.add(new Node(R, curr.str+'R'));
				visit[R] = true;
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		new DSLR().Solution();

	}

}
