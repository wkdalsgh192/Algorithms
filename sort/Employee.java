package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Employee {

	static int T,N,cnt,min,arr[];
	static void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N+1];
			
			StringTokenizer st;
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
			}
			
//			Arrays.sort(arr, (a,b) -> Integer.compare(a[0], b[0])); // 1차 성적 기준 오름차순 정렬
			
			cnt=1;
			min=arr[1]; // 첫번째가 기준 순위가 된다
			for (int i = 2; i <= N; i++) {
				if (arr[i] < min) {
					min = arr[i];
					cnt++;
				}
			}
			
			System.out.println(cnt);
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Employee().solution();
	}

}
