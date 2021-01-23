package simulation;

import java.util.*;
import java.io.*;
public class BOJ_15864_Ladder {

	static int N,M,H,a,b,answer,ladder[][];
	static boolean finish;
	static StringTokenizer st;
	static List<int[]> list;
	private static void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 주어지는 가로선 갯수
		H = Integer.parseInt(st.nextToken()); // 가로
		
		// 사다리 만들기
		ladder = new int[H+1][N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			ladder[a][b] = 1; // 오른쪽으로 가는 방향
			ladder[a][b+1] = 2; // 왼쪽으로 가는 방향
		}
		
		// 사다리 놓을 수 있는 곳 확인
		
		for (int i = 0; i < 4; i++) {
			answer = i;
			dfs(1,0);
			if (finish) break;
		}
		
		
		System.out.println(finish ? answer : -1);
	}
	private static void dfs(int x, int cnt) {
		
		if (finish) return;
		if (answer == cnt) {
			if (check()) finish = true;
			return;
		}
		
		// 모든 가로선 중 limit 갯수를 놓을 수 있는 경우의 수를 탐색
		for (int i = x; i < H+1; i++) {
			for (int j = 1; j < N; j++) {
				if (ladder[i][j] == 0 && ladder[i][j+1] == 0) {
					ladder[i][j] = 1;
					ladder[i][j+1] = 2;
					dfs(i,cnt+1);
					ladder[i][j]=ladder[i][j+1]=0;
				}
			}
			
		}
	}
	private static boolean check() {
		for (int i = 1; i <= N; i++) {
			int x = 1, y = i;
			for (int j = 0; j < H; j++) {
				if (ladder[x][y] == 1) y++;
				else if (ladder[x][y] == 2) y--;
				x++;
			}
			if (y != i) return false;
		}
		return true;
	}
	public static void main(String[] args) throws IOException {
		new BOJ_15864_Ladder();
		BOJ_15864_Ladder.solution();
	}

}
