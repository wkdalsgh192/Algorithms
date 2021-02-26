package simulation;

import java.util.*;
import java.io.*;
public class BOJ_18808_Sticker {
	
	private static int N,M,K,R,C;
	private static int[] pos; // 붙이는 위치 저장 공간
	private static boolean[][] notebook,sticker;
	private static StringTokenizer st;
	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// N,M,K값 받기
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		notebook = new boolean[N][M];
		// while loop으로 스티커 하나씩 처리하기
		while (cnt < K) {
			// 스티커 만들기
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			sticker = new boolean[R][C];
			for (int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < C; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken()) == 1 ? true : false;
				}
			}

			
			// 될 때까지 회전하기
			int rot = 0;
			while (!canAttach(sticker) && rot < 4) {
				sticker = rotate();
				rot++;
			}
			
			// 붙이기
			if (rot < 4) {
				for (int i = pos[0]; i < pos[0]+R; i++) {
					for (int j = pos[1]; j < pos[1]+C; j++) {
						if (sticker[i-pos[0]][j-pos[1]]) notebook[i][j] = sticker[i-pos[0]][j-pos[1]];
					}
				}	
			}
			
			cnt++;
		}
		
		// 다 처리하면 갯수 세기
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (notebook[i][j]) sum++;
			}
		}
		System.out.println(sum);
	}
	private boolean canAttach(boolean[][] sticker) {
		
		boolean flag;
		for (int i = 0; i <= N-R; i++) {
			for (int j = 0; j <= M-C; j++) {
				// 출발 좌표는 (i,j), 여기서부터 탐색하기
				flag = true;
				inner:for (int r = i; r < i+R; r++) {
					for (int c = j; c < j+C; c++) {
						// 하나라도 차있으면 다음 출발 좌표로 넘어간다.
						if(notebook[r][c] && sticker[r-i][c-j]) {
							flag = false;
							break inner;
						}
					}		
				}
				// 모두 가능하면 출발 좌표를 저장하고 결과 반환
				if (flag) {
					pos = new int[] {i,j};
					return true;
				}
			}
		}
		
		return false;
	}
	private boolean[][] rotate() {
		// R,C 서로 바꾸기
		int t = R;
		R = C;
		C = t;
		//새 배열 만들기
		boolean[][] temp = new boolean[R][C];
		
		// 90도 회전하기
		for (int i = 0; i < R; i++) { // 5
			for (int j = 0; j < C; j++) { // 2
				temp[i][j] = sticker[C-j-1][i]; // j, n-i-1 -> C-j-1,i;
			}
		}
		
		return temp;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new BOJ_18808_Sticker().solution();
	}

}
