package com.translate.style.rmb;

import java.util.ArrayList;
import java.util.List;

import com.translate.lexer.Lexer;
import com.translate.lexer.inst.ILexerInst;
import com.translate.lexer.inst.InstFactory;
import com.translate.lexer.inst.LexerInstType;
import com.translate.lexer.step.ILexerStep;
import com.translate.lexer.step.LexerStep;
import com.translate.lexer.step.LexerStepType;
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
		
		/* STATE 0 - Number */
		step = new LexerStep();
		lexerSteps.add(step);
		insts = new ArrayList<ILexerInst>();
		/**
		 * If IsRecording
		 *   Exit
		 * If Match 1
		 *   Pass
		 *   BeginRecord
		 * Else
		 *   JumpState 2
		 *   ExitStep
		 */
		/*[00]*/ insts.add(InstFactory.createInst(LexerInstType.IS_RECOEDING));
		/*[01]*/ insts.add(InstFactory.createInst(LexerInstType.IF, -1));
		/*[02]*/ insts.add(InstFactory.createInst(LexerInstType.MOV, 1));
		/*[03]*/ insts.add(InstFactory.createInst(LexerInstType.MATCH));
		/*[04]*/ insts.add(InstFactory.createInst(LexerInstType.IF, 7));
		/*[05]*/ insts.add(InstFactory.createInst(LexerInstType.JUMP_STATE, 2));
		/*[06]*/ insts.add(InstFactory.createInst(LexerInstType.EXIT_STEP));
		/*[07]*/ insts.add(InstFactory.createInst(LexerInstType.PASS));
		/*[08]*/ insts.add(InstFactory.createInst(LexerInstType.BEGIN_RECODE));
		step.setStep(LexerStepType.CURRENT, insts);
		insts = new ArrayList<ILexerInst>();
		/**
		 * If Match 1
		 *   Pass
		 * Else
		 *   EndRecord
		 *   If Load 100
		 *     JumpState 4
		 *     ExitStep
		 *   If Match 3
		 *     Pass
		 *     JumpState 1
		 *     ExitStep
		 *   Else
		 *     JumpState 3
		 *     ExitStep
		 */
		/*[00]*/ insts.add(InstFactory.createInst(LexerInstType.MOV, 1));
		/*[01]*/ insts.add(InstFactory.createInst(LexerInstType.MATCH));
		/*[02]*/ insts.add(InstFactory.createInst(LexerInstType.IF, 13));
		/*[03]*/ insts.add(InstFactory.createInst(LexerInstType.JMP, 15));
		/*[04]*/ insts.add(InstFactory.createInst(LexerInstType.MOV, 3));
		/*[05]*/ insts.add(InstFactory.createInst(LexerInstType.MATCH));
		/*[06]*/ insts.add(InstFactory.createInst(LexerInstType.IF, 10));
		/*[07]*/ insts.add(InstFactory.createInst(LexerInstType.JUMP_STATE, 3));
		/*[08]*/ insts.add(InstFactory.createInst(LexerInstType.PASS));
		/*[09]*/ insts.add(InstFactory.createInst(LexerInstType.EXIT_STEP));
		/*[10]*/ insts.add(InstFactory.createInst(LexerInstType.PASS));
		/*[11]*/ insts.add(InstFactory.createInst(LexerInstType.JUMP_STATE, 1));
		/*[12]*/ insts.add(InstFactory.createInst(LexerInstType.EXIT_STEP));
		/*[13]*/ insts.add(InstFactory.createInst(LexerInstType.PASS));
		/*[14]*/ insts.add(InstFactory.createInst(LexerInstType.EXIT));
		/*[15]*/ insts.add(InstFactory.createInst(LexerInstType.END_RECORD));
		/*[16]*/ insts.add(InstFactory.createInst(LexerInstType.LOAD, 100));
		/*[17]*/ insts.add(InstFactory.createInst(LexerInstType.IF, 19));
		/*[18]*/ insts.add(InstFactory.createInst(LexerInstType.JMP, 4));
		/*[19]*/ insts.add(InstFactory.createInst(LexerInstType.JUMP_STATE, 4));
		/*[20]*/ insts.add(InstFactory.createInst(LexerInstType.PASS));
		/*[21]*/ insts.add(InstFactory.createInst(LexerInstType.EXIT_STEP));
		step.setStep(LexerStepType.NEXT, insts);
		insts = new ArrayList<ILexerInst>();
		insts.add(InstFactory.createInst(LexerInstType.EXEC_PASS));
		insts.add(InstFactory.createInst(LexerInstType.IS_END));
		insts.add(InstFactory.createInst(LexerInstType.IF, 4));
		insts.add(InstFactory.createInst(LexerInstType.EXIT));
		insts.add(InstFactory.createInst(LexerInstType.END_RECORD));
		insts.add(InstFactory.createInst(LexerInstType.EXIT_STEP));
		step.setStep(LexerStepType.END, insts);

		/* STATE 1 - Dot */
		step = new LexerStep();
		lexerSteps.add(step);
		insts = new ArrayList<ILexerInst>();
		insts.add(InstFactory.createInst(LexerInstType.BEGIN_RECODE));
		step.setStep(LexerStepType.CURRENT, insts);
		insts = new ArrayList<ILexerInst>();
		insts.add(InstFactory.createInst(LexerInstType.END_RECORD));
		step.setStep(LexerStepType.NEXT, insts);
		insts = new ArrayList<ILexerInst>();
		insts.add(InstFactory.createInst(LexerInstType.PASS));
		insts.add(InstFactory.createInst(LexerInstType.JUMP_STATE, 0));
		insts.add(InstFactory.createInst(LexerInstType.MOV, 1));
		insts.add(InstFactory.createInst(LexerInstType.STORE, 100));
		insts.add(InstFactory.createInst(LexerInstType.EXIT_STEP));
		step.setStep(LexerStepType.END, insts);		
		
		/* STATE 2 - Missing Number */
		step = new LexerStep();
		lexerSteps.add(step);
		insts = new ArrayList<ILexerInst>();
		insts.add(InstFactory.createInst(LexerInstType.PANIC));
		step.setStep(LexerStepType.BEGIN, insts);
		insts = new ArrayList<ILexerInst>();
		insts.add(InstFactory.createInst(LexerInstType.MISSING, 1));
		step.setStep(LexerStepType.CURRENT, insts);
		
		/* STATE 3 - Missing Dot */
		step = new LexerStep();
		lexerSteps.add(step);
		insts = new ArrayList<ILexerInst>();
		insts.add(InstFactory.createInst(LexerInstType.PANIC));
		step.setStep(LexerStepType.BEGIN, insts);
		insts = new ArrayList<ILexerInst>();
		insts.add(InstFactory.createInst(LexerInstType.IS_END));
		insts.add(InstFactory.createInst(LexerInstType.IF, -1));
		insts.add(InstFactory.createInst(LexerInstType.MISSING, 1));
		step.setStep(LexerStepType.NEXT, insts);
		
		/* STATE 4 - Match End */		
		step = new LexerStep();
		lexerSteps.add(step);
		insts = new ArrayList<ILexerInst>();
		insts.add(InstFactory.createInst(LexerInstType.PANIC));
		step.setStep(LexerStepType.BEGIN, insts);
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
