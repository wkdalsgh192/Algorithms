package dp;

import java.util.Scanner;

public class Jump {

	private static int N;
	private static long[][] map1, map2;
	private void Solution() {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		map1 = new long[N][N];
		for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) map1[i][j] = sc.nextInt();
		
		map2 = new long[N][N];
		map2[0][0] = 1;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
				if (map2[i][j] != 0) {
					if (map1[i][j] == 0) continue;
					long move = map1[i][j];
					if (i+move < N) map2[(int) ((int) i+move)][j] += map2[i][j];
					if (j+move < N) map2[i][(int) ((int) j+move)] += map2[i][j];
				}
			}
		}
		
		System.out.println(map2[N-1][N-1]);
		sc.close();
	}
	public static void main(String[] args) {
		new Jump().Solution();
	}

}
