package DBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BreakingWall {

	static class Node {
		int r;
		int c;
		int ch;
		int cnt;
		public Node(int r, int c, int ch, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.ch = ch;
			this.cnt = cnt;
		}
	}
	
	private static int N,M;
	private static int[] dr = {0,0,1,-1};
	private static int[] dc = {1,-1,0,0};
	private static int[][] map;
	private static Node start;
	private static boolean[][][] visit;
	private void Solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M+1];
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine().trim());
			String str = st.nextToken();
			for (int j = 1; j < M+1; j++) {
				map[i][j] = str.charAt(j-1) - '0';
			}
		}
		
//		for (int i = 1; i < N+1; i++) {
//			System.out.println();
//			for (int j = 1; j < M+1; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//		}
		
		start = new Node(1,1,1,1);
		
		visit = new boolean[N+1][M+1][2];
		// BFS 호출 구간
		int res = BFS(start);
		System.out.println(res);
		
		br.close();
	}
	private static int BFS(Node start) {
		Queue<Node> q = new LinkedList<>();
		
		q.add(start);
		visit[start.r][start.c][start.ch] = true;
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			
			if (curr.r == N && curr.c == M) return curr.cnt;
			
			for (int i = 0; i < 4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];
				
				if (nr <= 0 || nc <= 0 || nr > N || nc > M) continue;
				if (visit[nr][nc][curr.ch]) continue;
				if (map[nr][nc] == 1) {
					if (curr.ch > 0) {
						q.add(new Node(nr,nc,0,curr.cnt+1));
						visit[nr][nc][0] = true;
					} else continue;
				} else {
					q.add(new Node(nr,nc,curr.ch,curr.cnt+1));
					visit[nr][nc][curr.ch] = true;
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) throws IOException {
		new BreakingWall().Solution();
	}

}
