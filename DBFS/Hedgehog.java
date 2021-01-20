package DBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Hedgehog {

	static class Node {
		int r;
		int c;
		int cnt;
		
		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	private static int R, C, res;
	private static boolean flag;
	private static int[] dr = {-1,1,0,0};
	private static int[] dc = {0,0,-1,1};
	private static int[][] map;
	private static Node start, dest;
	private static List<Node> list = new ArrayList<>();
	private void Solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				char ch = line.charAt(j);
				if (ch == 'S') {
					map[i][j] = 0;
					start = new Node(i, j);
				} else if (ch == 'D') {
					map[i][j] = -1;
					dest = new Node(i, j);
				} else if (ch == '*') {
					map[i][j] = -2;
					list.add(new Node(i, j));
				} else if (ch == '.') {
					map[i][j] = -3;
				} else map[i][j] = -4;
			}
		}
		BFS();
		
		if (flag) System.out.println(res);
		else System.out.println("KAKTUS");
		
		br.close();
	}
	
	private static void BFS() {
		Queue<Node> q = new LinkedList<>();
		
		// 고슴도치 집어 넣기
		q.offer(start);
		
		// 돌 집어넣기
		for (int i = 0; i < list.size(); i++) q.offer(list.get(i));
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			
			
			// 비버의 소굴에 도달하면 종료
			if (map[dest.r][dest.c] != -1) {
				flag = true;
				res = map[dest.r][dest.c];
				break;
			}
			
			int nr, nc;
			for (int i = 0; i < 4; i++) {
				nr = curr.r + dr[i];
				nc = curr.c + dc[i];
				
				if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
				// 고슴도치인 경우
				if (map[curr.r][curr.c] >= 0) {
					if (map[nr][nc] == -2 || map[nr][nc] == -4 || map[nr][nc] >= 0) continue;
					map[nr][nc] = map[curr.r][curr.c]+1;
					q.offer(new Node(nr, nc));
				// 물인경우
				} else {
					if (map[nr][nc] == -2 || map[nr][nc] == -4 || map[nr][nc] == -1) continue;
					map[nr][nc] = -2;
					q.offer(new Node(nr, nc));
				}
			}
		}
		
		
		
	}
	public static void main(String[] args) throws IOException {
		new Hedgehog().Solution(); 
	}

}
