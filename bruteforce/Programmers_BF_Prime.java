
import java.util.*;

public class Programmers_BF_Prime {
	private static int res;
    private static boolean[] used;
    private static StringBuilder sb;
    private static Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        // 배열로 변경
        // 1부터 최대 자리수까지 순회하면서
        for (int i=1;i<=numbers.length();i++) {
        	sb = new StringBuilder();
            used = new boolean[numbers.length()];
            makeNumbers(0,i,numbers);
        }
        System.out.println(res);
        return res;
    }
    private static void makeNumbers(int cnt,int n, String numbers) {
        if (cnt == n) {
        	int target=Integer.parseInt(sb.toString());
        	if (target < 2 || set.contains(target)) return;
        	// 약수 판단.
        	for (int i = 2; i < target; i++) if (target % i == 0) return;
        	set.add(target);
            res++;
        }
        
        // n자리 숫자들로 만들 수 있는 숫자 구성
        for(int i=0;i<numbers.length();i++) { // 조합으로 만들어야 한다.
        	if (used[i]) continue;
        	used[i] = true;
        	sb.append(numbers.charAt(i));
            makeNumbers(cnt+1,n,numbers);
            used[i] = false;
            sb.deleteCharAt(sb.length()-1);
        }
    }
	public static void main(String[] args) {
		new Programmers_BF_Prime().solution("123");
	}

}
