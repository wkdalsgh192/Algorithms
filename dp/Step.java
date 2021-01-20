package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step {
	
	
	private static int N, max;
	private static int[] steps, arr;
	private void Solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 계단의 수
		
		steps = new int[N+1];
		for (int i = 1; i <= N; i++) steps[i] = Integer.parseInt(br.readLine());
		
		// 각 단계의 최댓값을 저장할 배열 만들기
		arr = new int[N+1];
		arr[1] = steps[1];
		if (N >= 2) arr[2] = steps[1]+steps[2];
		for (int i = 3; i <= N; i++) {
			arr[i] = Math.max(steps[i]+steps[i-1]+arr[i-3], steps[i]+arr[i-2]);
		}
		System.out.println(arr[N]);
	}
	private static void Recursive(int n, int sum, int cnt) { // n: 다음 계단, sum : 다음 계단을 오를 때 예상 합계, cnt: 다음 계단 포함 연속으로 오른 계단 수
		// 종료 요건
		if (cnt == 3) return; // 연속된 세계의 계단을 넘을 수 없다.
		if (n > N) return; // 마지막 계단을 밟지 않으면 강제 종료
		// 최종 도착지에 도달하면
		if (n == N) {
			max = Math.max(max, sum);
			return;
		}
		
		// 출력 및 재귀 파트
		// 계단을 하나 오를 때
		Recursive(n+1, sum+steps[n+1], cnt+1);
		Recursive(n+2, sum+steps[n+1], 1);
	}
//	private static int DP(int n, int cnt) { // n: 다음 계단, sum : 다음 계단을 오를 때 예상 합계, cnt: 다음 계단 포함 연속으로 오른 계단 수
//		// 종료 요건
//		if (cnt == 3) return 0; // 연속된 세계의 계단을 넘을 수 없다.
//		if (n > N) return 0; // 마지막 계단을 밟지 않으면 강제 종료
//		if (n == N) return
//		// 최종 도착지에 도달하면
//		
//	
//		if (n+2 > N) return 0;
//		arr[n][n+1] = arr[n][n+1] == 0?DP(n+1, cnt+1): arr[n][n+1];
//		arr[n][n+2] = arr[n][n+2] == 0?DP(n+2, 1): arr[n][n+2];
//		
//		return arr[n][N] = Math.max(arr[n][n+1], arr[n][n+2]);
//	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Step().Solution();
	}

}
