
import java.util.*;

public class helloGuys {
    static class Profile {
        int team = 10;
    	String name = "장민호";
        int age = 30;
        String major = "정치외교학";
        String[] hobbies = { "요가", "웹툰", "여행", "커피" };
        String[] currentRoles = {"기획","VR 개발", "Front 개발"};
        int friends;
        	
        public Profile() {
			super();
		}
		public Profile(int team, String name, int age, String major, String[] hobbies, int friend) {
			super();
			this.team = team;
			this.name = name;
			this.age = age;
			this.major = major;
			this.hobbies = hobbies;
			this.friends = friend;
		}

  
    }
    
    static HashSet<String> hobbySet = new HashSet<>();
    private String canWeBeFriends(Profile you) {
    	Profile me = new Profile();
		for (int i=0;i<me.hobbies.length;i++) hobbySet.add(me.hobbies[i]);

		boolean weCanBeFriends = false;
		for (String hobby : you.hobbies) 
			if (you.friends == 10 && hobbySet.contains(hobby)) 
				weCanBeFriends = true;
		
		return weCanBeFriends ? "우리 모두 함께 즐거운 프로젝트해요~" : "Go to Hell!";
    }
    public static void main(String[] args) {    	
		for (int team_number = 1;team_number<=11;team_number++) {
			Profile you = new Profile(team_number,"누구나",team_number+20,"전공무관",
					new String[] {"다들", "취미 하나쯤은", "갖고 계시죠?"}, 10);
			new helloGuys().canWeBeFriends(you);
		}
	}
}
