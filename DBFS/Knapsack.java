package DBFS;

import java.util.Scanner;

public class Knapsack {

	private static int N, K;
	private static int[][] arr, res;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();
		
		arr = new int[N+1][2];
		for (int i = 1; i <= N; i++) {
			int w = sc.nextInt();
			int v = sc.nextInt();
			arr[i] = new int[] {w, v};
		}
		
		res = new int[N+1][K+1];
		
		System.out.println(DFS(N, K));
		sc.close();
	}
	
	private static int DFS(int idx, int k) {
		if (res[idx][k] != 0) return res[idx][k];
		
		if (idx == 0 || k <= 0) return res[idx][k]=0;
		else if (arr[idx][0] > k) return DFS(idx-1,k);
		else {
			int temp1 = DFS(idx-1, k-arr[idx][0]) + arr[idx][1];
			int temp2 = DFS(idx-1,k);
			return res[idx][k]=Math.max(temp1, temp2);
		}
	}
}
