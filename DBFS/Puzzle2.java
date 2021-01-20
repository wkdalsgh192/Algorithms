package DBFS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Puzzle2 {

	private static int[] dr = {-1,1,0,0};
	private static int[] dc = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int start = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int temp = sc.nextInt();
				if (temp == 0) temp = 9;
				
				start = start*10+temp; // 자릿수를 한 칸씩 이동해서 2차원 입력값을 int값으로 치환하는 과정
			}
		}
		
		Queue<Integer> queue = new LinkedList<>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		// 처음 시작점을 큐에 넣고 이동시킨다.
		queue.add(start);
		
		// 시작점에 해당하는 키의 값을 0으로 먼저 넣는다.
		map.put(start, 0);
		
		// 로직 설계
		// 9가 나오는 위치를 찾아서 위치를 찾고 해당 위치를 기준으로 r,c 위치를 찾는다.
		// r,c를 찾은 뒤에 그 인덱스로 9의 값을 이동시킨다
		// 이동시키면서 9가 우측 하당으로 갈 수 있도록 스왚해준다.
		
		while(!queue.isEmpty()) {
			
			// 현재 퍼즐을 int형으로 꺼낸뒤, 스트링으로 변환해 9가 있는 곳을 찾는다.
			int nowNum = queue.remove();
			String now = String.valueOf(nowNum);
			
			int target = now.indexOf('9');
			int r = target / 3;
			int c = target % 3;
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if (nr < 0 || nc < 0 || nr >= 3 || nc >= 3) continue; // 경계 체크
				StringBuilder next = new StringBuilder(now); // 현재 위치의 문자열 값을 StringBuilder를 통해서 만든다
				char temp = next.charAt(target); // 원래 자리에 있던 '9'를 가져오기
				next.setCharAt(target, (char) next.charAt(nr*3+nc)); // 9가 있던 자리에 새 좌표의 값으로 이동시킨다
				next.setCharAt(nr*3+nc, temp); // 새 좌표에는 9를 넣기
				
				
				// 조정된 결과값을 큐에 넣고, map의 키에도 넣는다.
				int num = Integer.parseInt(next.toString());
				if (!map.containsKey(num)) {
					map.put(num, map.get(nowNum)+1);
					queue.add(num);
				}
			}
		}
		
		if (map.containsKey(123456789)) System.out.println(map.get(123456789));
		else System.out.println(-1);
		
		sc.close();
	}

}
