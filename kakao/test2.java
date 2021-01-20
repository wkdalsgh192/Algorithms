package kakao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class test2 {
	
	private static int max;
	private static Character[] arr;
	private static List<char[]> list = new ArrayList<>();
	private static List<String> save;
	private static List<String> result;
	private static Set<Character> menu = new TreeSet<Character>();
	private static char[] output;
	private static boolean[] used;
	public String[] solution(String[] orders, int[] course) {
		
		// 주어진 메뉴 조합을 charArray, HashSet으로 만들기
		int len=0; // 단품 메뉴 구성의 최대 길이 구하기
		for (String s : orders) {
			list.add(s.toCharArray()); // 단품 메뉴로 쪼개서 저장하기
			for (char ch : list.get(list.size()-1)) {
				if (!menu.contains(ch)) menu.add(ch); // 메뉴에서 포함되어있지 않으면 추가하기 - 자동 정렬
			}
			
			len = Math.max(max, s.length());
		}
		
		arr = new Character[menu.size()]; // 현재 generics 버전의 character로 저장됨 조심하기
		arr = menu.toArray(arr);
		
		// 코스 요리 갯수만큼 조합 구성을 달리해서 반복
		result = new ArrayList<>();
		for (int i = 0; i < course.length; i++) { // 만약 코스 요리 갯수에 없는 조합을 만들면 시간 낭비다.
			if (course[i] > len) continue; // course 갯수가 아무리 많아도 구성 최댓값보다 크면 조합을 만들 수 없다.
			
			// 초기화 변수 
			max = 0; 
			used = new boolean[menu.size()];
			output = new char[course[i]];
			save = new ArrayList<>();
			
			// 갯수에 맞는 조합 만들기
			Combination(0,0,course[i]);
			
			// 한 번 돌 때마다 각 구성에 따른 메뉴 구성 집합이 저장되어 나온다.
			result.addAll(save);
		}

		// 정답 출력
		Collections.sort(result);
		String[] answer = new String[result.size()];
		
		for (int i = 0; i < answer.length; i++) answer[i] = result.get(i);
		
		return answer;
    }
	
	private static void Combination(int idx, int start, int r) {
		if (idx == r) { // 하나의 조합에 들어가는 단품의 갯수
			
			// 조합이 만들어졌으므로 이제 이 조합이 각각의 주문 메뉴에 몇개나 있는 지확인
			int res=0;
			for (int i = 0; i < list.size(); i++) { // 각각의 메뉴 조합에 대하여
				boolean flag = false;
				char[] arrChar = list.get(i);
				for (int j = 0; j < r; j++) {
					if(!contains(arrChar, output[j])) {
						flag = true;
						break;
					}
				} //하나의 메뉴 조합에 내가 만든 코스메뉴 중 일부가 안 들어가있으면 다음으로 넘어감
				
				if (!flag) {res++;} // flag가 안 바뀌어 있으면 코스메뉴가 손님의 단품 메뉴에 전부 있다는 말이다.
				
			} // 전체 조합에 내가 만든 코스메뉴가 들어있는 지 확인
			
			//확인 결과를 비교하고 같으면 배열리스트에 저장
			if (res >= 2) {
				if (res == max) {
					save.add(new String(output)); // 저장하기
				}
				
				//크면 기존 배열리스트를 비우고 새로 저장
				if (res > max) {
					save.clear();
					save.add(new String(output));
					max = Math.max(max, res);
				}
			}
			
			return;
		}
		
		for (int i = start; i < menu.size(); i++) { // 각각의 단품 메뉴에 관하여
			if (used[i]) continue; // 이미 구성에 포함했으면 지나가기
			output[idx] = arr[i]; 
			used[i] = true;
			Combination(idx+1, i+1, r);
			used[i] = false;
		}
	}
	
	private static boolean contains(char[] arr, char val) {
		for(char ch: arr){

		    if(ch == val)
		      return true;
		  }
		
		return false;
	}
}
