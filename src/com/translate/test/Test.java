package com.translate.test;

import com.translate.style.rmb.RmbParser;

public class Test {

	public static void main(String[] args) {
		
		try {
			RmbParser parser = new RmbParser("000905000234.0678");
			System.out.println(parser.toNumberString());
			System.out.println(parser.toString());
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
