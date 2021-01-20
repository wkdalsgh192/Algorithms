package bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BitOperation {

	private static String res;
	private static String andOp(int a, int b) {
		res = Integer.toBinaryString(a&b).toString();
		return String.format("%06d", Integer.parseInt(res));
	}
	
	private static String orOp(int a, int b) {
		res = Integer.toBinaryString(a|b).toString();
		return String.format("%06d", Integer.parseInt(res));
	}
	private static String xorOp(int a, int b) {
		res = Integer.toBinaryString(a^b).toString();
		return String.format("%06d", Integer.parseInt(res));
	}
	private static String notOp(int num) {
		res = Integer.toBinaryString(~num).toString();
		return res.substring(res.length()-6, res.length());
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(br.readLine().trim(), 2);
		int b = Integer.parseInt(br.readLine().trim(), 2);
		
		
		System.out.println(andOp(a, b));
		System.out.println(orOp(a, b));
		System.out.println(xorOp(a, b));
		System.out.println(notOp(a));
		System.out.println(notOp(b));
	}

}
