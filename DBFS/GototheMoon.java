package dbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class GototheMoon {

	static class Minsik {
		int r;
		int c;
		int cnt;
		char key; // 찾은 열쇠
		int[] keys; // 열쇠의 배열
		
		// 열쇠 칸을 지나갈 때
		public Minsik(int r, int c, int cnt, int[] keys) {
			super();
			this.r = r;
			this.c = c;
			this.cnt=cnt;
			this.keys = keys;
		}
	}
	
	private static int N,M, res;
	private static int[] dr = {0,0,1,-1};
	private static int[] dc = {1,-1,0,0};
	private static int[] start;
	private static char[][] map;
	private static boolean[][][] visit;
	private void Solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		start = new int[2];
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine(), " ");
			char[] arr = str.nextToken().toCharArray();
			for (int j = 0; j < arr.length; j++) {
				map[i][j] = arr[j];
				if (map[i][j] == '0') start = new int[] {i,j};
			}
		}
		
		for (int i = 0; i < N; i++) {
			System.out.println();
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]+" ");
			}
		}
		System.out.println();
		
		visit = new boolean[N][M][9]; // 가지고 있는 키의 갯수
		BFS(start[0], start[1], 0);
		
		System.out.println(res);
		
	}
	
	private static void BFS(int r, int c, int cnt) {
		Queue<Minsik> q = new LinkedList<>();
		
		int[] keys = new int[6];
		q.add(new Minsik(r,c,cnt,keys));
		visit[r][c][0] = true;
		
		while(!q.isEmpty()) {
			Minsik minsik = q.poll();
			
//			System.out.println();
//			for (int i : minsik.keys) System.out.print(i);
			
			int keyCnt = getLength(minsik.keys);
			
			System.out.println(minsik.r+" "+minsik.c+" "+minsik.cnt+" "+keyCnt);
			
			// 종료요건
			if (map[minsik.r][minsik.c] == '1') {
				res = minsik.cnt;
				break;
			}
			
			
			int nr,nc;
			for (int i = 0; i < 4; i++) {
				nr = minsik.r + dr[i];
				nc = minsik.c + dc[i];
				
				if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				if (visit[nr][nc][keyCnt] || map[nr][nc] == '#') continue;
				
				// 열쇠가 있는 칸인 경우
				if (map[nr][nc] >= 'a' && map[nr][nc] <= 'f') {
					if (hasKey(map[nr][nc], minsik.keys)) visit[nr][nc][keyCnt] = true;
					else {
						minsik.keys[map[nr][nc] - 'a'] = 1;
						int[] new_keys = minsik.keys;
						q.add(new Minsik(nr,nc,minsik.cnt+1,new_keys));
						visit[nr][nc][keyCnt+1] = true;
					}
					
				}
				else if (map[nr][nc] >= 'A' && map[nr][nc] <= 'F') {
					for (int j = 0; j < minsik.keys.length; j++) {
						if (minsik.keys[j] != 0 && Character.toLowerCase(map[nr][nc]) == j+'a') {
							q.add(new Minsik(nr,nc,minsik.cnt+1, minsik.keys));
							visit[nr][nc][keyCnt] = true;
							break;
						}
					}
				}
				// 빈 칸인 경우
				else {
					q.add(new Minsik(nr,nc,minsik.cnt+1, minsik.keys));
					visit[nr][nc][keyCnt]= true;
				}
			}
			
		}
		
	}
	private static boolean hasKey(char key, int[] keys) {
		
		for (int i = 0; i < keys.length; i++) {
			if (keys[i] != 0 && key == (i+'a')) return true;
		}
		
		return false;
	}
	private static int getLength(int[] keys) {
		
		int sum = 0;
		for (int i = 0; i < keys.length; i++) {
			if (keys[i] != 0) sum++;
		}
		return sum;
	}
	
	public static void main(String[] args) throws IOException {
		new GototheMoon().Solution();

	}

}
