package bitmask;

import java.util.Scanner;

public class Tile2 {

	private static int[][] dp;
	private void Solution() {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		dp = new int[N+1][6];
		
		System.out.println(f(N,0));
//		int n = sc.nextInt();
//		for(int i=0;i<n;i++){
//		 int temp = sc.nextInt();
//		 System.out.println(f(temp,0));
//		}
	}
	private static int f(int n, int cur) { // n은 구해야 되는 열의 크기, curr은 현재 열의 상태
		if (n < 0) return 0;
//		if (n < 0 || n == 1 && cur == 6) return 0;
		if (n == 0) return 1;
		if (dp[n][cur] != 0) return dp[n][cur];
		
		int ret = 0;
		switch(cur) {
		case 0:
			ret += f(n-2, 0);
			ret += f(n-4, 0);
			ret += f(n-2, 1);
			ret += f(n-2, 4);
			break;
		case 1:
			ret += f(n-2, 0);
			ret += f(n-2, 3);
			ret += f(n-2, 5);
			break;
		case 3:
			ret += f(n-2, 0);
			ret += f(n-2, 4);
			break;
		case 4:
			ret += f(n-2, 0);
			ret += f(n-2, 3);
			ret += f(n-2, 5);
			break;
		case 5:
			ret += f(n-2, 0);
			ret += f(n-2, 1);
			break;
		}
		
		return dp[n][cur] = ret;
	}
	public static void main(String[] args) {
		new Tile2().Solution();
	}

}
