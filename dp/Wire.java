package dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Wire {

	private void Solution() {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] dp = new int[N+1]; // 처음부터 각 전봇대까지 설치할 수 있는 최대 전봇대 갯수를 담는 배열
		int[][] arr = new int[N+1][2]; // 전봇대 전깃줄 연결정보 담기
		
		// 전봇대 저장하기
		for (int i = 1; i <= N; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			
			arr[i] = new int[] {s, e};
		}
		
		// A 전봇대를 기준으로 정렬
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
			
		for (int i = 1; i <= N; i++) {
			dp[i] = 1; // i번째 전봇대를 설치할 수 있는 최소 갯수
			for (int j = 1; j < i; j++) { // 겹치는 지 여부 확인하기
				
				// 만약 i번째 B 전봇대의 가 j번째  B 전봇대보다 아래에 있으면 설치 가능 
				// -> i번째 전봇대까지의 최대 설치가능한 전봇대 계수 = dp[j]번째 전봇대까지의 최대 갯수 +1 or 기존 dp[i] 중 최댓값 
				if (arr[i][1] > arr[j][1]) dp[i] = Math.max(dp[i], dp[j]+1);
			}
		}
		
		// 최대 설치가능한 전봇대 갯수 구하기
		int max = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, dp[i]);
		}
		
		// 전체 개수 - 설치 가능한 전깃줄 = 최소 철거 개수
		System.out.println(N-max);
		
	}
	public static void main(String[] args) {
		new Wire().Solution();
	}

}
