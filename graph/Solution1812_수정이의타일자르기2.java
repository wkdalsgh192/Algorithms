package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution1812_수정이의타일자르기2 {

	static class Node implements Comparable<Node> {
		int min, max;

		public Node(int width, int height) {
			super();
			this.min = Math.min(width, height);
			this.max = Math.max(width, height);
		}

		@Override
		public int compareTo(Node o) {
			return o.min - this.min; // 내림차순으로 저장
		}

	}
	
	private static int N,M,cnt;
	private static int[] arr;
	static PriorityQueue<Node> pq;
	private void Solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
			
			
			
			// 자르기 시작
			cnt=0;
			Arrays.sort(arr);
			cut();
						
			System.out.println("#"+t+" "+cnt);
			
		}
	}
	
	private static void cut() {

		// 짜투리를 저장할 곳 만들기
		pq = new PriorityQueue<>();
		cnt++;
		pq.offer(new Node(M,M)); // 첫 짜투리 저장
		
		for (int i = N-1; i >= 0; i--) {
			go(1<<arr[i]);
			
		}
	}
	
	private static void go(int size) {
		Node rect = pq.poll();
		// 자를 수 있는 지 확인
		if (size <= rect.min) { 
			// 자를 수 있으면 자르고 남은 짜투리 영역 계산
			pq.offer(new Node(rect.min-size, size));
			pq.offer(new Node(rect.max-size, rect.min));
		}
		else {
			pq.offer(rect); // 다시 집어넣기
			cnt++;
			pq.offer(new Node(M-size, size));
			pq.offer(new Node(M-size, M));				
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Solution1812_수정이의타일자르기2().Solution();
	}

}
