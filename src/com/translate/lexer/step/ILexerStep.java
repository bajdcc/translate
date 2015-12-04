package com.translate.lexer.step;

import java.util.List;

import com.translate.lexer.inst.ILexerInst;

/**
 * 词法分析的步骤
 * @author bajdc_000
 */
public interface ILexerStep {

	/**
	 * 设置步骤的指令
	 * @param type 步骤类型
	 * @param inst 指令集
	 */
	void setStep(LexerStepType type, List<ILexerInst> inst);

	/**
	 * 返回步骤的指令
	 * @param type 第几个步骤
	 * @return 指令集
	 */
	List<ILexerInst> getStep(LexerStepType type);
}
