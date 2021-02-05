package ssafy;

import java.io.*;
import java.util.*;

public class Exit {
	
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
	static boolean flag;
	static int N,time, visit, goal;
	static int[][] map;
	static StringTokenizer st;
	static List<int[]> exit, people;
	static PriorityQueue<Person> e1,e2;
	private static void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
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
			
			// 이동 시간 저장하기
			e1 = new PriorityQueue<>();
			int[] exOne = exit.get(0);
			for (int i = 0; i < people.size(); i++) {
				// 이동시간 계산
				int[] curr = people.get(i);
				int sec = Math.abs(exOne[0] - curr[0]) + Math.abs(exOne[1] - curr[1]);
				e1.add(new Person(i,sec));
			}
			
			e2 = new PriorityQueue<>();
			int[] exTwo = exit.get(1);
			for (int i = 0; i < people.size(); i++) {
				// 이동시간 계산
				int[] curr = people.get(i);
				int sec = Math.abs(exTwo[0] - curr[0]) + Math.abs(exTwo[1] - curr[1]);
				e2.add(new Person(i,sec));
			}
			
			// 시간 흘러가면서 풀기
			time = 0;
//			goal = (1<<(people.size()+1))-1;
//			visit = 1<<people.size();
			int[] exitTime = new int[people.size()];
			while(true) {
				
				// e1 탈출
				flag = false;
				while (!e1.isEmpty() && !flag && e1.peek().time < time) {
					Person p = e1.poll();
					// 이미 방문했으면 0이 아니다
//					if ((visit & 1<<p.idx) != 0) continue;
//					visit = visit | 1<<p.idx;
					exitTime[p.idx] = exitTime[p.idx] > 0 ? Math.min(exitTime[p.idx], time) : time;
					flag = true;
					
					System.out.println("e1 "+time+" "+p.idx+" "+p.time);
				}
				
				flag = false;
				while (!e2.isEmpty() && !flag && e2.peek().time < time) {
					Person p = e2.poll();
					// 이미 방문했으면 0이 아니다
//					if ((visit & 1<<p.idx) != 0) continue;
//					visit = visit | 1<<p.idx;
					exitTime[p.idx] = exitTime[p.idx] > 0 ? Math.min(exitTime[p.idx], time) : time;
					flag = true;
					
					System.out.println("e2 "+time+" "+p.idx+" "+p.time);
				}
				
//				if (visit == goal) break;
				if (e1.isEmpty() && e2.isEmpty()) break;
				
				time++;
			}
			
			int res = Integer.MIN_VALUE;
			for (int i : exitTime) res = Math.max(res, i);
			
			System.out.println("#"+t+" "+res); 
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Exit().solution();

	}

}
