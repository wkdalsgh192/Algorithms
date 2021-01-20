package bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class SortGame {

	static class Node {
		String data;
		int cnt;
		public Node(String data, int cnt) {
			super();
			this.data = data;
			this.cnt = cnt;
		}
	}
	private static int N, K, res=-1;
	private void Solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 숫자의 범위
		K = Integer.parseInt(st.nextToken()); // 소트할 숫자의 갯수
		
		StringBuilder sb;
		sb  = new StringBuilder();
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		while(str.hasMoreTokens()) {
			sb.append(str.nextToken());
		}
		
		// 정답 받기
		String answer="";
		for (int i = 1; i <= N; i++) answer+=i;
		
		Set<String> map = new HashSet<>();
		Queue<Node> q = new LinkedList<>();
		
		q.add(new Node(sb.toString(), 0));
		map.add(sb.toString());
		
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			
//			System.out.println(curr.data);
			if (answer.equals(curr.data)) {
				res = curr.cnt;
				break;
			}
			
			// 처음 인덱스부터 차례로 소트하기
			for (int i = 0; i < N-K+1; i++) {
				StringBuilder sbd = new StringBuilder();
				for (int j = 0; j < i; j++) sbd.append(curr.data.charAt(j));
				for (int j = i+K-1; j >= i; j--) sbd.append(curr.data.charAt(j));
				for (int j = i+K; j < N; j++) sbd.append(curr.data.charAt(j));
				
//				System.out.println(sbd.toString());
				if (map.contains(sbd.toString())) continue;
				q.add(new Node(sbd.toString(), curr.cnt+1));
				map.add(sbd.toString());
			}
		}
		
		System.out.println(res);
	}
	public static void main(String[] args) throws IOException {
		new SortGame().Solution();
	}

}
