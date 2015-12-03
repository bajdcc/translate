package com.translate.lexer.inst;

/**
 * 词法分析指令（零地址或一地址）
 * @author bajdc_000
 */
public interface ILexerInst {

	/**
	 * @return 指令类型
	 */
	LexerInstType getType();
	
	/**
	 * @return 指令数据
	 */
	int getData();
}
