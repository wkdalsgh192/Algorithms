package dbfs;

import java.util.*;
public class Programmers_BDFS_Travel {
	
	public static class Ticket {
		String airport; // 출발 공항
		int cnt; // 현재까지 사용한 티켓 수
		String[] path; // 경로
		boolean[] visit; // 티켓 사용 여부
		public Ticket(String airport, int cnt, String[] path, boolean[] visit) {
			super();
			this.airport = airport;
			this.cnt = cnt;
			this.path = path;
			this.visit = visit;
		}
	}
	public String[] solution(String[][] tickets) {
		
		String[] answer = null;
		
		// 큐에 다가 "ICN" 저장하기
		Queue<Ticket> q = new LinkedList<>();
		for (int i = 0; i < tickets.length; i++) {
			if ("ICN".equals(tickets[i][0])) { // 출발 공항을 찾는 경우
				int cnt = 0;
				String[] path = new String[tickets.length+1];
				boolean[] visit = new boolean[tickets.length];
				path[0] = "ICN";
				visit[i] = true;
				q.add(new Ticket(tickets[i][1],cnt+1,path,visit));
			}
			
			
		}
		
		while (!q.isEmpty()) {
			
			Ticket curr = q.poll();
			String airport = curr.airport;
			int cnt = curr.cnt;
			String[] path = curr.path;
			boolean[] visit = curr.visit;
			
			
			path[cnt] = airport;
			
			
			// 경로 갱신구간 - cnt가 증가하지 않음
			if (cnt == tickets.length) {
				for (String str : path) System.out.print(str+" ");
				System.out.println();
				for (Boolean b : visit) System.out.print(b+" ");
				System.out.println();
				if (answer == null) answer = path;
				else {
					outer:for (int i = 0; i < answer.length; i++) {
						if (answer[i].equals(path[i])) continue;
						for (int j = 0; j < 3; j++) {
							if (answer[i].charAt(j) == path[i].charAt(j)) continue;
							if (answer[i].charAt(j) > path[i].charAt(j)) answer = path;
							break outer;
						}
					}
				}
				continue;
			}
			
			// 경로 찾기
			for (int i = 0; i < tickets.length; i++) {
				if (visit[i]) continue;
				if (airport.equals(tickets[i][0])) { // 출발 공항을 찾는 경우
					visit[i] = true;
//					boolean[] newVisit = new boolean[visit.length];
//					for (int j = 0; j < visit.length; j++) newVisit[i] = visit[i];
					q.add(new Ticket(tickets[i][1],cnt+1,path,visit));
//					visit[i] = false;
					break;
				}
				 
				
			}
		}
		
		for (String str : answer) System.out.print(str+" ");
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Programmers_BDFS_Travel().solution(new String[][] {
			{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO","ATL"},
			{"ATL","ICN"},{"ATL","SFO"}}); 

	}

}
