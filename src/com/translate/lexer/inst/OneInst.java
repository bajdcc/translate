package com.translate.lexer.inst;

/**
 * 一地址
 * @author bajdc_000
 */
public class OneInst implements ILexerInst {
	
	private LexerInstType type;
	private int data;
	
	public OneInst(LexerInstType type, int data) {
		this.type = type;
		this.data = data;
	}
	
	@Override
	public LexerInstType getType() {
		return type;
	}

	@Override
	public int getData() {
		return data;
	}

}
