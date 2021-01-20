package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Make2048 {

	private static int T,N;
	private static String order;
	private static int[][] map, res;
	private void Solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 칸의 수
			order = st.nextToken(); // 명령
			
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			res = new int[N][N];
			int[][] new_map = new int[N][N];
			if ("up".equals(order)) new_map = MoveUp(map);
			if ("left".equals(order)) {
				new_map = turn(3, MoveUp(turn(1, map)));
			}
			if ("down".equals(order)) {
				new_map = turn(2, MoveUp(turn(2, map)));			
			}
			if ("right".equals(order)) {
				new_map = turn(1, MoveUp(turn(3, map)));
			}

			System.out.println("#"+tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(new_map[i][j]+" ");
				}
				System.out.println();
			}
		} // end of T
		
	}
	private static int[][] turn(int cnt, int[][] map) {
		
		int[][] new_map = new int[N][N];
		
		switch (cnt) {
		case 1 :
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					new_map[j][N-1-i] = map[i][j];
				}
			}
			break;
		case 2 :
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					new_map[N-1-i][N-1-j] = map[i][j];
				}
			}
			break;
		case 3 :
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					new_map[N-1-j][i] = map[i][j];
				}
			}
			break;
		}
		
		return new_map;
	}

	private static int[][] MoveUp(int[][] map) {
		for (int i = 0; i < N; i++) {
			boolean flag = false; // 합치는 것이 가능한 경우 false
			List<Integer> arr = new ArrayList<>();
			for (int j = 0; j < N; j++) {
				int idx = arr.size()-1;
				if (map[j][i] != 0) {
					if (arr.size() == 0) arr.add(map[j][i]);
					else {
						if (arr.get(idx) == map[j][i] && !flag) {
							arr.set(idx, map[j][i]*2);
							flag = true; // 더 이상 합칠 수 없음
						} else {
							arr.add(map[j][i]);
							flag = false; // 해당 인덱스의 원소는 합칠 수 있음
						}
					}
				}
			}
			for (int j = 0; j < arr.size(); j++) {
				res[j][i] = arr.get(j);
			}
		}
		
		return res;
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Make2048().Solution();
	}

}

