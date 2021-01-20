package line;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test2 {

	private static LinkedList<Integer> balls;
	private static List<Integer> list, answer;
	private static Queue<Integer> q;
	public int[] solution(int[] ball, int[] order) {
        
		balls = new LinkedList<>(); // 공 담기
		for (int i = 0; i < ball.length; i++) balls.add(ball[i]);
		
		q = new LinkedList<>(); // 명령담기
		for (int i = 0; i < order.length; i++) q.offer(order[i]);
		
		list = new ArrayList<>();
		answer = new ArrayList<>();		
		
		while (answer.size() != ball.length) { // answer가 다 채워질 때까지 반복한다
			// 첫번째공과 마지막공 구하기
			int fball = balls.getFirst();
			int lball = balls.getLast();
			
			
					
			// 보류 중인 공 먼저 처리
			if (list.size() > 0) {
				while(list.contains(fball) || list.contains(lball)) {
					// 만약 첫번째 공과 마지막 공이 대기 명령에 있으면
					if (list.indexOf(fball) != -1) { // 만약 꺼낼 수 있는 위치에 있으면
						list.remove(list.indexOf(fball)); // 대기열에서 꺼내기꺼내기
						answer.add(fball); // 집어넣기
						balls.remove(0); // 원래 목록에서 제거하기
						fball = balls.getFirst(); // 공 갱신하기
					}
					if (list.indexOf(lball) != -1) {
						list.remove(list.indexOf(lball)); // 꺼내기
						answer.add(lball);
						balls.remove(balls.size()-1);
						lball = balls.getLast(); // 공 갱신하기
					}
				}
			}
			
			
			
			// 다음 명령 처리 - 보류 중인 공이 없거나 조건에 맞지 않음
			int curr = q.poll(); // 현재 명령공
			System.out.println("curr : "+curr);
			if (curr == fball) { // 명령공이 맞으면
				answer.add(curr);
				balls.remove(0);
			} else if (curr == lball) {
				answer.add(curr);
				balls.remove(balls.size()-1);
			} else {
				list.add(curr);
			}
			
//			System.out.println(Arrays.toString(answer.toArray()));
		}

		int[] result = answer.stream().mapToInt(Integer::intValue).toArray();
//		System.out.println(Arrays.toString(result));
        return result;
		
    }
	
	
	
	public static void main(String[] args) {
		new Test2().solution(new int[] {11, 2, 9, 13, 24}, new int[] {9, 2, 13, 24, 11});

	}

}
