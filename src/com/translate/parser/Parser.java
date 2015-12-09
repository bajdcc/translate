package com.translate.parser;

import java.util.List;

import com.translate.lexer.Lexer;
import com.translate.lexer.iterator.IRefStringIterator;
import com.translate.lexer.match.MatchGroup;
import com.translate.lexer.match.RefString;
import com.translate.parser.tree.DecimalNode;
import com.translate.parser.tree.DotNode;
import com.translate.parser.tree.ITreeNode;
import com.translate.parser.tree.IntegerNode;
import com.translate.parser.tree.TreeNode;
import com.translate.style.IStyle;

/**
 * 语法分析器
 * @author bajdc_000
 */
public abstract class Parser {

	public enum PartType {
		INTEGER,
		DOT,
		DECIMAL,
	}
	protected Lexer lexer;
	protected MatchGroup group;
	protected ITreeNode root;

	public Parser(String text, IStyle style) {
		if (text == null) {
			throw new NullPointerException("text");
		}
		init(text, style);
	}
	
	private void init(String text, IStyle style) {
		this.lexer = style.createLexer(text);		
		this.lexer.match();
		this.group = lexer.getGroup();
		normalizeGroup(PartType.values().length);
		System.out.println(group.toString());
		try {
			root = parse();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * 标准化结果数组
	 * @param group
	 */
	private void normalizeGroup(int count) {
		List<RefString> results = group.getResults();
		for (int i = 0; i < count; i++) {
			if (i >= results.size()) {
				results.add(new RefString(getDefaultValue(i)));
			}
		}
	}

	/**
	 * 设置默认值
	 * @param id 索引
	 * @return
	 */
	protected abstract String getDefaultValue(int id);

	/**
	 * 生成树
	 * @param group
	 * @return
	 */
	private ITreeNode parse() throws Exception {
		ITreeNode node = new TreeNode();
		for (PartType type : PartType.values()) {
			node.addNode(parseNode(type, group.getResult(type.ordinal())), true);
		}
		return node;
	}
	
	/**
	 * 结点创建工厂
	 * @param type
	 * @return
	 */
	private ITreeNode createNode(PartType type) {
		switch (type) {
		case DECIMAL:
			return new DecimalNode();
		case DOT:
			return new DotNode();
		case INTEGER:
			return new IntegerNode();
		default:
			return null;
		}
	}

	/**
	 * 解析整数部分
	 * @param type 类型
	 * @param text 文本
	 * @return
	 * @throws Exception
	 */
	private ITreeNode parseNode(PartType type, RefString text) throws Exception {
		ITreeNode node = createNode(type);
		IRefStringIterator iterator = iterator(type, text);
		while (parseInternal(type, iterator, node))
			;
		return node;
	}
	
	/**
	 * 获取迭代器
	 * @param type 类型
	 * @param text 文本
	 * @return
	 */
	protected abstract IRefStringIterator iterator(PartType type, RefString text);
	
	/**
	 * 内部解析
	 * @param type 类型
	 * @param iterator 迭代器
	 * @param node 结点
	 * @return 是否可以继续
	 * @throws Exception
	 */
	protected abstract boolean parseInternal(PartType type, IRefStringIterator iterator, ITreeNode node) throws Exception;

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "," + lexer.toString();
	}
}
