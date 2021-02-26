package dbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4008_숫자만들기 {

	static int ops[], opsCnt[], numbers[], max, min, N; // 연산자 순열, 연산자 갯수, 숫자배열, 최댓값, 최소값, 숫자갯수
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.valueOf(br.readLine());
		StringTokenizer st;
		opsCnt = new int[4];
		for (int t = 1; t <= T; t++) {
			N = Integer.valueOf(br.readLine());
			numbers = new int[N];
			ops = new int[N-1];
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 4; i++) {
				opsCnt[i] = Integer.parseInt(st.nextToken());
			} // 연산자 갯수 저장
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			} // 숫자 저장
			
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			
			permutation(0);
			
			System.out.println("#"+t+" "+(max-min));
		}
	}
	
	private static void permutation(int cnt) { // 연산자의 순열 생성
		
		if (cnt == N-1) { // 연산자 순열 완성
			calc();
			return;
		}
		
		// 모든 연산자를 다 시도해봄
		for (int i = 0; i < 4; i++) { // +:0, -:1, *:2, /:3
			if (opsCnt[i] == 0) continue;
			ops[cnt] = i; // 연산자 선택
			opsCnt[i]--;
			permutation(cnt+1);
			opsCnt[i]++;
		}
		
	}
	
	private static void calc() { // 연산자의 순열 상태를 이용해 수식 게산
		int result = numbers[0];
		
		for (int i = 1; i < N; i++) {
			int currNumber = numbers[i];
			switch(ops[i-1]) {
			case 0:
				result += currNumber;
				break;
			case 1:
				result -= currNumber;
				break;
			case 2:
				result *= currNumber;
				break;
			case 3:
				result /= currNumber;
				break;
			}
		}
		
		max = Math.max(max, result);
		min = Math.min(min, result);
	}
}
