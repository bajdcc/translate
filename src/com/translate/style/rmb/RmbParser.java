package com.translate.style.rmb;

import java.util.InputMismatchException;
import com.translate.lexer.iterator.IRefStringIterator;
import com.translate.lexer.match.RefString;
import com.translate.parser.Parser;
import com.translate.parser.tree.IStoreableNode;
import com.translate.parser.tree.ITreeNode;
import com.translate.parser.tree.IntegerAtomNode;
import com.translate.parser.tree.IntegerUnitNode;
import com.translate.parser.tree.TreeNodeToString;
import com.translate.style.StyleFactory;
import com.translate.style.StyleFactory.StyleType;

/**
 * 人民币翻译方案
 * 
 * @author bajdc_000
 */
public class RmbParser extends Parser {	
	
	public enum NodeDataType {
		DATA,
		VALUE,
	}

	public RmbParser(String text) {
		super(text, StyleFactory.singleton().createStyle(StyleType.RMB));
		init();
	}

	/**
	 * 初始化
	 */
	private void init() {
		
	}
	
	@Override
	protected String getDefaultValue(int id) {
		PartType type = PartType.values()[id];
		switch (type) {
		case INTEGER:
			return "0";
		case DOT:
			return "";
		case DECIMAL:
			return "";
		default:
			break;
		}
		throw new IllegalArgumentException("id");
	}	

	@Override
	protected IRefStringIterator iterator(PartType type, RefString text) {
		switch (type) {
		case DECIMAL:
			return text.iterator();
		case DOT:
			return text.iterator();
		case INTEGER:
			return text.reverse();
		default:
			return null;
		}
	}

	@Override
	protected boolean parseInternal(PartType type, IRefStringIterator iterator, ITreeNode node) throws Exception {
		switch (type) {
		case DECIMAL:
			return parseDecimal(iterator, node);
		case DOT:
			return parseDot(iterator, node);
		case INTEGER:
			return parseInteger(iterator, node);
		default:
			return false;
		}
	}
	
	/**
	 * 返回数字
	 * @param ch 字符
	 * @param message 错误信息
	 * @return 数字
	 * @throws Exception
	 */
	private char getIntegerWithCheck(char ch, String message) throws Exception {
		if (!Character.isDigit(ch)) {
			throw new InputMismatchException(message);
		}
		return ch;
	}

	/**
	 * 解析小数
	 * @param iterator 迭代器
	 * @param node 结点
	 * @return 是否可以继续
	 * @throws Exception 解析错误
	 */
	private boolean parseDecimal(IRefStringIterator iterator, ITreeNode node) throws Exception {
		if (iterator.available()) {
			IntegerAtomNode decimal = new IntegerAtomNode();
			node.addNode(decimal, true);
			char ch = getIntegerWithCheck(iterator.current(), "Decimal");
			decimal.set(NodeDataType.DATA.ordinal(), ch);
			decimal.set(NodeDataType.VALUE.ordinal(), Integer.parseInt(String.valueOf(ch)));
			iterator.next();
			return iterator.available();
		}
		return false;
	}
	
	/**
	 * 解析小数点
	 * @param iterator 迭代器
	 * @param node 结点
	 * @return 是否可以继续
	 * @throws Exception 解析错误
	 */
	private boolean parseDot(IRefStringIterator iterator, ITreeNode node) throws Exception {
		if (iterator.current() == '.') {
			IStoreableNode store = node.storeable();
			store.set(NodeDataType.DATA.ordinal(), iterator.current());
			iterator.next();
			return iterator.available();
		}
		throw new InputMismatchException("Dot");
	}

	/**
	 * 解析整数
	 * @param iterator 迭代器
	 * @param node 结点
	 * @return 是否可以继续
	 * @throws Exception 解析错误
	 */
	private boolean parseInteger(IRefStringIterator iterator, ITreeNode node) throws Exception {
		while (parseIntegerUnit(iterator, node))
			;
		return iterator.available();
	}
	
	/**
	 * 解析整数单元
	 * @param iterator 迭代器
	 * @param node 结点
	 * @return 是否可以继续
	 * @throws Exception 解析错误
	 */
	private boolean parseIntegerUnit(IRefStringIterator iterator, ITreeNode node) throws Exception {
		ITreeNode unit = new IntegerUnitNode();
		unit.storeable().set(NodeDataType.DATA.ordinal(), " ");
		node.addNode(unit, false);
		for (int i = 0; i < 4 && iterator.available(); i++) {
			IntegerAtomNode atom = new IntegerAtomNode();
			atom.set(NodeDataType.DATA.ordinal(), getIntegerWithCheck(iterator.current(), "Integer"));
			iterator.next();
			unit.addNode(atom, false);
		}
		return iterator.available();
	}

	@Override
	public String toString() {
		TreeNodeToString visitor = new TreeNodeToString();
		root.visit(visitor);
		return visitor.toString();
	}
}
