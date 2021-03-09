package simulation;

import java.io.*;
import java.util.*;
public class SWEA_10761_Trust {
	
	static class Pair {
		int b,o,t;
		
		public Pair(int b,int o,int t) {
			super();
			this.b = b;
			this.o = o;
			this.t = t;
		}
	}
	
	private static int T,N;
	private static Queue<Pair> q;
	private static List<String[]> list;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st;
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			list = new ArrayList<>();
			while (st.hasMoreTokens()) {
				list.add(new String[] {st.nextToken(),st.nextToken()});
			}
			
			q = new LinkedList<>();
			q.add(new Pair(1,1,0));
			
			int ans = 0;
			
			// 목표 설정
			int bg=0,og=0;
			for(String[] str: list) {
				if (bg != 0 && og != 0) break;
				if ("B".equals(str[0]) && bg == 0) bg = Integer.parseInt(str[1]);
				if ("O".equals(str[0]) && og == 0) og = Integer.parseInt(str[1]);
			}
			
//			for(String[] ch: list) {
//				System.out.print(ch[0]+" "+ch[1]+" ");
//			}
			
			while(!q.isEmpty()) {

				Pair curr = q.poll();
//				System.out.println(curr.b+" "+curr.o+" "+curr.t);
				
				if (list.isEmpty()) {
					ans = curr.t;
					break;
				}
				
				int nb,no;
				String[] btn = list.get(0);
				if ("B".equals(btn[0]) && Integer.parseInt(btn[1]) == curr.b) {
					System.out.println("b");
					// O가 움직이는 선택지
					// O의 목표에 따라 움직임이 달라져야 한다. - 백트래킹
					if (curr.o < og) q.add(new Pair(curr.b,curr.o+1,curr.t+1));
					else if (curr.o > og) q.add(new Pair(curr.b,curr.o-1,curr.t+1));
					else q.add(new Pair(curr.b,curr.o,curr.t+1));
					
					// 삭제하고, 목표 재설정
					list.remove(0);
					for(String[] str: list) {
						if ("B".equals(str[0])) {
							bg = Integer.parseInt(str[1]);
							break;
						}
					}
				} else if ("O".equals(btn[0]) && Integer.parseInt(btn[1]) == curr.o) {
					System.out.println("c");
					if (curr.b < bg) q.add(new Pair(curr.b+1,curr.o,curr.t+1));
					else if (curr.b > bg) q.add(new Pair(curr.b-1,curr.o,curr.t+1));
					else q.add(new Pair(curr.b,curr.o,curr.t+1));
					
					list.remove(0);
					for(String[] str: list) {
						if ("O".equals(str[0])) {
							og = Integer.parseInt(str[1]);
							break;
						}
					}
				} else {
					
					if (curr.b < bg) nb = curr.b+1;
					else if (curr.b > bg) nb = curr.b-1;
					else nb = curr.b;
					
					if (curr.o < og) no = curr.o+1;
					else if (curr.o > og) no = curr.o-1;
					else no = curr.o;
					
					q.add(new Pair(nb,no,curr.t+1));
				}
			}
			
			System.out.println("#"+t+" "+ans);
		}
	}

}
