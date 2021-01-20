package DBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution8382_방향전환2 {

	static class Node {
		int x,y,dir,cnt;

		public Node(int x, int y, int dir, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cnt = cnt;
		}
	}
	
	private static int x1, y1, x2, y2;
	private static final int HOR = 0, VER = 1;
	private static int[][][] arr = {
			{{0,1}, {0,-1}},
			{{1,0}, {-1,0}}
	};
	
	private void Solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// 출발점과 시작점 받기
			x1 = Integer.parseInt(st.nextToken()) + 100;
			y1 = Integer.parseInt(st.nextToken()) + 100;
			x2 = Integer.parseInt(st.nextToken()) + 100;
			y2 = Integer.parseInt(st.nextToken()) + 100;
						
			System.out.println("#"+t+" "+BFS());
			
		}
	}
	private static int BFS() {
		Queue<Node> q = new LinkedList<>();
		boolean[][][] visit = new boolean[2][201][201];
		
		q.offer(new Node(x1,y1,HOR,0));
		visit[HOR][x1][y1] = true;
		q.offer(new Node(x1,y1,VER,0));
		visit[VER][x1][y1] = true;
		
		while (!q.isEmpty()) {
			Node curr = q.poll();
			
			if (curr.x == x2 && curr.y == y2) return curr.cnt;
			
			int[][] d = arr[curr.dir^1];
			
			int nx,ny;
			for (int i = 0; i < 2; i++) {
				nx = curr.x+d[i][0];
				ny = curr.y+d[i][1];
				
				if (nx >= 0 && ny >= 0 && nx <= 200 && ny <= 200 && !visit[curr.dir^1][nx][ny]) {
					q.offer(new Node(nx,ny,curr.dir^1,curr.cnt+1));
					visit[curr.dir^1][nx][ny] = true;
				}
			}
		}
		
		return 0;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Solution8382_방향전환2().Solution();
	}

}
