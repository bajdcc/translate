package com.translate.lexer.step;

/**
 * 词法分析的步骤类型
 * @author bajdc_000
 */
public enum LexerStepType {

	BEGIN("Begin"),
	CURRENT("Current"),
	NEXT("Next"),
	END("End"),
	
	;

	private String name;

	LexerStepType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
