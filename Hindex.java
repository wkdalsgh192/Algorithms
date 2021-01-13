package sort;

import java.util.*;

class Hindex {
    static int h,ht,cnt,ans,arr[];
    public int solution(int[] citations) {
        
        // 오름차순 정렬
        Arrays.sort(citations);
        
        // 인용된 횟수 저장
        cnt = 1;
        arr = new int[citations[citations.length-1]+1];
        for(int i=1;i<citations.length;i++) {
            if (citations[i] == citations[i-1]) cnt++;
            else {
                arr[citations[i-1]] = cnt;
                cnt=1;
            }
            if (i == citations.length-1) arr[citations[citations.length-1]] = cnt;
        }
        
        // 인용된 횟수 차감하면서 확인
        h = citations.length; // 총 논문 수
        ht = 0; // h번 이하 인용된 논문 수
        ans = 0;
        for (int i = 0; i < arr.length; i++) {
			if (h >= i && ht <= i) ans = i;
			h -= arr[i]; // 총 논문 수에서 i번 인용된 논문 수를 제외
			ht += arr[i];
		}
        
        System.out.println(ans);
        return ans;
    }
    public static void main(String[] args) {
    	int[] citations = new int[] {3,0,6,1,5}; //3,0,6,1,5
		new Hindex().solution(citations);
	}
}