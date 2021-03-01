package soma;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Soma_020703_Peanut {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int idx = 0; // E와 가장 가까운 오른쪽 인덱스
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (idx == 0 && arr[i]>=E) idx = i;
		}
		
		int cnt = 0;	
		int min = Integer.MAX_VALUE;	
		
		while (true) {
			cnt = 0;
			for (int i = idx; i < arr.length; i++) {
				if (arr[i]>=E) cnt++;
				if (cnt == M) {
					if (arr[i] < E) break;
					min = Math.min(min, arr[i]-arr[idx]);
				}
			}
			
			idx--; // 왼쪽으로 한 칸 가기
			if (idx<0) break;
			else E = arr[idx];
		}
		
		System.out.println(min);
		
	}

}
