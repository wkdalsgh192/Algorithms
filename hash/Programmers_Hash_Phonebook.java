package hash;

public class Programmers_Hash_Phonebook {

	public boolean solution(String[] phone_book) {
        
		boolean answer = true;
        for (int i=0;i<phone_book.length;i++) {
        	String curr = phone_book[i];
            for (int j=0;j<phone_book.length;j++) if (i != j && phone_book[j].startsWith(curr)) return answer = false;
        }
        
        return answer;
    }
	public static void main(String[] args) {
		new Programmers_Hash_Phonebook().solution(new String[] {"119", "976", "1191"});
	}

}
