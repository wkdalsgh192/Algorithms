package bitmask;

import java.util.Scanner;

public class Tile {

	private static int N;
	private static int[] map;
	private void Solution() {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		map = new int[N+1]; // 0부터 N까지

		map[0] = 1;
		for (int i = 1; i <= N; i++) {
			if ((i & 1) == 1) continue;
			for (int j = 0; j <= i; j+=2) {
				if (j==2) map[i] += map[i-j]*3;
				else map[i] += map[i-j]*2;
			}
		}
		
		System.out.println(map[N]);
		sc.close();
	}
	public static void main(String[] args) {
		new Tile().Solution();
	}
}
