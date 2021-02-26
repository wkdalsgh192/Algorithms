package dbfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Programmers_DBFS_Travel3 {
	
	public static class Ticket {
		String airport; // 출발 공항
		int cnt; // 현재까지 사용한 티켓 수

		public Ticket(String airport, int cnt) {
			super();
			this.airport = airport;
			this.cnt = cnt;
		}
	}
	
	
	List<String> list = new ArrayList<>();
	static String route = "";
	static boolean[] visit;
	
	private void dfs(String[][] tickets, Ticket curr) {
		String airport = curr.airport;
		int cnt = curr.cnt;
		
		route += airport+",";
		
		if (cnt == tickets.length) {
			list.add(route);
			return;
		}
		
		for (int i = 0; i < tickets.length; i++) {
			String s= tickets[i][0], e = tickets[i][1];
			if (s.equals(airport) && !visit[i]) {
				visit[i] = true;
				dfs(tickets,new Ticket(e,cnt+1));
				visit[i] = false;
				route = route.substring(0,route.length()-4); // - 이 부분에서 차이가 난다.
			}
		}
	}
	public String[] solution(String[][] tickets) {
		
		for (int i = 0; i < tickets.length; i++) {
			String s = tickets[i][0], e = tickets[i][1];
			visit = new boolean[tickets.length];
			
			if (s.equals("ICN")) {
				visit[i] = true;
				dfs(tickets,new Ticket(e,1));
			}
		}
		
		Collections.sort(list);
		String[] answer = list.get(0).split(",");
		
		for (String str : answer) System.out.print(str+" ");
		return answer;
	}
	
	public static void main(String[] args) {
		new Programmers_DBFS_Travel3().solution(new String[][] {
			{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO","ATL"},
			{"ATL","ICN"},{"ATL","SFO"}}); 
	}
}
