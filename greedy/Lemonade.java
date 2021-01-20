package greedy;

public class Lemonade {

	public boolean lemonadeChange(int[] bills) {
        int c1=0,c2=0,c3=0;
        
        boolean flag = true;
        
        for(int i=0;i<bills.length;i++) {
            switch (bills[i]) {
                case 5:
                    c1++;
                    break;
                case 10:
                    if (c1>0) {
                    	c2++;
                    	c1--;
                    }
                    else return flag=false;
                    break;
                case 20:
                    if (c1 > 0 && c2 > 0) {
                        c1-=1;
                        c2-=1;
                        c3++;
                    }
                    else if (c1 > 2) {
                    	c1 -= 3;
                    	c3++;
                    }
                    else {
                    	return flag=false;
                    }
                    break;
            }
        }
        
        return flag;
    }
	
	public static void main(String[] args) {
		int[] bills = new int[] {5,5,5,10,20};
		new Lemonade().lemonadeChange(bills); 
	}

}
