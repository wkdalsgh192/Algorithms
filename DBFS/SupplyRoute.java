package dbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SupplyRoute {

	static class Node {
		int r;
		int c;
		int cnt;
		public Node(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	
	private static int N, res;
	private static int[] dr = {0,0,1,-1};
	private static int[] dc = {1,-1,0,0};
	private static int[][] map;
	private static int[][] visit;
	private void Solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			// 맵 만들기
			map = new int[N][N];
			visit = new int[N][N];
			for (int i = 0; i < N; i++) {
				String str = new StringTokenizer(br.readLine()).nextToken();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
					visit[i][j] = Integer.MAX_VALUE;
					
				}
			}
			
			// BFS 출력하기
			res = Integer.MAX_VALUE;
			
			BFS(0,0,0);
			
			// 결과 출력하기
			System.out.println("#"+tc+" "+res);
		}
	}
	private static void BFS(int r, int c, int cnt) {
		Queue<Node> q = new LinkedList<>();
		
		visit[r][c] = 0;
		q.add(new Node(r,c,cnt));
		
		while (!q.isEmpty()) {
			Node curr = q.poll();
			
			if (curr.r == N-1 && curr.c == N-1) {
				if (res > curr.cnt) res = curr.cnt; 
			}
			
			for (int i = 0; i < 4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];
				
				if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				if (visit[nr][nc] > curr.cnt+map[nr][nc]) {
					q.add(new Node(nr, nc, curr.cnt+map[nr][nc]));
					visit[nr][nc] = curr.cnt+map[nr][nc];
				}
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		new SupplyRoute().Solution();
	}

}
