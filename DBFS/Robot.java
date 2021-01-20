package DBFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Robot {

	static class Node {
		int r;
		int c;
		int k;
		int cnt;
		public Node(int r, int c, int k, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.k = k;
			this.cnt = cnt;
		}
	}
	private static int M, N, res;
	private static int[] dir = {0,1,2,3,4};	
	private static int[] dr = {0,0,0,1,-1};	
	private static int[] dc = {0,1,-1,0,0};	
	private static int[][] map;
	private static boolean[][][] visit;
	private static Node start, end;
	private static Node[] nodes;
	public void Solution() {
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt(); // r
		N = sc.nextInt(); // c
		
		// 맵 만들기
		map = new int[M+1][N+1];
		for (int i = 1; i < M+1; i++) for (int j = 1; j < N+1; j++) map[i][j] = sc.nextInt();
		
		// 출발지와 도착지 만들기
		nodes = new Node[2];
		for (int i = 0; i < 2; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int k = sc.nextInt();
			nodes[i] = new Node(r,c,k,0);
		}
		
		start = nodes[0];
		end = nodes[1];
		
		// 방문 배열만들고 BFS 호출하기
		visit = new boolean[M+1][N+1][5];
		
		// 정답 출력하기
		res = BFS(start);
		
		System.out.println(res);
		sc.close();
		
	}
	public static int BFS(Node start) {
		// 초기 설정 -  큐 만들기, 첫 좌표 집어 넣기, 방문체크
		int res = 0;
		Queue<Node> q = new LinkedList<>();
		
		q.add(start);
		visit[start.r][start.c][start.k] = true;

		// BFS 탐색
		while(!q.isEmpty()) {
			Node curr = q.poll();
			
			// 종료 요건
			if (curr.r == end.r && curr.c == end.c && curr.k == end.k) {
				return res=curr.cnt;
			}
			
			// 탐색 요건
			// 명령어 1 수행
			for (int i = 1; i <= 3; i++) {
				int nr = curr.r + dr[curr.k]*i;
				int nc = curr.c + dc[curr.k]*i;
				
				if (nr < 1 || nc < 1 || nr >= M+1 || nc >= N+1) continue;
				if (map[nr][nc] == 1) break;
				if (!visit[nr][nc][curr.k]) {
					q.add(new Node(nr,nc,curr.k,curr.cnt+1));
					visit[nr][nc][curr.k] = true;
				}
			}
			
			// 명령어 2 수행
			for (int i = 1; i <= 4; i++) {
				// 자기자신의 방향이 아니고, 해당 방향으로 방향 전환한 적이 없으면
				if (i != curr.k && !visit[curr.r][curr.c][i]) {
					int turn = 1;
					switch (curr.k) {
					case 1: if (i == 2) turn++;
							break;
					case 2: if (i == 1) turn++;
							break;
					case 3: if (i == 4) turn++;
							break;
					case 4: if (i == 3) turn++;
							break;
					}
					q.add(new Node(curr.r, curr.c, i, curr.cnt+turn));
					visit[curr.r][curr.c][i] = true;
				}
			}
			
		}
		
		return res;
	}
	public static void main(String[] args) {
		new Robot().Solution();
	}

}
