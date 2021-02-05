package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class SSAFY_Exit_Answer {

	static class Person implements Comparable<Person> {
		int idx;
		int time;
		public Person(int idx, int time) {
			super();
			this.idx = idx;
			this.time = time;
		}
		@Override
		public int compareTo(Person o) {
			return this.time - o.time;
		}
	}
	static boolean flag, turn[];
	static int N,time, visit, goal,res;
	static int[][] map;
	static StringTokenizer st;
	static List<int[]> exit, people;
	static PriorityQueue<Person> e1,e2;
	private void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			res = Integer.MAX_VALUE;
			exit = new ArrayList<>();
			people = new ArrayList<>();
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) people.add(new int[] {i,j});
					if (map[i][j] == 2) exit.add(new int[] {i,j});
				}
			}
			
			// 순열로 가는 경우의 수 모두 확인
			turn = new boolean[people.size()];
			permutation(0);
			
			System.out.println("#"+t+" "+res); 
		}
	}
	private static int escape(boolean[] turn) {
		// 이동 시간 저장하기
		e1 = new PriorityQueue<>();
		e2 = new PriorityQueue<>();
		
		int curr[], res;
		int[] exitOne = exit.get(0), exitTwo = exit.get(1);
		for (int i = 0; i < turn.length; i++) {
			curr = people.get(i);
			if (turn[i]) {
				res = Math.abs(exitOne[0] - curr[0]) + Math.abs(exitOne[1] - curr[1]);
				e1.add(new Person(i, res));
			}  else {
				res = Math.abs(exitTwo[0] - curr[0]) + Math.abs(exitTwo[1] - curr[1]);
				e2.add(new Person(i, res));
			}
		}
		
		int time = 0;
		while(true) {
			
			// e1 탈출
			flag = false;
			while (!e1.isEmpty() && !flag && e1.peek().time < time) {
				e1.poll();
				flag = true;
			}
			
			flag = false;
			while (!e2.isEmpty() && !flag && e2.peek().time < time) {
				e2.poll();
				flag = true;
			}
		
			if (e1.isEmpty() && e2.isEmpty()) break;
			
			time++;
		}
		
		return time;
	}
	private static void permutation(int cnt) {
		if (cnt == turn.length) {
			// 탈출 시간 연산 실행
			int time = escape(turn);
			// 최소값 갱신
			res = Math.min(res, time);
			//리턴
			return;
		}
		
		turn[cnt] = true;
		permutation(cnt+1);
		turn[cnt] = false;
		permutation(cnt+1);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		new SSAFY_Exit_Answer().solution(); 
	}

}
