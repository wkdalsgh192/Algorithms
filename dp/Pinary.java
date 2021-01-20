package dp;

import java.util.Scanner;

public class Pinary {

	private static int N;
	private static long[] arr;
	private void Solution() {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		arr = new long[N+1]; // 1부터 N까지의 배열 생성 - N자리의 이친수 갯수 저장
		System.out.println(DP(N));
		
		sc.close();
	}
	
	private static long DP(int n) {
		if (n == 1 || n == 2) return arr[n] = 1;
		if (arr[n] != 0) return arr[n];
		
		return arr[n] = DP(n-1) + DP(n-2);
	}
	public static void main(String[] args) {
		new Pinary().Solution();
	}
}
