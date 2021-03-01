package soma;

import java.util.*;
import java.io.*;
public class Soma_020701_Story {
	
	private static List<String> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine()); // 스킬 입력
		
		int N = Integer.parseInt(br.readLine());
		
		Set<Character> set = new HashSet<>();
		char[][] arr = new char[N][];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new char[] {st.nextToken().charAt(0),st.nextToken().charAt(0)};
			set.add(arr[i][1]);
		}
		
		for (int i = 0; i < N; i++) {
			boolean[] visit = new boolean[N];
			if (!set.contains(arr[i][0])) {
				String str = arr[i][0]+" ";
				visit[i] = true;
				dfs(arr[i][1], str, visit,arr);
			}
		}
		
		for (String str : list) System.out.println(str);
		
	}
	private static void dfs(char ch, String str, boolean[] visit, char[][] arr) {
		str += ch+" ";
		
		boolean flag = false;
		for (int i = 0; i < visit.length; i++) {
			if (arr[i][0] == ch && !visit[i]) {
				flag = true;
				visit[i] = true;
				dfs(arr[i][1],str,visit,arr);
				visit[i] = false;
			}
		}
		
		if (!flag) list.add(str);
		return;
	}

}
