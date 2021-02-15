package others;

public class Sort {

	static int[] insertionSort(int[] list) {
		int temp = 0, idx=0;
		for(int i=1;i<list.length;i++) {
			temp = list[i]; // 스왑을 위해 기준값 저장 - 10 저장
			for (idx = i-1; idx >= 0 && temp<list[idx]; idx--) { // 기준값보다 작은 값을 찾을 때까지 기준 위치에서 왼쪽으로 이동
				list[idx+1] = list[idx]; // 빈 공간 만들어주기
			}
			list[idx+1] = temp; // 5가 들어가야하는 자리
				
		}
		
		return list;
	}
	public static void main(String[] args) {
		
		int[] list = {1,5,6,10,5};
		
		list = Sort.insertionSort(list);
		for (int i:list) System.out.print(i+" ");
	}

}
