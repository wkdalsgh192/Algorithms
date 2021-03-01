package soma;

import java.util.*;
import java.io.*;

public class Soma_020702_PC {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine()); // 스킬 입력
		
		int p = Integer.parseInt(st.nextToken()); // pc의 댓수
		int n = Integer.parseInt(st.nextToken()); // 손님의 수
		int h = Integer.parseInt(st.nextToken()); // 운영시간
		
		int[][] arr = new int[p][]; // 전체 입력값
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
		}
		
		int[][] dp = new int[p+1][p];
		for (int i = 1; i <= p; i++) {
			if (arr[i][0] == i)
		}
		
	}

}
