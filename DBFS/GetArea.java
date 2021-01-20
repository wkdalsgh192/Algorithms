package DBFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GetArea {

	private static int N,M,K,cnt,res;
	private static int[] dr = {0,0,1,-1};
	private static int[] dc = {1,-1,0,0};
	private static int[][] arr;
	private static boolean[][] map;
	private static List<Integer> list = new ArrayList<>();
	private void Solution() {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();		
		
		map = new boolean[N][M]; // 모눈종이
		arr = new int[K][4]; // 좌표값을 저장할 배열
		
		// 좌표값 저장하기
		for (int i = 0; i < K; i++) for (int j = 0; j < 4; j++) arr[i][j] = sc.nextInt();
		
		// 모눈종이에 직사각형 표시하기
		for (int k = 0; k < K; k++) {
			for (int i = N-1; i >= 0; i--) {
				for (int j = 0; j < M; j++) {
					if (N-1-arr[k][3] < i && i <= N-1-arr[k][1] && arr[k][0] <= j && j < arr[k][2]) map[i][j] = true;
				}
			}
		}
		
		// DFS로 빈 영역 구하기
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!map[i][j]) {
					res++; // 영역의 갯수 증가시키기
					cnt=0; // 넓이 초기화
					DFS(i,j); // DFS 호출
					list.add(cnt);
				}
			}
		}
		
		// 오름차순으로 정렬하기
		Collections.sort(list);
		
		System.out.println(res);
		for (int i : list) System.out.print(i+" ");
		
	}
	private static void DFS(int r, int c) {
		
		map[r][c] = true;
		cnt++;
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
			if (map[nr][nc]) continue;
			DFS(nr,nc);
		}
		
	}
	public static void main(String[] args) {
		new GetArea().Solution();
	}

}
