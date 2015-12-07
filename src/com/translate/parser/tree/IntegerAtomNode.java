package com.translate.parser.tree;

/**
 * 整数原子
 * @author bajdc_000
 */
public class IntegerAtomNode extends StoreableNode {

	@Override
	public void visit(ITreeNodeVisitor visitor) {
		visitor.visit(this);
	}

}
