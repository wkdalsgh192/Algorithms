package dbfs;

import java.util.*;
import java.io.*;
public class BOJ_6593_SangBum {
	
	class Node {
		int l,r,c,cnt;
		boolean[][][] visit;
		public Node(int l, int r, int c, int cnt, boolean[][][] visit) {
			super();
			this.l = l;
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.visit = visit;
		}
	}
	
	private int L,R,C; // 층,행,열
	private int[] dl = {0,0,0,0,1,-1};
	private int[] dr = {0,0,1,-1,0,0};
	private int[] dc = {1,-1,0,0,0,0};
	private char[][][] bd;
	private Queue<Node> q;
	private void solution() throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			if (L == 0 && R == 0 && C == 0) break;
			
			bd = new char[L][R][C];
			q = new LinkedList<>();
			for (int k = 0; k < L; k++) {
				for (int i = 0; i < R; i++) {
					bd[k][i] = br.readLine().toCharArray();
					for (int j = 0; j < C; j++) {
						if (bd[k][i][j] == 'S') {
							boolean[][][] visit = new boolean[L][R][C];
							visit[k][i][j] = true;
							q.add(new Node(k,i,j,0,visit));
						}
					}
				}
				br.readLine(); // 빈 라인 제거
			}
			
			int min = Integer.MAX_VALUE;
			String answer = "Trapped!";
			while (!q.isEmpty()) {
				Node curr = q.poll();
				
				if (bd[curr.l][curr.r][curr.c] == 'E') {
					min = Math.min(min, curr.cnt);
					answer = "Escaped in "+curr.cnt+" minute(s).";
				}
				
				int nl,nr,nc;
				for (int i = 0; i < 6; i++) {
					nl = curr.l+dl[i];
					nr = curr.r+dr[i];
					nc = curr.c+dc[i];
					
					if (nl < 0 || nl >= L || nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
					if (curr.visit[nl][nr][nc] || bd[nl][nr][nc] == '#') continue;
					curr.visit[nl][nr][nc] = true;
					q.add(new Node(nl,nr,nc,curr.cnt+1,curr.visit));
				}
			}
			
			System.out.println(answer);
			
		}
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new BOJ_6593_SangBum().solution();
	}
}
