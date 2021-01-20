package bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SetOp {

	private static int M, num;
	private void Solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		M = Integer.parseInt(br.readLine());
		num = 0;
		
		String op= null;
		int val = 0;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			op = st.nextToken();
			if (!"all".equals(op) && !"empty".equals(op)) val = Integer.parseInt(st.nextToken());
			
//			if ("add".equals(op)) num = updateBit(num, val, true);
//			else if ("remove".equals(op)) num = updateBit(num, val, false);
//			else if ("toggle".equals(op)) num = toggleBit(num, val);
//			else if ("all".equals(op)) num = allBit(num, true);
//			else if ("empty".equals(op)) num = allBit(num, false);
//			else checkBit(num, val);
			
			if ("add".equals(op)) num = ((num & ~(1 << val)) | (1 << val));
			else if ("remove".equals(op)) num = ((num & ~(1 << val)) | (0 << val));
			else if ("toggle".equals(op)) num = (num ^ (1 << val));
			else if ("all".equals(op)) num = (num | ((1 << 21)-1));
			else if ("empty".equals(op)) num = (num & ((1 << 21)));
			else {
				if ((num & (1 << val)) != 0) sb.append("1\n");
				else sb.append("0\n");
			}
		}
		
		System.out.println(sb);
		
	}
	private static void checkBit(int num, int i) {
		if ((num & (1 << i)) != 0) System.out.println(1);
		else System.out.println(0);
	}
	private static int toggleBit(int num, int i) {
		return num ^ (1 << i);
	}
	private static int allBit(int num, boolean flag) {
		if (flag) return num | ((1 << 21)-1);
		else return num & ((1 << 21));
	}
	private static int updateBit(int num, int i, boolean flag) {
		return (num & ~(1 << i)) | ((flag?1:0) << i);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		new SetOp().Solution();

	}

}
