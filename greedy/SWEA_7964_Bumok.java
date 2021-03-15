package greedy;

import java.util.*;
import java.io.*;
public class SWEA_7964_Bumok {
    private int T,N,R,cnt,ans;
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            cnt=0; // 0의 갯수
            ans=0; // 차원관문수
            while(st.hasMoreTokens()) {
                if (st.nextToken().equals("0")) {
                    cnt+=1;
                    if (cnt>=R) {
                        ans++;
                        cnt=0;
                    } 
                } else cnt=0;
                // System.out.println(cnt+" "+ans);
            }

            System.out.println("#"+t+" "+ans);

        }
    }
    public static void main(String[] args) throws IOException {
        new SWEA_7964_Bumok().solution();
    }
}