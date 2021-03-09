package simulation;

import java.io.*;
import java.util.*;

import simulation.SWEA_10761_Trust.Pair;

public class SWEA_2105_Dessert {
	private static int T,N,ans;
	private static int[][] dir = {{1,1},{1,-1},{-1,-1},{-1,1}};
	private static int[][] map;
	private static boolean[][] visited;
	private static HashSet<Integer> set;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			ans = -1;
			
			// 모든 좌표에 대하여 집어넣기
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N-2; i++) {
				for (int j = 1; j < N-1; j++) {
					visited = new boolean[N][N];
					set = new HashSet<>();
					visited[i][j] = true;
					set.add(map[i][j]);
					tour(i,j,i,j,0); // 시작 방향을 지정한다.
				}
			}
			System.out.println("#"+t+" "+ans);
		}
	}
	private static void tour(int r,int c,int sr,int sc,int curve) {
		int nr,nc;
		for (int d = curve; d < 4; d++) {
			nr = r + dir[d][0];
			nc = c + dir[d][1];
			
			if (set.size() >= 3 && nr == sr && nc == sc) {
				ans = Math.max(ans, set.size());
				return;
			}
			
			if (nr<0||nr>=N||nc<0||nc>=N) continue;
			if (visited[nr][nc]||set.contains(map[nr][nc])) continue;
			
			visited[nr][nc] = true;
			set.add(map[nr][nc]);
			tour(nr,nc,sr,sc,d);
			visited[nr][nc] = false; // for-loop 내에서 계속 도니까 이미 지나갔던 것들은 다시 지워줘야한다.
			set.remove(map[nr][nc]);
		}
		
		
	}

}
