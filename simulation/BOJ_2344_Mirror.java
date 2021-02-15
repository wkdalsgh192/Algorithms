package simulation;
import java.util.*;
import java.io.*;
public class BOJ_2344_Mirror {
	static class Point{
		int r,c,dir;
		public Point(int r, int c, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}
	private static int N,M,map[][];
	private static int[] dr = {-1,1,0,0};
	private static int[] dc = {0,0,-1,1};
	private static StringTokenizer st;
	private static Queue<Point> q;
	private static List<Integer> list;
	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 지도 만들기
		map = new int[N+2][M+2]; // 제로 패딩하기
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 제로 패딩하면서 좌표 저장
//		q = new LinkedList<>();
//		for (int i = 1; i <= N; i++) {
//			map[i][0] = i;
//			map[N+1-i][M+1] = M+N+i;
//			q.add(new Point(i,0,3));
//			q.add(new Point(N+1-i,M+1,2));
//		}
//		for (int i = 1; i <= M; i++) {
//			map[N+1][i] = N+i;
//			map[0][M+1-i] = M+2*N+i;
//			q.add(new Point(N+1,i,0));
//			q.add(new Point(0,M+1-i,1));
//		}
		int idx = 1;
		q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			map[i][0] = idx++;
			q.add(new Point(i,0,3));
		}
		for (int i = 1; i <= M; i++) {
			map[N+1][i] = idx++;
			q.add(new Point(N+1,i,0));
		}
		for (int i = N; i > 0; i--) {
			map[i][M+1] = idx++;
			q.add(new Point(i,M+1,2));
		}
		for (int i = M; i > 0; i--) {
			map[0][i] = idx++;
			q.add(new Point(0,i,1));
		}
		
		// 큐 하나씩 빼기
		list = new ArrayList<>();
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			int nr=p.r,nc=p.c,dir=p.dir;
			while (true) {
				nr += dr[dir];
				nc += dc[dir];
				
				if (nr < 1 || nc < 1 || nr >= N+1 || nc >= M+1) {
					list.add(map[nr][nc]);
					break;
				}
				if (map[nr][nc] == 1) dir = 3-dir;
			}
		}
		
		for (int i : list) System.out.print(i+" ");
		System.out.println();
		return;	
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new BOJ_2344_Mirror().solution();
	}
}
