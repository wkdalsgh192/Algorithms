package dp;

import java.util.Scanner;

public class Tile {

	private static int N;
	private static int[] arr;
	private void Solution() {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		arr = new int[N+1]; // 0부터 N까지
		
		System.out.println(DP(N));
	}
	private static int DP(int idx) {
		if (idx % 2 != 0) return arr[idx] = 0;
		if (idx == 0) return arr[0] = 1;
		if (idx == 2) return arr[2] = 3;
		if (arr[idx] != 0) return arr[idx];
		
		for (int i = 2; i <= idx; i+=2) {
			if (i == 2) arr[idx] += DP(idx-i)*3;
			else arr[idx] += DP(idx-i)*2;
		}
		return arr[idx];
	}
	public static void main(String[] args) {
		new Tile().Solution();

	}

}
