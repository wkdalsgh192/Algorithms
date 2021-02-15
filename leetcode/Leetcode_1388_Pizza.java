package leetcode;
import java.util.*;
public class Leetcode_1388_Pizza {
	private int max,cnt;
    private int[] used;
	private List<Integer> list;
    private Map<String,Integer> map;
    private StringBuilder sb;
    public int maxSizeSlices(int[] slices) {
    	cnt = 0;
    	max = Integer.MIN_VALUE; 
        list = new ArrayList<>();
        map = new HashMap<>();
        used = new int[slices.length];
        sb = new StringBuilder();
        dfs(slices,cnt);
        
        System.out.println(max);
        return max;
    }
    private int dfs(int[] slices, int cnt) {
    	for (int i : list) sb.append(i);
    	if (map.containsKey(sb.toString())) return map.get(sb.toString());
        if (cnt == slices.length) {
            int sum = 0;
            for (int selected : list) {
            	System.out.print(selected+" ");
            	sum += selected;	
            }
            System.out.println(sum);
            max = Math.max(max,sum);
            return sum;
        }
        
        int maxSlice = 0;
        for(int i=0;i<slices.length;i++) {
            if (used[i] == 1) continue; // 이미 사용했다면 패스
            used[i] = 1;
            list.add(slices[i]);
            int antiwise = i,clockwise = i;
            while (used[antiwise]==1) antiwise = antiwise-1<0? slices.length-1:antiwise-1;
            used[antiwise]=1;
        	while (used[clockwise]==1) clockwise = (clockwise+1)%slices.length;
            used[clockwise]=1;
//            System.out.println(i+" "+antiwise+" "+clockwise);
            maxSlice = Math.max(maxSlice, dfs(slices,cnt+3));
            list.remove(list.size()-1);
            used[i]=0;
            used[antiwise]=0;
            used[clockwise]=0;
        }
        // 레벨에 대한 최댓값 구하기
        sb.delete(0, sb.length()-1);
        for (int i : list) sb.append(i);
        map.put(sb.toString(),maxSlice);
        return maxSlice;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Leetcode_1388_Pizza().maxSizeSlices(new int[] {3,10,3,2,10,7,6,5,5,6,10,7});
	}

}
