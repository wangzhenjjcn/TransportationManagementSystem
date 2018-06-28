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
}
