package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PowerSum {

	private void Solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		double N = Integer.parseInt(br.readLine());
		
		int K = (int) Math.sqrt(N);
		
		int[] arr = new int[K+1];
		
		int idx = K;
		while (N != 0) {
			for (int i = idx; i > 0; i--) {
				int num = (int) Math.pow(i, 2);
				if (N - num >= 0) {
					N -= num;
					arr[i] += 1;
					idx = i;
					break;
				}
			}
		}
		
		int sum = 0;
		for (int i : arr) sum += i;
		
		System.out.println(sum);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		new PowerSum().Solution();
	}

}
