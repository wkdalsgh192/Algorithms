package im;

import java.util.Scanner;

public class Origami2 {

	private static int N, res;
	private static int[][] arr;
	private static boolean[][] map;
	private void Solution() {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		// 좌표값을 배열에 저장하기
		arr = new int[N][];
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[i] = new int[] {x, y}; 
		}
		
		// 도화지 만들기
		map = new boolean[100][100]; // (0,0)부터 (100,100)까지 있음
		
		for (int k = 0; k < arr.length; k++) { // 각 array 좌표에 대하여
			int nx = arr[k][0];
			int ny = arr[k][1];
			for (int i = nx; i < 10+nx; i++) {
				for (int j = ny; j < 10+ny; j++) {
					// 색종이에 가려져있는 영역을 True로 칠하기
					if (!map[i][j]) map[i][j] = true; 
				}
			}
		}
		
		// 색종이가 모두 칠해지면 칠해진 부분의 갯수 세기
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				// 색종이에 가려져있는 영역을 True로 칠하기
				if (map[i][j]) res++; 
			}
		}
		
		System.out.println(res);
		sc.close();
	}
	public static void main(String[] args) {
		new Origami2().Solution();
	}
}
