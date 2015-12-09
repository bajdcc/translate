package com.translate.style.rmb;

import com.translate.parser.tree.DecimalAtomNode;
import com.translate.parser.tree.DecimalNode;
import com.translate.parser.tree.DotNode;
import com.translate.parser.tree.ITreeNodeVisitor;
import com.translate.parser.tree.IntegerAtomNode;
import com.translate.parser.tree.IntegerNode;
import com.translate.parser.tree.IntegerUnitNode;
import com.translate.parser.tree.VisitBag;
import com.translate.style.rmb.RmbParser.NodeDataType;

/**
 * 人民币翻译（结点序列化）
 * @author bajdc_000
 */
public class RmbTreeToString implements ITreeNodeVisitor {

	private static String[] CN_ATOMS = new String[] { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖", };
	private static String[] CN_UNITS = new String[] { "", "拾", "佰", "仟", };
	private static String[] CN_DECIMALS = new String[] { "", "角", "分", };

	private static String CN_TEN_THOUSAND = "万";
	private static String CN_HUNDRED_MILLION = "亿";
	private static String CN_SYMBOL = "人民币";
	private static String CN_DOLLAR = "元";
	private static String CN_INTEGER = "整";

	private StringBuilder sb = new StringBuilder();

	private int unitZero = 0;
	private int atomZero = 0;
	
	public RmbTreeToString() {
		append(CN_SYMBOL);
	}

	@Override
	public void visitBegin(IntegerNode node, VisitBag bag) {

	}

	@Override
	public void visitBegin(DotNode node, VisitBag bag) {
		bag.setVisitChildren(false);
		bag.setVisitEnd(false);
		append(CN_DOLLAR);
	}

	@Override
	public void visitBegin(DecimalNode node, VisitBag bag) {
		if (node.isEmptyNodes()) {
			bag.setVisitChildren(false);
			bag.setVisitEnd(false);
			append(CN_INTEGER);
		}
	}

	@Override
	public void visitBegin(IntegerUnitNode node, VisitBag bag) {

	}

	@Override
	public void visitBegin(IntegerAtomNode node, VisitBag bag) {
		bag.setVisitChildren(false);
		bag.setVisitEnd(false);
		int data = (int)node.get(NodeDataType.VALUE);
		if (data != 0) {
			if (atomZero > 0) {
				atomZero = 0;
				appendZero();
			}
			int level = (int)node.get(NodeDataType.LEVEL);
			appendIntegerAtom(data, level);
		} else {
			atomZero++;
		}
	}
	
	@Override
	public void visitBegin(DecimalAtomNode node, VisitBag bag) {
		bag.setVisitChildren(false);
		bag.setVisitEnd(false);
		int data = (int)node.get(NodeDataType.VALUE);
		if (data != 0) {			
			int level = (int)node.get(NodeDataType.LEVEL);
			appendDecimalAtom(data, level);
		}
	}

	@Override
	public void visitEnd(IntegerNode node) {
		
	}

	@Override
	public void visitEnd(DotNode node) {

	}

	@Override
	public void visitEnd(DecimalNode node) {

	}

	@Override
	public void visitEnd(IntegerUnitNode node) {
		if (atomZero == node.size()) {
			unitZero++;
		}
		int level = (int)node.get(NodeDataType.LEVEL);
		if (level != 0) {
			boolean zero = unitZero > 0;			
			if (level % 2 == 0) {
				unitZero = 0;
				append(CN_HUNDRED_MILLION);
			} else if (!zero) {
				append(CN_TEN_THOUSAND);
			} else {
				appendZero();
			}
		}
		atomZero = 0;
	}

	@Override
	public void visitEnd(IntegerAtomNode node) {

	}

	@Override
	public void visitEnd(DecimalAtomNode node) {

	}
	
	/**
	 * 添加整数原子
	 * @param data 数字
	 * @param level 等级
	 */
	private void appendIntegerAtom(int data, int level) {
		append(CN_ATOMS[data]);
		append(CN_UNITS[level]);
	}
	
	/**
	 * 添加小数原子
	 * @param data 数字
	 * @param level 等级
	 */
	private void appendDecimalAtom(int data, int level) {
		append(CN_ATOMS[data]);
		append(CN_DECIMALS[level]);
	}
	
	private void appendZero() {
		sb.append(CN_ATOMS[0]);
	}

	private void append(String text) {
		sb.append(text);
	}

	@Override
	public String toString() {
		return sb.toString();
	}
}
