package kakao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test1 {
	
	private static String id;
	private static List<Character> list;
	private void Solution() {
		Scanner sc = new Scanner(System.in);
		id = sc.next();
		
		// 1단계: char로 바꾸기
		char[] charArr = id.toCharArray();
		for (int i = 0; i < charArr.length; i++) {
			if (65<=charArr[i] && charArr[i] <=90) charArr[i] += 32;
		}
		
		// 2단계 : 특수문자 제거하기
		id = charArr.toString();
		list = new ArrayList<>();
		
		for (int i = 0; i < charArr.length; i++) {
			list.add(charArr[i]);
		}
		
		char[] specs = "~!@#$%^&*()=+[{]}:?,<>".toCharArray(); // 제거할 특수문자셋
		for (int i = 0; i < specs.length; i++) {
			for (int j = 0; j < list.size(); j++) {
				char ch = list.get(j);
				if (ch == specs[i]) list.remove(j);
			}
		}
		
		//3단계 : 연속된 마침표 합치기
		int idx=0;
		while (idx < list.size()) {
			int cnt=0;
			for (int i = 1; i < list.size(); i++) {
				if (list.get(i) == '.') {
					cnt++;
				}
				if (cnt >= 2) {
					list.remove(i);
					idx = 0;
					break;
				}
			}
			idx++;
		}
		
		// 4단계: 맨 처음과 끝 . 제거하기
		if (list.get(0).equals('.')) list.remove(0);
		if (list.get(list.size()-1).equals('.')) list.remove(list.size()-1);
		
		// 5단계: 빈 문자열 체크
		if (list.size() == 0) list.add('a');
		
		// 6단계 : 15자 이상 체크 + 마침표 체크
		if (list.size() >= 16) {
			while (list.size() > 15) {
				list.remove(list.size()-1);
			}
		}
		if (list.get(list.size()-1).equals('.')) list.remove(list.size()-1);
		
		// 7단계 : 최소 글자 체크
		if (list.size() <= 2) {
			char last = list.get(list.size()-1);
			while (list.size() != 3) {
				list.add(last);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (char ch : list) sb.append(ch);
		
		System.out.println(sb.toString());
		sc.close();
	}
	
	public static void main(String[] args) {
		new test1().Solution();
	}

}
