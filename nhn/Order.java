package nhn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {

	private static int T;
	private static List<Character> list = new ArrayList<>();
	private void Solution() {
		StringBuilder res = new StringBuilder("");
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			String str = sc.next();
			res.append(str);
			
			// 거꾸로 세기
			for (int i = str.length()-1; i <= 0; i++) {
				int start = i-1;
				int end = i;
				char curr = str.charAt(i);
				StringBuilder sb = new StringBuilder("");
				if ('(' == curr) {
					// 내부 연산 처리
					while (str.charAt(end) != ')') {
						if (curr > 48 && curr <= 57) {
							int num = Character.getNumericValue(curr);
							for (int j = 0; j < num; j++) {
								sb.append(str.charAt(i+1));
							}
						} else sb.append(curr);
						end++;
					} // sb에는 괄호 안의 결과물이 저장됨
					
					// 외부 연산 처리
					// 앞이 숫자인 경우
					String inner = sb.toString();
					if (str.charAt(i-1) > 48 && str.charAt(i-1) <= 57) {
						for (int j = 1; j < str.charAt(i-1); j++) {
							sb.append(inner);
						}
					} else { // 앞이 문자인 경우
						sb = sb.delete(0, sb.length()-1);
						char[] subArr = inner.toCharArray();
						for (int j = 0; j < subArr.length; j++) {
							sb.append(str.charAt(i-1)+subArr[j]);	
						}
					}
				}
				System.out.println(sb.toString());
//				res.delete(start, end);
//				res.insert(start, sb.toString());
			}
			
			System.out.println(res.toString());
		}
	}
	public static void main(String[] args) {
		new Order().Solution();
	}

}
