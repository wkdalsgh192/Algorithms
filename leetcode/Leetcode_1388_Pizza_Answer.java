package leetcode;
import java.util.*;
public class Leetcode_1388_Pizza_Answer {
	public int maxSizeSlices(int[] slices) {
		int m = slices.length, n = m / 3;
		int[] slices1 = Arrays.copyOfRange(slices, 0, m-1); // 원형 배열을 선형 배열로 바꾸면 맨 마지막을 선택하지 않는 경우와
		int[] slices2 = Arrays.copyOfRange(slices, 1, m); // 맨 처음을 선택하지 않는 경우로 나뉜다.
		return Math.max(maxSum(slices1, n), maxSum(slices2, n));
	}

	int maxSum(int[] arr, int n) { // max sum when pick `n` non-adjacent elements from `arr`
		int m = arr.length;
		int[][] dp = new int[m+1][n+1]; 
		// Case j = 0 (pick 0 elements): dp[i][0] = 0
		// Case i = 0 (array is empty): dp[0][j] = 0
		for (int i = 1; i <= m; ++i) { // m개 중에
			for (int j = 1; j <= n; ++j) { // n개를 뽑는다.
				if (i == 1) {
					dp[i][j] = arr[0]; // 1개 중에 1개를 뽑는다.
				} else {
					dp[i][j] = Math.max( // i개 중에 j개를 뽑을 때 최댓값은
						dp[i-1][j],             // i번째를 뽑지 않고 j개를 뽑는 경우의 최댓값과
						dp[i-2][j-1] + arr[i-1] // i번째를 뽑고(arr은 0부터 시작이므로 i-1를 뽑음, i-2개 중에 j-1개를 뽑는 경우를 비굫
					);
				}
			}
		}
		return dp[m][n]; // for-loop 순회가 끝나면 m개 중에 n개를 뽑는 최댓값이 저장된다.
	}
}
