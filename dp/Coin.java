package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Coin {

	private static int N, K;
	private static int[] coin, arr;

	private void Solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 동전의 갯수
		K = Integer.parseInt(st.nextToken()); // 가치의 합

		coin = new int[N];
		for (int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}

		arr = new int[K + 1];
		arr[0] = 1;

		for (int i = 0; i < N; i++) {
			for (int j = coin[i]; j <= K; j++) {
				arr[j] += arr[j - coin[i]];
			}
		}

		System.out.println(arr[K]);
	}

	public static void main(String[] args) throws IOException {
		new Coin().Solution();
	}

}
