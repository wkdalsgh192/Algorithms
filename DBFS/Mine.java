package dbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Mine {

	static class Node {
		int i;
		int j;
		int cnt; // 몇 개를 터트릴 수 있는 지 저장
		public Node(int i, int j, int cnt) {
			super();
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}
	}
	
	private static int T,N;
	private static int[] dr = {-1,1,0,0,-1,-1,1,1};
	private static int[] dc = {-1,1,0,0,-1,1,-1,1};
	private static int[][] map;
	private static boolean[][] check;
	private static List<Node> list;
	private static Queue<int[]> q = new LinkedList<>();
	private void Solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			check = new boolean[N][N];
			
			// 지뢰 만들기
			for (int i = 0; i < N; i++) {
				char[] chars = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					int mine = chars[j]=='*'?-1:0;
					map[i][j] = mine;
				}
			}
			
			// 팡야팡야할 수 있는 리스트 만들기
			list = new ArrayList<>();
			
			
			
			
			
			
			System.out.println("#"+tc+" ");
		}
	}
	
	private static void BFS(int r, int c) {
		q.clear();
		
		q.add(new int[] {r,c});
		// 체크하기
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			// 해당 좌표 안에 지뢰가 있으면?
			
			// 좌표 안에 지뢰가 없으면?
			
			// 8방 탐색
			int nr, nc;
			for (int i = 0; i < 8; i++) {
				nr = r + dr[i];
				nc = c + dc[i];
				
				// 8방 안에 지뢰가 있으면 자기자신만 터진다.
				if (map[nr][nc] == -1) {
					list.add(new Node(r,c,1));
				}
				
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Mine().Solution();

	}

}
