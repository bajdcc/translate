package com.translate.lexer.inst;

/**
 * 一地址
 * @author bajdc_000
 */
public class OneInst extends ZeroInst {
	
	private int data;
	
	public OneInst(LexerInstType type, int data) {
		super(type);
		this.data = data;
	}

	@Override
	public int getData() {
		return data;
	}

	@Override
	public String toString() {
		return super.toString() + " " + data;
	}
}
