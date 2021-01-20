package bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Moon {

	private static int N, M, sr, sc, res=-1;
	private static int[] dr = {0,0,-1,1};
	private static int[] dc = {-1,1,0,0};	
	private static char[][] map;
	private static boolean[][][] visit;
	private void Solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		// 지도 만들기
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j); // char로 저장하기
				if (map[i][j] == '0') { // 출발 위치 저장하기
					sr = i;
					sc = j;
				}
			}
		}
		
		// 방문배열 만들고 BFS 호출하기
		visit = new boolean[1 << 6][N][M]; // 모든 열쇠를 다 가지고 있을 때만큼의 방문배열을 만들기
		BFS(sr,sc);
		// 결과 출력하기
		System.out.println(res);
	}
	
	private static void BFS(int sr, int sc) {
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {sr,sc,0,0});
		visit[0][sr][sc] = true;
		
		int r,c,keys,cnt;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			r = curr[0];
			c = curr[1];
			keys = curr[2];
			cnt = curr[3];
			
//			System.out.println(r+" "+c+" "+cnt+" "+keys);
			// 종료 요건
			if (map[r][c] == '1') {
				res = cnt;
				break;
			}
			// 사방 탐색
			int nr,nc;
			for (int i = 0; i < 4; i++) {
				nr = r + dr[i];
				nc = c + dc[i];
				
				if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				if (visit[keys][nr][nc] || map[nr][nc] == '#') continue;
				if (map[nr][nc] == '.' || map[nr][nc] == '0' || map[nr][nc] == '1') { // 갈 수 있는 곳인 경우
					q.add(new int[] {nr,nc,keys,cnt+1});
					visit[keys][nr][nc] = true;
				} else if (map[nr][nc] >= 'a' && map[nr][nc] <= 'f') { // 열쇠칸에 도달한 경우
					int idx = map[nr][nc] - 'a'; // 저장가능한 숫자로 바꿔주기
					int nkeys = (keys | 1<<idx);
					q.add(new int[] {nr,nc,nkeys,cnt+1});
					visit[keys][nr][nc] = true;
				} else if (map[nr][nc] >= 'A' && map[nr][nc] <= 'F') { // 문 칸에 도착한 경우
					int idx = map[nr][nc] - 'A';
					if (hasKey(keys, idx)) {
						q.add(new int[] {nr,nc,keys,cnt+1});
						visit[keys][nr][nc] = true;
					}
				}
				
			}
		}
	}
	private static boolean hasKey(int keys, int idx) {
		return (keys & 1 << idx) != 0 ? true : false;
	}
	public static void main(String[] args) throws IOException {
		new Moon().Solution();
	}

}
