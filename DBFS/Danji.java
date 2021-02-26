package dbfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Danji {

	private static int N,sum;
	private static int[] dr = {0,0,-1,1};
	private static int[] dc = {-1,1,0,0};
	private static int[][] map;
	private static boolean[][] visit;
	private static List<Integer> list = new ArrayList<>();
	private void Solution() {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j] && map[i][j] != 0) { // 방문한 게 아니고 단지가 있다면
					sum = 1;
					visit[i][j] = true;
					DFS(i,j);
					list.add(sum); // 집이 1개인 경우도 단지가 아니다.
				}
			}
		}
		
		Collections.sort(list);
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		sc.close();
	}
	
	private static int DFS(int i, int j) {
		
		int nr, nc;
		for (int d = 0; d < 4; d++) {
			nr = i + dr[d];
			nc = j + dc[d];
			if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
			if (map[nr][nc] == 0 || visit[nr][nc]) continue;
			sum++;
			visit[nr][nc] = true;
			DFS(nr, nc);
		}
		return sum;
	}
	
	public static void main(String[] args) {
		new Danji().Solution();
	}

}
