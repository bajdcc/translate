package com.translate.lexer.inst;

/**
 * 词法分析的指令
 * @author bajdc_000
 */
public enum LexerInstType {

	//基于字符串
	IsRecording,
	RecordStart,
	RecordEnd,
	JumpState,
	MatchReg,
	Pass,
	Stop,
	
	//基于指令
	If,
	Jmp,
	Exit,
	ExitStep,
	Mov,
	Not,
}
