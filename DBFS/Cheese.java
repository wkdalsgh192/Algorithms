package DBFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Cheese {

	static class Node {
		int r;
		int c;
		
		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	private static int N, M, total, left, time;
	private static int[] dr = {0,0,1,-1};
	private static int[] dc = {1,-1,0,0};
	private static int[][] map;
	private static boolean[][] visit;
	private void Solution() {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		// 치츠 만들기
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1) total++;
			}
		} 
		
		// 방문 체크 배열 만들고, BFS 구현하기
		visit = new boolean[N][M];
		
		
		
		while (true) {
			BFS(0,0);
			time++;
			
			boolean flag = true;
			left = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] != 0) {
						flag = false;
						left++;
					}
				}
			}
			
			if (flag) break;
			visit = new boolean[N][M];
			total = left;
			
		}
		
		// 답 출력하기
		System.out.println(time);
		System.out.println(total);
		
		sc.close();
		
	}
	
	private static void BFS(int r, int c) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0,0));
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			
			// 총 걸린시간 및 해당 시간에 남은 갯수 세기
			
			// 사방 탐색해서 녹을 치즈 갱신하기
			for (int i = 0; i < 4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];
				
				if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				if (visit[nr][nc]) continue;
				
				if (map[nr][nc] == 0) {
					q.add(new Node(nr,nc));
					visit[nr][nc] = true;
				} else {
					map[nr][nc] = 0;
					visit[nr][nc] = true;
				}	
			}
		}
	}
	
	public static void main(String[] args) {
		new Cheese().Solution();
	}
}

