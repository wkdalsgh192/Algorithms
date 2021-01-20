package simulation;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20165_Domino {
	
	private static int[] dr = {0,0,1,-1};
	private static int[] dc = {1,-1,0,0};
	private static int M,N,R,points,map[][];
	private static char idx,dir[],fallen[][];
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st; 
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // 행
		N = Integer.parseInt(st.nextToken()); // 열
		R = Integer.parseInt(st.nextToken()); // 라운드 수
		
		
		map = new int[M+1][N+1];
		fallen = new char[M+1][N+1];
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (char[] ch : fallen) Arrays.fill(ch, 'S');
		
		// 라운드 시작
		int r,c;
		dir = new char[] {'E','W','S','N'};
		for (int i = 0; i < R; i++) {
			// 공격 시작
			st = new StringTokenizer(br.readLine());
			
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			idx = st.nextToken().charAt(0);
			// 해당 도미노가 이미 넘어졌는가?
			if (fallen[r][c] == 'S') {
				fallen[r][c] = 'F'; // 이미 넘어진 것이 아니라면 넘어뜨리고
				points++; // 포인트 획득
				for (int j = 0;j<4;j++) if (idx == dir[j]) attack(r,c,j);
			}
			
			// 수비
			st = new StringTokenizer(br.readLine());
			fallen[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 'S';
			
//			printout();
//			System.out.println();
		}
		
		System.out.println(points);
		printout();
		
	}
	private static void printout() {
		for (int i = 1; i < M+1; i++) {
			for (int j = 1; j < N+1; j++) {
				System.out.print(fallen[i][j]+" ");
			}
			System.out.println();
		}
	}
	private static void attack(int r, int c, int idx) {
		
		// 주어진 방향과 도미노 길이-1만큼 넘어뜨리기
		int nr=r+dr[idx],nc=c+dc[idx]; // 이동하기
		for (int i = 0; i < map[r][c]-1; i++) { // 자기 자신을 포함한 k개만큼 연달아 쓰러뜨린다.
			if (nr < 1 || nc < 1 || nr >= M+1 || nc >= N+1) break; // 범위 유효성 검사
			if (fallen[nr][nc] == 'S') {
				fallen[nr][nc] = 'F'; // 이미 넘어진 것이 아니라면 넘어뜨리고
				points++; // 포인트 획득
				// 해당 길이만큼 다시 넘어짐
				attack(nr,nc,idx);
			}
			// 좌표값 갱신
			nr += dr[idx];
			nc += dc[idx];
		}
		
		return;
	}
	public static void main(String[] args) throws IOException {
		new BOJ_20165_Domino().solution();
	}

}
