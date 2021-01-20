package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Truck {

	static int n,w,L,t,cnt,weight,next,truck[],time[];
	static void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 트럭 수
		w = Integer.parseInt(st.nextToken()); // 다리 길이
		L = Integer.parseInt(st.nextToken()); // 최대 하중
		
		truck = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) truck[i] = Integer.parseInt(st.nextToken());
		
		time = new int[n]; // 트럭이 다리위에 있는 시간
		while (true) {
			t++; // 시간이 흐른다
			// 탑승 시간을 조정하고, 도착한 트럭이 있는 경우 무게를 감소시킨다.
			if (weight > 0) weight = reduceTime(time, next, weight);
			
			// 탑승가능여부 확인
			if (next < n && weight + truck[next] <= L) {
				time[next] = w; // 탑승
				weight += truck[next];
				next++; // 다음트럭으로 이동
			}
			
			if (cnt == n) break; // 모든 트럭이 다리를 건너면 종료
		}
		
		System.out.println(t);
		
	}
	static int reduceTime(int[] time, int next, int weight) {
		for (int i = 0; i < next; i++) if (time[i]>0) {
			time[i] -= 1; // 현재 다리 위에 있으면 시간을 감소시킨다.
			if (time[i] == 0) {
				weight -= truck[i];
				cnt++; // 도착 트럭 수 증가
			}
		}
		
		return weight;
	}
	public static void main(String[] args) throws IOException {
		new Truck().solution();
	}

}
