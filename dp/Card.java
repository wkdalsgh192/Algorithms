package dp;

import java.util.Scanner;

public class Card {
	
	private static int N;
	private static int[] arr, res;
	private void Solution() {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new int[N+1];
		res = new int[N+1];
		
		
		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 1개의 카드를 뽑을 때부터, N개의 카드를 뽑을 때까지의 최댓값을 구해보면
		for (int i = 1; i <= N; i++) {
			// 1개의 카드부터 i개의 카드까지 추가로 뽑는 경우의 수를 비교한다
			for (int j = 1; j <= i; j++) {
				// 비교 대상, j를 돌면서 
				res[i] = Math.max(res[i], res[i-j]+arr[j]);
			}
		}
		
		System.out.println(res[N]);
//		System.out.println(DP(4,4));
		sc.close();
	}
	
//	private static int DP(int idx, int k) { // idx : 현재 카드덱, k : 남은 카드의 갯수 수
//		int res=0;
//		// 고를 수 있는 카드덱이 없거나, 카드를 모두 골랐다면 마지막에는 0을 반환한다.
//		if (idx == 0 || k == 0) return 0;
//		// 현재 카드덱이 남은 카드의 갯수보다 큰 경우 다음 카드덱으로 넘어간다.
//		if (idx > k) DP(idx-1,k);
//		else {
//			// 현재 카드덱을 쓰고, 또 쓴다.
//			int temp1 = arr[idx] + DP(idx,k-idx);
//			// 현재 카드덱을 쓰고, 다음 카드덱으로 넘어간다.
//			int temp2 = arr[idx] + DP(idx-1, k-idx);
//			// 현재 카드덱을 안 쓰고, 다음 카드덱으로 넘어간다.
//			int temp3 = DP(idx-1,k);
//			res = Math.max(temp1, Math.max(temp2, temp3));
//		}
//		return res;
//		
//	}
	public static void main(String[] args) {
		new Card().Solution();

	}

}
