package soma;

import java.io.*;
public class Soma_Test_Protect {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    String str = br.readLine();
	    char[] arr = str.toCharArray();
	    
	    int sum = 0;
	    for (char ch : arr) {
	    	if (ch == ')') sum++;
	    	else sum--;
	    }
	    
	    System.out.println(sum==0?"YES":"NO");  
	}

}
