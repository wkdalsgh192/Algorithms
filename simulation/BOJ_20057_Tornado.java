package simulation;

import java.util.*;
import java.io.*;

public class BOJ_20057_Tornado {

	static int N,map[][],res;
	static int[] dr = {0,1,0,-1}; // 좌,하,우,상으로 좌표 갱신
	static int[] dc = {-1,0,1,0};
	static int[][][] sand = {
							{{-2,0},{-1,0},{-1,-1},{-1,1},{2,0},{1,0},{1,-1},{1,1},{0,-2},{0,-1}}, // 좌
							{{0,2},{0,1},{-1,1},{1,1},{0,-2},{0,-1},{-1,-1},{1,-1},{+2,0},{+1,0}}, // 하
							{{-2,0},{-1,0},{-1,-1},{-1,1},{2,0},{1,0},{1,-1},{1,1},{0,+2},{0,+1}}, // 우
							{{0,2},{0,1},{-1,1},{1,1},{0,-2},{0,-1},{-1,-1},{1,-1},{-2,0},{-1,0}}  // 상
							};
	static double[][] percent = {
								{0.02,0.07,0.1,0.01,0.02,0.07,0.1,0.01,0.05}, // 좌
								{0.02,0.07,0.01,0.1,0.02,0.07,0.01,0.1,0.05}, // 하
								{0.02,0.07,0.01,0.1,0.02,0.07,0.01,0.1,0.05}, // 우
								{0.02,0.07,0.1,0.01,0.02,0.07,0.1,0.01,0.05}, // 상
								};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1]; // 1,1부터 시작하도록 조정
		
		//맵 만들기
		StringTokenizer st;
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 토네이도 회전하기
		int dir = 0, step = 1;
		int sr = (N+1)/2, sc = (N+1)/2;
		outer:while(true) {
			// 두 번 이동
			for (int j = 0;j<4;j++) {
				for (int i = 0; i < step; i++) {
					if (sr == 1 && sc == 1) break outer; // 1,1에 도착해도 spread해야하나?
					sr+=dr[dir];
					sc+=dc[dir];
					// 모래 흩날리기
					if (map[sr][sc] > 0) spread(sr,sc,dir,map[sr][sc]);
//					System.out.println("--------------------");
//					for (int k = 1; k < N+1; k++) {
//						System.out.println();
//						for (int k2 = 1; k2 < N+1; k2++) {
//							System.out.print(map[k][k2]+" ");
//						}
//					}
//					System.out.println();
//					System.out.println(sr+" "+sc+" "+res);
				}
				dir = (dir+1)%4;
				if (j%2 == 1) step++;
			}
		}
		
		System.out.println(res);
		

				

	}
	static void spread(int r, int c, int dir, int qt) { // 입력 위치로 토네이도가 이동하고, 모래를 흩날린다.
		int nr=0, nc=0,movedSand=0,total=0;
		
		int len = sand[dir].length;
		for (int k = 0; k < len; k++) {
			nr = r + sand[dir][k][0];
			nc = c + sand[dir][k][1];
			
			if (k < len-1) {
				movedSand = (int) (qt * percent[dir][k]);
				total+=movedSand;
			} else {
				// 남은 모래 계산
				movedSand = qt - total;
			}
			
			// 격자 밖으로 벗어나면
			if (nr < 1 || nc < 1 || nr > N || nc > N) {
				res += movedSand;
				continue;
			}
			map[nr][nc] += movedSand;
		}
		map[r][c] = 0;
	}
}


