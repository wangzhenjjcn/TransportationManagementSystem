package org.myazure.transportation;

import org.myazure.utils.S;

public class PinYinTest {
	public static void main(String[] args) {
		System.out.println(S.getHardChineseWords());
		System.out.println(S.getPinYin(S.getHardChineseWords()));
		System.out.println("=======================");
		System.out.println(S.getPinYinFirstChar(S.getHardChineseWords()).toUpperCase());
		System.out.println(S.getPinYinFirstChar("长沙市长").toUpperCase());
		
	}

}
