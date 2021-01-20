package bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Jewelry {
	
	static class Node {
		int land; // 향하는 섬의 이름
		int wt; // 다음 섬으로 가기 위해 가질 수 있는 보석의 최대 갯수
		int cnt; // 내가 현재 가지고 있는 보석의 양
		public Node(int land, int wt, int cnt) {
			super();
			this.land = land;
			this.wt = wt;
			this.cnt = cnt;
		}
	}
	
	private static int N,M,K,a,b,c,k,max;
	private static List<ArrayList<Node>> list = new ArrayList<>();
	private void Solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// 보석이 있는 섬을 비트로 저장
		k = 0;
		for (int i = 0; i < K; i++) {
			// 0번 제외
			int num = Integer.parseInt(br.readLine());
			k = k | 1 << num;
		}
		
		// 섬을 연결하는 다리와 다리 무게
		for (int i = 0; i < N+1; i++) list.add(new ArrayList<>());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			list.get(a).add(new Node(b,c,0));
			list.get(b).add(new Node(a,c,0));
		}
		// BFS 호출
		BFS(1);
		// 결과값 호출
		System.out.println(max);
	}
	private static void BFS(int start) {
		Queue<Node> q = new LinkedList<>();
		
		// 1번 섬에 보석이 있는 지 확인하고 큐에 넣기
		for (int i = 0; i < list.get(start).size(); i++) {
			Node curr = list.get(start).get(i);
			// 보석이 있으면 가지고 가는 경우의 수 확인
			if (isAble(k, start)) q.add(new Node(curr.land, curr.wt, (curr.cnt<<1)+1));
			// 디폴트는 보석없이 가기
			q.add(new Node(curr.land, curr.wt, curr.cnt));
		}
		
		int cnt = 1;
		while(!q.isEmpty() && cnt < 100) {
			cnt++;
			Node curr = q.poll();
			
//			System.out.println("The land I am heading to : "+ curr.land);
//			System.out.println("jewelry : "+curr.cnt);
//			System.out.println("weight : "+curr.wt);
			// 현재 위치 : curr 섬으로 가는 다리. 다리 건널 수 있는 지 확인
			if ((curr.cnt & ((1<<K)-1)<<curr.wt) != 0) continue;
//			System.out.println("crossed");
			// 건널 수 있으면 curr 섬에 도착한 것이다! curr 섬이 1번 섬인 지 확인. 1번 섬이라고 하더라도 종료하면 안 됨!
			if (curr.land == 1) {
				max = Math.max(max, curr.cnt);
				continue;
			}
			// 1번 섬이 아니라면 다음 다리 탐색
			for (int i = 0; i < list.get(curr.land).size(); i++) {
				Node next = list.get(curr.land).get(i);
				if (isAble(k, next.land)) q.add(new Node(next.land, next.wt, (curr.cnt<<1)+1));
				q.add(new Node(next.land, next.wt, curr.cnt));
			}
			
		}
		
		
		
	}
	private static boolean isAble(int k, int idx) { // 해당 섬에 보석이 있나요.
		return (k & 1<<idx) !=0 ? true:false;
	}
	public static void main(String[] args) throws IOException {
		new Jewelry().Solution();
	}

}
