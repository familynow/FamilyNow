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
	
	public static String GetRandomDate(){
		String[] possibleDates = {"01", "02", "03","04","05","06","07","08","09","10","11","12","13","14","15","16","18","19","20","21","22","23","24","25","26","27","28"};
		 int rnd = new Random().nextInt(possibleDates.length);
		 return possibleDates[rnd];
		
	 }
	
	
	public static String GetRandomFirstName(){
		String[] fname = {"James", "Michael", "Maria","David","Mary","Charles","Ambrose","Amery","Calvin","Carrick","Carl","Carlton"};
		 int rnd = new Random().nextInt(fname.length);
		 return fname[rnd];
		
	 }
	
	public static String GetRandomLasttName(){
		String[] lname = {"Smith", "Johnson", "Williams","Jones","Brown","Davis","Miller","Wilson","Moore","Taylor","Anderson","Thomas"};
		 int rnd = new Random().nextInt(lname.length);
		 return lname[rnd];
		
	 }
	

}
