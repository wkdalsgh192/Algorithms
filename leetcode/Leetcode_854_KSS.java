package leetcode;

/**
 * Leetcode_854_KSS
 */
public class Leetcode_854_KSS {
    static StringBuilder a;

    public int kSimilarity(String A, String B) {
        int answer = 0;
        a = new StringBuilder(A);
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == B.charAt(i))
                continue;
            else {
                boolean flag = false;
                for (int j = i + 1; j < a.length(); j++) {
                    if (a.charAt(j) == B.charAt(i) && a.charAt(i) == B.charAt(j)) {
                        swap(i, j);
                        answer++;
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    for (int j = i + 1; j < a.length(); j++) {
                        if (a.charAt(j) == B.charAt(i)) {
                            swap(i, j);
                            answer++;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(answer);
        return answer;
    }

    static void swap(int i, int j) {
        char temp = a.charAt(j);
        a.setCharAt(j, a.charAt(i));
        a.setCharAt(i, temp);
    }

    public static void main(String[] args) {
        new Leetcode_854_KSS().kSimilarity("abccaacceecdeea", "bcaacceeccdeaae");
    }
}