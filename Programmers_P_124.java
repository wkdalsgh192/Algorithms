public class Programmers_P_124 {
	
	public String solution(int n) {
        String[] num = new String[] {"4","1","2"};
        String answer = "";
        
        while (n > 0) {
            answer = num[n%3]+answer;
            n = (n-1)/3;
        }
        return "1";
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
