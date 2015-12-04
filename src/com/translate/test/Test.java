package com.translate.test;

import com.translate.style.rmb.RmbParser;

public class Test {

	public static void main(String[] args) {
		
		RmbParser parser = new RmbParser("00001234");
		System.out.println(parser.toString());
	}
}
