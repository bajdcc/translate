package com.translate.lexer.inst;

import java.util.ArrayList;
import java.util.List;

/**
 * 词法分析的步骤实现
 * @author bajdc_000
 */
public class LexerStep implements ILexerStep {

	private List<List<ILexerInst>> steps;
	
	public LexerStep() {
		steps = new ArrayList<List<ILexerInst>>(LexerStepType.values().length);
		for (int i = 0; i < LexerStepType.values().length; i++) {
			steps.add(null);
		}
	}
	
	@Override
	public void setStep(LexerStepType type, List<ILexerInst> inst) {
		steps.set(type.ordinal(), inst);
	}
	
	@Override
	public List<ILexerInst> getStep(LexerStepType type) {
		return steps.get(type.ordinal());
	}
}
