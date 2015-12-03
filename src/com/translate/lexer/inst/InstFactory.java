package com.translate.lexer.inst;

public class InstFactory {

	/**
	 * 创建零地址指令
	 * @param type
	 * @return
	 */
	static public ZeroInst createInst(LexerInstType type) {
		return new ZeroInst(type);
	}
	
	/**
	 * 创建一地址指令
	 * @param type
	 * @param data
	 * @return
	 */
	static public OneInst createInst(LexerInstType type, int data) {
		return new OneInst(type, data);
	}
}
