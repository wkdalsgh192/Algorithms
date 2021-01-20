package dp;

import java.util.Scanner;

public class OneTwoThree {

	private static int T, N;
	private static int[] arr;
	private void Solution() {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			N = sc.nextInt();
			
			arr = new int[N+1];
			for (int j = 1; j <= N; j++) {
				if (j == 1) arr[j] = 1;
				else if (j == 2) arr[j] = 2;
				else if (j == 3) arr[j] = 4;
				else arr[j] = arr[j-1]+arr[j-2]+arr[j-3];
			}
			
			System.out.println(arr[N]);
			
		}
		sc.close();
		
	}
	public static void main(String[] args) {
		new OneTwoThree().Solution();
	}

}
