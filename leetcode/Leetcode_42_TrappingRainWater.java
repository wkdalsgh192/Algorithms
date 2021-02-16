class Solution {
    public int trap(int[] height) {
        int cnt=0,start=0,end=0;
        for (int i=0;i<height.length;i++) {
            
            if (start == 0 && height[i] == 0) continue; // 섹션이 없으면 막을 수 없음.
            start = start == 0? height[i]:end;
            end = endPoint(start,i,height);
            if (start > end) start = end;
            
            // 트랩된 물 게산하기
            while (i<height.length && height[i] < end) {
                // System.out.println(start-height[i]);
                cnt += start - height[i];
                i++;
            }
            
            // System.out.println(start+" "+end+" "+cnt);
            
            
        }
        System.out.println(cnt);
        return cnt;
    }
    private int endPoint(int start, int idx, int[] height) {
        int end = 0;
        for (int i=idx;i<height.length;++i) {
            if (height[i] >= start) return end = height[i];
            if (height[i] > end) end = height[i];
        }
        return end;
    }
}
