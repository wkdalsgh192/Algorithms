package simulation;

import java.util.*;
import java.io.*;

/**
 * BOJ_14502_Lab
 */
public class BOJ_14502_Lab {

    static int n, m, idx, max, map[][];
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static StringTokenizer st;
    static Queue<int[]> q = new LinkedList<>();
    static List<int[]> list = new ArrayList<>();

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        idx = 0;
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2)
                    list.add(new int[] { i, j });
            }
        }

        dfs(0, 0, map);

        System.out.println(max);
    }

    private static void dfs(int si, int cnt, int[][] map) {
        if (cnt == 3) {
            // 안전 영역 크기 구하기
            max = Math.max(max, bfs()); // map의 변형이 일어나지 않아?
            return;
        }
        for (int i = si; i < n; i++) {
            for (int j = 0; j < m; j++) { // 0부터 하면 중복 체크가 되지 않나?
                if (map[i][j] == 1 || map[i][j] == 2)
                    continue;
                map[i][j] = 1;
                dfs(i, cnt + 1, map);
                map[i][j] = 0;
            }
        }
    }

    private static int bfs() { // 인자로 들어오는 맵에만 칠해야한다.
        int num = 0;
        int nr, nc;
        int[][] newMap = Arrays.stream(map).map(int[]::clone).toArray(int[][]::new);

        // int[][] newMap = new int[n][m];
        // for (int i = 0; i < n; i++) { // 최적화가 가능하다
        // newMap[i] = map[i].clone(); // 1차원 배열을 clone하면 깊은 복사가 된다.
        // }

        // for (int i = 0; i < n; i++) {
        // System.out.println();
        // for (int j = 0; j < m; j++) {
        // System.out.print(newMap[i][j] + " ");
        // }
        // }

        q.clear();
        for (int[] arr : list)
            q.add(arr);

        while (!q.isEmpty()) { // 큐에 아무것도 들어가있지 않게 된다.
            int[] curr = q.poll();

            for (int i = 0; i < 4; i++) {
                nr = curr[0] + dr[i];
                nc = curr[1] + dc[i];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m)
                    continue;
                if (newMap[nr][nc] == 1 || newMap[nr][nc] == 2)
                    continue;

                newMap[nr][nc] = 2;
                q.add(new int[] { nr, nc });
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (newMap[i][j] == 0)
                    num++;
            }
        }
        return num;
    }

    public static void main(String[] args) throws IOException {
        new BOJ_14502_Lab().solution();
    }
}
