package com.translate.parser.tree;

/**
 * 整数结点
 * @author bajdc_000
 */
public class IntegerNode extends StoreableNode {

	@Override
	public void visit(ITreeNodeVisitor visitor) {
		visitor.visit(this);
		super.visit(visitor);
	}

}
