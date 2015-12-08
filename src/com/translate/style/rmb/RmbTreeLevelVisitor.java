package com.translate.style.rmb;

import com.translate.parser.tree.DecimalNode;
import com.translate.parser.tree.DotNode;
import com.translate.parser.tree.ITreeNodeVisitor;
import com.translate.parser.tree.IntegerAtomNode;
import com.translate.parser.tree.IntegerNode;
import com.translate.parser.tree.IntegerUnitNode;
import com.translate.parser.tree.VisitBag;
import com.translate.style.rmb.RmbParser.NodeDataType;

/**
 * 计算结点层次
 * @author bajdc_000
 */
public class RmbTreeLevelVisitor implements ITreeNodeVisitor {
	
	private int unitLevel = 0;
	private int atomLevel = 0;

	@Override
	public void visitBegin(IntegerNode node, VisitBag bag) {
		bag.setVisitReverse(true);
	}

	@Override
	public void visitBegin(DotNode node, VisitBag bag) {
		node.set(NodeDataType.LEVEL, 0);
		bag.setVisitChilren(false);
		bag.setVisitEnd(false);
	}

	@Override
	public void visitBegin(DecimalNode node, VisitBag bag) {
		atomLevel = 1;
	}

	@Override
	public void visitBegin(IntegerUnitNode node, VisitBag bag) {
		node.set(NodeDataType.LEVEL, unitLevel);
		bag.setVisitReverse(true);
	}

	@Override
	public void visitBegin(IntegerAtomNode node, VisitBag bag) {
		node.set(NodeDataType.LEVEL, atomLevel);
		bag.setVisitChilren(false);
	}

	@Override
	public void visitEnd(IntegerNode node) {
		unitLevel = 0;
	}

	@Override
	public void visitEnd(DotNode node) {
		
	}

	@Override
	public void visitEnd(DecimalNode node) {
		
	}

	@Override
	public void visitEnd(IntegerUnitNode node) {
		atomLevel = 0;
		unitLevel++;
	}

	@Override
	public void visitEnd(IntegerAtomNode node) {
		atomLevel++;
	}

}
