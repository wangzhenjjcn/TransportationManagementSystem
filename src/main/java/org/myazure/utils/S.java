package org.myazure.utils;

public class S {
	public S() {

	}

	public static String getRandomNumString(int number) {
		if (number > 0) {
			StringBuffer numberStringBuffer = new StringBuffer();
			for (int i = 0; i < number; i++) {
				int num = (int) (Math.random() * 10L);
				numberStringBuffer.append(num);
			}
			return numberStringBuffer.toString();
		} else {
			return "0";
		}
	}
	
	public static int getRandomNum(int number){
		if ((number>0 ) && (number<16)) {
			return Integer.valueOf(getRandomNumString(number));
		}
		return 0;
	}
	
	public static String getRandomString(int number) {
		if (number > 0) {
			StringBuffer charsBuffer = new StringBuffer();
			String[] chars={"q","w","e","r","t","y","u","i","o","p","a","s","d","f","g","h","j","k","l","z","x","c","v","b","n","m","Q","W","E","R","T","Y","U","I","O","P","A","S","D","F","G","H","J","K","L","Z","X","C","V","B","N","M"};
			int num = (int) (Math.random() * 100L);
			for (int i = 0; i < number;   num = (int) (Math.random() * 100L)) {
				if (num>=0 && num <chars.length) {
					charsBuffer.append(chars[num]);
					i++;
				} 
			}
			return charsBuffer.toString();
		} else {
			return "0";
		}
	}
	
	public static String getRandomStringAndNumber(int number) {
		if (number > 0) {
			StringBuffer charsBuffer = new StringBuffer();
			String[] chars={"1","2","3","4","5","6","7","8","9","0","q","w","e","r","t","y","u","i","o","p","a","s","d","f","g","h","j","k","l","z","x","c","v","b","n","m","Q","W","E","R","T","Y","U","I","O","P","A","S","D","F","G","H","J","K","L","Z","X","C","V","B","N","M"};
			int num = (int) (Math.random() * 100L);
			for (int i = 0; i < number;   num = (int) (Math.random() * 100L)) {
				if (num>=0 && num <chars.length) {
					charsBuffer.append(chars[num]);
					i++;
				} 
			}
			return charsBuffer.toString();
		} else {
			return "0";
		}
	}
	
	
	
	
}
