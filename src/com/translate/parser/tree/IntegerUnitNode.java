package com.translate.parser.tree;

/**
 * 整数单位
 * @author bajdc_000
 */
public class IntegerUnitNode extends StoreableNode {

	@Override
	public void visit(ITreeNodeVisitor visitor) {
		visitor.visit(this);
		super.visit(visitor);
	}

}
