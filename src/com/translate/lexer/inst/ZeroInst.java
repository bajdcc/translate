package com.translate.lexer.inst;

/**
 * 零地址
 * @author bajdc_000
 */
public class ZeroInst implements ILexerInst {

	private LexerInstType type;
	
	public ZeroInst(LexerInstType type) {
		this.type = type;
	}
	
	@Override
	public LexerInstType getType() {
		return type;
	}

	@Override
	public int getData() {
		return -1;
	}

}
