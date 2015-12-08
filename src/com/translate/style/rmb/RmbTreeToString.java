package com.translate.style.rmb;

import com.translate.parser.tree.DecimalNode;
import com.translate.parser.tree.DotNode;
import com.translate.parser.tree.ITreeNodeVisitor;
import com.translate.parser.tree.IntegerAtomNode;
import com.translate.parser.tree.IntegerNode;
import com.translate.parser.tree.IntegerUnitNode;
import com.translate.parser.tree.VisitBag;

/**
 * 人民币翻译（结点序列化）
 * @author bajdc_000
 */
public class RmbTreeToString implements ITreeNodeVisitor {

	@Override
	public void visitBegin(IntegerNode node, VisitBag bag) {

	}

	@Override
	public void visitBegin(DotNode node, VisitBag bag) {

	}

	@Override
	public void visitBegin(DecimalNode node, VisitBag bag) {

	}

	@Override
	public void visitBegin(IntegerUnitNode node, VisitBag bag) {

	}

	@Override
	public void visitBegin(IntegerAtomNode node, VisitBag bag) {

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

}
