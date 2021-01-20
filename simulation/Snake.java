package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Snake {

	private static int N, K;
	private static int[][] map;
	private void Solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1];
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 2;
		}
		
		for (int i = 0; i < N+1; i++) {
			System.out.println();
			for (int j = 0; j < N+1; j++) {
				System.out.print(map[i][j]+" ");
			}
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Snake().Solution();
	}

}
