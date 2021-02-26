package dbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * 
 * @author taeheekim
 *
 */
// 다익스트라 + priority queue
public class SupplyRoute2 {

	static int N = 0, INF = Integer.MAX_VALUE;
	static int map[][], minTime[][];
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static PriorityQueue<int[]> queue;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());

		for (int t = 1; t <= TC; ++t) {
			N = Integer.parseInt(in.readLine());
			map = new int[N][N];
			minTime = new int[N][N];
			visited = new boolean[N][N];
			queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[2] - o2[2];
				}
			});

			for(int i=0; i<N; ++i) {
				char[] ch = in.readLine().toCharArray();
				for(int j=0; j<N; ++j) {
					map[i][j] = ch[j] - '0';
					minTime[i][j] = INF;
				}
			}
			
			System.out.println("#"+t+" "+dijkstra(0, 0));
		}
	}

	private static int dijkstra(int startX, int startY) {

		minTime[startX][startY] = 0;
		queue.offer(new int[] { startX, startY, minTime[startX][startY] });

		int r, c, cost, nr, nc, current[];
		while (true) {
			current = queue.poll();
			r = current[0];
			c = current[1];
			cost = current[2];

			if(visited[r][c]) continue; // 이미 처리된 정점이면 다음으로 
			visited[r][c] =true; // 아니면 방문 처리 
			if (r == N - 1 && c == N - 1) return cost; // 도착점이면 끝냄  

			
			for (int d = 0; d < 4; ++d) {
				nr = r + dr[d];
				nc = c + dc[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N 
						&& !visited[nr][nc] && minTime[nr][nc] > cost + map[nr][nc]) {
					minTime[nr][nc] = cost + map[nr][nc];
					queue.offer(new int[] { nr, nc, minTime[nr][nc] });
				}
			}
		}
	}

}