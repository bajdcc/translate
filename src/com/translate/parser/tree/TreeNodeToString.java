package com.translate.parser.tree;

import com.translate.style.rmb.RmbParser.NodeDataType;

/**
 * 从树结点生成字符串
 * @author bajdc_000
 */
public class TreeNodeToString implements ITreeNodeVisitor {

	private StringBuilder sb = new StringBuilder();
	
	@Override
	public void visit(IntegerNode node) {

	}

	@Override
	public void visit(DotNode node) {
		sb.append(node.get(NodeDataType.DATA.ordinal()));
	}

	@Override
	public void visit(DecimalNode node) {

	}

	@Override
	public void visit(IntegerUnitNode node) {
		sb.append(node.get(NodeDataType.DATA.ordinal()));
	}

	@Override
	public void visit(IntegerAtomNode node) {
		sb.append(node.get(NodeDataType.DATA.ordinal()));
	}
	
	@Override
	public String toString() {
		return sb.toString();
	}
}
