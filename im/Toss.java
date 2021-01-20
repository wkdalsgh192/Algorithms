package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Toss {

	private static int N,M,L;
	private static int[] arr;
	private void Solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); // 끝나는 위치
		L = Integer.parseInt(st.nextToken()); // 몇 번째
		
		//학생들이 앉는 자리 만들기
		int pos=0; // 0번부터 시작
		int cnt=0; // 던진 총 횟수
		arr = new int[N];
		arr[pos] = 1; // 1번이 공을 받는다.
		
		while (true) {
			
			if (arr[pos] == M) { // 던진 횟수가 3번이면 종료하기
				break;
			};
			
			if (arr[pos] % 2 == 1) { // 시계방향으로 바꾸기. 
				if (pos+L >= N ) pos = pos+L-N;
				else pos += L;
				arr[pos]++;
			} else { // 반시계방향으로
				if (pos - L < 0) pos = N-L+pos;
				else pos -= L;
				arr[pos]++;
			}
		}
		
		for (int i : arr) cnt += i;
		System.out.println(cnt-1); // 처음 시작할 때 1번 자리는 처리하지 않으므로 빼줘야한다.
		
		
	}
	public static void main(String[] args) throws IOException {
		new Toss().Solution();
	}

}
