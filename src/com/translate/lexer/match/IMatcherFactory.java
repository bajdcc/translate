package com.translate.lexer.match;

import com.translate.lexer.match.MatcherFactory.LexerMatcherType;

public interface IMatcherFactory {

	/**
	 * 创建匹配器
	 * @param type 类型
	 * @return 匹配器
	 */
	ILexerMatcher createMatcher(LexerMatcherType type);
}
