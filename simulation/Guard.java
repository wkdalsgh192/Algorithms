package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Guard {

	private static int X,Y,my_dir, k_dir, my_len, k_len;
	private void Solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 가로, 세로 길이 받기
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken()); // 가로 길이
		Y = Integer.parseInt(st.nextToken()); // 세로 길이
		
		// 상점 정보 받기
		
		int N = Integer.parseInt(br.readLine()); // 상점의 갯수
		int[][] shops = new int[N][2]; // 상점에 대한 정보 배열
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken()); // 방향
			int len = Integer.parseInt(st.nextToken()); // 축으로부터의 길이
			shops[i] = new int[] {dir, len};
		}
		
		// 동근이 정보 받기
		st = new StringTokenizer(br.readLine());
		int dir = Integer.parseInt(st.nextToken()); // 방향
		int len = Integer.parseInt(st.nextToken()); // 축으로부터의 길이
		int[] start = new int[] {dir, len}; // 동근이에 대한 정보
		
		// 거리 계산하기
		int sum = 0;
		for (int i = 0; i < N; i++) {
			// 계산 함수 호출
			sum+=calc(start, shops[i]);
		}
		
		System.out.println(sum);
	}
	
	private static int calc(int[] me, int[] shop) {
		
		// 위치는 북,남,서,동 => 1,2,3,4
		my_dir = me[0];
		k_dir = shop[0];
		
		my_len = me[1];
		k_len = shop[1];
		
		int temp = 0;
		if (my_dir == k_dir) temp = Math.abs(my_len - k_len);
		else if (my_dir + k_dir == 3) temp = my_len+k_len+Y; // 남과 북의 거리 계산
		else if (my_dir + k_dir == 4) temp = my_len+k_len; // 북과 서의 거리 계산
		else if (my_dir + k_dir == 6) temp = my_len+k_len+X+Y; // 남과 동의 거리 계산
		else if (my_dir + k_dir == 7) temp = my_len+k_len+X; // 동과 서의 거리 계산
		else {
			if (my_dir == 1) temp = X+k_len-my_len;
			else if (my_dir == 2) temp = Y+my_len-k_len;
			else if (my_dir == 3) temp = Y+k_len-my_len;
			else if (my_dir == 4) temp = X+my_len-k_len;
		}
		
		if (temp > X+Y) temp = 2*(X+Y) - temp;
		
		return temp;
	}
	public static void main(String[] args) throws IOException {
		new Guard().Solution();
	}

}
