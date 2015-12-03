package com.translate.style.rmb;

import com.translate.lexer.Lexer;
import com.translate.style.IStyle;

public class RmbLexer extends Lexer {

	public RmbLexer(String string, IStyle style) {
		super(string, style);		
	}

	@Override
	public String toString() {		
		return "RMB Lexer" + "\n" + this.text;
	}	
}
