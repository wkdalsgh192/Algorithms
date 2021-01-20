package im;

import java.io.IOException;
import java.util.Scanner;

public class Email {
	
	private static int R,C,N;
	private static char[] arr;
	private static char[][] map;
	private void Solution() throws IOException {		
		Scanner sc = new Scanner(System.in);
		
		
		arr = sc.next().toCharArray(); // 배열 만들기
		N = arr.length; // 글자 수 세기
		
		int idx = 1;
		System.out.println(N % idx);
		while (true) {
			if (idx > 100) { // 최대 100글자이므로 R은 10을 넘을 수 없다.
				break;
			}
			
			if (N % idx == 0) { // N이 C로 나눠떨어진다면
				int temp =  N / idx; // R 값 구하기
				if (temp <= idx) { // R <= C 인 경우에만
					if (temp >= R) {
						C = idx; // C값 갱신하기
						R = temp;
					}
					
				}
			}
			idx++;
		}
		
		System.out.println(R +" " + C);
		map = new char[R][C];
		for (int i = 0; i < C; i++) { 
			for (int j = 0; j < R; j++) {
				map[j][i] = arr[i*R+j]; // 행먼저 채우고 열 채우기
			}
		}
		
		for (int i = 0; i < R; i++) {
			System.out.println();
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]+" ");
			}
		}
		
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < R; i++) { 
			for (int j = 0; j < C; j++) {
				sb.append(map[i][j]);
			}
		}
		System.out.println();
		System.out.println(sb.toString());

		sc.close();
	}
	
	public static void main(String[] args) throws IOException {
		new Email().Solution();
	}

}
