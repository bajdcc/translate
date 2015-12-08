package com.translate.parser.visitor;

import com.translate.parser.tree.DecimalNode;
import com.translate.parser.tree.DotNode;
import com.translate.parser.tree.ITreeNodeVisitor;
import com.translate.parser.tree.IntegerAtomNode;
import com.translate.parser.tree.IntegerNode;
import com.translate.parser.tree.IntegerUnitNode;
import com.translate.parser.tree.VisitBag;
import com.translate.style.rmb.RmbParser.NodeDataType;

/**
 * 从树结点生成字符串（数字）
 * @author bajdc_000
 */
public class TreeNodeToString implements ITreeNodeVisitor {

	private StringBuilder sb = new StringBuilder();
	
	@Override
	public void visitBegin(IntegerNode node, VisitBag bag) {

	}

	@Override
	public void visitBegin(DotNode node, VisitBag bag) {
		sb.append(node.get(NodeDataType.DATA));
	}

	@Override
	public void visitBegin(DecimalNode node, VisitBag bag) {
		
	}

	@Override
	public void visitBegin(IntegerUnitNode node, VisitBag bag) {
		sb.append(node.get(NodeDataType.DATA));
	}

	@Override
	public void visitBegin(IntegerAtomNode node, VisitBag bag) {
		sb.append(node.get(NodeDataType.DATA));
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
		
	}

	@Override
	public void visitEnd(IntegerAtomNode node) {
		
	}

	@Override
	public String toString() {
		return sb.toString();
	}
}
