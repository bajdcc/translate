package com.translate.parser.tree;

/**
 * 小数点结点
 * @author bajdc_000
 */
public class DotNode extends StoreableNode {

	@Override
	public void visit(ITreeNodeVisitor visitor) {
		visitor.visit(this);
		super.visit(visitor);
	}

}
