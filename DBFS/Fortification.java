package DBFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Fortification {

	private static int M,N,cnt;
	private static int[] dr = {+1,0,-1,0};
	private static int[] dc = {0,+1,0,-1};	
	private static int[][] map, seg;
	private static boolean[][] visit;
	private static List<Integer> list;
	private void Solution() {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); // 세로 열
		M = sc.nextInt(); // 가로 열
		
		
		// 성곽 만들기
		map = new int[M][N];
		for (int i = 0; i < M; i++) for (int j = 0; j < N; j++) map[i][j] = sc.nextInt();
		
		// 방문 배열 만들고 DFS 호출 구간 만들기
		int idx = 0; // 각 방을 칠할 순서 만들기
		seg = new int[M][N];
		visit = new boolean[M][N];
		list = new ArrayList<>();
		
		// 성에 있는 방의 갯수 구하기
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (visit[i][j]) continue;
				cnt = 1;
				DFS(i,j, idx++);
				list.add(cnt);
			}
		}
		
		// 가장 넓은 방의 크기 구하기
		int roomMax = 0;
		for (int i : list) roomMax = Math.max(roomMax, i);
		
		
		// 하나의 벽을 제거해 얻을 수 있는 가장 넓은 방의 크기 구하기
		int max = 0;
		dr = new int[] {0, -1};
		dc = new int[] {1, 0};
		for (int r = 0; r < M; r++) {
			for (int c = 0; c < N; c++) {
				for (int d = 0; d < 2; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					if (nr < 0 || nc < 0 || nr >= M || nc >= N) continue;
					if (seg[r][c] != seg[nr][nc]) max = Math.max(max, list.get(seg[r][c])+ list.get(seg[nr][nc]));
				}
			}
			
		}
		
		
		System.out.println(list.size());
		System.out.println(roomMax);
		System.out.println(max);
		sc.close();
	}
	private static void DFS(int r, int c, int k) {
		
		// 방문 체크 및 방의 순서 표시
		visit[r][c] = true;
		seg[r][c] = k;
		
		// 원래 수를 4자리 이진수 배열로 변환하기
		char[] bin = Integer.toBinaryString(map[r][c]).toCharArray();
		int[] arr = new int[4];
		Arrays.fill(arr, 0);
		int idx = 0;
		for (int i = 4-bin.length; i < arr.length; i++) {
			arr[i] = Character.getNumericValue(bin[idx]);
			idx++;
		}
		
		for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if (nr < 0 || nc < 0 || nr >= M || nc >= N) continue;
				// 성곽이 있거나 이미 방문했던 곳은 방문할 수 없다.
				if (arr[i] == 1 || visit[nr][nc]) continue;
				cnt++;
				DFS(nr,nc, k);			
		}
	}
	public static void main(String[] args) {
		new Fortification().Solution();

	}

}
