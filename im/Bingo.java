package im;

import java.util.Scanner;

public class Bingo {

	private static int N;
	private static int[] arr;
	private static int[][] map;
	private void Solution() {
		Scanner sc = new Scanner(System.in);
		
		//5줄 빙고판 만들기
		N = 5;
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		// 사회자가 부를 빙고판 만들기
		arr = new int[N*N];
		for (int i = 0; i < N*N; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 사회자가 숫자를 한 개씩 부릅니다
		int k = 0;
		outer:for (k = 0; k < arr.length; k++) {
			int num = arr[k];
			// 사회자가 부른 숫자를 내 빙고판에서 처리하기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == num) map[i][j] = 0; // 맞힌 숫자를 0으로 처리하기
					
					// 빙고판이 완성되기 위해서는 최소 10개 이상의 숫자가 불려져야 한다. 
					if (k > 10) {
						// 동시에 빙고판에 완성된 줄의 갯수가 3개 이상이면 for loop를 종료한다.
						if (bingoCheck(i, j) >= 3) break outer;
					}	
				}
			}
		}
		
		System.out.println(k+1);
		sc.close();
	}
	
	// 주어진 좌표를 기준으로 몇 개의 빙고줄이 완성되어있는 지를  확인하는 함수
	private static int bingoCheck(int r, int c) {
		int cnt = 0;
		
		// 가로 줄 , 세로 줄이 완성되어있는 지 확인
		for (int i = 0; i < N; i++) {
			boolean flag = false;
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0) flag = true;
			}
			if (!flag) cnt++;
			
			flag = false;
			for (int j = 0; j < N; j++) {
				if (map[j][i] != 0) flag = true;
			}
			if (!flag) cnt++; 
		}
		
		// 대각선이 완성되어있는 지 확인
		if (map[0][0] == 0 && map[1][1] == 0 && map[2][2] == 0 && map[3][3] == 0 && map[4][4] == 0) cnt++;
		if (map[0][4] == 0 && map[1][3] == 0 && map[2][2] == 0 && map[3][1] == 0 && map[4][0] == 0) cnt++;
		return cnt;
	}
	public static void main(String[] args) {
		new Bingo().Solution();
	}

}
