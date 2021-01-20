package DBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Puzzle {

	static class Node {
		int r;
		int c;
		int cnt;
		int prev;
		public Node(int r, int c, int cnt, int prev) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.prev = prev;
		}
	}
	
	private static int res=-1;
	private static int min=Integer.MAX_VALUE;
	private static int[] dr = {-1,1,0,0};
	private static int[] dc = {0,0,-1,1};	
	private static int[][] map, answer;
	private static boolean[][] check;
	private void Solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt=0;
		int[] init = null;
		map = new int[3][3];
		answer = new int[3][3];
		check = new boolean[3][3];
		for (int i = 0; i < 3; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < 3; j++) {
				map[i][j] = str[j].charAt(0) - '0';
				if (map[i][j] == 0) init = new int[] {i,j};
				answer[i][j] = cnt+1==9?0:++cnt;
			}
		}
		
		// 처음 제자리에 있는 수 확인하기
		for (int i = 0; i < 3; i++) for (int j = 0; j < 3; j++) if (map[i][j] == answer[i][j]) check[i][j] = true;
		
		// DFS 탐색하기
		DFS(new Node(init[0], init[1], 0, 0));
		System.out.println(res);
	}
	
	private static void DFS(Node curr) {
		
		if (curr.r == 2 && curr.c == 2) {
			for (int i = 0; i < 3; i++) for (int j = 0; j < 3; j++) if (map[i][j] != answer[i][j]) return;
			min = Math.min(min, curr.cnt);
			res = min;
			return; 
		} else if (curr.cnt > 110) return; 

		
		for (int i = 0; i < 4; i++) {
			int nr = curr.r+dr[i];
			int nc = curr.c+dc[i];
			
			if (nr < 0 || nc < 0 || nr >= 3 || nc >= 3) continue; // 경계 체크
			if (curr.prev == map[nr][nc] || check[nr][nc]) continue; // 직전에 옮겼거나 제 자리에 있는 수는 건들지 않는다.
			
			// 변경된 맵 조정하기
			int temp = map[nr][nc];
			map[curr.r][curr.c] = temp;
			if (map[curr.r][curr.c] == answer[curr.r][curr.c]) check[curr.r][curr.c] = true;
			map[nr][nc] = 0;
			
			// 다음 이동 항목 찾기
			DFS(new Node(nr,nc,curr.cnt+1,temp));
			
			// 맵 변경 되돌리기
			map[nr][nc] = temp;
			check[curr.r][curr.c] = false;
			map[curr.r][curr.c] = temp;	
		}
		
	}
	public static void main(String[] args) throws IOException {
		new Puzzle().Solution();
	}

}
