package dp;

import java.util.Scanner;

public class Hide {

	private static int N, K;
	private static int[] arr;
	private void Solution() {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); // 언니의 위치
		K = sc.nextInt(); // 동생의 위치
		
		// N에 도달하는 가장 빠른 시간을 저장
		arr = new int[100000+1];

		// DP 출력 구간
		System.out.println(arr[K]);
		
//		System.out.println(arr[K]);
		sc.close();
	}
	
	
	public static void main(String[] args) {
		new Hide().Solution();
	}

}
