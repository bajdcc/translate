package com.translate.style.rmb;

import java.util.ArrayList;
import java.util.List;

import com.translate.lexer.Lexer;
import com.translate.lexer.inst.ILexerInst;
import com.translate.lexer.inst.ILexerStep;
import com.translate.lexer.inst.InstFactory;
import com.translate.lexer.inst.LexerInstType;
import com.translate.lexer.inst.LexerStep;
import com.translate.lexer.inst.LexerStepType;
import com.translate.style.IStyle;

/**
 * RMB翻译方案
 * @author bajdc_000
 */
public class RmbStyle implements IStyle {

	static private RmbStyle style;
	
	/**
	 * 词法分析的状态机指令
	 */
	private List<ILexerStep> lexerSteps;
	
	public RmbStyle() {
		initLexerSteps();
	}
	
	/**
	 * 词法分析的状态机指令
	 */
	private void initLexerSteps() {
		lexerSteps = new ArrayList<ILexerStep>();
		ILexerStep step;
		List<ILexerInst> insts;
		
		step = new LexerStep();
		lexerSteps.add(step);
		insts = new ArrayList<ILexerInst>();
		insts.add(InstFactory.createInst(LexerInstType.RecordStart));
		step.setStep(LexerStepType.Begin, insts);
		insts = new ArrayList<ILexerInst>();
		insts.add(InstFactory.createInst(LexerInstType.Mov, 0));
		insts.add(InstFactory.createInst(LexerInstType.MatchReg));
		insts.add(InstFactory.createInst(LexerInstType.If, 5));
		insts.add(InstFactory.createInst(LexerInstType.RecordEnd));
		insts.add(InstFactory.createInst(LexerInstType.Stop));
		insts.add(InstFactory.createInst(LexerInstType.Exit));
		step.setStep(LexerStepType.Next, insts);
	}	

	@Override
	public List<ILexerStep> getLexerStep() {
		return lexerSteps;
	}

	@Override
	public Lexer createLexer(String text) {
		return new RmbLexer(text, this);
	}

	static public synchronized IStyle singleton() {
		if (style == null) {
			style = new RmbStyle();
		}
		return style;
	}
}
