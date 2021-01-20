package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class TileCut {

	private void Solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			
			StringTokenizer st;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 만들어야할 타일의 갯수
			int M = Integer.parseInt(st.nextToken()); // 가게에서 파는 타일의 크기
			
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
			
			List<int[]> list = Arrays.asList(arr);
			Collections.reverse(list);
			
			
			int cnt = 0;
			int minLen = M;
			int maxLen = M;
			long origin = M*M;
			long sum = origin;
			
			
			for (int i = 0; i < N; i++) {
				long curr = (long) Math.pow(2, arr[i]*2);
				

				
			}
			
			System.out.println("#"+t+" ");
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		new TileCut().Solution();
	}

}
