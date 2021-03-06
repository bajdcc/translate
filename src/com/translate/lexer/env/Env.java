package com.translate.lexer.env;

import java.util.HashMap;
import java.util.Map;

import com.translate.lexer.inst.ILexerInst;
import com.translate.lexer.match.RefString;
import com.translate.lexer.step.ILexerStep;

/**
 * 词法分析器的状态机环境
 * @author bajdc_000
 */
public class Env {

	/**
	 * 当前状态
	 */
	public int state = 0;
	
	/**
	 * 当前字符串位置
	 */
	public int index = 0;
	
	/**
	 * 当前指令位置
	 */
	public int addr = 0;
	
	/**
	 * 当前寄存器 
	 */
	public int reg = -1;
	
	/**
	 * 当前字符
	 */
	public char ch = 0;
	
	/**
	 * 当前步骤
	 */
	public ILexerStep step = null;
	
	/**
	 * 当前指令
	 */
	public ILexerInst inst = null;
	
	/**
	 * 当前捕获字串
	 */
	public RefString ref = null;

	/**
	 * 是否刚执行过跳转指令
	 */
	public boolean jmp = false;
	
	/**
	 * 是否需要执行PASS指令
	 */
	public boolean pass = false;
	
	/**
	 * 是否需要退出步骤
	 */
	public boolean exitStep = false;
	
	/**
	 * 是否出现错误
	 */
	public boolean panic = false;
	
	/**
	 * 全局存储空间
	 */
	public Map<Integer, Integer> scope = new HashMap<Integer, Integer>();
}
