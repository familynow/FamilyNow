package General;

import java.util.Random;

public class Utilities {
	
	public static String GetRandomString(int count){
		 char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		 StringBuilder sb = new StringBuilder();
		 Random random = new Random();
		 for (int i = 0; i < count; i++) {
		     char c = chars[random.nextInt(chars.length)];
		     sb.append(c);
		 }
		 
		 return sb.toString();
	 }

}
