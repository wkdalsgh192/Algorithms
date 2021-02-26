package dbfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Virus {

	private static int N, M;
	private static boolean[] visit;
	private static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	private void Solution() {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); // 컴퓨터의 갯수
		M = sc.nextInt(); // 연결 쌍의 갯수
		
		// N+1개의 인접 리스트만들기 - 1부터 N까지로 만들기 위해
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		// 인접리스트 채우기
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		
		// 방문 배열 만들고 BFS 호출하기
		visit = new boolean[N+1];
		BFS(1);
		
		int sum = 0;
		for (int i = 2; i < visit.length; i++) sum += visit[i]?1:0;
		
		System.out.println(sum);
		sc.close();
	}
	private static void BFS(int idx) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(idx);
		
		while(!q.isEmpty()) {
			int num = q.poll();
			ArrayList<Integer> target = list.get(num);
			
			for (int i = 0; i < target.size(); i++) {
				if (visit[target.get(i)]) continue;
				q.add(target.get(i));
			}
			visit[num] = true;
		}
		
	}
	public static void main(String[] args) {
		new Virus().Solution();

	}

}
