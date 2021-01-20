package simulation;

import java.util.*;

public class Snail {
	static int N, idx;
	static int[] dr = new int[] {1,0,-1,0}; // 하,우,상,좌
	static int[] dc = new int[] {0,1,0,-1};
	static void solution2() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		idx = sc.nextInt();
		
		int cnt = 1, dir = 0, step = 1;
		int[][] arr = new int[N][N];
		int[] ans = new int[2];
		
		dr = new int[] {-1,0,1,0}; // 상,우,하,좌
		dc = new int[] {0,1,0,-1};
		
		int nr = N/2, nc = N/2;
		outer:while(true) {
			// 두 번 이동
			for (int j = 0;j<4;j++) {
				for (int i = 0; i < step; i++) {
					arr[nr][nc] = cnt++; // 채우기
					if (nr == 0 && nc == 0) break outer;
					nr+=dr[dir];
					nc+=dc[dir];
				}
				dir = (dir+1)%4;
				if (j%2 == 1) step++;
			}
		}

		// 정답 출력하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == idx) ans = new int[] {i+1,j+1};
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println(ans[0]+" "+ans[1]);
		
		sc.close();
		
	}
	static void solution() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		idx = sc.nextInt();
		
		
		int cnt = N*N, dir = 0;
		int[][] arr = new int[N][N];
		int[] ans = new int[2];
		
		// 새 좌표 설정
		int nr=0,nc=0;
		for(int i=0;i<N*N;i++) {
			arr[nr][nc] = cnt--;
			if (arr[nr][nc] == idx) ans = new int[] {nr+1,nc+1};
			nr += dr[dir];
			nc += dc[dir];
			if (nr < 0 || nc < 0 || nr >= N || nc >= N || arr[nr][nc] != 0) {
				nr -= dr[dir];
				nc -= dc[dir];
				dir = (dir+1)%4;
				nr += dr[dir];
				nc += dc[dir];
			}
		}
		
		// 정답 출력하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println(ans[0]+" "+ans[1]);
		
		sc.close();
	}
	public static void main(String[] args) {
		new Snail().solution2();
	}

}
