package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Runway {

	private static int T, N, X, cnt;
	private static boolean flag1, flag2;
	private static int[][] map;
	private void Solution() throws NumberFormatException, IOException {
		// 입출력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 칸의 길이
			X = Integer.parseInt(st.nextToken()); // 경사로의 길이
			
			// 활주로 만들기
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer str = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(str.nextToken());
				}
			}
			
			// 가로로 활주로를 놓을 때
			for (int i = 0; i < N; i++) {
				// 경사로가 지어졌는 지 확인하는 방문 배열 생성하기
				flag1 = false;
				boolean[] isUsed = new boolean[N];
				for (int j = 0; j < N-1; j++) {
					// 가로로 활주로를 놓을 때
					if (map[i][j] != map[i][j+1]) { // 높이가 다르면 높이 차이를 계산한다.
						if (map[i][j] - map[i][j+1] == 1) { // 높이 차가 1일 때
							// 경사로가 없으면
							if (!isUsed[j]) {
								// 경사로를 지을 수 있는 지 확인한다.
								if (Buildable(i,j,1,1)) {
									// 경사로를 짓는다.
									for (int k = j; k < j+X; k++) isUsed[k] = true;
								}
								else flag1 = true;
							}
						} else if (map[i][j] - map[i][j+1] == -1) {
							// 경사로가 있을 때
							if (!isUsed[j]) {
								if (Buildable(i,j,-1,1)) {
									for (int k = j; k < j+X; k++) isUsed[k] = true;
								}
								else flag1 = true;
							}
						} else flag1 = true;		
					}
				}
				
				if (!flag1) {
//					System.out.println(i+"번째 다리에는 활주로 건설 가능!");
					cnt++;
				}
			}
			System.out.println(cnt);
			// 세로로 활주로를 놓을 때
			for (int i = 0; i < N; i++) {
				// 경사로가 지어졌는 지 확인하는 방문 배열 생성하기
				flag2 = false;
				boolean[] isUsed = new boolean[N];
				for (int j = 0; j < N-1; j++) {
					if (map[j][i] != map[j+1][i]) {
						if (map[j][i] - map[j+1][i] == 1) {
							// 경사로가 있을 때
							if (!isUsed[j]) {
								if (Buildable(j,i,1,0)) {
									for (int k = j; k < j+X; k++) isUsed[k] = true;
								}
								else flag2 = true;
							}
						} else if (map[j][i] - map[j+1][i] == -1) {
							// 경사로가 있을 때
							if (!isUsed[j]) {
								if (Buildable(j,i,-1,0)) {
									for (int k = j; k < j+X; k++) isUsed[k] = true;
								}
								else flag2 = true;
							}
						} else flag2 = true;	
					}
				}
				if (!flag2) cnt++;
			}
			System.out.println("#"+" "+tc+" "+cnt);
		} // end of T
		
	}
	// 활주로 건설 가능한 지 여부 확인하는 메소드 만들기
	private static boolean Buildable(int r, int c, int k, int target) {
		boolean flag = true;
		
		// 가로일 때
		if (target == 1) {
			if (k == 1) {
				if (c + X >= N) return flag=false;
				else {
					for (int i = c+1; i < c+X; i++) if (map[r][i-1] != map[r][i]) return flag=false;
				}
			} else {
				if (c - X < 0) return flag=false;
				else {
					for (int i = c-1; i > c-X; i--) if (map[r][i] != map[r][i+1]) return flag=false;
				}
			}
		}
		
		
		// 세로일 때
		if (target == 0) {
			if (k == 1) {
				if (r + X >= N) return flag=false;
				else {
					for (int i = r+1; i < r+X; i++) if (map[i-1][c] != map[i][c]) return flag=false;
				}
			} else {
				if (r - X < 0) return flag=false;
				else {
					for (int i = r-1; i > r-X; i--) if (map[i][c] != map[i+1][c]) return flag=false;
				}
			}
		}
		
		
		return flag;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Runway().Solution();

	}

}
