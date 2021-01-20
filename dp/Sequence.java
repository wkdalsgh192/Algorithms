package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sequence {

	private static int N;
	private static int[] arr, drr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 수열을 카운트할 배열 만들기
		drr = new int[N];
		// 최초 값을 1로 카운트
		drr[0] = 1;
		
		for (int i = 1; i < N; i++) {
			drr[i] = 1; // 초기값을 가장 작은 값으로 카운트
			for (int j = 0; j < i; j++) {
				// 탐색하는 값이 그 이전 값보다 크지만, 카운트값은 작거나 같을 경우 해당 카운트 값에다가 1을 증가시켜 저장한다.
				if (arr[i] > arr[j] && drr[i] <= drr[j]) drr[i] = drr[j]+1;
			}
		}
		
		int max = 0;
		for (int i : drr) max = Math.max(max, i);
		System.out.println(max);
	}
}
