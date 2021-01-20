package DBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Kevin {
	
	static class Node {
		int to;
		int cnt;
		public Node(int to, int cnt) {
			super();
			this.to = to;
			this.cnt = cnt;
		}
	}

	private static int N, M;
	private static int[][] arr;
	private static List<ArrayList<Integer>> list = new ArrayList<>(); 
	private void Solution() {
		// 입출력받기
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); // 유저의 수
		M = sc.nextInt(); // 친구 관계의 수
		
		// 인접리스트 만들기
		for (int i = 0; i < N+1; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		//인접리스트에 집어넣기
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		// BFS로 케빈 베이컨 구하기
		arr = new int[N+1][N+1]; // 1부터 N까지의 배열 만들기
		for (int i = 1; i < N+1; i++) {
			BFS(i);
		}
		// 케빈 베이컨 계산하기
		int[] sum = new int[N+1];
		for (int i = 1; i < N+1; i++) {
			for (int j = 0; j < N+1; j++) {
				sum[i] += arr[i][j];
			}
		}
		
//		for (int i = 0; i < N+1; i++) {
//			System.out.println();
//			for (int j = 0; j < N+1; j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//		}
		
		// 최솟값 찾기
		int idx = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < N+1; i++) {
			if (min > sum[i]) {
				min = sum[i];
				idx = i;
			}
		}
		
		System.out.println(idx);
		sc.close();
	}
	private static void BFS(int start) {
		Queue<Node> q = new LinkedList<>();
		
		// 시작점과 연결된 노드 구하기
		// 자기 자신을 제외한 노드 넣기
		for (int i = 0; i < list.get(start).size(); i++) {
			q.add(new Node(list.get(start).get(i), 1));
		}
		
		while (!q.isEmpty()) {
			Node curr = q.poll();
			
			// 연결점이 자기 자신이 아니고, 0인 경우 - 배열 채우기, 연결점 추가하기
			if (start != curr.to && arr[start][curr.to] == 0) {
				arr[start][curr.to] = curr.cnt;
				for (int i = 0; i < list.get(curr.to).size(); i++) {
					q.add(new Node(list.get(curr.to).get(i), curr.cnt+1));
				}
			}
			// 0이 아닌 경우 - 이미 거쳐갔던 연결점이므로 탐색하지 않는다.
		}
		
	}
	
	public static void main(String[] args) {
		new Kevin().Solution();

	}

}
