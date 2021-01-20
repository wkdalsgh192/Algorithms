package im;

import java.util.Scanner;

public class Line {

	private static int N;
	private static int[] line, lot;
	private void Solution() {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		line = new int[N];
		lot = new int[N];
		for (int i = 0; i < N; i++) {
			lot[i] = sc.nextInt(); // 뽑은 번호 저장
			line[i] = i+1; // 학생들을 일렬로 줄 세우기
		}
		
		for (int i = 0; i < N; i++) {
			int res = lot[i];
			int cnt = 0;
			while (cnt < res) { // 횟수만큼 앞 사람과 자리 바꾸기
				int K = i-cnt; // 자리가 바뀔 때마다 자리값을 갱신해줘야 한다.
				int temp = line[K];
				line[K] = line[K-1];
				line[K-1] = temp;
				cnt++;
			}
			
//			System.out.println();
//			for (int j = 0; j < N; j++) {
//				if (j == N-1) {
//					System.out.print(line[j]);
//				} else {
//					System.out.print(line[j]+" ");
//				}
//			}
		}
		
//		System.out.println();
//		System.out.println("-----------------------");
		for (int i = 0; i < N; i++) {
			if (i == N-1) {
				System.out.print(line[i]);
			} else {
				System.out.print(line[i]+" ");
			}
		}
		
		sc.close();
	}
	public static void main(String[] args) {
		new Line().Solution();
	}

}
