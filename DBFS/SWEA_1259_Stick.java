package DBFS;

import java.util.*;
import java.io.*;
public class SWEA_1259_Stick {
    private int T,N;
    private boolean[] visit;
    private String str,max;
    private List<Integer[]> list;
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++) {
           
            // 나사 세트 만들기
            N = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) {
                list.add(new Integer[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
            }

            // 돌아가면서 dfs 돌기
            max="";
            for(int i=0;i<N;i++){
                Integer[] curr = list.get(i);
                visit = new boolean[N];
                visit[i]=true;
                str = ""+curr[0]+" "+curr[1]+" ";
                dfs(list.get(i),1);
            }

            System.out.println("#"+t+" "+max);
        }
    }
    private void dfs(Integer[] arr, int cnt) {
        // 최댓값 갱신
        if (str.length()>max.length()) {
            max = str.substring(0,str.length());   
        }
        
        for(int i=0;i<N;i++) {
            if (visit[i]) continue;
            Integer[] curr = list.get(i);
            if (arr[1]==curr[0]) {
                visit[i] = true;
                str += curr[0]+" "+curr[1]+" ";
                dfs(curr,cnt+1);
                visit[i]=false;
                str.substring(0, str.length()-4);
            }
        }
        return;
    }
    public static void main(String[] args) throws IOException {
        new SWEA_1259_Stick().solution();
    }
}