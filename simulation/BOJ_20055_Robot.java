package simulation;

import java.util.Scanner;

public class BOJ_20055_Robot {

	private void solution() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] arr = new int[2*N][2];
		for (int i = 0; i < 2*N; i++) {
			arr[i] = new int[] {sc.nextInt(), 0};
		}
		
		int step = 1; // 내구도가 0인 칸의 갯수, 진헹된 단계 1
		while (true) {
			
			// 벨트가 한 칸씩 회전한다.
			int[] last = arr[arr.length-1];
			for (int i = arr.length-1; i > 0; i--) arr[i] = arr[i-1];
			arr[N-1][1] = 0;
			arr[0] = last;
			
			// 2번째 단계 - 로봇이 움직인다
			if (arr[2*N-1][1] == 1 && arr[0][0] > 0 && arr[0][1] == 0) {
				arr[0][0]--;
				arr[0][1] = 1;
				arr[2*N-1][1] = 0;
			}
			for (int i = arr.length-1; i > 0; i--) {
				// 로봇 올리기
				if (arr[i][1] == 0 && arr[i-1][1] == 1 && arr[i][0] > 0) { // 다음 칸에 로봇이 없고, 그 전 칸에는 로봇이 있는 경우
					arr[i][1] = 1;
					arr[i-1][1] = 0;
					arr[i][0]--;
				}
				
				if (i == N-1) arr[N-1][1] = 0; // N번째 칸에 도착하면 내리기
			}
			
			
			// 3번째 단계 - index 0에서 올라가고 N-1에서 내려간다.
			if (arr[0][0] > 0 && arr[0][1] == 0) {
				arr[0][1] = 1;
				arr[0][0]--;
			}
			
//			for (int i = 0; i < arr.length; i++) {
//				System.out.print(arr[i][0]+" ");
//				System.out.println(arr[i][1]+" ");
//			}
//			System.out.println();
			
			int cnt = 0;
			for (int i = 0; i < 2*N; i++) {
				if (arr[i][0] == 0) cnt++;
			}
			
			if (cnt >= K) break;
			else step++;
		}
		
		System.out.println(step);
		sc.close();
	}
	public static void main(String[] args) {
		new BOJ_20055_Robot().solution();
	}

}
