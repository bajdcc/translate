package com.translate.lexer;

import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import com.translate.lexer.env.Env;
import com.translate.lexer.inst.ILexerInst;
import com.translate.lexer.inst.LexerInstType;
import com.translate.lexer.iterator.LookAheadOneIterator;
import com.translate.lexer.match.ILexerMatcher;
import com.translate.lexer.match.IMatcherFactory;
import com.translate.lexer.match.MatchGroup;
import com.translate.lexer.match.MatcherFactory;
import com.translate.lexer.match.MatcherFactory.LexerMatcherType;
import com.translate.lexer.match.RefString;
import com.translate.lexer.step.ILexerStep;
import com.translate.lexer.step.LexerStepType;
import com.translate.style.IStyle;

/**
 * 词法分析器
 * 
 * @author bajdc_000
 */
public abstract class Lexer {

	protected String text;
	protected IStyle style;

	private LookAheadOneIterator itText;
	protected List<ILexerMatcher> matchers;

	private MatchGroup group;

	public Lexer(String text, IStyle style) {
		this.text = text;
		this.style = style;
		this.itText = new RefString(this.text).iterator().skip('0').lookAhead();
		this.group = new MatchGroup();
		initMatchers();
	}

	private void initMatchers() {
		this.matchers = new ArrayList<ILexerMatcher>();
		IMatcherFactory factory = MatcherFactory.singleton();
		for (LexerMatcherType type : LexerMatcherType.values()) {
			this.matchers.add(factory.createMatcher(type));
		}
	}

	public String getText() {
		return text;
	}

	public IStyle getStyle() {
		return style;
	}

	public MatchGroup getGroup() {
		return group;
	}

	public boolean match() {
		Env env = new Env();
		try {
			while (env.state != -1) {
				System.out.println(String.format("# State=%d, Index=%d, Current='%c'",
						env.state, itText.index(), itText.current()));
				// 按照当前状态，从steps里面取出相应的指令，并且运行指令
				// 当且仅当指令为stop时，退出

				// 运行步骤
				if (!runStep(env)) {
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 运行步骤
	 * 
	 * @param env
	 *            环境
	 * @return 是否终止
	 * @throws OperationNotSupportedException
	 */
	private boolean runStep(Env env) throws OperationNotSupportedException {
		for (LexerStepType type : LexerStepType.values()) {
			if (env.exitStep) {
				env.exitStep = false;
				break;
			}
			swapEnvironment(type, env);
			List<ILexerInst> insts = env.step.getStep(type);
			if (insts != null) {
				for (env.addr = 0; env.addr != -1 && env.addr < insts.size();) {
					env.inst = insts.get(env.addr);
					System.out.println(String.format("[%s] %d %s", type.toString(), env.addr, env.inst));
					if (!runInst(env)) {
						return false;
					}
					if (!env.jmp) {
						env.addr++;
					} else {
						env.jmp = false;
					}
				}
			}
		}
		if (env.pass) {
			env.pass = false;
			itText.next();
		}
		return itText.available();
	}

	/**
	 * 运行指令
	 * 
	 * @param env
	 *            环境
	 * @throws OperationNotSupportedException
	 */
	private boolean runInst(Env env) throws OperationNotSupportedException {
		ILexerInst inst = env.inst;
		LexerInstType type = inst.getType();
		switch (type) {
		case Exit:
			env.jmp = true;
			env.addr = -1;
			break;
		case ExitStep:
			env.exitStep = true;
			break;
		case If:
			if (env.reg == 1) {
				env.jmp = true;
				env.addr = inst.getData();
			}
			break;
		case IsRecording:
			env.reg = env.ref != null ? 1 : 0;
			break;
		case Jmp:
			env.jmp = true;
			env.addr = inst.getData();
			break;
		case JumpState:
			env.state = inst.getData();
			break;
		case MatchReg:
			env.reg = matchers.get(env.reg).match(env.ch);
			break;
		case Mov:
			env.reg = inst.getData();
			break;
		case Not:
			env.reg = env.reg == 0 ? 1 : 0;
			break;
		case Pass:
			env.pass = true;
			break;
		case RecordEnd:
			env.ref.setEnd(itText.index());
			group.addResult(env.ref);
			env.ref = null;
			break;
		case RecordStart:
			env.ref = new RefString(text);
			env.ref.setStart(itText.index());
			break;
		case Stop:
			return false;
		default:
			throw new OperationNotSupportedException(type.toString());
		}
		return true;
	}

	/**
	 * 切换当前环境
	 * 
	 * @param type
	 *            步骤类型
	 * @param env
	 *            环境
	 */
	private void swapEnvironment(LexerStepType type, Env env) {
		// 取出当前步骤
		final List<ILexerStep> steps = style.getLexerStep();
		switch (type) {
		case Begin:
			env.step = steps.get(env.state);
			break;
		case Current:
			// 准备好当前字符和下一个字符
			env.ch = itText.current();
			break;
		case End:
			break;
		case Next:
			// 准备好当前字符和下一个字符
			env.ch = itText.ahead();
			break;
		default:
			break;
		}
	}
}
