package simulation;

public class Programmers_P_NQ {

	int answer = 0;
    int nn = 0;
    int cols[];
    public int solution(int n) {
        
        cols = new int[n]; // n개의 열을 만든다
        nn=n;
        
        queen(0); // 0열부터 검사를 시작한다.
        return answer;   
    }
    private void queen(int lev) {
        if (lev==nn) {
            answer++;
            return;
        }
        for(int i=0;i<nn;i++) {
            cols[lev] = i;
            // 해당 부분이 백트래킹!
            if (isPossible(lev)) queen(lev+1);
        }
    }
    private boolean isPossible(int lev) {
        for (int i=0;i<lev;i++) { // lev 이전의 열들에 대해 겹치는 지 조사
            if (cols[i] == cols[lev]) // 가로 체크 
                return false;
            if (Math.abs(lev-i) == Math.abs(cols[lev] - cols[i])) // 대각선 체크
                return false;
        }
        
        return true;
    }
}
