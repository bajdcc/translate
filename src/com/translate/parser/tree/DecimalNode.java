package com.translate.parser.tree;

/**
 * 小数结点
 * @author bajdc_000
 */
public class DecimalNode extends StoreableNode {

	@Override
	public void visit(ITreeNodeVisitor visitor) {
		visitor.visit(this);
		super.visit(visitor);
	}

}
