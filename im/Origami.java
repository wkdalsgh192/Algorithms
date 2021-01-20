package im;

import java.util.Scanner;

public class Origami {

	private static int N, sum, res;
	private static int[][] arr;
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
		
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				int diffX = 10+Math.min(arr[i][0], arr[j][0])-Math.max(arr[i][0], arr[j][0]);
				int diffY = 10+Math.min(arr[i][1], arr[j][1])-Math.max(arr[i][1], arr[j][1]);
				if (diffX < 10 && diffY < 10) {
					sum += diffY * diffX;
				}
			}
		}
		
		res = 100*N - sum;
		System.out.println(res);
		sc.close();
	}
	public static void main(String[] args) {
		new Origami().Solution();
	}

}
