package com.translate.style;

import java.util.List;

import com.translate.lexer.Lexer;
import com.translate.lexer.inst.ILexerStep;

/**
 * 翻译方案的通式
 * @author bajdc_000
 */
public interface IStyle {

	/**
	 * 创建词法分析器
	 * @param string 输入
	 * @return 词法分析器
	 */
	Lexer createLexer(String string); 
	
	/**
	 * 返回词法分析的指令步骤
	 * @return 指令步骤
	 */
	List<ILexerStep> getLexerStep();
}
