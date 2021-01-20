package im;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Delivery {

	static class Node {
		int i;
		int j;
		int cnt;
		
		public Node(int i, int j, int cnt) {
			super();
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}
		public Node(int i, int j) {
			super();
			this.i = i;
			this.j = j;
			this.cnt = 0;
		}
		
		
	}
	public static int T, N, min;
	public static int[][] map;
	public static boolean[] used;
	public static List<Node> house, store,arr;
	public void Solution() {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new int[N+1][N+1];
			
			// 집의 위치와 가게의 위치를 저장
			house = new ArrayList<>();
			store = new ArrayList<>();
			for (int i = 1; i < N+1; i++) {
				for (int j = 1; j < N+1; j++) {
					int temp = sc.nextInt();
					if (temp == 0) continue;
					else if (temp == 1) house.add(new Node(i,j));
					else store.add(new Node(i,j,temp));
				}
			}
			
			// 1부터 전체 개의 가게를 뽑아서 최솟값 찾기
			// 가게 위치를 저장할 리스트 만들기
			min = Integer.MAX_VALUE;
			arr = new ArrayList<>();
			for (int i = 1; i < store.size()+1; i++) {
				if (i == 1) {
					// 1개의 배달점을 선택하는 경우, 각각의 전문점에 대하여
					for (int j = 0; j < store.size(); j++) {
						Node[] arr = new Node[i];
						arr[0] = store.get(j);
						int temp = Find(arr);
						// 최솟값 갱신
						min = Math.min(min, temp);
					}
				} else {
					// i개의 배달 위치 고르기
					used = new boolean[store.size()];
					Node[] arr = new Node[i];
					Combination(arr,0,i,0);
				}
			}
			
			System.out.println("#"+tc+" "+min);
			
			
		}
		
		sc.close();
	}
	
	public static void Combination(Node[] arr, int cnt, int r, int start) {
		// 종료 요건
		if (cnt == r) {
			int temp = Find(arr);
			min = Math.min(min, temp);
			return;
			
		}
		
		for (int i = start;i < store.size();i++) {
			arr[cnt] = store.get(i);
			used[i] = true;
			Combination(arr,cnt+1,r,i+1);
			used[i] = false;
		}
	}
	
	public static int Find(Node[] arr) {
		int[] res = new int[house.size()];
		
		// 각 집에서 선택한 배달점 중 최소 거리를 가지는 곳의 거리 구하기
		for (int i = 0; i < house.size(); i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < arr.length; j++) {
				Node hCurr = house.get(i);
				Node sCurr = arr[j];
				int temp = Math.abs(hCurr.i - sCurr.i) + Math.abs(hCurr.j - sCurr.j);
				min = Math.min(min, temp);
			} // 특정 집에서 최소 거리를 가지는 배달점의 위치를 갱신
			res[i] = min;
		}
		
		// 비용 총 합산하기
		int sum = 0;
		for (int i : res) sum += i;
		for (Node n : arr) sum += n.cnt;
		
		return sum;
	}
	public static void main(String[] args) {
		new Delivery().Solution();
	}

}
