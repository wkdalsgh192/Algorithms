package dbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution8382_방향전환 {

	static int x1,y1,x2,y2;
	static final int HOR=0, VER=1; // 0000==>0001, 0001==>0000 -> n^1 사용
	
	static int[][][] dir = {
			{{-1,0},{1,0}},//hor : 0
			{{0,-1},{0,1}}//ver : 1
	};
	
	public static class Point{
		int x,y,d,cnt;

		public Point(int x, int y, int d, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			
			// 좌표에 100씩 더해서 음수좌표 보정
			x1 = Integer.parseInt(st.nextToken()) + 100;
			y1 = Integer.parseInt(st.nextToken()) + 100;
			x2 = Integer.parseInt(st.nextToken()) + 100;
			y2 = Integer.parseInt(st.nextToken()) + 100;
			
			System.out.println("#"+t+" "+bfs());
		}
	}
	
	private static int bfs() {
		
		Queue<Point> queue = new LinkedList<Point>();
		boolean[][][] visited = new boolean[2][201][201];
		
		visited[HOR][x1][y1] = true;
		queue.offer(new Point(x1,y1, HOR, 0));
		visited[VER][x1][y1] = true;
		queue.offer(new Point(x1,y1,VER, 0));
		
		Point cur;
		int nx,ny;
		while(!queue.isEmpty()) {
			cur = queue.poll();
			
			if (cur.x == x2 && cur.y == y2) return cur.cnt;
			
			int[][] d = dir[cur.d^1];
			
			for (int i = 0; i < 2; i++) {
				nx = cur.x + d[i][0];
				ny = cur.y + d[i][1];
				
				if (nx>=0 && nx <= 200 && ny>=0 && ny<= 200 && !visited[cur.d^1][nx][ny]) {
					visited[cur.d^1][nx][ny] = true;
					queue.offer(new Point(nx,ny,cur.d^1, cur.cnt+1));
				}
			}
			
//			if (cur.d == HOR) {
//				// 세로이동 처리
//				nx = cur.x;
//				ny = cur.y-1;
//				if (ny>=0 && !visited[VER][nx][ny]) { // 경계 체크 및 세로모드에서 이동한 적이 업는 경우
//					visited[VER][nx][ny] = true;
//					queue.offer(new Point(nx, ny, VER, cur.cnt+1));
//				}
//				
//				ny = cur.y+1;
//				if (ny<=200 && !visited[VER][nx][ny]) { // 경계 체크 및 세로모드에서 이동한 적이 업는 경우
//					visited[VER][nx][ny] = true;
//					queue.offer(new Point(nx, ny, VER, cur.cnt+1));
//				}
//				
//			} else {
//				//가로이동 처리
//				nx = cur.x-1;
//				ny = cur.y;
//				if (nx>=0 && !visited[HOR][nx][ny]) {
//					visited[HOR][nx][ny] = true;
//					queue.offer(new Point(nx, ny, HOR, cur.cnt+1));
//				}
//				
//				nx = cur.x+1;
//				if (nx<=200 && !visited[HOR][nx][ny]) {
//					visited[HOR][nx][ny] = true;
//					queue.offer(new Point(nx, ny, HOR, cur.cnt+1));
//				}
//				
//			}
		}
		return 0;
	}

}
