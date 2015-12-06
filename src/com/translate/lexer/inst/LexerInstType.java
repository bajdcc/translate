package com.translate.lexer.inst;

/**
 * 词法分析的指令
 * 
 * @author bajdc_000
 */
public enum LexerInstType {

	// 基于字符串
	IS_RECOEDING("IsRecording"),
	IS_END("IsEnd"),
	BEGIN_RECODE("BeginRecord"),
	END_RECORD("EndRecord"),
	JUMP_STATE("JumpState"),
	MATCH("Match"),
	PASS("Pass"),
	EXEC_PASS("ExecPass"),
	STOP("Stop"),

	// 基于指令
	IF("If"),
	JMP("Jmp"),
	EXIT("Exit"),
	EXIT_STEP("ExitStep"),
	MOV("Mov"),
	NEG("Neg"),
	LOAD("Load"),
	STORE("Store"),
	PANIC("Panic"),
	
	// 基于错误
	MISSING("Missing"),
	
	;

	private String name;

	LexerInstType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
