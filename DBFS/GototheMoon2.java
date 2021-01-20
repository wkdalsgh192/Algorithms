package DBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class GototheMoon2 {

	static class State {
		int r;
		int c;
		int keySet;
		int cnt;
		
		public State(int r, int c, int keySet, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.keySet = keySet;
			this.cnt = cnt;
		}
		
		boolean containsKey(int key) {
			if (keySet % (key*2) / key == 1) return true;
			return false;
		}
		
	}
	
	private static int N, M;
	private static int sr, sc;
	private static int minCnt = Integer.MAX_VALUE;
	private static int[] dr = {0,0,1,-1};
	private static int[] dc = {1,-1,0,0};
	private final int[] key = {1, 2, 4, 8, 16, 32};
	private static char[][] maze;
	private static boolean[][][] visit;
	private void Solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		// 맵을 만들자
		maze = new char[N][M];
		visit = new boolean[N][M][64];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				maze[i][j] = str.charAt(j);
				if (maze[i][j] == '0') {
					sr = i;
					sc = j;
				}
			}
		}
		
		Queue<State> q = new LinkedList<>();
		q.add(new State(sr, sc, 0, 0));
		visit[sr][sc][0] = true;
		
		while(!q.isEmpty()) {
			State stat = q.poll();
			
			int r = stat.r;
			int c = stat.c;
			int keySet = stat.keySet;
			int cnt = stat.cnt;
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				
				int curr = maze[nr][nc];
				
				// 열쇠 있는 칸에 도착한 경우
				if (curr >= 'a' && curr <= 'f') {
					curr -= 'a';
					// 열쇠세트를 복사하고
					int nKey = keySet;
					// 열쇠를 가지고 있는 지 확인한다음, 없으면 새 열쇠세트에 결과값을 더해준다
					if (!stat.containsKey(key[curr])) nKey += key[curr];
					if (!visit[nr][nc][nKey]) {
						visit[nr][nc][nKey] = true;
						// 새 열쇠세트를 저장한다.
						q.add(new State(nr, nc, nKey, cnt+1));
					}
				}
					
				// 문에 있는 칸에 도착한 경우
				else if (curr >= 'A' && curr <= 'F') {
					curr -= 'A';
					if (!stat.containsKey(key[curr])) continue;
					else if (!visit[nr][nc][keySet]) {
						visit[nr][nc][keySet] = true;
						// 열쇠세트 값에 변화가 없으므로 그냥 넣어준다.
						q.add(new State(nr, nc, keySet, cnt+1));
					}
				}
				
				else if (curr == '.' || curr == '0') {
					if (!visit[nr][nc][keySet]) {
						visit[nr][nc][keySet] = true;
						q.add(new State(nr, nc, keySet, cnt+1));
					}
				}
				
				else if (curr == '#') continue;
				
				else if (curr == '1') {
					// 최소값을 찾는다.
					if (minCnt > cnt+1) minCnt = cnt+1;
				}
			}
		}
		
		if (minCnt == Integer.MAX_VALUE) minCnt = -1;
		System.out.println(minCnt);
		
		br.close();
		
		
	}
	public static void main(String[] args) throws IOException {
		new GototheMoon2().Solution();

	}

}
