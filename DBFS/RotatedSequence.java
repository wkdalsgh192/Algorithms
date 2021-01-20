package DBFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RotatedSequence {

	private static int A, P, cnt;
	private static List<Integer> list = new ArrayList<>();
	public void Solution() {
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		P = sc.nextInt();
		
		// DFS 호출하기 - 중복되지 않은 원소들로만 이루어진 수열을 리턴
		DFS(A);
		System.out.println(cnt);
		sc.close();
		
	}
	private static void DFS(int idx) {
		// 종료 요건
		for (int i = 0; i < list.size(); i++) {
			if (idx == list.get(i)) {
				cnt = i;
				return;
			}
		}
			
		
		// 실행 및 출력 파트
		// 리스트에 집어넣기
		list.add(idx);
		// 새로운 원소값 구하기
		int temp = idx;
		int sum = 0;
		while (true) {
			int res = temp % 10;
			temp /= 10;
			sum += Math.pow(res, P);
			
			// 계산 다 하고 temp = 0이면 할 필요가 없다.
			if (temp == 0) break;
		}
		// DFS 호출하기
		DFS(sum);
	}
	public static void main(String[] args) {
		new RotatedSequence().Solution();

	}

}
