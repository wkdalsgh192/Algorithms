package hash;

import java.util.*;
public class Marathon {

	// 해쉬맵을 이용한 풀이 방법
	static String answer="";
	public String solution(String[] participant, String[] completion) {
        Map<String,Integer> map = new HashMap<>();
        
        for(String str : participant) map.put(str, map.getOrDefault(str, 0)+1);
        
        for (String str : completion) {
            if(map.get(str) == 1) map.remove(str);
            else map.replace(str, map.get(str)-1);
        }
        
        map.forEach((k,v) -> {answer=k;});
        return answer;
    }
	
	// 배열을 이용한 풀이방법 -- 시간 복잡도가 O(N*N)으로 효율성 테스트를 통과하지 못한다.
	public String solution2(String[] participant, String[] completion) {
		
		
		
		for (int i = 0; i < completion.length; i++) {
			String player = completion[i];
			for (int j = 0; j < participant.length; j++) {
				if (player.equals(participant[j])) {
					participant[j] = "";
					break;
				}
			}
		}
		
		for (String str : participant) if (!"".equals(str)) answer = str;
		
		System.out.println(answer);
        return answer;
    }
	
	// 배열을 이용한 풀이 답안
	public String solution3(String[] participant, String[] completion) {
		
		Arrays.sort(participant);
		Arrays.sort(completion);
		
//		for (String str:participant) System.out.print(str+" ");
//		System.out.println();
//		for (String str : completion) System.out.print(str+" ");
		
		int i=0;
		for(;i<completion.length;i++) {
			// 동명이인이 있는 경우
			if (!participant[i].equals(completion[i])) return participant[i];
		}
        return participant[i];
    }

	public static void main(String[] args) {
		String[] participant = new String[] {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion = new String[] {"josipa", "filipa", "marina", "nikola"};
		
		new Marathon().solution3(participant, completion);
	}
}
