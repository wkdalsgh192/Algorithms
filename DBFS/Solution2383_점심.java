package dbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution2383_점심 {

	static class Person implements Comparable<Person> {
		int Pnum,Snum,time,cnt,stat;

		public Person(int pnum, int snum, int time, int cnt, int stat) {
			super();
			Pnum = pnum;
			Snum = snum;
			this.time = time;
			this.cnt = cnt;
			this.stat = stat;
		}

		@Override
		public int compareTo(Person o) {
			return this.time - o.time;
		}
	}
	static List<int[]> people, stairs;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.valueOf(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.valueOf(br.readLine());
			
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			people = new ArrayList<>(); 
			stairs = new ArrayList<>(); 
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1) people.add(new int[] {i, j}); // 사람의 좌표 위치 저장
					if (map[i][j] >= 2) stairs.add(new int[] {i, j, map[i][j]}); // 계단의 좌표 위치 저장
					
				}
			}
			
			
			System.out.println("#"+t+" "+BFS());
			
		}
	}
	
	static int BFS() {
		int res=0;
		int total = (1 << people.size())-1;
		PriorityQueue<Person> pq = new PriorityQueue<>();
		
		int[] p,s; // 사람들을 계단으로 이동 시키기
		for (int i = 0; i < people.size(); i++) {
			p = people.get(i);
			for (int j = 0; j < stairs.size(); j++) {
				s = stairs.get(j);
				int time = Math.abs(p[0]-s[0]) + Math.abs(p[1]-s[1]);
				pq.offer(new Person(i,j,time,0,0));
				
			}		
		}
		
		// BFS돌면서 사람들을 아래로 이동시키기
		int[] onStair = new int[] {0,0};
		while (!pq.isEmpty()) {
			Person curr = pq.poll();
			int K = stairs.get(curr.Snum)[2];
			
			// 모두 도착했으면 종료
			if (res == total) {
				return curr.time;	
			}
			// 이 친구가 이전에 도착하지 않았다면
			if ((res & 1 << curr.Pnum) == 0) {
				//도착했으면 추가
				if (curr.stat == 2) {
					System.out.println(curr.Pnum+" "+curr.Snum+" "+curr.time);
					res = res | 1 << curr.Pnum;
					onStair[curr.Snum]--;
				} else if (curr.stat == 1) { // 계단 내려가는 중
					// 계단을 다 내려왔으면 완료로 바꿔주기
					if (curr.cnt == K) pq.offer(new Person(curr.Pnum, curr.Snum, curr.time+1, curr.cnt+1, 2));
					else pq.offer(new Person(curr.Pnum, curr.Snum, curr.time+1, curr.cnt+1, 1));
				} else { // 계단에 도착
					// 계단 내 사람 수가 3이하이면
					if (onStair[curr.Snum] < 3) {
						onStair[curr.Snum]++;
						pq.offer(new Person(curr.Pnum, curr.Snum, curr.time+1, curr.cnt+1, 1)); // 내려가기
					} else pq.offer(new Person(curr.Pnum, curr.Snum, curr.time+1, curr.cnt, 0)); // 대기하기
				}
			}

		}
		return 0;
		
		
	}

}
