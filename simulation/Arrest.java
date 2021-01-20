package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Arrest {

	static class Node {
		int posR;
		int posC;
		boolean ok;
		
		public Node(int posR, int posC, boolean ok) {
			super();
			this.posR = posR;
			this.posC = posC;
			this.ok = ok;
		}
	}
	private static int T, N, M, sr, sc, hour;
	private static int[] dr = {-1,1,0,0,0}; // 상, 하, 좌, 우, 움직이지 않음으로 표시
	private static int[] dc = {0,0,-1,1,0};
	private static int[][] map;
	private static boolean[][] check;
	private void Solution() throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 터널의 세로 크기
			M = Integer.parseInt(st.nextToken()); // 터널 가로 크기
			sr = Integer.parseInt(st.nextToken()); // 멘홀의 r 좌표
			sc = Integer.parseInt(st.nextToken()); // 멘홀 c 좌표
			hour = Integer.parseInt(st.nextToken()); // 검거에 소요된 시간
			
			// 맵 만들기
			map = new int[N][M];
			check = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 큐를 이용해 로직 설계
			Queue<int[]> q = new LinkedList<>();
			
			q.add(new int[] {sr,sc,1});
			check[sr][sc] = true;
			
			while(!q.isEmpty()) {
				// 현재 도둑놈의 위치 꺼내기
				int[] curr = q.poll();
				
				int posR = curr[0];
				int posC = curr[1];
				int H = curr[2];
				
//				System.out.println(posR+" "+posC);
				
				if (H < hour) { // 경과된 시간이 도달할 때까지의 모든 가능 경로만 계산해야 한다.
					List<Node> list = Reachable(posR, posC);
					for (int i = 0; i < list.size(); i++) {
						Node next = list.get(i);
						// 이미 방문했거나, 옮겨갈 좌표에 연결된 파이프가 없다면 통과
						if (check[next.posR][next.posC] || map[next.posR][next.posC] == 0) continue;
						if (next.ok) {
							q.add(new int[] {next.posR, next.posC, H+1});
							check[next.posR][next.posC] = true;
						}
					}
				}
			}
			
			int res = 0;
			for (boolean[] row : check) for (boolean b : row) if (b) res++;
			
//			for (int i = 0; i < N; i++) {
//				System.out.println();
//				for (int j = 0; j < M; j++) {
//					int k = check[i][j]? 1:0;
//					System.out.print(k+" ");
//				}
//			}
			System.out.println("#"+tc+" "+res);
		}
		
	}
	
	private static List<Node> Reachable(int posR, int posC) {
		List<Node> list = new ArrayList<>();
		
		int[] dirs = GetDirection(new int[] {posR, posC});
		
		for (int i = 0; i < dirs.length; i++) {
			int[] newPos = GetLocation(posR, posC, dirs[i]);
			if (newPos == null) continue;
			
			int newR = newPos[0];
			int newC = newPos[1];
			
			if (newR < 0 || newC < 0 || newR >= N || newC >= M) continue;
			
			int[] opDir = GetDirection(newPos);
			for (int j = 0; j < opDir.length; j++) {
				int temp = dirs[i] + (dirs[i]%2==0?1:-1);
				if (dirs[i] >= 4 || opDir[j] >= 4) break;
				
				if (temp == opDir[j]) list.add(new Node(newPos[0], newPos[1], true));
			}
				
		}
		
		return list;
	}
	
	private static int[] GetDirection(int[] pos) {
		int[] dirs;
		switch (map[pos[0]][pos[1]]) {
		case 1 :
			dirs = new int[] {0,1,2,3};
			break;
		case 2 :
			dirs = new int[] {0,1,4,4};
			break;
		case 3 :
			dirs = new int[] {2,3,4,4};
			break;
		case 4 :
			dirs = new int[] {0,3,4,4};
			break;
		case 5 :
			dirs = new int[] {1,3,4,4};
			break;
		case 6 :
			dirs = new int[] {1,2,4,4};
			break;
		case 7 :
			dirs = new int[] {0,2,4,4};
			break;
		default :
			dirs = new int[] {4,4,4,4};
			break;
		}
		
		return dirs;
	}
	
	private static int[] GetLocation(int posR, int posC, int dir) {
		
		int[] newPos;
		
		int nr = posR + dr[dir];
		int nc = posC + dc[dir];
		
		if (nr < 0 || nc < 0 || nr >= N || nc >= M) return null;
		
		return newPos = new int[] {nr, nc};
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Arrest().Solution();
	}

}
