package dbfs;

/*
백준 18405 경쟁적 전염
https://www.acmicpc.net/problem/18405
*/

import java.util.*;
import java.io.*;

public class BOJ_18405_CP {
    static class Virus implements Comparable<Virus> {
        int r;
        int c;
        int lv;

        public Virus(int r, int c, int lv) {
            super();
            this.r = r;
            this.c = c;
            this.lv = lv;
        }

        @Override
        public int compareTo(Virus o) {
            return this.lv - o.lv;
        }
    }

    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static StringTokenizer st;
    PriorityQueue<Virus> pq = new PriorityQueue<>();
    List<Virus> list = new ArrayList<>();
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 맵의 크기
        int K = Integer.parseInt(st.nextToken()); // 바이러스의 종료

        // 지도 만들기
        int[][] map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0)
                    pq.add(new Virus(i, j, map[i][j]));
            }
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken()); // 지나간 시간
        int X = Integer.parseInt(st.nextToken()); // 바이러스의 위치
        int Y = Integer.parseInt(st.nextToken()); // 바이러스의 위치

        int cnt = 0;
        while (!pq.isEmpty()) {
            if (cnt == S)
                break;
            for (int size = pq.size(); size > 0; size--) {
                Virus curr = pq.poll();
                int nr, nc;
                for (int i = 0; i < 4; i++) {
                    nr = curr.r + dr[i];
                    nc = curr.c + dc[i];
                    if (nr < 1 || nc < 1 || nr > N || nc > N)
                        continue;
                    if (map[nr][nc] != 0)
                        continue;
                    map[nr][nc] = curr.lv;
                    list.add(new Virus(nr, nc, map[nr][nc]));
                }
            }
            for (int i = 0; i < list.size(); i++) {
				pq.add(list.get(i));
			}
            list.clear();
            cnt++;
        }

        System.out.println(map[X][Y]);
    }

    public static void main(String[] args) throws IOException {
        new BOJ_18405_CP().solution();
    }
}
