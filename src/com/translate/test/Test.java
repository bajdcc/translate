package com.translate.test;

import com.translate.style.rmb.RmbParser;

public class Test {

	public static void main(String[] args) {
		
		try {
			RmbParser parser = new RmbParser("000543565636123gf.46666.");
			System.out.println(parser.toString());
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
